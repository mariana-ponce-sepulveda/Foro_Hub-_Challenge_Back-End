package com.andromeda.forohub.dto;

import com.andromeda.forohub.model.Response;
import com.andromeda.forohub.model.Topic;
import com.andromeda.forohub.model.User;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.LocalDateTime;

public record RespResponseDTO(
        Long id,
        String message,
        LocalDateTime creationDate,
        String user
) {
    public RespResponseDTO(Response response){
        this(response.getId(), response.getMessage(), response.getCreationDate(), response.getUser().getName());
    }
}
