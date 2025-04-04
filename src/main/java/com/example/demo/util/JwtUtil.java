package com.example.demo.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.time.Instant;
import java.util.Date;

public class JwtUtil {

    private static final String SECRET_KEY = "your-secret-kekkkkkk00000000000000y"; // Change this to a secure key
    private static final long EXPIRATION_TIME = 3600000; // 1 hour in milliseconds

    private static SecretKey getSigningKey() {
        return Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
    }

    public static String generateToken(String username) {
        Instant now = Instant.now();
        Instant expiration = now.plusSeconds(EXPIRATION_TIME / 1000);

        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(Date.from(now))
                .setExpiration(Date.from(expiration))
                .claim("username", username)
                .claim("expirationTime", expiration.toEpochMilli())
                .signWith(getSigningKey())
                .compact();
    }

//    public static Claims verifyToken(String token) {
//        return Jwts.parserBuilder()
//                .setSigningKey(getSigningKey())
//                .build()
//                .parseClaimsJws(token)
//                .getBody();
//    }
//
//    public static boolean isValidToken(String token) {
//        try {
//            verifyToken(token);
//            return true;
//        } catch (Exception e) {
//            return false;
//        }
//    }
}
