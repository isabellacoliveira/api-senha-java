package com.teste_tecnico.api_senha.infra;

import com.teste_tecnico.api_senha.controller.PasswordController;
import com.teste_tecnico.api_senha.exceptions.*;
import com.teste_tecnico.api_senha.service.PasswordService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import static org.junit.jupiter.api.Assertions.*;

class RestExceptionHandlerTest {
    private RestExceptionHandler restExceptionHandler;

    @Test
    void shouldReturnBadRequestForHasUpperException() {
        HasUpperException exception = new HasUpperException("Upper case required");

        ResponseEntity<RestErrorMessage> response = restExceptionHandler.hasUpperHandler(exception);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("Upper case required", response.getBody().getMessage());
    }

    @Test
    void shouldReturnBadRequestForHasSpecialCharacterException() {
        HasSpecialCharacterException exception = new HasSpecialCharacterException("Special character required");

        ResponseEntity<RestErrorMessage> response = restExceptionHandler.hasSpecialCharactersHandler(exception);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("Special character required", response.getBody().getMessage());
    }

    @Test
    void shouldReturnBadRequestForHasLowerException() {
        HasLowerException exception = new HasLowerException("Lower case required");

        ResponseEntity<RestErrorMessage> response = restExceptionHandler.hasLowerHandler(exception);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("Lower case required", response.getBody().getMessage());
    }

    @Test
    void shouldReturnBadRequestForMinimunCharactersException() {
        MinimunCharactersException exception = new MinimunCharactersException("Minimum characters required");

        ResponseEntity<RestErrorMessage> response = restExceptionHandler.minimunOfCharactersHandler(exception);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("Minimum characters required", response.getBody().getMessage());
    }

    @Test
    void shouldReturnBadRequestForNotEmptyException() {
        NotEmptyException exception = new NotEmptyException("Password should not be empty");

        ResponseEntity<RestErrorMessage> response = restExceptionHandler.notEmptyHandler(exception);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("Password should not be empty", response.getBody().getMessage());
    }

    @Test
    void shouldReturnBadRequestForRepeatedCharacterException() {
        RepeatedCharacterException exception = new RepeatedCharacterException("Password should not contain repeated characters");

        ResponseEntity<RestErrorMessage> response = restExceptionHandler.repeatedCharacterHandler(exception);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("Password should not contain repeated characters", response.getBody().getMessage());
    }
}
