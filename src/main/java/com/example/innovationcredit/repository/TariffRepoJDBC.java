package com.example.innovationcredit.repository;

import com.example.innovationcredit.model.entity.TariffEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class TariffRepoJDBC {
    private final JdbcTemplate jdbcTemplate;

    public List<TariffEntity> findAll() {
        return jdbcTemplate.query("SELECT * FROM tariffs", new BeanPropertyRowMapper<>(TariffEntity.class));
    }
}
