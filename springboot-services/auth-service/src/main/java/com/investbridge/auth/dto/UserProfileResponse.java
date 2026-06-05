package com.investbridge.auth.dto;

import java.time.LocalDateTime;

public class UserProfileResponse {

    private Long id;
    private String name;
    private String email;
    private String profession;
    private String location;
    private String experienceLevel;
    private LocalDateTime createdAt;

    public UserProfileResponse(Long id, String name, String email, String profession, String location, String experienceLevel, LocalDateTime createdAt) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.profession = profession;
        this.location = location;
        this.experienceLevel = experienceLevel;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getProfession() {
        return profession;
    }

    public String getLocation() {
        return location;
    }

    public String getExperienceLevel() {
        return experienceLevel;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
