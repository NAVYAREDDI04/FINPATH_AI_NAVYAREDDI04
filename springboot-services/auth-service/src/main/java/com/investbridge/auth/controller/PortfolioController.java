package com.investbridge.auth.controller;

import com.investbridge.auth.dto.PortfolioRequest;
import com.investbridge.auth.entity.Portfolio;
import com.investbridge.auth.service.PortfolioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/portfolio")
public class PortfolioController {

    @Autowired
    private PortfolioService portfolioService;

    @PostMapping("/add")
    public Portfolio addStock(Authentication authentication,
                              @RequestBody PortfolioRequest request) {
        return portfolioService.addStock(authentication.getName(), request);
    }

    @GetMapping("/all")
    public List<Portfolio> getAllStocks(Authentication authentication) {
        return portfolioService.getAllStocks(authentication.getName());
    }

    @DeleteMapping("/{id}")
    public String deleteStock(Authentication authentication,
                              @PathVariable Long id) {
        boolean deleted = portfolioService.deleteStock(authentication.getName(), id);
        return deleted ? "Stock deleted" : "Not found or unauthorized";
    }
}
