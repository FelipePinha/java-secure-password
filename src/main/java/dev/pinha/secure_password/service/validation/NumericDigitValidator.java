package dev.pinha.secure_password.service.validation;

import dev.pinha.secure_password.infra.exception.PasswordValidationException;
import org.springframework.stereotype.Component;

@Component
public class NumericDigitValidator implements PasswordValidator{

    @Override
    public void validate(String password) {
        boolean hasDigit = password.chars()
                .anyMatch(Character::isDigit);

        if (!hasDigit) {
            throw new PasswordValidationException(
                    "A senha deve conter pelo menos um número"
            );
        }
    }
}
