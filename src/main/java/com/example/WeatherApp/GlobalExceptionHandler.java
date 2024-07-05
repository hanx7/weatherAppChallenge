package com.example.WeatherApp;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

/**
 * Global exception handler for handling validation and custom exceptions.
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Handles IllegalArgumentException and returns a 400 Bad Request response.
     *
     * @param ex the exception to handle
     * @return a ResponseEntity containing the error message
     */
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(IllegalArgumentException ex) {
        Map<String, String> error = new HashMap<>();
        error.put("error", ex.getMessage());

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    /**
     * Handles LocationNotFoundException and returns a 404 Not Found response.
     *
     * @param ex the exception to handle
     * @return a ResponseEntity containing the error message
     */
    @ExceptionHandler(LocationNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleLocationNotFoundException(LocationNotFoundException ex) {
        Map<String, String> error = new HashMap<>();
        error.put("error", ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}
