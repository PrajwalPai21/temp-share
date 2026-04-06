package com.tempshare.tempshare_backend.controller;

import com.tempshare.tempshare_backend.model.FileEntity;
import com.tempshare.tempshare_backend.repository.FileRepository;
import com.tempshare.tempshare_backend.service.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@RestController
@RequiredArgsConstructor
@RequestMapping("/files")
@CrossOrigin(origins = "http://localhost:5173") // frontend access
public class FileController {

    private final FileService fileService;
    private final FileRepository fileRepository;

    @PostMapping("/upload")
    public ResponseEntity<?> upload(@RequestParam("file") MultipartFile file) {
        try {
            FileEntity saved = fileService.uploadFile(file);
            return ResponseEntity.ok(saved); // return JSON metadata
        } catch (Exception e) {
            return ResponseEntity.badRequest()
                    .body("Upload Failed: " + e.getMessage());
        }
    }
//download
    @GetMapping("/{fileId}")
    public ResponseEntity<?> downloadFile(@PathVariable String fileId) {
        try {
            FileEntity fileEntity = fileRepository.findByFileId(fileId)
                    .orElseThrow(() -> new RuntimeException("File not found!"));

            File file = new File(
                    "/home/pai/Documents/Personal_Projects/TempShare/tempshare-backend/src/uploads/"
                            + fileEntity.getStoredName()
            );

            if (!file.exists()) {
                return ResponseEntity.notFound().build();
            }

            Resource resource = new FileSystemResource(file);

            return ResponseEntity.ok()
                    .header(
                            HttpHeaders.CONTENT_DISPOSITION,
                            "attachment; filename=\"" + fileEntity.getOriginalName() + "\""
                    )
                    .contentLength(file.length())
                    .body(resource);

        } catch (Exception e) {
            return ResponseEntity.badRequest()
                    .body("Download Failed: " + e.getMessage());
        }
    }
}
