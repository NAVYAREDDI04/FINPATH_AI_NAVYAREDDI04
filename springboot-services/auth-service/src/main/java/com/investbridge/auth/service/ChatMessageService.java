package com.investbridge.auth.service;

import com.investbridge.auth.entity.ChatMessage;
import com.investbridge.auth.entity.Distributor;
import com.investbridge.auth.entity.User;
import com.investbridge.auth.repository.ChatMessageRepository;
import com.investbridge.auth.repository.DistributorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ChatMessageService {

    @Autowired
    private ChatMessageRepository chatMessageRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private DistributorRepository distributorRepository;

    public ChatMessage saveMessage(String studentEmail, Long mentorId, String message) {
        User student = userService.findByEmail(studentEmail);
        if (student == null) {
            return null;
        }
        Distributor mentor = distributorRepository.findById(mentorId).orElse(null);
        if (mentor == null) {
            return null;
        }
        ChatMessage chatMessage = new ChatMessage(student, mentor, message, LocalDateTime.now());
        return chatMessageRepository.save(chatMessage);
    }

    public List<ChatMessage> getMessagesForMentor(Long mentorId) {
        return chatMessageRepository.findByMentorId(mentorId);
    }
}
