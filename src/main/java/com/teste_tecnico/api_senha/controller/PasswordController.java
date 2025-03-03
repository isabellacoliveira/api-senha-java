package com.teste_tecnico.api_senha.controller;

import com.teste_tecnico.api_senha.domain.Password;
import com.teste_tecnico.api_senha.service.PasswordService;
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

    @GetMapping
    public String getPassword(){
        return passwordService.checkPassword("123456");
    }

    @PostMapping("/{id}")
    public String definePassword(@PathVariable("id") String id, @RequestParam(value = "filter", defaultValue = "nenhum") String filter, @RequestBody Password password) {
        return "Define a new password " + password.getPassword() + id + filter;
    }

    @PostMapping("password-check")
    public String returnPassword(@RequestBody Password password) {
        var passedPassword = passwordService.checkPassword(password.getPassword());
        return passedPassword;
    }
}
