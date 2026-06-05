package com.investbridge.auth.market;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/stocks")
public class MarketController {

    @Autowired
    private MarketService service;

    @GetMapping
    public List<StockDTO> getStocks() {
        return service.getStocks();
    }
}
