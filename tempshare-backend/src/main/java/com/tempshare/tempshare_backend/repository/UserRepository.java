package com.tempshare.tempshare_backend.repository;

import com.tempshare.tempshare_backend.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {
// custom method
//    Optional<UserModel> findByEmail(String email);
    Optional<UserModel> findByUsername(String username);
}
