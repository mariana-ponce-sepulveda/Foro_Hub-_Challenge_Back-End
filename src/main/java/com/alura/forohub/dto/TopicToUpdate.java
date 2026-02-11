package com.andromeda.forohub.dto;

import jakarta.validation.constraints.NotNull;

public record TopicToUpdate(
        String title,
        String message,
        Boolean status
) {
}
