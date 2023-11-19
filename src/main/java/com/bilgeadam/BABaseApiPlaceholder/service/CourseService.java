package com.bilgeadam.BABaseApiPlaceholder.service;

import com.bilgeadam.BABaseApiPlaceholder.exception.CourseManagerException;
import com.bilgeadam.BABaseApiPlaceholder.exception.ErrorType;
import com.bilgeadam.BABaseApiPlaceholder.repository.ICourseRepository;
import com.bilgeadam.BABaseApiPlaceholder.repository.entity.Course;
import com.bilgeadam.BABaseApiPlaceholder.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService extends ServiceManager<Course,Long> {

    private final ICourseRepository courseRepository;


    public CourseService(ICourseRepository courseRepository) {
        super(courseRepository);
        this.courseRepository = courseRepository;
    }

    public List<Course> findCourseByName(String name) {
        List<Course> coursesList = courseRepository.findByNameIgnoreCase(name);
        if (coursesList.isEmpty()) {
            throw new CourseManagerException(ErrorType.COURSE_NOT_FOUND, "Aradığınız isimde kurs bulunamadı.");
        }
        return coursesList;
    }
    //

}
