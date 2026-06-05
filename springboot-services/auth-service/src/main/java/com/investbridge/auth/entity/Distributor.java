package com.investbridge.auth.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "distributors")
public class Distributor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String location;
    private String qualification;
    private int experienceYears;
    private int investorsGuided;
    private double rating;
    private String phone;
    private String email;
    private String assetsManaged;
    private String certifications;
    private String clientReviews;
    private String educationSessions;

    public Distributor() {
    }

    public Distributor(String name, String location, String qualification, int experienceYears, int investorsGuided, double rating, String phone, String email, String assetsManaged, String certifications, String clientReviews, String educationSessions) {
        this.name = name;
        this.location = location;
        this.qualification = qualification;
        this.experienceYears = experienceYears;
        this.investorsGuided = investorsGuided;
        this.rating = rating;
        this.phone = phone;
        this.email = email;
        this.assetsManaged = assetsManaged;
        this.certifications = certifications;
        this.clientReviews = clientReviews;
        this.educationSessions = educationSessions;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public int getExperienceYears() {
        return experienceYears;
    }

    public void setExperienceYears(int experienceYears) {
        this.experienceYears = experienceYears;
    }

    public int getInvestorsGuided() {
        return investorsGuided;
    }

    public void setInvestorsGuided(int investorsGuided) {
        this.investorsGuided = investorsGuided;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAssetsManaged() {
        return assetsManaged;
    }

    public void setAssetsManaged(String assetsManaged) {
        this.assetsManaged = assetsManaged;
    }

    public String getCertifications() {
        return certifications;
    }

    public void setCertifications(String certifications) {
        this.certifications = certifications;
    }

    public String getClientReviews() {
        return clientReviews;
    }

    public void setClientReviews(String clientReviews) {
        this.clientReviews = clientReviews;
    }

    public String getEducationSessions() {
        return educationSessions;
    }

    public void setEducationSessions(String educationSessions) {
        this.educationSessions = educationSessions;
    }
}
