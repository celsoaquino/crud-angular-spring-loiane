package com.celsoaquino.crudspring.controller;

import com.celsoaquino.crudspring.model.Course;
import com.celsoaquino.crudspring.repository.CourseRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@AllArgsConstructor
@RequestMapping("/api/courses")
public class CourseController {

    private final CourseRepository courseRepository;

    @GetMapping()
    public List<Course> list() {
        return courseRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Course> findById(@PathVariable Long id) {
        return courseRepository.findById(id)
                .map(redord -> ResponseEntity.ok().body(redord))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping()
    @ResponseStatus(code = HttpStatus.CREATED)
    public Course create(@RequestBody Course course) {
        return courseRepository.save(course);
    }

}
