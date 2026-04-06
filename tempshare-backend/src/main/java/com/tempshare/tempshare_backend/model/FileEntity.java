package com.tempshare.tempshare_backend.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "files_table")
public class FileEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fileId; // unique link to download the file
    private  String originalName;
    private String storedName; // this is because i dont wanna create cconflicts in file naming
    private String downloadUrl;
    private long size;
    private LocalDateTime uploadedAt;
}
