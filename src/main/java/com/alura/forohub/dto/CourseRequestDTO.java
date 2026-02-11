package com.andromeda.forohub.dto;

import jakarta.validation.constraints.NotBlank;

public record CourseRequestDTO(
        @NotBlank(message = "El nombre no debe estar vacio") String name,
        @NotBlank(message = "La categoria no debe estar vacio") String category) {
}
