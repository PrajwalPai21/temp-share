package com.pai.temp_share.service;

import com.pai.temp_share.model.FileMetadata;
import com.pai.temp_share.repository.FileMetadataRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class FileService {
    private final FileMetadataRepository fileMetadataRepository;

    public FileService(FileMetadataRepository fileMetadataRepository) {
        this.fileMetadataRepository = fileMetadataRepository;
    }

    public FileMetadata saveTestFile(){
        FileMetadata file = new FileMetadata(
                "test-document.pdf",
                "stored-test-document.pdf",
                1024L,
                "application/pdf",
                LocalDateTime.now().plusHours(24)
        );
        return fileMetadataRepository.save(file);
    }

    public Optional<FileMetadata> findByShareToken(String shareToken){
        return fileMetadataRepository.findByShareToken(shareToken);
    }
}
