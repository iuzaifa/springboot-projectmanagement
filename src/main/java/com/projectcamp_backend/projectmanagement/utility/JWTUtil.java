package com.projectcamp_backend.projectmanagement.utility;

import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JWTUtil {

    public String generateJWTToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date())
                .signWith()
                .compact();
    }
}
