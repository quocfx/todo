package com.lf.todo.controller;

import com.lf.todo.model.ErrorDetail;
import com.lf.todo.model.ErrorResponse;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.Clock;
import java.util.ArrayList;
import java.util.List;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class ValidationExceptionControllerAdvice {
    private final Clock applicationClock;

    public ValidationExceptionControllerAdvice(final Clock clock) {
        this.applicationClock = clock;
    }


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        List<ErrorDetail> errorDetails = new ArrayList<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errorDetails.add(new ErrorDetail(fieldName, errorMessage));
        });
        return new ResponseEntity<>(new ErrorResponse(HttpStatus.BAD_REQUEST, errorDetails, applicationClock),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
