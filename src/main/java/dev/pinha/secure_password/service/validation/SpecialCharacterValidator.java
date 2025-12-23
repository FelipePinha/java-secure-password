package dev.pinha.secure_password.service.validation;

import dev.pinha.secure_password.infra.exception.PasswordValidationException;
import org.springframework.stereotype.Component;

@Component
public class SpecialCharacterValidator implements PasswordValidator {

    @Override
    public void validate(String password) {
        boolean hasSpecialCharacter = password.chars()
                .anyMatch(c ->!Character.isLetterOrDigit(c));

        if (!hasSpecialCharacter) {
            throw new PasswordValidationException(
                    "A senha deve conter pelo menos um caracter especial"
            );
        }
    }
}
