package com.example.innovationcredit.repository;

import com.example.innovationcredit.entity.Application;
import com.example.innovationcredit.entity.DataEntity;
import com.example.innovationcredit.mapper.TariffMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
/*

@Component
@RequiredArgsConstructor
public class ApplicationRepoJDBC {
    private final JdbcTemplate jdbcTemplate;
    private final TariffMapper tariffMapper;

    private final String SQL_FIND_BY_TARIFF_ID = "select * from tariff_id where tariff_id = ?";

    public Application getStatus(long orderId) {
        return jdbcTemplate.queryForObject("select(order_id) from loan_order where orderId=?",new Object[]{orderId},  new BeanPropertyRowMapper<Application>());
    }

    public List<DataEntity> supply(long tariffId, Application application) {
         jdbcTemplate.queryForStream(SQL_FIND_BY_TARIFF_ID, tariffMapper, tariffId).findFirst();

//        jdbcTemplate.update("insert into loan_order values(1,?,?,?,?)", application.getUser_id(), application.getTariff_id(), user.getName(), user.getSurname());
    }

    public void delete(long userId,long orderId) {
        BeanPropertyRowMapper application = new BeanPropertyRowMapper<Application>();
//        application.
//        return jdbcTemplate.update("delete from loan_order WHERE id=?", id", new UserMapper());
    }
}
*/
