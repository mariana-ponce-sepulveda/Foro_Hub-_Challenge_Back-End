package com.andromeda.forohub.controller;

import com.andromeda.forohub.dto.CourseRequestDTO;
import com.andromeda.forohub.dto.CourseResponseDTO;
import com.andromeda.forohub.service.CourseService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/courses")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping
    public ResponseEntity<CourseResponseDTO> register(@RequestBody @Valid CourseRequestDTO course){
        var response = courseService.register(course);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<Page<CourseResponseDTO>> getAll(@PageableDefault(size = 10)Pageable pagination){
        return ResponseEntity.ok(courseService.getAll(pagination));
    }

}
