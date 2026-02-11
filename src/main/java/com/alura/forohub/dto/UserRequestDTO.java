package com.andromeda.forohub.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UserRequestDTO(
        @NotBlank(message = "El nombre no debe estar vacio") String name,
        @Email @NotBlank(message = "El email no debe estar vacio") String email,
        @NotBlank(message = "El password no debe estar vacio") String password
) {
}
