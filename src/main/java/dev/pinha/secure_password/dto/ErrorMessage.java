package dev.pinha.secure_password.dto;

public record ErrorMessage(
        String message
) {
    public ErrorMessage(String message) {
        this.message = message;
    }
}
