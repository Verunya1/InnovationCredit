package com.example.innovationcredit.controller;

import com.example.innovationcredit.api.response.DataResponse;
import com.example.innovationcredit.api.response.StatusResponse;
import com.example.innovationcredit.api.response.TariffListResponse;
import com.example.innovationcredit.model.mapper.TariffMapperInterface;
import com.example.innovationcredit.repository.ApplicationRepoJDBC;
import com.example.innovationcredit.repository.TariffRepoJDBC;
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
    public ResponseEntity<DataResponse<?>> supply(@RequestParam(required = false) long userId,@RequestParam(required = false) long tariffId) {
        UUID orderID = applicationRepoJDBC.supply(tariffId,userId);
        return ResponseEntity.ok(new DataResponse<>(orderID));
    }
    @DeleteMapping("/deleteOrder")
    public ResponseEntity<?> delete(@RequestParam(required = false) long userId,@RequestParam(required = false) String orderId){
        applicationRepoJDBC.delete(userId,orderId);
        return new ResponseEntity<>(HttpStatus.OK);

    }

    @GetMapping("/getStatusOrder")
    public ResponseEntity<DataResponse<?>> getStatus(@RequestParam String orderId) {
        return ResponseEntity.ok(new DataResponse<>(applicationRepoJDBC.getStatus(orderId)));
    }
}
