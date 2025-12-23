package dev.pinha.secure_password.service.validation;

import dev.pinha.secure_password.infra.exception.PasswordValidationException;
import org.springframework.stereotype.Component;

@Component
public class UppercaseCharacterValidator implements PasswordValidator{

    @Override
    public void validate(String password) {
        int count = 0;

        for (int i = 0; i < password.length(); i++) {
            if(!Character.isUpperCase(password.charAt(i))) {
                count++;
            }
        }

        if(count == password.length()) {
            throw new PasswordValidationException("A senha deve conter pelo menos uma letra maiúscula");
        }
    }
}
