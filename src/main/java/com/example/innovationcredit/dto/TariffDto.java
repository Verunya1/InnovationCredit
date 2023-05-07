package com.example.innovationcredit.dto;

import com.example.innovationcredit.api.response.Dto;

public record TariffDto(
        long id,
        String type,
        String interest_rate
) implements Dto {
}
