package com.hcc.controllers;


import com.hcc.dto.AuthCredentialRequest;
import com.hcc.entities.User;
import com.hcc.utils.JwtUtil;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    JwtUtil jwtUtil;
    @Autowired
    AuthenticationManager manager;

    @GetMapping("/validate")
    public ResponseEntity<?> validateToken(@RequestParam String token, @AuthenticationPrincipal User user) {
        try {
            if (user != null) {
                boolean isTokenValid = jwtUtil.validateToken(token, user);
                return ResponseEntity.ok(isTokenValid);
            } else {
                return ResponseEntity.ok(false);
            }
        } catch (ExpiredJwtException e) {
            return ResponseEntity.ok(false);
        }
    }

    @GetMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthCredentialRequest request) {
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(request.getUsername(),
                request.getPassword());
        // Authentication authenticate = manager.authenticate(token);
        boolean isAuthenticated = manager.authenticate(token).isAuthenticated();
        request.setPassword(null);

        if (isAuthenticated) {
            User user = new User();
            user.setUsername(request.getUsername());


            HttpHeaders responseHeaders = new HttpHeaders();
            responseHeaders.set(HttpHeaders.AUTHORIZATION, jwtUtil.generateToken(user));

            return ResponseEntity.ok().headers(responseHeaders).body(request.getUsername());
        } else {
            return ResponseEntity.ok(false);
        }

    }

}
