package com.youngwu.safecommunitynet.controller;

import com.youngwu.safecommunitynet.model.dto.UserCreateDto;
import com.youngwu.safecommunitynet.model.dto.UserUpdatedDto;
import com.youngwu.safecommunitynet.service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author: Young.Wu
 * @create-date: 2024/4/1 5:06 PM
 * @description:
 */
@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class UserController {

    private final UserService userService;


    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody @Valid UserCreateDto user) {
        userService.createUser(user);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }

    @GetMapping("/all")
    public ResponseEntity<?> getUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserByUsername(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserByUserId(id));
    }

    @PutMapping
    public ResponseEntity<?> updateUser(@RequestBody @Valid UserUpdatedDto updatedUser) {
        userService.updateUser(updatedUser);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }
}
