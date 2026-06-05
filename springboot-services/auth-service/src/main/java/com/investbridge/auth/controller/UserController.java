package com.investbridge.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.investbridge.auth.dto.ProfileUpdateRequest;
import com.investbridge.auth.dto.UserProfileResponse;
import com.investbridge.auth.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/profile")
    public UserProfileResponse getProfile(Authentication authentication) {
        String email = authentication.getName();
        return userService.getProfile(email);
    }

    @PutMapping("/profile")
    public UserProfileResponse updateProfile(Authentication authentication,
                                             @RequestBody ProfileUpdateRequest request) {
        String email = authentication.getName();
        return userService.updateProfile(email, request);
    }
}
