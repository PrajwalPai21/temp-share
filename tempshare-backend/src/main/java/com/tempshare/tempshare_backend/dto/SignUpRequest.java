package com.tempshare.tempshare_backend.dto;

import lombok.Data;

//React Signup Form → JSON → /auth/signup → AuthController → AuthService →
// UserRepository → Database → Response back to frontend

@Data
public class SignUpRequest {
    private String fullName;
    private String email;
    private String password;
}
