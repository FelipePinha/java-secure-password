package dev.pinha.secure_password.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PasswordController {

    @GetMapping("/secure-passowrd")
    public ResponseEntity<Void> newPassword() {

        return ResponseEntity.ok().build();
    }
}
