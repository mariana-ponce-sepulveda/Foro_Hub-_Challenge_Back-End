package com.andromeda.forohub.dto;

import com.andromeda.forohub.model.User;

public record UserResponseDTO(
        Long id,
        String name,
        String email
) {
    public UserResponseDTO(User user){
        this(user.getId(), user.getName(), user.getEmail());
    }
}
