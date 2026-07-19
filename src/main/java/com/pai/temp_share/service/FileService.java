package com.pai.temp_share.service;

import com.pai.temp_share.model.FileMetadata;
import com.pai.temp_share.model.FileUploadResponseDTO;
import com.pai.temp_share.repository.FileMetadataRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
public class FileService {
    private final FileMetadataRepository fileMetadataRepository;
    private final Path uploadDir;

    @Value("${app.base-url}")
    private String baseUrl;

    public FileService(FileMetadataRepository fileMetadataRepository,
                      /* app properties*/ @Value("${file.upload-dir}") String uploadDir) throws IOException {
        this.fileMetadataRepository = fileMetadataRepository;
        this.uploadDir = Paths.get(uploadDir).toAbsolutePath().normalize();
    }

    public FileUploadResponseDTO uploadFile(MultipartFile file, int expirationHours) throws IOException{
        if(file.isEmpty()){
            throw new IllegalArgumentException("Cannot upload empty file");
        }

        if(file.getSize() > 10* 1024 * 1024)
            throw new IllegalArgumentException("File size too large, Limit is 10MB");

//        Build safe unique filename for storage
        String originalFileName = file.getOriginalFilename() != null
                ? file.getOriginalFilename()
                : "unnamed-file";
        String fileExtension="";
        if(originalFileName != null && originalFileName.contains(".")){
            fileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));
        }
        String storedFileName = UUID.randomUUID().toString()+fileExtension;

        // save to disk

        Path targetLocation = uploadDir.resolve(storedFileName);
        Files.createDirectories(targetLocation.getParent());
        Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);

//        save to db
        LocalDateTime expiresAt = LocalDateTime.now().plusHours(expirationHours);
        FileMetadata metadata = new FileMetadata(
                originalFileName,
                storedFileName,
                file.getSize(),
                file.getContentType(),
                expiresAt
        );
//        saved -> savedMetaData
        FileMetadata savedMetadata = fileMetadataRepository.save(metadata);


//        Build and return dto response

        String downloadUrl = baseUrl + "/api/files/download/" + savedMetadata.getShareToken();

        return new FileUploadResponseDTO(
                savedMetadata.getShareToken(),
                savedMetadata.getOriginalFileName(),
                savedMetadata.getFileSize(),
                downloadUrl,
                savedMetadata.getExpiresAt().toString()
        );
    }
//    public FileMetadata saveTestFile(){
//        FileMetadata file = new FileMetadata(
//                "test-document.pdf",
//                "stored-test-document.pdf",
//                1024L,
//                "application/pdf",
//                LocalDateTime.now().plusHours(24)
//        );
//        return fileMetadataRepository.save(file);
//    }

    public Optional<FileMetadata> findByShareToken(String shareToken){
        return fileMetadataRepository.findByShareToken(shareToken);
    }
}
