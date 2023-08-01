package com.mike.forexservice.controller;

import com.mike.forexservice.model.ExchangeValue;
import com.mike.forexservice.service.RequestLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RequestLogController {

    private final RequestLogService requestLogService;

    @GetMapping("/log/{time}")
    public ResponseEntity<List<ExchangeValue>> getLogForDate(@PathVariable String time) {
        return new ResponseEntity<>(requestLogService.getRequestsByDate(time), HttpStatus.OK);
    }

    @GetMapping("/log")
    public ResponseEntity<List<ExchangeValue>> getAllQueries() {
        return new ResponseEntity<>(requestLogService.getAllQueries(), HttpStatus.OK);
    }
}
