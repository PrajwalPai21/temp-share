package com.tempshare.tempshare_backend.repository;

import com.tempshare.tempshare_backend.model.FileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

//gives CRUD automatically
public interface FileRepository extends JpaRepository<FileEntity,Long> {
    Optional<FileEntity> findByFileId(String fileId);
}
