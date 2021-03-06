package com.example.simpleecom.controller;

import com.example.simpleecom.dto.RegisterRequest;
import com.example.simpleecom.dto.UserDto;
import com.example.simpleecom.entity.User;
import com.example.simpleecom.service.AuthService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:4300"})
@RestController
@RequestMapping("/api")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/signup")
    public void signUp(@RequestBody RegisterRequest registerRequest) {
        authService.signUp(registerRequest);
    }

    @GetMapping("/login")
    public void login() {
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return authService.getAllUsers();
    }

    @GetMapping("/user/{username}")
    public UserDto getUserByUsername(@PathVariable String username) {
        return authService.getUserByUsername(username);
    }
}
