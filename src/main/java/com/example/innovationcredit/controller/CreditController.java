package com.example.innovationcredit.controller;

import com.example.innovationcredit.api.response.DataResponse;
import com.example.innovationcredit.api.response.TariffListResponse;
import com.example.innovationcredit.model.mapper.TariffMapperInterface;
import com.example.innovationcredit.repository.TariffRepoJDBC;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/loan-service")
public class CreditController {

    private final TariffRepoJDBC tariffRepo;
    private final TariffMapperInterface tariffMapper;

    @GetMapping("/getTariffs")
    public ResponseEntity<DataResponse<TariffListResponse>> getTariffs() {
   /*     if(true) {
            throw new LoanProcessException(ErrorCode.LOAN_CONSIDERATION, "message");
        }*/
        return ResponseEntity.ok(new DataResponse<>(new TariffListResponse(tariffRepo.findAll().stream().map(tariffMapper::entityToDto).collect(Collectors.toList()))));
    }

/*    @DeleteMapping("/deleteOrder")
    public ResponseEntity<?> delete(Long id){
        try {
            Product product = productsService.findById(id).orElseThrow();
            return new ResponseEntity<>(product, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(new AppError(HttpStatus.NOT_FOUND.value(),
                    "Product with id " + id + " nor found"),
                    HttpStatus.NOT_FOUND);
        }
    }*/
}
