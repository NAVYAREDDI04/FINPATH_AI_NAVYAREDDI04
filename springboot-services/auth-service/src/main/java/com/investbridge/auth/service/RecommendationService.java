package com.investbridge.auth.service;

import com.investbridge.auth.entity.Distributor;
import com.investbridge.auth.entity.User;
import com.investbridge.auth.repository.DistributorRepository;
import com.investbridge.auth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class RecommendationService {

    @Autowired
    private DistributorRepository distributorRepo;

    @Autowired
    private UserRepository userRepo;

    public List<Distributor> recommend(Long userId) {
        User user = userRepo.findById(userId).orElseThrow(() -> new IllegalArgumentException("User not found"));
        if (user.getProfession() != null && user.getExperienceLevel() != null
                && user.getProfession().equalsIgnoreCase("Student")
                && user.getExperienceLevel().equalsIgnoreCase("Beginner")) {
            return distributorRepo.findByLocation(user.getLocation());
        }
        return Collections.emptyList();
    }
}
