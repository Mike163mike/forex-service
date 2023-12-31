package com.mike.forexservice.controller;

import com.mike.forexservice.model.ExchangeValue;
import com.mike.forexservice.service.FeignService;
import com.mike.forexservice.service.ForexService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ForexController {
    private final FeignService feignService;
    private final ForexService forexService;

    @GetMapping("/from/{from}/to/{to}")
    public ResponseEntity<ExchangeValue> retrieveExchangeValue(@PathVariable String from, @PathVariable String to) {
        return new ResponseEntity<>(forexService.calculateRate(from, to), HttpStatus.OK);
    }

    @GetMapping("/info")
    public ResponseEntity<?> getAllCurrencies() {
        return new ResponseEntity<>(feignService.getAllCurrencies(), HttpStatus.OK);
    }
}
