package com.example.ProductService.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.function.EntityResponse;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice // I use this exception because, if any controller throws an exception first come here first
public class GlobalExceptionHandler {
    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<Map<String, Object>>handleProductNotFoundException(ProductNotFoundException exception) {
        Map<String, Object> errorResponse = new HashMap<>();
        errorResponse.put("Timestamp: ", LocalDateTime.now());
        errorResponse.put("Status: ", 404);
        errorResponse.put("Error:" , "Not Found, Sorry! ");
        errorResponse.put("Message: ", exception.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
    /*
    pending validation work
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse>handleNotValidException(MethodArgumentNotValidException exception) {
        String errorResponse = exception.getBindingResult()
                .getFieldError()
                .getDefaultMessage();

        ErrorResponse errorResponse1 = new ErrorResponse(LocalDateTime.now(), HttpStatus.BAD_REQUEST.value(), "Validation error", errorResponse);
    }

    pending validation work*/
}
