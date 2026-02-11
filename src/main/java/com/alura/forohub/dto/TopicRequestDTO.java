package com.andromeda.forohub.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TopicRequestDTO(
        @NotBlank(message = "El titlo no debe estar vacío") String title,
        @NotBlank(message = "El mensaje no debe estar vacio") String message,
        @NotNull(message = "Se debe especificar un curso") Long courseId,
        @NotNull(message = "Se debe especificar un usuario") Long userId
) {
}
