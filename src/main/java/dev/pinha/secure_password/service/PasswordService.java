package dev.pinha.secure_password.service;

import dev.pinha.secure_password.service.validation.PasswordValidator;

import java.util.List;

public class PasswordService {
    private final List<PasswordValidator> validators;

    public PasswordService(List<PasswordValidator> validator) {
        this.validator = validator;
    }

    public void validatePassword(String password) {
        validators.forEach(v -> v.validate(password));
    }
}
