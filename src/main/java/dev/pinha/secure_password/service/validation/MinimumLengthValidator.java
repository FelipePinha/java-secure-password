package dev.pinha.secure_password.service.validation;

public class MinimumLengthValidator implements PasswordValidator {

    @Override
    public void validate(String password) {
        if(password.length() < 8) {
            throw new PasswordValidationException("A senha deve ter pelo menos 8 caracteres");
        }
    }
}
