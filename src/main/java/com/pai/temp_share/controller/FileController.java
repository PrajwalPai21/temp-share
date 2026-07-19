package com.pai.temp_share.controller;

import com.pai.temp_share.model.FileMetadata;
import com.pai.temp_share.model.FileUploadResponseDTO;
import com.pai.temp_share.service.FileService;
import org.apache.tomcat.util.http.fileupload.FileUpload;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.swing.text.html.Option;
import java.util.Optional;

@RestController
@RequestMapping("/api/files")
public class FileController {
    private final FileService fileService;

    public FileController(FileService fileService) {
        this.fileService = fileService;
    }


    @PostMapping("/upload")
    public ResponseEntity<?> uploadFile(
            @RequestParam("file")MultipartFile file,
            @RequestParam(value = "expirationHours", defaultValue = "24") int expirationHours)
    {
        try{
            FileUploadResponseDTO response = fileService.uploadFile(file,expirationHours);
            return ResponseEntity.ok(response);
        } catch(IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch(Exception e){
//            e.printStackTrace();
            return ResponseEntity.internalServerError().body("Upload failed: " + e.getMessage());
        }
    }

    @GetMapping("/{shareToken}")
    // <?> I might return different types from this method, sometimes dto-upload or plain string error
    public ResponseEntity<?> getFileInfo(@PathVariable String shareToken){
        return fileService.findByShareToken(shareToken).map(
                file -> ResponseEntity.ok().body(file))
                .orElse(ResponseEntity.notFound().build());
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
