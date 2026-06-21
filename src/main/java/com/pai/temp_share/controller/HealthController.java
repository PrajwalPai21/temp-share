package com.pai.temp_share.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {
    @GetMapping("/api/health")
    public String healthController() {
        return "TempShare is working properly";
    }
}
