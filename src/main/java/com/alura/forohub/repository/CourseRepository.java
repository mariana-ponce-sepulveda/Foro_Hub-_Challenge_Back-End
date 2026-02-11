package com.andromeda.forohub.repository;

import com.andromeda.forohub.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
