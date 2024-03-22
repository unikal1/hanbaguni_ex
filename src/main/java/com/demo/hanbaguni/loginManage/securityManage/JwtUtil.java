package com.demo.hanbaguni.loginManage.securityManage;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Base64;
import java.util.Date;

@Component
public class JwtUtil {
    @Value("${secretKey}")
    private String secretKey;

    @Value("${jwt.expiredMs")
    private Long expiredMs;

    private Key secretKeyToSigningKey(String secretKey) {
        byte[] apiKeySecretBytes = Base64.getEncoder().encode(secretKey.getBytes());
        return new SecretKeySpec(apiKeySecretBytes, SignatureAlgorithm.HS512.getJcaName());


    }
    public String createJwt(String secretKey, Long expiredMs, String memberKey) {

        Claims claims = Jwts.claims();
        claims.put("key", memberKey);

        String token = Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + expiredMs))
                .signWith(secretKeyToSigningKey(secretKey))
                .compact();

        return token;
    }

    public Long getMemberKey(String token, String secretKey) {
        return Jwts.parserBuilder()
                .setSigningKey(secretKeyToSigningKey(secretKey))
                .build()
                .parseClaimsJws(token)
                .getBody()
                .get("key", Long.class);
    }

    public boolean isExpired(String token, String secretKey) {
        return Jwts.parserBuilder()
                .setSigningKey(secretKeyToSigningKey(secretKey))
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getExpiration()
                .before(new Date());
    }
}
