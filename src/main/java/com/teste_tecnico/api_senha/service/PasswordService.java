package com.teste_tecnico.api_senha.service;

import com.teste_tecnico.api_senha.domain.Password;
import com.teste_tecnico.api_senha.exceptions.*;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;

@Service
public class PasswordService {
    public String checkPassword(String password) {
        if(password.isEmpty()){
            throw new NotEmptyException("❌ Password should not be empty.");
        }
        if (!password.matches(".*\\p{Lu}.*")) {
            throw new HasUpperException("❌ Password should have at least one uppercase letter.");
        }
        if (!password.matches(".*\\p{Ll}.*")) {
            throw new HasLowerException("❌ Password should have at least one lowercase letter.");
        }
        if (!password.matches(".*[!@#$%^&*()].*")) {
            throw new HasSpecialCharacterException("❌ Password should have at least one special character (!@#$%^&*()-+).");
        }
        if (password.length() < 9) {
            throw new MinimunCharactersException("❌ Password should have at least 9 characters.");
        }
        if (hasRepeatedCharacters(password)) {
            throw new RepeatedCharacterException("❌ Password should not contain repeated characters.");
        }
        return "✅ Senha válida!";
    }

    private boolean hasRepeatedCharacters(String password) {
        Set<Character> uniqueChars = new HashSet<>();
        for (char c : password.toLowerCase().toCharArray()) {
            if (!uniqueChars.add(c)) {
                return true;
            }
        }
        return false;
    }

    @Bean
    public Function<Password, String> passwordChecker() {
        return password -> checkPassword(password.getPassword());
    }
}
