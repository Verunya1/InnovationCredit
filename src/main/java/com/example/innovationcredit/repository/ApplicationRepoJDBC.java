package com.example.innovationcredit.repository;


import com.example.innovationcredit.exception.LoanProcessException;
import com.example.innovationcredit.model.enums.ErrorCode;
import com.example.innovationcredit.model.entity.Application;
import com.example.innovationcredit.model.entity.TariffEntity;
import com.example.innovationcredit.model.mapper.TariffMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.util.Optional;
import java.util.UUID;

import static com.example.innovationcredit.model.enums.StatusCode.*;

@Component
@RequiredArgsConstructor
public class ApplicationRepoJDBC {
    private final JdbcTemplate jdbcTemplate;
    private final TariffMapper tariffMapper;

    private final String SQL_FIND_BY_TARIFF_ID = "select * from tariffs where id = ?";
    private final String SQL_FIND_BY_ORDER_ID = "select * from loan_order where user_id = ?";

    public Application getStatus(String orderId) {
        var appl = jdbcTemplate.queryForStream("select status from loan_order where order_id = ?", new BeanPropertyRowMapper<>(TariffEntity.class), orderId).findFirst();
        if (appl.isEmpty())
            throw new LoanProcessException(ErrorCode.ORDER_NOT_FOUND, "Заявка не найдена");
        else
            return jdbcTemplate.queryForObject("select status from loan_order where order_id = ?", new BeanPropertyRowMapper<>(Application.class), orderId);
    }


    public UUID supply(long tariffId, long userId) {
        var tariffCheck = jdbcTemplate.queryForStream(SQL_FIND_BY_TARIFF_ID, new BeanPropertyRowMapper<>(TariffEntity.class), tariffId).findFirst();
//        var orderCheck = jdbcTemplate.queryForStream(SQL_FIND_BY_ORDER_ID, new BeanPropertyRowMapper<>(Application.class), userId).findFirst();

        if (tariffCheck.isEmpty())
            throw new LoanProcessException(ErrorCode.TARIFF_NOT_FOUND, "тариф не найден");

         if (jdbcTemplate.query("select * from loan_order where (user_id = ?) ", new BeanPropertyRowMapper<>(Application.class), userId).isEmpty()) {
            throw new LoanProcessException(ErrorCode.LOAN_CONSIDERATION, "заявка на рассмотрении");
        }
         if (jdbcTemplate.query("select * from loan_order where (user_id = ?) and (tarrif_id = ?) and (status = ?)", new BeanPropertyRowMapper<>(Application.class), userId, tariffId, APPROVED.name()).isEmpty()) {
            throw new LoanProcessException(ErrorCode.LOAN_ALREADY_APPROVED, "заявка одобрена");
        }
//         if (jdbcTemplate.queryForObject("select EXTRACT(EPOCH FROM (now() - time_update)) AS difference from loan_order where (user_id = ?) and (tarrif_id = ?) and (status = ?) ", new BeanPropertyRowMapper<>(Application.class), userId, tariffId, REFUSED.name()) < 120L) {
//            throw new LoanProcessException(ErrorCode.TRY_LATER, "попробуйте позже");
//        }
        else {
            UUID orderId = UUID.randomUUID();
            double value = Math.random();
            DecimalFormat decimalFormat = new DecimalFormat("#.##");
            long n = jdbcTemplate.queryForObject("SELECT id FROM loan_order ORDER BY id DESC LIMIT 1",new BeanPropertyRowMapper<>(Application.class)).getId();
            jdbcTemplate.update("insert into loan_order (id,order_id,user_id, tarrif_id, credit_rating, status, time_insert,time_update) values(?,?,?,?,?,?,?,?)", ++n, orderId, userId, tariffId, value, IN_PROGRESS.name(), new Timestamp(System.currentTimeMillis()),new Timestamp(System.currentTimeMillis()));
            return orderId;
        }
    }


    public void delete(long userId, String orderId) {
//        String appl = jdbcTemplate.queryForObject("select status from loan_order where (user_id = ?) and (order_id = ?) ", new BeanPropertyRowMapper<>(Application.class), userId, orderId).getStatus();
//        if (appl!=null)
//            throw new LoanProcessException(ErrorCode.ORDER_NOT_FOUND, "заявка не найдена");
//        if (appl.equals(IN_PROGRESS)){
//            throw new LoanProcessException(ErrorCode.ORDER_IMPOSSIBLE_TO_DELETE, "заявка не может быть удалена");
//        }
        jdbcTemplate.update("delete from loan_order where (user_id = ?) and (order_id = ?) ",userId,orderId);


    }


}


