package com.investbridge.auth.controller;

import com.investbridge.auth.dto.ChatMessageRequest;
import com.investbridge.auth.entity.ChatMessage;
import com.investbridge.auth.service.ChatMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/chat")
public class ChatMessageController {

    @Autowired
    private ChatMessageService chatMessageService;

    @PostMapping
    public ChatMessage saveChatMessage(Principal principal, @RequestBody ChatMessageRequest request) {
        return chatMessageService.saveMessage(principal.getName(), request.getMentorId(), request.getMessage());
    }

    @GetMapping("/mentor/{mentorId}")
    public List<ChatMessage> getMessagesForMentor(@PathVariable Long mentorId) {
        return chatMessageService.getMessagesForMentor(mentorId);
    }
}
