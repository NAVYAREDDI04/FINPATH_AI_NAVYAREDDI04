package com.investbridge.auth.service;

import com.investbridge.auth.entity.Distributor;
import com.investbridge.auth.entity.MentorRequest;
import com.investbridge.auth.entity.User;
import com.investbridge.auth.repository.DistributorRepository;
import com.investbridge.auth.repository.MentorRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MentorRequestService {

    @Autowired
    private MentorRequestRepository mentorRequestRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private DistributorRepository distributorRepository;

    public MentorRequest requestMentorship(String studentEmail, Long mentorId) {
        User student = userService.findByEmail(studentEmail);
        if (student == null) {
            return null;
        }
        Distributor mentor = distributorRepository.findById(mentorId).orElse(null);
        if (mentor == null) {
            return null;
        }
        MentorRequest request = new MentorRequest(student, mentor, "Pending", LocalDateTime.now());
        return mentorRequestRepository.save(request);
    }

    public MentorRequest getMentorRequest(Long id) {
        return mentorRequestRepository.findById(id).orElse(null);
    }

    public List<MentorRequest> getMentorRequests(String studentEmail) {
        return mentorRequestRepository.findByStudentEmail(studentEmail);
    }
}
