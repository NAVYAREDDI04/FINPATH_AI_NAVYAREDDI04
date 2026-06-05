package com.investbridge.auth.repository;

import com.investbridge.auth.entity.RiskAssessment;
import com.investbridge.auth.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RiskAssessmentRepository extends JpaRepository<RiskAssessment, Long> {
    Optional<RiskAssessment> findFirstByUserOrderByIdDesc(User user);
}
