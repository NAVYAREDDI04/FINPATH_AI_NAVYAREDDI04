package com.investbridge.auth.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "mentor_requests")
public class MentorRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User student;

    @ManyToOne
    private Distributor mentor;

    private String status;
    private LocalDateTime requestedDate;

    public MentorRequest() {
    }

    public MentorRequest(User student, Distributor mentor, String status, LocalDateTime requestedDate) {
        this.student = student;
        this.mentor = mentor;
        this.status = status;
        this.requestedDate = requestedDate;
    }

    public Long getId() {
        return id;
    }

    public User getStudent() {
        return student;
    }

    public void setStudent(User student) {
        this.student = student;
    }

    public Distributor getMentor() {
        return mentor;
    }

    public void setMentor(Distributor mentor) {
        this.mentor = mentor;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getRequestedDate() {
        return requestedDate;
    }

    public void setRequestedDate(LocalDateTime requestedDate) {
        this.requestedDate = requestedDate;
    }
}
