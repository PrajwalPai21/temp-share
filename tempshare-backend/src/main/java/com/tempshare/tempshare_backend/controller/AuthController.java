package com.tempshare.tempshare_backend.controller;

import com.tempshare.tempshare_backend.dto.LoginRequest;
import com.tempshare.tempshare_backend.dto.SignUpRequest;
import com.tempshare.tempshare_backend.model.User;
import com.tempshare.tempshare_backend.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//This class is responsible for handling API endpoints.
//It returns:
//JSON, strings, objects
//@RestController = @Controller + @ResponseBody
//It is specifically used for REST APIs, not HTML pages.

@RequiredArgsConstructor
@RequestMapping("/auth") //Base point so /auth/login or /auth/signup
@CrossOrigin("*") //REMEMBER TO fix //allows frontend to call these endpoints

public class AuthController {
    private final AuthService authService;

    @PostMapping("/signup") // handles POST request
    public String signup(@RequestBody SignUpRequest signUpRequest) { //requestBody tells Spring the request JSON into singupRequest objecgt.
        return authService.signupFunc(signUpRequest); // returns a string
    /*
    * public String
    → Returns a String as the response (example: "Signup successful!")

    @RequestBody
    → Tells Spring that the incoming JSON should be converted into a Java object.

    Example JSON from frontend:

    {
      "fullName": "John Doe",
      "email": "john@example.com",
      "password": "abc123"
    }


    Automatically becomes:

    SignUpRequest signUpRequest = new SignUpRequest();
    signUpRequest.fullName = "John Doe";
    signUpRequest.email = "john@example.com";
    signUpRequest.password = "abc123";


    SignUpRequest signUpRequest
    → The DTO object receiving the parsed JSON.*/

    }
    @CrossOrigin(origins = "http://localhost:5173")
    @GetMapping("/all-users")
    public List<User> getAllUsers() {
        return authService.getAllUsers();
    }
    @PostMapping("/login")
    public String login(@RequestBody LoginRequest loginRequest) {
        return authService.loginFunc(loginRequest);
    }
}
