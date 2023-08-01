package com.mike.forexservice.service;

import com.mike.forexservice.model.ExchangeValue;
import com.mike.forexservice.repository.ExchangeValueRepository;
import com.mike.forexservice.util.StringUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RequestLogService {

    private final ExchangeValueRepository exchangeValueRepository;

    public List<ExchangeValue> getRequestsByDate(String stringDate) {
        var localDate = StringUtil.parseStringToLocalDate(stringDate);
        var from = LocalDateTime.of(localDate, LocalTime.ofSecondOfDay(1));
        var to = from.plus(Duration.ofDays(1));
        return exchangeValueRepository.getExchangeValueByTime(from, to);
    }

    public List<ExchangeValue> getAllQueries() {
        return exchangeValueRepository.findAll();
    }
}
