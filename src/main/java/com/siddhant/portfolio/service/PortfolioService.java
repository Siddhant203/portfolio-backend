package com.siddhant.portfolio.service;

import com.siddhant.portfolio.entity.Portfolio;
import com.siddhant.portfolio.repository.PortfolioRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PortfolioService {

    private final PortfolioRepository portfolioRepository;

    public PortfolioService(PortfolioRepository portfolioRepository) {
        this.portfolioRepository = portfolioRepository;
    }

    public Optional<Portfolio> getPorfolio(){
        return portfolioRepository.findAll()
            .stream()
            .findFirst();
    }
}
