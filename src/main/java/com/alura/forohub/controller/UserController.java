package com.andromeda.forohub.controller;

import com.andromeda.forohub.dto.UserRequestDTO;
import com.andromeda.forohub.dto.UserResponseDTO;
import com.andromeda.forohub.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserResponseDTO> register(@RequestBody @Valid UserRequestDTO user){
        return ResponseEntity.ok(userService.register(user));
    }
}
