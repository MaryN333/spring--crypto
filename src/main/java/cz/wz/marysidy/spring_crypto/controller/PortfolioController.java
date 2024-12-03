package cz.wz.marysidy.spring_crypto.controller;

import cz.wz.marysidy.spring_crypto.service.CryptoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PortfolioController {
    private final CryptoService cryptoService;

    public PortfolioController(CryptoService cryptoService) {
        this.cryptoService = cryptoService;
    }

    // Getting total price of portfolio
    @GetMapping("/portfolio-value")
    public double getPortfolioValue() {
        return cryptoService.getPortfolioValue();
    }
}
