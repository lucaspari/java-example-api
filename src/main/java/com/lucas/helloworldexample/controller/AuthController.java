package com.lucas.helloworldexample.controller;

import com.lucas.helloworldexample.domain.User;
import com.lucas.helloworldexample.infra.security.TokenService;
import com.lucas.helloworldexample.services.UserServices;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class AuthController {
    private final TokenService tokenService;
    private final UserServices userServices;

    @PostMapping("/auth")
    public ResponseEntity<String> login(@RequestBody User user) {
        var token = tokenService.generateToken(user);
        userServices.save(user);
        return ResponseEntity.ok(token);
    }

    @GetMapping("/validate")
    public String authenticated() {
        return "authenticated";
    }
}
