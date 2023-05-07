package com.example.innovationcredit.controller;

import com.example.innovationcredit.entity.TariffEntity;
import com.example.innovationcredit.repository.TariffRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RestController
@RequiredArgsConstructor
@RequestMapping("/loan-service")
public class CreditController {

private final TariffRepo tariffRepo;

    @GetMapping("/getTariffs")
    public List<TariffEntity> getTariffs() {
        return tariffRepo.findAll();
    }

//    @PostMapping("/order")
//    public


}
