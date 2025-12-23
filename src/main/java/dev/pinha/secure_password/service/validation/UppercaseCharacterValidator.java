package dev.pinha.secure_password.service.validation;

import dev.pinha.secure_password.infra.exception.PasswordValidationException;
import org.springframework.stereotype.Component;

@Component
public class UppercaseCharacterValidator implements PasswordValidator{

    @Override
    public void validate(String password) {
        boolean hasUppercase = password.chars()
                .anyMatch(Character::isUpperCase);

        if(!hasUppercase) {
            throw new PasswordValidationException(
                    "A senha deve conter pelo menos uma letra maiúsculua"
            );
        }
    }
}
