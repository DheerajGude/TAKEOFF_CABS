package com.takeoff.user_service.controller;

import com.takeoff.user_service.dto.UserRequestDto;
import com.takeoff.user_service.dto.UserResponseDto;
import com.takeoff.user_service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Create user
    @PostMapping
    public ResponseEntity<UserResponseDto> createUser(@RequestBody UserRequestDto requestDto) {
        UserResponseDto user = userService.createUser(requestDto);
        return ResponseEntity.ok(user);
    }

    // Get user by email
    @GetMapping("/email/{email}")
    public ResponseEntity<UserResponseDto> getUserByEmail(@PathVariable String email) {
        UserResponseDto user = userService.getUserByEmail(email);
        return ResponseEntity.ok(user);
    }

    // Check if user exists by email
    @GetMapping("/exists/{email}")
    public ResponseEntity<Boolean> checkIfExists(@PathVariable String email) {
        boolean exists = userService.userExists(email);
        return ResponseEntity.ok(exists);
    }

    // Get all users
    @GetMapping
    public ResponseEntity<List<UserResponseDto>> getAllUsers() {
        List<UserResponseDto> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }
}
