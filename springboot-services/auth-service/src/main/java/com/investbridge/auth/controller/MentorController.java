package com.investbridge.auth.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.investbridge.auth.entity.Mentor;
import com.investbridge.auth.service.MentorService;

@RestController
@RequestMapping("/api/mentors")
public class MentorController {

    @Autowired
    private MentorService mentorService;

    @GetMapping("/{city}")
    public List<Mentor> getMentorsByCity(@PathVariable String city) {
        return mentorService.getMentorsByCity(city);
    }
}
