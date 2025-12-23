package dev.pinha.secure_password.service.validation;

import dev.pinha.secure_password.infra.exception.PasswordValidationException;
import org.springframework.stereotype.Component;

@Component
public class SpecialCharacterValidator implements PasswordValidator {

    @Override
    public void validate(String password) {
        int count = 0;

        for (int i = 0; i < password.length(); i++) {
            if(!Character.isLetterOrDigit(password.charAt(i))) {
                count++;
            }
        }

        if(count == 0) {
            throw new PasswordValidationException("A senha deve conter pelo menos um caractere especial");
        }
    }
}
