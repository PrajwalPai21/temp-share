package com.tempshare.tempshare_backend.repository;

import com.tempshare.tempshare_backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository; //gives CRUD methods (save, findAll,
                                                                // findById, delete, etc.).

import java.util.Optional;
// Declares a repository interface for User entity with primary key type Long. Spring Data will automatically
// create an implementation at runtime.
public interface UserRepository extends JpaRepository<User, Long> {
    //this is custom query method
    Optional<User> findByEmail(String email); //findByEmailandPassword(String email,String password)
}

// here Optional is to say : it might be empty if no user if found
