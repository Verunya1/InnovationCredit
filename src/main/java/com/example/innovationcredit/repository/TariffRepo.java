package com.example.innovationcredit.repository;

import com.example.innovationcredit.model.entity.TariffEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TariffRepo extends JpaRepository<TariffEntity, Long> {
}
