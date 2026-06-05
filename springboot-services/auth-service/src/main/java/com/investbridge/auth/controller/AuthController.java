package com.investbridge.auth.controller;

import com.investbridge.auth.dto.AuthResponse;
import com.investbridge.auth.dto.JwtResponse;
import com.investbridge.auth.dto.LoginRequest;
import com.investbridge.auth.dto.RegisterRequest;
import com.investbridge.auth.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public AuthResponse registerUser(@RequestBody RegisterRequest request) {
        String message = authService.registerUser(request);
        return new AuthResponse(message);
    }

    @PostMapping("/login")
    public JwtResponse loginUser(@RequestBody LoginRequest request) {
        return authService.loginUser(request);
    }
}
