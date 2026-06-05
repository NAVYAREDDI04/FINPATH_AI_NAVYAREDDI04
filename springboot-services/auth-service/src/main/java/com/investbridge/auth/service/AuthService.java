package com.investbridge.auth.service;

import com.investbridge.auth.dto.JwtResponse;
import com.investbridge.auth.dto.LoginRequest;
import com.investbridge.auth.dto.RegisterRequest;
import com.investbridge.auth.entity.User;
import com.investbridge.auth.repository.UserRepository;
import com.investbridge.auth.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    public String registerUser(RegisterRequest request) {
        boolean emailExists = userRepository.existsByEmail(request.getEmail());
        if (emailExists) {
            return "Email already registered";
        }
        String encryptedPassword = passwordEncoder.encode(request.getPassword());
        User user = new User(
                request.getName(),
                request.getProfession(),
                request.getLocation(),
                request.getExperienceLevel(),
                request.getEmail(),
                encryptedPassword,
                com.investbridge.auth.entity.Role.STUDENT
        );
        userRepository.save(user);
        return "Registration successful";
    }

    public JwtResponse loginUser(LoginRequest request) {
        User user = userRepository.findByEmail(request.getEmail());
        if (user == null) {
            throw new IllegalArgumentException("Invalid email or password");
        }
        boolean passwordMatched = passwordEncoder.matches(request.getPassword(), user.getPassword());
        if (!passwordMatched) {
            throw new IllegalArgumentException("Invalid email or password");
        }
        String token = jwtUtil.generateToken(user.getEmail());
        return new JwtResponse(token);
    }
}
