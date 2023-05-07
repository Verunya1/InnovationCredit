package com.example.innovationcredit.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Component;

import java.security.SecureRandom;
import java.util.Random;

public record TariffDto(
        long id,
        String type,
        @JsonProperty("interest_rate")
        String interestRate
) {

}

