package com.investbridge.auth.controller;

import com.investbridge.auth.dto.ReviewRequestDTO;
import com.investbridge.auth.entity.Review;
import com.investbridge.auth.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @PostMapping
    public Review submitReview(Principal principal, @RequestBody ReviewRequestDTO request) {
        return reviewService.saveReview(principal.getName(), request.getMentorId(), request.getRating(), request.getComment());
    }

    @GetMapping("/mentor/{mentorId}")
    public List<Review> getReviewsForMentor(@PathVariable Long mentorId) {
        return reviewService.getReviewsForMentor(mentorId);
    }
}
