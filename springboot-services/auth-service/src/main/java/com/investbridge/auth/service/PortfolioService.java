package com.investbridge.auth.service;

import com.investbridge.auth.dto.PortfolioRequest;
import com.investbridge.auth.entity.Portfolio;
import com.investbridge.auth.entity.User;
import com.investbridge.auth.repository.PortfolioRepository;
import com.investbridge.auth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PortfolioService {

    @Autowired
    private PortfolioRepository portfolioRepository;

    @Autowired
    private UserRepository userRepository;

    public Portfolio addStock(String email, PortfolioRequest request) {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            return null;
        }
        Portfolio portfolio = new Portfolio(
                request.getStockName(),
                request.getQuantity(),
                request.getBuyPrice(),
                request.getCurrentPrice(),
                user
        );
        return portfolioRepository.save(portfolio);
    }

    public List<Portfolio> getAllStocks(String email) {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            return List.of();
        }
        return portfolioRepository.findByUser(user);
    }

    public boolean deleteStock(String email, Long id) {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            return false;
        }
        Optional<Portfolio> existing = portfolioRepository.findById(id);
        if (existing.isEmpty()) {
            return false;
        }
        Portfolio portfolio = existing.get();
        if (!portfolio.getUser().getId().equals(user.getId())) {
            return false;
        }
        portfolioRepository.deleteById(id);
        return true;
    }

    public double calculateProfit(Portfolio portfolio) {
        return portfolio.getProfit();
    }
}
