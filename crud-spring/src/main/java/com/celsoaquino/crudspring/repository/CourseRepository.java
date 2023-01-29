package com.celsoaquino.crudspring.repository;

import com.celsoaquino.crudspring.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
