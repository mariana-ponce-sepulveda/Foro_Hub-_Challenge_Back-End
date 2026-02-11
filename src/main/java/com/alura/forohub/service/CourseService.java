package com.andromeda.forohub.service;

import com.andromeda.forohub.dto.CourseRequestDTO;
import com.andromeda.forohub.dto.CourseResponseDTO;
import com.andromeda.forohub.model.Course;
import com.andromeda.forohub.repository.CourseRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CourseService {

    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Transactional
    public CourseResponseDTO register(CourseRequestDTO data) {
        var course = new Course();
        course.setName(data.name());
        course.setCategory(data.category());
        courseRepository.save(course);
        return new CourseResponseDTO(course);
    }

    @Transactional(readOnly = true)
    public Page<CourseResponseDTO> getAll(Pageable pagination) {
        return courseRepository.findAll(pagination).map(CourseResponseDTO::new);
    }
}
