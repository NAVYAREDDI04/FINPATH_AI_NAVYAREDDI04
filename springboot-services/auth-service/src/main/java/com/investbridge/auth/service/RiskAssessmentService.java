package com.investbridge.auth.service;

import com.investbridge.auth.dto.RiskResultResponse;
import com.investbridge.auth.dto.RiskSubmitRequest;
import com.investbridge.auth.entity.RiskAssessment;
import com.investbridge.auth.entity.User;
import com.investbridge.auth.repository.RiskAssessmentRepository;
import com.investbridge.auth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RiskAssessmentService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RiskAssessmentRepository riskAssessmentRepository;

    public RiskResultResponse submitRiskAnswers(String email, RiskSubmitRequest request) {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            return null;
        }
        int score = request.getAnswers() == null ? 0 : request.getAnswers().stream().mapToInt(Integer::intValue).sum();
        String riskLevel = calculateRiskLevel(score);
        RiskAssessment record = new RiskAssessment(user, score, riskLevel);
        record = riskAssessmentRepository.save(record);
        return new RiskResultResponse(record.getId(), record.getUser().getId(), record.getScore(), record.getRiskLevel());
    }

    public RiskResultResponse getLatestResult(String email) {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            return null;
        }
        Optional<RiskAssessment> optional = riskAssessmentRepository.findFirstByUserOrderByIdDesc(user);
        return optional.map(record -> new RiskResultResponse(record.getId(), record.getUser().getId(), record.getScore(), record.getRiskLevel()))
                .orElse(null);
    }

    private String calculateRiskLevel(int score) {
        if (score <= 10) {
            return "LOW";
        } else if (score <= 20) {
            return "MEDIUM";
        }
        return "HIGH";
    }
}
