package com.investbridge.auth.controller;

import com.investbridge.auth.entity.Distributor;
import com.investbridge.auth.service.RecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/recommend")
public class RecommendationController {

    @Autowired
    private RecommendationService service;

    @GetMapping("/{userId}")
    public List<Distributor> getRecommendations(@PathVariable Long userId) {
        return service.recommend(userId);
    }
}
