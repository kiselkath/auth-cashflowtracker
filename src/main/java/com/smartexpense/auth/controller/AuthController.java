package com.smartexpense.auth.controller;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Key;
import java.util.Date;

@Controller
public class AuthController {
    private final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256); // хранить в конфиге!

    @GetMapping("/token")
    @ResponseBody
    public String getToken(@AuthenticationPrincipal OidcUser user){
        String jwt = Jwts.builder()
                .setSubject(user.getEmail())
                .claim("name", user.getFullName())
                .claim("picture", user.getAttribute("picture"))
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 3600_000)) // 1h
                .signWith(key)
                .compact();
        return jwt;
    }
}
