package com.investbridge.auth.service;

import com.investbridge.auth.entity.Distributor;
import com.investbridge.auth.entity.User;
import com.investbridge.auth.repository.DistributorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProfileAnalysisService {

    @Autowired
    private DistributorRepository distributorRepository;

    public ProfileAnalysisResult analyzeProfile(String profession, String experience, String location) {
        List<String> recommendations = new ArrayList<>();
        if (profession.equalsIgnoreCase("Student") && experience.equalsIgnoreCase("Beginner")) {
            recommendations.add("Learn Mutual Funds First");
            recommendations.add("Complete Beginner Course");
            recommendations.add("Connect With Certified Distributor");
            recommendations.add("Avoid Direct Equity Trading Initially");
        } else if (profession.equalsIgnoreCase("Student") && experience.equalsIgnoreCase("Intermediate")) {
            recommendations.add("SIP Recommendations");
            recommendations.add("ETF Learning");
            recommendations.add("Portfolio Building");
            recommendations.add("Mentor Optional");
        } else if (profession.equalsIgnoreCase("Student") && experience.equalsIgnoreCase("Advanced")) {
            recommendations.add("Stock Screening Tools");
            recommendations.add("Portfolio Optimization");
            recommendations.add("Risk Analytics");
            recommendations.add("AI Market Insights");
        }

        List<Distributor> mentors = new ArrayList<>();
        if (profession.equalsIgnoreCase("Student") && experience.equalsIgnoreCase("Beginner")) {
            mentors = distributorRepository.findByLocation(location);
        }

        return new ProfileAnalysisResult(recommendations, mentors);
    }

    public static class ProfileAnalysisResult {
        private List<String> recommendations;
        private List<Distributor> mentors;

        public ProfileAnalysisResult(List<String> recommendations, List<Distributor> mentors) {
            this.recommendations = recommendations;
            this.mentors = mentors;
        }

        public List<String> getRecommendations() {
            return recommendations;
        }

        public List<Distributor> getMentors() {
            return mentors;
        }
    }
}
