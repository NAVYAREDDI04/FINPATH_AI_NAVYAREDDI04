package com.investbridge.auth.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "chat_messages")
public class ChatMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User student;

    @ManyToOne
    private Distributor mentor;

    private String message;
    private LocalDateTime sentAt;

    public ChatMessage() {
    }

    public ChatMessage(User student, Distributor mentor, String message, LocalDateTime sentAt) {
        this.student = student;
        this.mentor = mentor;
        this.message = message;
        this.sentAt = sentAt;
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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getSentAt() {
        return sentAt;
    }

    public void setSentAt(LocalDateTime sentAt) {
        this.sentAt = sentAt;
    }
}
