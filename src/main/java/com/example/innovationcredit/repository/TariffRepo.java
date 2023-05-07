package com.example.innovationcredit.repository;

import com.example.innovationcredit.entity.TariffEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TariffRepo extends JpaRepository<TariffEntity, Long> {
    List<TariffEntity> findAll();
}
