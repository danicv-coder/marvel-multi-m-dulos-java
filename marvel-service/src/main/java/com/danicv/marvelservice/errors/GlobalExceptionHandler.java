package com.danicv.marvelservice.errors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//Author: Daniel Calderon
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(CharacterNotFound.class)
    public ResponseEntity<String> handleCharacterNotFound(CharacterNotFound ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(ex.getMessage());
    }
}
