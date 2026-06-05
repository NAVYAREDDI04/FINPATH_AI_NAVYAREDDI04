package com.investbridge.auth.controller;

import com.investbridge.auth.dto.MentorRequestDTO;
import com.investbridge.auth.entity.MentorRequest;
import com.investbridge.auth.service.MentorRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/api/mentor")
public class MentorRequestController {

    @Autowired
    private MentorRequestService mentorRequestService;

    @PostMapping("/request")
    public String requestMentor(Principal principal, @RequestBody MentorRequestDTO request) {
        MentorRequest mentorRequest = mentorRequestService.requestMentorship(principal.getName(), request.getMentorId());
        if (mentorRequest == null) {
            return "Unable to send mentor request";
        }
        return "Request Sent";
    }

    @GetMapping("/requests")
    public List<MentorRequest> getMentorRequests(Principal principal) {
        return mentorRequestService.getMentorRequests(principal.getName());
    }

    @GetMapping("/{id}")
    public MentorRequest getMentorRequest(@PathVariable Long id) {
        return mentorRequestService.getMentorRequest(id);
    }
}
