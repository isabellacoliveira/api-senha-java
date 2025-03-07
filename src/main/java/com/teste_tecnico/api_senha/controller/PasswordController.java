package com.teste_tecnico.api_senha.controller;

import com.teste_tecnico.api_senha.domain.Password;
import com.teste_tecnico.api_senha.service.PasswordService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/password")
public class PasswordController {
    @Autowired
    private final PasswordService passwordService;

    public PasswordController(PasswordService passwordService) {
        this.passwordService = passwordService;
    }

    @Operation(summary = "Check the password", description = "Checks if the provided password is valid.")
    @PostMapping("password-check")
    public String returnPassword(@RequestBody Password password) {
        var passedPassword = passwordService.checkPassword(password.getPassword());
        return passedPassword;
    }
}
