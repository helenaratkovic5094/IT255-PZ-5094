package com.metropolitan.letovi.controller;

import com.metropolitan.letovi.entiteti.Admin;
import com.metropolitan.letovi.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:4200")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Admin loginRequest) {
        System.out.println("Received login request:");
        System.out.println("Username: " + loginRequest.getUsername());
        System.out.println("Password: " + loginRequest.getPassword());

        boolean isAuthenticated = authService.authenticate(loginRequest.getUsername(), loginRequest.getPassword());
        System.out.println("kontroler /login");

        Map<String, String> response = new HashMap<>();
        if (isAuthenticated) {
            System.out.println("kontroler login succ");
            response.put("message", "Login successful");
            return ResponseEntity.ok(response);
        } else {
            System.out.println("kontroler invalid u and p");
            response.put("message", "Invalid username or password");
            return ResponseEntity.status(401).body(response);
        }
    }
}
