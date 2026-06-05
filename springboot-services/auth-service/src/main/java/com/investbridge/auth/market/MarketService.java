package com.investbridge.auth.market;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarketService {

    public List<StockDTO> getStocks() {
        return List.of(
                new StockDTO("TCS", 4200, 2.3),
                new StockDTO("INFY", 1600, -1.2),
                new StockDTO("RELIANCE", 2900, 0.8)
        );
    }
}
