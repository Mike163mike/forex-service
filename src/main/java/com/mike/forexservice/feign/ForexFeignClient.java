package com.mike.forexservice.feign;

import com.mike.forexservice.dto.CurrencyRateDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient(name = "${feign.name}", url = "${feign.url}")
public interface ForexFeignClient {

    @GetMapping("latest.json")
    CurrencyRateDto getLatestRates(@RequestParam("app_id") String appId,
                                   @RequestParam("symbols") String currencyForCalculate);

    @GetMapping("currencies.json")
    Map<String, String> getAllCurrencies();
}
