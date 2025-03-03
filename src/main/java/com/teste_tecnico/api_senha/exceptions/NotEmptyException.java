package com.teste_tecnico.api_senha.exceptions;

public class NotEmptyException extends RuntimeException {
    private NotEmptyException() {
        super("❌ Password should not be empty.");
    }

    public NotEmptyException(String message) {
        super(message);
    }
}
