package com.example.innovationcredit.api.response;

import com.example.innovationcredit.dto.TariffDto;

import java.util.List;

public record TariffListResponse(List<TariffDto> tariffs) {
}
