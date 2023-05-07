package com.example.innovationcredit.repository;

import com.example.innovationcredit.entity.TariffEntity;
import com.example.innovationcredit.mapper.TariffMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class TariffRepoJDBC {
    private final JdbcTemplate jdbcTemplate;

    public List<TariffEntity> findAll() {
        return jdbcTemplate.query("SELECT * FROM tariff_id WHERE id=?", new TariffMapper());
    }
}
