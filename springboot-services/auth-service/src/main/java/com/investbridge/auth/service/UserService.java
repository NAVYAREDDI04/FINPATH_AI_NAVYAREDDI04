package com.investbridge.auth.service;

import com.investbridge.auth.dto.ProfileUpdateRequest;
import com.investbridge.auth.dto.UserProfileResponse;
import com.investbridge.auth.entity.User;
import com.investbridge.auth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public UserProfileResponse getProfile(String email) {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            return null;
        }
        return new UserProfileResponse(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getProfession(),
                user.getLocation(),
                user.getExperienceLevel(),
                user.getCreatedAt()
        );
    }

    public UserProfileResponse updateProfile(String email, ProfileUpdateRequest request) {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            return null;
        }
        if (request.getName() != null && !request.getName().isBlank()) {
            user.setName(request.getName());
        }
        if (request.getPassword() != null && !request.getPassword().isBlank()) {
            user.setPassword(passwordEncoder.encode(request.getPassword()));
        }
        if (request.getProfession() != null) {
            user.setProfession(request.getProfession());
        }
        if (request.getLocation() != null) {
            user.setLocation(request.getLocation());
        }
        if (request.getExperienceLevel() != null) {
            user.setExperienceLevel(request.getExperienceLevel());
        }
        userRepository.save(user);
        return new UserProfileResponse(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getProfession(),
                user.getLocation(),
                user.getExperienceLevel(),
                user.getCreatedAt()
        );
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
