package com.andromeda.forohub.dto;

import com.andromeda.forohub.model.Topic;

import java.time.LocalDateTime;
import java.util.List;

public record TopicResponseDTO(
        Long id,
        String title,
        String message,
        LocalDateTime creationDate,
        String course,
        String user,
        List<RespResponseDTO> responses
) {
    public TopicResponseDTO(Topic topic){
        this(topic.getId(),topic.getTitle(),topic.getMessage(),topic.getCreationDate(),
                topic.getCourse().getName(),topic.getUser().getName(),
                topic.getResponses().stream().map(RespResponseDTO::new).toList());
    }
}
