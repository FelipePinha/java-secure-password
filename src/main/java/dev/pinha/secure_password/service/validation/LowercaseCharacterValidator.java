package dev.pinha.secure_password.service.validation;

public class LowercaseCharacterValidator implements PasswordValidator {

    @Override
    public void validate(String password) {
        int count = 0;

        for (int i = 0; i < password.length(); i++) {
            if(!Character.isLowerCase(password.charAt(i))) {
                count++;
            }
        }

        if(count == password.length()) {
            throw new PasswordValidationException("A senha deve conter pelo menos uma letra maiúscula");
        }
    }
}
