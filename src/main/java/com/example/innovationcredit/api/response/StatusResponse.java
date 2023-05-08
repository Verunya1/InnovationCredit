package com.example.innovationcredit.api.response;

import com.example.innovationcredit.dto.ErrorDto;
import com.example.innovationcredit.dto.StatusDto;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record StatusResponse(StatusDto statusDto) {
}
