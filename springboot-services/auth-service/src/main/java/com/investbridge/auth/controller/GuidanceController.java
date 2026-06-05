package com.investbridge.auth.controller;

import com.investbridge.auth.entity.User;
import com.investbridge.auth.repository.UserRepository;
import com.investbridge.auth.service.GuidanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/guidance")
public class GuidanceController {

    @Autowired
    private GuidanceService guidanceService;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/{userId}")
    public String getGuidance(@PathVariable Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("User not found"));
        return guidanceService.getAdvice(user.getProfession(), user.getExperienceLevel());
    }
}
