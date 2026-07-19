package com.pai.temp_share.controller;

import com.pai.temp_share.model.FileMetadata;
import com.pai.temp_share.service.FileService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.Optional;

@RestController
@RequestMapping("/api/files")
public class FileController {
    private final FileService fileService;

    public FileController(FileService fileService) {
        this.fileService = fileService;
    }

//    @PostMapping("/test")
//    public ResponseEntity<FileMetadata> createTestFile(){
//        FileMetadata saved = fileService.saveTestFile();
//        return ResponseEntity.ok(saved);
//    }

//    @GetMapping("/{shareToken}")
//    public ResponseEntity<FileMetadata> getFileByToken(@PathVariable String shareToken){
//        Optional<FileMetadata> file = fileService.findByShareToken(shareToken);

//        if (file.isPresent()) {
//            return ResponseEntity.ok(file.get());
//        } else{
//            return ResponseEntity.notFound().build();
//        }
//}
}
