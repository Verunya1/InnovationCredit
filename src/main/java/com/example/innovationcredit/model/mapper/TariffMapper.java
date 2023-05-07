package com.example.innovationcredit.model.mapper;

import com.example.innovationcredit.model.entity.TariffEntity;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class TariffMapper implements RowMapper<TariffEntity> {
    @Override
    public TariffEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
        TariffEntity tariff = new TariffEntity();

        tariff.setId(rs.getLong("id"));
        tariff.setType(rs.getString("type"));
        tariff.setInterestRate(rs.getString("interest_rate"));

        return tariff;
    }
}
