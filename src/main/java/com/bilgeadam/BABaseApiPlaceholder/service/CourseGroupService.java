package com.bilgeadam.BABaseApiPlaceholder.service;

import com.bilgeadam.BABaseApiPlaceholder.exception.ErrorType;
import com.bilgeadam.BABaseApiPlaceholder.exception.FakeBaseApiManagerException;
import com.bilgeadam.BABaseApiPlaceholder.repository.ICourseGroupRepository;
import com.bilgeadam.BABaseApiPlaceholder.repository.entity.CourseGroup;
import com.bilgeadam.BABaseApiPlaceholder.utility.ServiceManager;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CourseGroupService extends ServiceManager<CourseGroup, Long> {
    private final ICourseGroupRepository courseGroupRepository;

    public CourseGroupService(ICourseGroupRepository groupRepository) {
        super(groupRepository);
        this.courseGroupRepository = groupRepository;
    }

    public CourseGroup findGroupById(Long id) {
        return findById(id).orElseThrow(() -> new FakeBaseApiManagerException(ErrorType.COURSEGROUP_NOT_FOUND));
    }

    public List<CourseGroup> findByCourse(Long courseId) {
        List<CourseGroup> groupList = courseGroupRepository.findByCourseId(courseId);
        if (groupList.isEmpty()) {
            throw new FakeBaseApiManagerException(ErrorType.COURSEGROUP_NOT_FOUND);
        }
        return groupList;
    }

    public List<CourseGroup> findByBranchId(Long branchId) {
        if (courseGroupRepository.findByBranchId(branchId).isEmpty()) {
            throw new FakeBaseApiManagerException(ErrorType.COURSEGROUP_NOT_FOUND);
        }
        return courseGroupRepository.findByBranchId(branchId);
    }

    public CourseGroup findByName(String name) {
        return courseGroupRepository.findByName(name).orElseThrow(() -> new FakeBaseApiManagerException(ErrorType.COURSEGROUP_NOT_FOUND));
    }
}
