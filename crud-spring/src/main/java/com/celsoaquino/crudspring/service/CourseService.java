package com.celsoaquino.crudspring.service;


import com.celsoaquino.crudspring.dto.CourseDTO;
import com.celsoaquino.crudspring.dto.mapper.CourseMapper;
import com.celsoaquino.crudspring.exception.RecordNotFoundException;
import com.celsoaquino.crudspring.model.Course;
import com.celsoaquino.crudspring.repository.CourseRepository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.stream.Collectors;

@Validated
@Service
public class CourseService {

    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;

    public CourseService(CourseRepository courseRepository, CourseMapper courseMapper) {
        this.courseRepository = courseRepository;
        this.courseMapper = courseMapper;
    }

    public List<CourseDTO> list() {
        return courseRepository.findAll()
                .stream()
                .map(courseMapper::toDTO)
                .collect(Collectors.toList());
    }

    public CourseDTO findById(@NotNull @Positive Long id) {
        return courseRepository.findById(id)
                .map(courseMapper::toDTO)
                .orElseThrow(() -> new RecordNotFoundException(id));
    }

    public CourseDTO create(@Valid @NotNull CourseDTO course) {
        return courseMapper.toDTO(courseRepository.save(courseMapper.toEntity(course)));
    }

    public CourseDTO update(@NotNull @Positive Long id, @Valid @NotNull CourseDTO courseDTO) {
        return courseRepository.findById(id)
                .map(record -> {
                    Course course = courseMapper.toEntity(courseDTO);
                    record.setName(courseDTO.name());
                    record.setCategory(courseMapper.convertCategoryValue(courseDTO.category()));
                    //record.setLessons(course.getLessons());
                    record.getLessons().clear();
                    course.getLessons().forEach(record.getLessons()::add);

                    return courseMapper.toDTO(courseRepository.save(record));
                })
                .orElseThrow(() -> new RecordNotFoundException(id));
    }

    public void delete(@NotNull @Positive Long id) {
        courseRepository.delete(courseRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException(id)));
    }
}
