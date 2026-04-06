package com.tempshare.tempshare_backend.dto;
//DTO data transfer objecct : simple classes used to receive request bodies from the client (frontend).
import lombok.Data;

@Data //generates getters and setters automatically
public class LoginRequest {
    private String email;
    private String password;
}
