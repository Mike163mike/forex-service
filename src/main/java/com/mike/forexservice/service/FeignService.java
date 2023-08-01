package com.mike.forexservice.service;

import com.mike.forexservice.feign.ForexFeignClient;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class FeignService {

    private final ForexFeignClient forexFeignClient;
    @Value("${openexchangerates-api-key}")
    private String openExchangeToken;

    public BigDecimal getLatestRates(String currencyForCalculate) {
        if (currencyForCalculate == null) {
            currencyForCalculate = "USD";
        }
        var currencyRateDto = forexFeignClient.getLatestRates(openExchangeToken, currencyForCalculate);
        return currencyRateDto.rates().get(currencyForCalculate);
    }

    public Map<String, String> getAllCurrencies() {
        return forexFeignClient.getAllCurrencies();
    }
}
