package com.investbridge.auth.service;

import com.investbridge.auth.entity.Distributor;
import com.investbridge.auth.entity.Review;
import com.investbridge.auth.entity.User;
import com.investbridge.auth.repository.DistributorRepository;
import com.investbridge.auth.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private DistributorRepository distributorRepository;

    public Review saveReview(String reviewerEmail, Long mentorId, double rating, String comment) {
        User reviewer = userService.findByEmail(reviewerEmail);
        if (reviewer == null) {
            return null;
        }
        Distributor mentor = distributorRepository.findById(mentorId).orElse(null);
        if (mentor == null) {
            return null;
        }
        Review review = new Review(reviewer, mentor, rating, comment, LocalDateTime.now());
        return reviewRepository.save(review);
    }

    public List<Review> getReviewsForMentor(Long mentorId) {
        return reviewRepository.findByMentorId(mentorId);
    }
}
