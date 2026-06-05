package com.investbridge.auth.controller;

import com.investbridge.auth.dto.ChatRequest;
import com.investbridge.auth.dto.ChatResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/chat")
public class ChatController {

    @PostMapping
    public ChatResponse chat(@RequestBody ChatRequest request) {
        String message = request.getMessage();
        if (message == null) {
            return new ChatResponse("I didn't understand that.");
        }
        String normalized = message.toLowerCase();
        if (normalized.contains("sip")) {
            return new ChatResponse("SIP stands for Systematic Investment Plan.");
        } else if (normalized.contains("mutual fund")) {
            return new ChatResponse("A mutual fund pools money from many investors to buy assets.");
        } else if (normalized.contains("risk")) {
            return new ChatResponse("Risk depends on your time horizon and investment goals.");
        }
        return new ChatResponse("I didn't understand that.");
    }
}
