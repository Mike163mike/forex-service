package com.mike.forexservice.repository;

import com.mike.forexservice.model.ExchangeValue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ExchangeValueRepository extends JpaRepository<ExchangeValue, Long> {

    String GET_QUERIES_BY_DAY = "select ev from ExchangeValue ev where time between ?1 and ?2";

    @Query(GET_QUERIES_BY_DAY)
    List<ExchangeValue> getExchangeValueByTime(LocalDateTime from, LocalDateTime to);
}
