package com.siddhant.portfolio.controller;

import com.siddhant.portfolio.dto.PortfolioResponse;
import com.siddhant.portfolio.service.PortfolioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("api/portfolio")
public class PortfolioController {

    private final PortfolioService portfolioService;

    public PortfolioController(PortfolioService portfolioService) {
        this.portfolioService = portfolioService;
    }

    @GetMapping
    public ResponseEntity<PortfolioResponse> getPortfolio(){
        return portfolioService.getPorfolio()
                .map(portfolio -> ResponseEntity.ok(
                        new PortfolioResponse(
                                portfolio.getName(),
                                portfolio.getTitle(),
                                portfolio.getAbout(),
                                portfolio.getEmail()
                        )
                ))
                .orElse(ResponseEntity.notFound().build());
    }
}
