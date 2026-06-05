package com.investbridge.ai.auth_service.security;

import org.springframework.stereotype.Component;

@Component
public class JwtUtil {

    private final String secret = "changeThisSecretKey";

    public String generateToken(String username) {
        return "token-for-" + username;
    }

    public String extractUsername(String token) {
        if (token == null || !token.startsWith("token-for-")) {
            return null;
        }
        return token.substring("token-for-".length());
    }

    public boolean validateToken(String token, String username) {
        return username != null && token != null && token.equals(generateToken(username));
    }
}
