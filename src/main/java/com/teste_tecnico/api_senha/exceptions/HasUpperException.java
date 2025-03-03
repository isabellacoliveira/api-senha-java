package com.teste_tecnico.api_senha.exceptions;

public class HasUpperException extends RuntimeException {
    private HasUpperException() {
        super("❌ Password should have at least one uppercase letter.");
    }

    public HasUpperException(String message) {
        super(message);
    }
}
