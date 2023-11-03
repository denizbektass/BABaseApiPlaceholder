package com.bilgeadam.BABaseApiPlaceholder.repository;

import com.bilgeadam.BABaseApiPlaceholder.repository.entity.CourseGroup;
import com.bilgeadam.BABaseApiPlaceholder.repository.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IStudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByNameIgnoreCase(String name);

    List<Student> findBySurnameIgnoreCase(String surname);

    Optional<Student> findByBaEmailIgnoreCase(String email);

    List<Student> findByGroupId(Long groupId);
}
