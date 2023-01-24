package com.celsoaquino.crudspring.controller;

import com.celsoaquino.crudspring.model.Course;
import com.celsoaquino.crudspring.repository.CourseRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class CourseController {

    private final CourseRepository courseRepository;

    @GetMapping("/courses")
    public List<Course> list() {
        return courseRepository.findAll();
    }

    @PostMapping("/courses")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Course create(@RequestBody Course course) {
        return courseRepository.save(course);
    }

}
