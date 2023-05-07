package com.example.innovationcredit.exception;

import com.example.innovationcredit.model.ErrorCode;
import lombok.Getter;

@Getter
public class LoanProcessException extends RuntimeException {
    private final ErrorCode errorCode;

    public LoanProcessException(ErrorCode errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }
}
