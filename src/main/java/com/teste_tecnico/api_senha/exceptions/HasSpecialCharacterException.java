package com.teste_tecnico.api_senha.exceptions;

public class HasSpecialCharacterException extends RuntimeException {
    private HasSpecialCharacterException() {
        super("❌ Password should have at least one special character (!@#$%^&*()-+).");
    }

    public HasSpecialCharacterException(String message) {
        super(message);
    }
}
