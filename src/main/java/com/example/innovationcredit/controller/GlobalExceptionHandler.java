package com.example.innovationcredit.controller;

import com.example.innovationcredit.api.response.ErrorResponse;
import com.example.innovationcredit.dto.ErrorDto;
import com.example.innovationcredit.exception.LoanProcessException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(value = {LoanProcessException.class})
    protected ResponseEntity<ErrorResponse> handleLoanProcess(LoanProcessException exception) {
        logger.error("Exception during loan processing", exception);
        return ResponseEntity.badRequest().body(new ErrorResponse(new ErrorDto(exception.getErrorCode(), exception.getMessage())));
    }
}
