package com.tempshare.tempshare_backend.service;

import com.tempshare.tempshare_backend.dto.LoginRequest;
import com.tempshare.tempshare_backend.dto.SignUpRequest;
import com.tempshare.tempshare_backend.model.User;
import com.tempshare.tempshare_backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // business logic
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;

    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
    //The repository used to query/save users.
                            //dto class.java
    public String signupFunc(SignUpRequest request) {
        if(userRepository.findByEmail(request.getEmail()).isPresent())
            return "Email is already in use";

        User user = User.builder()
                .fullName(request.getFullName())
                .email(request.getEmail())
                .password(bCryptPasswordEncoder.encode(request.getPassword())).build();
        //Creates a new User entity using Lombok builder.

        userRepository.save(user); //jpa  inserts the row
        return  "You have successfully signed up!";
    }

    public String loginFunc(LoginRequest request) {
        User user = userRepository.findByEmail(request.getEmail()).orElse(null);
        if(user == null)
            return "User not found";
        if(!bCryptPasswordEncoder.matches(request.getPassword(), user.getPassword()))
            return "Wrong password";

        return "You have Logged in";
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
