package com.andromeda.forohub.dto;

import com.andromeda.forohub.model.Topic;
import com.andromeda.forohub.model.User;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record RespRequestDTO(
        @NotBlank(message = "El mensaje no debe estar vacio") String message,
        @NotNull Long topicId,
        @NotNull Long userId
) {
}
