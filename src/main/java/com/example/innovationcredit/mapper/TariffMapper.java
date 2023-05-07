package com.example.innovationcredit.mapper;

import com.example.innovationcredit.entity.TariffEntity;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TariffMapper implements RowMapper<TariffEntity> {
    @Override
    public TariffEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
        TariffEntity tariff = new TariffEntity();

        tariff.setId(rs.getLong("id"));
        tariff.setType(rs.getString("type"));
        tariff.setInterest_rate(rs.getString("interest_rate"));

        return tariff;
    }
}
