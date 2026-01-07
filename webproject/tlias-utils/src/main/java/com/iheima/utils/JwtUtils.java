package com.iheima.utils;

import java.sql.Date;
import java.util.Map;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JwtUtils {

    private static String signKey = "SVRIRUlNQQ==";
    private static Long expire = 3600000L;

    public static String generateJwt(Map<String, Object> claims) {
        return Jwts.builder()
            .addClaims(claims)
            .signWith(SignatureAlgorithm.HS256, signKey)
            .setExpiration(new Date(System.currentTimeMillis() + expire))
            .compact();
    }

    public static Claims parseToken(String token) throws Exception {
        return Jwts.parser()
            .setSigningKey(signKey)
            .parseClaimsJws(token)
            .getBody();
    }
}
