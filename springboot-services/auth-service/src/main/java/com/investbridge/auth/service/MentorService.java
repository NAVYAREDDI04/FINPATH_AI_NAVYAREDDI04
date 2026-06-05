package com.investbridge.auth.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.investbridge.auth.entity.Mentor;
import com.investbridge.auth.repository.MentorRepository;

@Service
public class MentorService {

    @Autowired
    private MentorRepository mentorRepository;

    public List<Mentor> getMentorsByCity(String city) {
        return mentorRepository.findByCityIgnoreCase(city);
    }
}
