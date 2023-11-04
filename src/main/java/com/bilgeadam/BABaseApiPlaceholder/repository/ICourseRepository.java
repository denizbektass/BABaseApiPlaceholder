package com.bilgeadam.BABaseApiPlaceholder.repository;

import com.bilgeadam.BABaseApiPlaceholder.repository.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICourseRepository extends JpaRepository<Course, Long> {
    List<Course> findByNameIgnoreCase(String name);

}
