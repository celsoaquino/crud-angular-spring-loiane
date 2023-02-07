package com.celsoaquino.crudspring.service;


import com.celsoaquino.crudspring.model.Course;
import com.celsoaquino.crudspring.repository.CourseRepository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Validated
@Service
public class CourseService {

    private CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public List<Course> list() {
        return courseRepository.findAll();
    }

    public Course findById( @NotNull @Positive Long id) {
        return courseRepository.findById(id).get();
    }

    public Course create(@RequestBody @Valid Course course) {
        return courseRepository.save(course);
    }

    public Optional<Course> update(@NotNull @Positive Long id, @Valid Course course) {
        return courseRepository.findById(id)
                .map(record -> {
                    record.setName(course.getName());
                    record.setCategory(course.getCategory());
                    return courseRepository.save(record);
                });
    }

    public boolean delete( @NotNull @Positive Long id) {
        return courseRepository.findById(id)
                .map(record -> {
                    this.courseRepository.deleteById(id);
                    return true;
                })
                .orElse(false);
    }
}
