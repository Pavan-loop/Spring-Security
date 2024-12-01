package com.madara.security.jwtTest;

import com.madara.security.security.jwt.JwtService;
import io.jsonwebtoken.Jwts;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class jwtserviceut {

    private JwtService jwtService;

    @BeforeEach
    void setUp(){
        jwtService = new JwtService();
        jwtService.secretKey = "+Q7ASzj1ITXwFEhTkupCEyzW9KyWfJX9rGxS/bv6QZY=";
        jwtService.expiration = 3600000;
    }

    @Test
    void ExtractingEmailFormTheTokenTest(){
        String email = "anithaprashanth@gmail.com";
        String token = Jwts.builder()
                .setSubject(email)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + jwtService.expiration))
                .signWith(jwtService.getSignInKey())
                .compact();

        String extractedEmail = jwtService.extractEmail(token);

        assertEquals(email, extractedEmail, "This both should be same");

        System.out.println("Expected: " + email);
        System.out.println("Result: " + extractedEmail);
    }

    @Test
    void CheckingIsTokenValid() {

        String email = "anithaprashanth@gmail.com";
        String token = Jwts.builder()
                .setSubject(email)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + jwtService.expiration))
                .signWith(jwtService.getSignInKey())
                .compact();

                UserDetails userDetails = new User(
                "anithaprashanth@gmail.com",
                "password",
                List.of(new SimpleGrantedAuthority("ROLE_USER"))
        );

        boolean notExpired = true;

        boolean result = jwtService.isTokenValid(token, userDetails);

        assertEquals(notExpired, result);

        System.out.println("Expected: " + notExpired);
        System.out.println("Result: " + result);
    }

    @Test
    void testGenerateToken() {

        String email = "anithaprashanth@gmail.com";

        UserDetails userDetails = new User(
                "anithaprashanth@gmail.com",
                "password",
                List.of(new SimpleGrantedAuthority("ROLE_USER"))
        );

        String generatedToken = jwtService.generateToken(userDetails);

        String extractedEmail = jwtService.extractEmail(generatedToken);

        System.out.println("Token: " + generatedToken);

        assertEquals(email, extractedEmail);
    }

}
