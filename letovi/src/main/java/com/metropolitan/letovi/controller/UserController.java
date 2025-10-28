package com.metropolitan.letovi.controller;

import com.metropolitan.letovi.entiteti.Admin;
import com.metropolitan.letovi.entiteti.User;
import com.metropolitan.letovi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/user-login")
    public ResponseEntity<?> login(@RequestBody User loginRequest) {
        System.out.println("Received login request:");
        System.out.println("Username: " + loginRequest.getUsername());
        System.out.println("Password: " + loginRequest.getPassword());

        boolean isAuthenticated = userService.authenticate(loginRequest.getUsername(), loginRequest.getPassword());
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
    @GetMapping("/test")
    public ResponseEntity<String> test() {
        return ResponseEntity.ok("API is working");
    }

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody User user) {
        System.out.println("Signup request received for user: " + user.getUsername());
        List<User> existingUsers = userService.findByUsername(user.getUsername());
        if (existingUsers.isEmpty()) {
            userService.save(user);
            return ResponseEntity.ok("User registered successfully");
        }
        return ResponseEntity.status(400).body("Username already exists");
    }


}
