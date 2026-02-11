package com.andromeda.forohub.exceptions;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ConfigException {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity manageError404(){
        return ResponseEntity.noContent().build();
    }

    @ExceptionHandler(DuplicateException.class)
    public ResponseEntity manageDuplicateError(DuplicateException e){
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity manageError400(MethodArgumentNotValidException e){
        var errores = e.getFieldErrors().stream()
                .map(DataError::new).toList();
        return ResponseEntity.badRequest().body(errores);
    }

    public record DataError(String field, String message){
        public DataError(FieldError error){
            this(error.getField(), error.getDefaultMessage());
        }
    }
}
