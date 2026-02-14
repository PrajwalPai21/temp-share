package com.tempshare.tempshare_backend.service;

import com.tempshare.tempshare_backend.model.UserModel;
import com.tempshare.tempshare_backend.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
//BCRYPT PASSWORD
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserModel createUser(UserModel userModel) {
        userModel.setJoinedDate(new Date(System.currentTimeMillis()));

        if (userRepository.findByUsername(userModel.getUsername()).isPresent())
            throw new RuntimeException("Username already exists");

        userModel.setPassword(passwordEncoder.encode(userModel.getPassword()));
        return userRepository.save(userModel);
    }

    public List<UserModel> getAllUsers() {
        return userRepository.findAll();
    }

    public UserModel getUserById(Long id){
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User DOES not exist"));
    }

    public UserModel updateUser(Long id, UserModel newUserData) {
        UserModel existingUser = userRepository.findById(id)
                .orElseThrow(()->
                        new RuntimeException("user not found")
                );
        existingUser.setUsername(newUserData.getUsername());
        existingUser.setPassword(passwordEncoder.encode(newUserData.getPassword())
        );
        return userRepository.save(existingUser);
    }

    public void deleteUserId(Long id){
        if(!(userRepository.existsById(id)))
            throw new RuntimeException("user not found");
        else
            userRepository.deleteById(id);
    }


}
