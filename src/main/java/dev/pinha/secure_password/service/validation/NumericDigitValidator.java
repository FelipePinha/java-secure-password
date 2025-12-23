package dev.pinha.secure_password.service.validation;

public class NumericDigitValidator {
    @Override
    public void validate(String password) {
        int count = 0;

        for (int i = 0; i < password.length(); i++) {
            if(!Character.isDigit(password.charAt(i))) {
                count++;
            }
        }

        if(count == password.length()) {
            throw new PasswordValidationException("A senha deve conter pelo menos um dígito numérico");
        }
    }
}
