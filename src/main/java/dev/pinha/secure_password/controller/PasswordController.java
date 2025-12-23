package dev.pinha.secure_password.controller;

import dev.pinha.secure_password.dto.PasswordRequest;
import dev.pinha.secure_password.service.PasswordService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PasswordController {
    private final PasswordService passwordService;

    public PasswordController(PasswordService passwordService) {
        this.passwordService = passwordService;
    }

    @PostMapping("/validate-password")
    public ResponseEntity<Void> newPassword(@RequestBody PasswordRequest body) {
        passwordService.validatePassword(body.password());

        return ResponseEntity.ok().build();
    }
}
