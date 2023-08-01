package com.mike.forexservice.dto;

import java.math.BigDecimal;
import java.util.Map;

public record CurrencyRateDto(String disclaimer, String license, Long timestamp, String base,
                              Map<String, BigDecimal> rates) {
}
