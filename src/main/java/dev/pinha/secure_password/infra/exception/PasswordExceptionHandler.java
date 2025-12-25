package dev.pinha.secure_password.infra.exception;

import dev.pinha.secure_password.dto.ErrorMessage;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class PasswordExceptionHandler {

    @ExceptionHandler(PasswordValidationException.class)
    public ResponseEntity<ErrorMessage> handlePasswordValidationException(PasswordValidationException e) {
        return ResponseEntity.badRequest().body(new ErrorMessage(e.getMessage()));
    }
}
