package com.example.innovationcredit.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.sql.Types;

import static com.example.innovationcredit.model.enums.StatusCode.*;

@Service
//@Component
@RequiredArgsConstructor
public class StatusService {
    private static final Logger logger = LoggerFactory.getLogger(StatusService.class);
    private final JdbcTemplate jdbcTemplate;

    @Scheduled(initialDelayString = "${update-loan.initial-delay:2000}", fixedRateString = "${update-loan.rate:120000}")
    @Transactional
//    @Async
    public void refreshPricingParameters() {
        logger.info("{} loan orders have been updated", jdbcTemplate.update("update loan_order" +
                " set status = case (random() * 10)::int % 2 when 0 then ? else ? end," +
                " time_update = now()" +
                " where status = ?", APPROVED.name(), REFUSED.name(), IN_PROGRESS.name()));
    }

}
