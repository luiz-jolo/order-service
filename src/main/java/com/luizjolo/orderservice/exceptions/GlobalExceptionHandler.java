package com.luizjolo.orderservice.exceptions;

import jakarta.validation.ValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorRecordResponse> handleArgumentNotValidException(MethodArgumentNotValidException ex) {
        HashMap<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });

        var errorRecordResponse = new ErrorRecordResponse(HttpStatus.BAD_REQUEST.value(), "Validation field", errors);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorRecordResponse);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorRecordResponse> handleInvalidFormat(HttpMessageNotReadableException ex){
        var errorRecordResponse = new ErrorRecordResponse(HttpStatus.BAD_REQUEST.value(), "Invalid request body format", null);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorRecordResponse);
    }

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<ErrorRecordResponse> handleDomainValidatatioException(ValidationException ex){
        var errorRecordResponse = new ErrorRecordResponse(HttpStatus.BAD_REQUEST.value(), ex.getMessage(), null);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorRecordResponse);
    }

}
