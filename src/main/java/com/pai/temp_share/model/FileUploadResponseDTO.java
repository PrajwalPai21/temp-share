package com.pai.temp_share.model;

// DTO is a purpose-built response shape

public class FileUploadResponseDTO {

    private String shareToken;
    private String originalFileName;
    private Long fileSize;
    private String downloadUrl;
    private String expiresAt;

    public String getShareToken() {
        return shareToken;
    }

    public String getOriginalFileName() {
        return originalFileName;
    }

    public Long getFileSize() {
        return fileSize;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public String getExpiresAt() {
        return expiresAt;
    }

    public FileUploadResponseDTO(String shareToken, String originalFileName, Long fileSize, String downloadUrl, String expiresAt) {
        this.shareToken = shareToken;
        this.originalFileName = originalFileName;
        this.fileSize = fileSize;
        this.downloadUrl = downloadUrl;
        this.expiresAt = expiresAt;
    }



}
