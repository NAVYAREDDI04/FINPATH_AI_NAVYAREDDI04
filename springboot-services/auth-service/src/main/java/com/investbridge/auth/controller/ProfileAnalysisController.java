package com.investbridge.auth.controller;

import com.investbridge.auth.dto.ProfileAnalysisRequest;
import com.investbridge.auth.service.ProfileAnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/profile")
public class ProfileAnalysisController {

    @Autowired
    private ProfileAnalysisService profileAnalysisService;

    @PostMapping("/analyze")
    public ProfileAnalysisService.ProfileAnalysisResult analyzeProfile(@RequestBody ProfileAnalysisRequest request) {
        return profileAnalysisService.analyzeProfile(request.getProfession(), request.getExperience(), request.getLocation());
    }
}
