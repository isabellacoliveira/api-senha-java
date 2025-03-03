package com.teste_tecnico.api_senha.service;

import com.teste_tecnico.api_senha.exceptions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordServiceTest {
    private PasswordService passwordService;

    @BeforeEach
    void setUp() {
        passwordService = new PasswordService();
    }

    @Test
    void shouldThrowNotEmptyException_whenPasswordIsEmpty() {
        Exception exception = assertThrows(NotEmptyException.class, () -> {
            passwordService.checkPassword("");
        });
        assertEquals("❌ Password should not be empty.", exception.getMessage());
    }

    @Test
    void shouldThrowHasUpperException_whenPasswordHasNoUpperCase() {
        Exception exception = assertThrows(HasUpperException.class, () -> {
            passwordService.checkPassword("senha123!");
        });
        assertEquals("❌ Password should have at least one uppercase letter.", exception.getMessage());
    }

    @Test
    void shouldThrowHasLowerException_whenPasswordHasNoLowerCase() {
        Exception exception = assertThrows(HasLowerException.class, () -> {
            passwordService.checkPassword("SENHA123!");
        });
        assertEquals("❌ Password should have at least one lowercase letter.", exception.getMessage());
    }

    @Test
    void shouldThrowHasSpecialCharacterException_whenPasswordHasNoSpecialCharacter() {
        Exception exception = assertThrows(HasSpecialCharacterException.class, () -> {
            passwordService.checkPassword("Senha1234");
        });
        assertEquals("❌ Password should have at least one special character (!@#$%^&*()-+).", exception.getMessage());
    }

    @Test
    void shouldThrowMinimunCharactersException_whenPasswordIsShorterThanNine() {
        Exception exception = assertThrows(MinimunCharactersException.class, () -> {
            passwordService.checkPassword("Ab!123");
        });
        assertEquals("❌ Password should have at least 9 characters.", exception.getMessage());
    }

    @Test
    void shouldThrowRepeatedCharacterException_whenPasswordHasDuplicateCharacters() {
        Exception exception = assertThrows(RepeatedCharacterException.class, () -> {
            passwordService.checkPassword("AaBbCc123!");
        });
        assertEquals("❌ Password should not contain repeated characters.", exception.getMessage());
    }

    @Test
    void shouldPass_whenPasswordIsValid() {
        assertDoesNotThrow(() -> passwordService.checkPassword("A1!bcdefgh"));
    }
}
