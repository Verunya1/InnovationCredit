package com.example.innovationcredit.dto;

import com.example.innovationcredit.model.ErrorCode;

public record ErrorDto(ErrorCode code, String message) {
}
