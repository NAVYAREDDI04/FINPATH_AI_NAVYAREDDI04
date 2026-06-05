package com.investbridge.auth.service;

import org.springframework.stereotype.Service;

@Service
public class GuidanceService {

    public String getAdvice(String profession, String level) {
        if (profession != null && profession.equalsIgnoreCase("Student")
                && level != null && level.equalsIgnoreCase("Beginner")) {
            return "Start with Mutual Funds. Learn SIPs. Connect with a certified mentor. Avoid direct stock trading initially.";
        }

        if (level != null && level.equalsIgnoreCase("Intermediate")) {
            return "Learn ETFs. Start Portfolio Building. Diversify Investments.";
        }

        return "Use Stock Analysis Tools. Track Portfolio Risk. Explore Advanced Strategies.";
    }
}
