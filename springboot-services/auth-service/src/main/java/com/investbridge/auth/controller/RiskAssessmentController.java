package com.investbridge.auth.controller;

import com.investbridge.auth.dto.RiskResultResponse;
import com.investbridge.auth.dto.RiskSubmitRequest;
import com.investbridge.auth.service.RiskAssessmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/risk")
public class RiskAssessmentController {

    @Autowired
    private RiskAssessmentService riskAssessmentService;

    @PostMapping("/submit")
    public RiskResultResponse submitRiskAssessment(Authentication authentication,
                                                  @RequestBody RiskSubmitRequest request) {
        return riskAssessmentService.submitRiskAnswers(authentication.getName(), request);
    }

    @GetMapping("/result")
    public RiskResultResponse getRiskResult(Authentication authentication) {
        return riskAssessmentService.getLatestResult(authentication.getName());
    }
}
