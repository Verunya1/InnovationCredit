package com.example.innovationcredit.controller;

import com.example.innovationcredit.api.response.DataResponse;
import com.example.innovationcredit.api.response.StatusResponse;
import com.example.innovationcredit.api.response.TariffListResponse;
import com.example.innovationcredit.model.entity.Application;
import com.example.innovationcredit.model.mapper.TariffMapperInterface;
import com.example.innovationcredit.repository.ApplicationRepoJDBC;
import com.example.innovationcredit.repository.TariffRepoJDBC;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/loan-service")
public class CreditController {

    private final TariffRepoJDBC tariffRepo;
    private final ApplicationRepoJDBC applicationRepoJDBC;
    private final TariffMapperInterface tariffMapper;

    @GetMapping("/getTariffs")
    public ResponseEntity<DataResponse<TariffListResponse>> getTariffs() {
        return ResponseEntity.ok(new DataResponse<>(new TariffListResponse(tariffRepo.findAll().stream().map(tariffMapper::entityToDto).collect(Collectors.toList()))));
    }

    @PostMapping("/order")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<DataResponse<?>> supply(@Valid @RequestBody Application application) {
        UUID orderID = applicationRepoJDBC.supply(application.getTariffId(),application.getUserId());
        return ResponseEntity.ok(new DataResponse<>(orderID));
    }
    @DeleteMapping("/deleteOrder")
    public ResponseEntity<?> delete(@Valid @RequestBody Application application){
        applicationRepoJDBC.delete(application.getUserId(),application.getOrderId());
        return new ResponseEntity<>(HttpStatus.OK);

    }

    @GetMapping("/getStatusOrder")
    public ResponseEntity<DataResponse<?>> getStatus(@RequestParam String orderId) {
        return ResponseEntity.ok(new DataResponse<>(applicationRepoJDBC.getStatus(orderId)));
    }
}
