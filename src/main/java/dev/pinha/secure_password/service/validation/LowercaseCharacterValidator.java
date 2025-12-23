package dev.pinha.secure_password.service.validation;

import dev.pinha.secure_password.infra.exception.PasswordValidationException;
import org.springframework.stereotype.Component;

@Component
public class LowercaseCharacterValidator implements PasswordValidator {

    @Override
    public void validate(String password) {
        boolean hasLowercase = password.chars()
                .anyMatch(Character::isLowerCase);

        if(!hasLowercase) {
            throw new PasswordValidationException(
                    "A senha deve conter pelo menos uma letra minúscula"
            );
        }
    }
}
