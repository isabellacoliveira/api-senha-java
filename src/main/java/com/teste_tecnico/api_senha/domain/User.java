package com.teste_tecnico.api_senha.domain;

public class User extends Password {
    private String username;
    private String id;

    public User(String password) {
        super(password);
    }
}
