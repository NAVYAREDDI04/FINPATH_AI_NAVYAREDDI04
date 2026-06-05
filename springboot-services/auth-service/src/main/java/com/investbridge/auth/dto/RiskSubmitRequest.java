package com.investbridge.auth.dto;

import java.util.List;

public class RiskSubmitRequest {

    private List<Integer> answers;

    public List<Integer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Integer> answers) {
        this.answers = answers;
    }
}
