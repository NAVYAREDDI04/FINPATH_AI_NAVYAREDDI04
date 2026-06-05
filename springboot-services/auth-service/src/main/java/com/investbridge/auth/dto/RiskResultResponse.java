package com.investbridge.auth.dto;

public class RiskResultResponse {

    private Long id;
    private Long userId;
    private Integer score;
    private String riskLevel;

    public RiskResultResponse(Long id, Long userId, Integer score, String riskLevel) {
        this.id = id;
        this.userId = userId;
        this.score = score;
        this.riskLevel = riskLevel;
    }

    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public Integer getScore() {
        return score;
    }

    public String getRiskLevel() {
        return riskLevel;
    }
}
