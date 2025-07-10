package com.example.backend.controller;

import com.example.backend.model.User;
import com.example.backend.security.JwtUtil;
import com.example.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.*;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:3000")
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserService userService;
    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/register")
    public String register(@RequestBody User user) {
        if (userService.findByUsername(user.getUsername()).isPresent()) {
            return "Username already exists";
        }
        userService.save(user);
        return "User registered successfully";
    }

    @PostMapping("/login")
    public String login(@RequestBody User user) {
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
        final UserDetails userDetails = userService.loadUserByUsername(user.getUsername());
        return jwtUtil.generateToken(userDetails.getUsername());
    }
} 