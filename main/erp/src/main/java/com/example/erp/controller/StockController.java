package com.example.erp.controller;

import com.example.erp.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.Date;

@RestController
public class StockController {

    private final StockService stockService;

    @Autowired
    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    @PostMapping("/stock/cost")
    public ResponseEntity<Integer> clacStockCost(@RequestParam long storageId, @RequestParam String date) {
        int cost = 0;

        try {
            cost = stockService.stockCostCalculationDate(storageId, date);
        } catch (ParseException e) {
            System.out.println("parseException");
        }

        return ResponseEntity.ok(cost);
    }


}
