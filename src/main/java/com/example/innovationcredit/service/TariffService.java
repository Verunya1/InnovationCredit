package com.example.innovationcredit.service;

import com.example.innovationcredit.dto.TariffDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;


public interface TariffService {
    List<TariffDto> getDefaulterUsers();
}
