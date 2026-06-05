package com.investbridge.auth.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "appointments")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User student;

    @ManyToOne
    private Distributor mentor;

    private LocalDateTime scheduledDate;
    private String status;

    public Appointment() {
    }

    public Appointment(User student, Distributor mentor, LocalDateTime scheduledDate, String status) {
        this.student = student;
        this.mentor = mentor;
        this.scheduledDate = scheduledDate;
        this.status = status;
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

    public LocalDateTime getScheduledDate() {
        return scheduledDate;
    }

    public void setScheduledDate(LocalDateTime scheduledDate) {
        this.scheduledDate = scheduledDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
