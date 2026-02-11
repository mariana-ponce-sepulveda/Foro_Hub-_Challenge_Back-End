package com.andromeda.forohub.dto;

import com.andromeda.forohub.model.Course;
import jakarta.validation.constraints.NotBlank;

public record CourseResponseDTO(Long id, String name, String category) {
    public CourseResponseDTO(Course course){
        this(course.getId(), course.getName(),course.getCategory());
    }
}

