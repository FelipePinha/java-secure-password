package dev.pinha.secure_password.service.validation;

import dev.pinha.secure_password.infra.exception.PasswordValidationException;
import org.springframework.stereotype.Component;

@Component
public class MinimumLengthValidator implements PasswordValidator {

    @Override
    public void validate(String password) {
        if(password.length() < 8) {
            throw new PasswordValidationException("A senha deve ter pelo menos 8 caracteres");
        }
    }
}
