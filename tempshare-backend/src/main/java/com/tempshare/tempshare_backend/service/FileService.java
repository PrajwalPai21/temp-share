package com.tempshare.tempshare_backend.service;

import com.tempshare.tempshare_backend.model.FileEntity;
import com.tempshare.tempshare_backend.repository.FileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FileService {

    private final FileRepository fileRepository;

    // Absolute path (GOOD — avoids Tomcat temp issues)
    private final String uploadDir =
            "/home/pai/Documents/Personal_Projects/TempShare/tempshare-backend/src/uploads/";

    public FileEntity uploadFile(MultipartFile file) throws IOException {

        File folder = new File(uploadDir);
        if (!folder.exists()) {
            // if the folder has not been created, just in case
            folder.mkdirs();
        }

        // generate a unique ID for public access
        String fileId = UUID.randomUUID().toString();

        // stored filename = UUID + original name (prevents conflicts)
        String storedName = fileId + "_" + file.getOriginalFilename();

        // save file to disk
        File savedFile = new File(uploadDir + storedName);
        file.transferTo(savedFile);

        // build file metadata
        FileEntity fileEntity = FileEntity.builder()
                .fileId(fileId)
                .originalName(file.getOriginalFilename())
                .storedName(storedName)
                .downloadUrl("http://localhost:8080/files/" + fileId)
                .size(file.getSize())
                .uploadedAt(LocalDateTime.now())
                .build();

        // save metadata in DB
        return fileRepository.save(fileEntity);
    }
}
