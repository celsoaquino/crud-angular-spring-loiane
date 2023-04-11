package com.celsoaquino.crudspring;

import com.celsoaquino.crudspring.enums.Category;
import com.celsoaquino.crudspring.enums.Status;
import com.celsoaquino.crudspring.model.Course;
import com.celsoaquino.crudspring.model.Lesson;
import com.celsoaquino.crudspring.repository.CourseRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CrudSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrudSpringApplication.class, args);
    }

    @Bean
    CommandLineRunner initDatabase(CourseRepository courseRepository) {
        return args -> {
            Course c = new Course();
            c.setName("Angular com Spring");
            c.setCategory(Category.FRONT_END);
            Lesson l = new Lesson();
            l.setName("Introdução");
            l.setYoutubeUrl("watch?v=1");
            l.setCourse(c);
            c.getLessons().add(l);

			courseRepository.save(c);
        };
    }

}
