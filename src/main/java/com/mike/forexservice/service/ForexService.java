package com.mike.forexservice.service;

import com.mike.forexservice.model.ExchangeValue;
import com.mike.forexservice.repository.ExchangeValueRepository;
import com.mike.forexservice.util.StringUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.NoSuchElementException;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ForexService {

    private final FeignService feignService;
    private final ExchangeValueRepository exchangeValueRepository;

    public ExchangeValue calculateRate(String baseCurrency, String currencyForCalculate) {
        if (!StringUtil.currencyStringValidate(baseCurrency) &&
                !StringUtil.currencyStringValidate(currencyForCalculate)) {
            throw new NoSuchElementException("Insert appropriate symbol for currency.");
        }
        var baseRate = feignService.getLatestRates(baseCurrency);
        var forCalculateRate = feignService.getLatestRates(currencyForCalculate);
        var exchangeValue = new ExchangeValue();
        exchangeValue.setId(UUID.randomUUID());
        exchangeValue.setFrom(baseCurrency);
        exchangeValue.setTo(currencyForCalculate);
        exchangeValue.setConversionMultiple(forCalculateRate.divide(baseRate, 4, RoundingMode.HALF_UP));
        exchangeValue.setTime(LocalDateTime.now());
        saveCalculateRequest(exchangeValue);
        return exchangeValue;
    }

    public void saveCalculateRequest(ExchangeValue exchangeValue) {
        exchangeValueRepository.save(exchangeValue);
    }
}
