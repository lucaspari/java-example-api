package com.lucas.helloworldexample.infra.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.lucas.helloworldexample.domain.User;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class TokenService {
    private final String SECRET = "super_secret_password";

    public String generateToken(User user) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(SECRET);
            String token = JWT.create()
                    .withIssuer("auth0")
                    .withSubject(user.getUsername())
                    .withExpiresAt(getExpirationTime())
                    .sign(algorithm);
            return token;
        } catch (JWTCreationException exception) {
            throw new RuntimeException(exception);
        }
    }
    private Instant getExpirationTime() {
        return Instant.now().plusSeconds(3600);
    }

    public String validateToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(SECRET);
            return JWT.require(algorithm)
            .withIssuer("auth0")
                    .build().verify(token).getSubject();
        } catch (Exception exception) {
            return null;
        }
    }
}

