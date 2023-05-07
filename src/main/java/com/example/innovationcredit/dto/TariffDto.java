package com.example.innovationcredit.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record TariffDto(
        long id,
        String type,
        @JsonProperty("interest_rate")
        String interestRate
) {
}
