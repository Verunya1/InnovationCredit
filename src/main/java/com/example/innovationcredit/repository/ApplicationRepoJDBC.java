/*package com.example.innovationcredit.repository;


import com.example.innovationcredit.exception.LoanProcessException;
import com.example.innovationcredit.model.enums.ErrorCode;
import com.example.innovationcredit.model.entity.Application;
import com.example.innovationcredit.model.entity.TariffEntity;
import com.example.innovationcredit.model.mapper.TariffMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class ApplicationRepoJDBC {
    private final JdbcTemplate jdbcTemplate;
    private final TariffMapper tariffMapper;

    private final String SQL_FIND_BY_TARIFF_ID = "select * from tariffs where tariff_id = ?";
    private final String SQL_FIND_BY_USER_ID = "select * from loan_order where user_id = ?";

*//*public Application getStatus(long orderId) {
        return jdbcTemplate.queryForObject("select(order_id) from loan_order where orderId=?",new Object[]{orderId},  new BeanPropertyRowMapper<Application>());
    }*//*


    public UUID supply(long tariffId, long userId) {
        var tariffCheck = jdbcTemplate.queryForStream(SQL_FIND_BY_TARIFF_ID, new BeanPropertyRowMapper<>(TariffEntity.class), tariffId).findFirst();

        if (tariffCheck.isEmpty())
            throw new LoanProcessException(ErrorCode.TARIFF_NOT_FOUND, "тариф не найден");

        var userCheck = jdbcTemplate.queryForStream(SQL_FIND_BY_USER_ID, new BeanPropertyRowMapper<>(Application.class), userId).findFirst();

//        jdbcTemplate.update("insert into loan_order values(1,?,?,?,?)", application.getUser_id(), application.getTariff_id(), user.getName(), user.getSurname());
    }

*//*
  public void delete(long userId,long orderId) {
        BeanPropertyRowMapper application = new BeanPropertyRowMapper<Application>();
//        application.
//        return jdbcTemplate.update("delete from loan_order WHERE id=?", id", new UserMapper());
    }
*//*

}*/


