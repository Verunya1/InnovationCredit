package com.example.innovationcredit.controller;

import com.example.innovationcredit.api.response.DataResponse;
import com.example.innovationcredit.api.response.TariffListResponse;
import com.example.innovationcredit.model.mapper.TariffMapperInterface;
import com.example.innovationcredit.repository.TariffRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/loan-service")
public class CreditController {

    private final TariffRepo tariffRepo;
    private final TariffMapperInterface tariffMapper;

    @GetMapping("/getTariffs")
    public ResponseEntity<DataResponse<TariffListResponse>> getTariffs() {
        return ResponseEntity.ok(new DataResponse<>(new TariffListResponse(tariffRepo.findAll().stream().map(tariffMapper::entityToDto).collect(Collectors.toList()))));
    }
}
