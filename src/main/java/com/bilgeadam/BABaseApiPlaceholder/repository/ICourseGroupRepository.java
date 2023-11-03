package com.bilgeadam.BABaseApiPlaceholder.repository;


import com.bilgeadam.BABaseApiPlaceholder.repository.entity.CourseGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ICourseGroupRepository extends JpaRepository<CourseGroup, Long> {
    Optional<CourseGroup> findByName(String name);

    List<CourseGroup> findByCourseId(Long courseId);

    List<CourseGroup> findByBranchId(Long branchId);

//    List<CourseGroup> findCourseGroupByTrainers(Long trainers);
}