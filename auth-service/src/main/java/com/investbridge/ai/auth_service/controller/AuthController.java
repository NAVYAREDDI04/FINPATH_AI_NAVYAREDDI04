package com.investbridge.ai.auth_service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @GetMapping("/health")
    public String health() {
        return "Auth Service Running Successfully";
    }
}