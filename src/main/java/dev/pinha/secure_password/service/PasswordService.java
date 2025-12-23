package dev.pinha.secure_password.service;

import dev.pinha.secure_password.service.validation.PasswordValidator;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PasswordService {
    private final List<PasswordValidator> validators;

    public PasswordService(List<PasswordValidator> validator, List<PasswordValidator> validators) {
        this.validators = validators;
    }

    public void validatePassword(String password) {
        validators.forEach(v -> v.validate(password));
    }
}
