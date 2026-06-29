package com.pai.temp_share.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "files")
public class FileMetadata {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String shareToken;

    @Column(nullable = false)
    private String storedFileName;

    @Column(nullable = false)
    private Long fileSize;

    @Column(nullable = false)
    private String contentType;

    @Column(nullable = false)
    private LocalDateTime uploadedAt;

    @Column(nullable = false)
    private Integer downloadCount = 0;

    @Column(nullable = false)
    private String originalFileName;

    @Column(nullable = false)
    private LocalDateTime expiresAt;


    // only provide those parameters which we know at the upload time
    public FileMetadata(String originalFileName, String storedFileName,
                        Long fileSize, String contentType,
                        LocalDateTime expiresAt){
        this.shareToken = UUID.randomUUID().toString();
        this.storedFileName = storedFileName;
        this.fileSize = fileSize;
        this.contentType = contentType;
        this.uploadedAt = LocalDateTime.now();
        this.downloadCount = 0;
        this.originalFileName = originalFileName;
        this.expiresAt = expiresAt;
    }

    public FileMetadata(){}


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getShareToken() {
        return shareToken;
    }

//    public void setShareToken(String shareToken) {
//        this.shareToken = shareToken;
//    }

    public String getStoredFileName() {
        return storedFileName;
    }

    public void setStoredFileName(String storedFileName) {
        this.storedFileName = storedFileName;
    }

    public Long getFileSize() {
        return fileSize;
    }

    public void setFileSize(Long fileSize) {
        this.fileSize = fileSize;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public LocalDateTime getUploadedAt() {
        return uploadedAt;
    }

//    public void setUploadedAt(LocalDateTime uploadedAt) {
//        this.uploadedAt = uploadedAt;
//    }

    public Integer getDownloadCount() {
        return downloadCount;
    }

    public void setDownloadCount(Integer downloadCount) {
        this.downloadCount = downloadCount;
    }

    public String getOriginalFileName() {
        return originalFileName;
    }

    public void setOriginalFileName(String originalFileName) {
        this.originalFileName = originalFileName;
    }

    public LocalDateTime getExpiresAt() {
        return expiresAt;
    }

    public void setExpiresAt(LocalDateTime expiresAt) {
        this.expiresAt = expiresAt;
    }

}
