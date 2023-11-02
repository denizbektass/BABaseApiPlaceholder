package com.bilgeadam.BABaseApiPlaceholder.service;

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

    @PostConstruct
    public void defaultData() {
        save(CourseGroup.builder()
                .name("JAVA9")
                .startDate(LocalDate.now())
                .endDate(LocalDate.of(2024, 05, 2))
                .branchId(1L)
                .courseId(1L)
                .build());
        save(CourseGroup.builder()
                .name("REACT18")
                .startDate(LocalDate.now())
                .endDate(LocalDate.of(2024, 05, 2))
                .branchId(1L)
                .courseId(1L)
                .build());
        save(CourseGroup.builder()
                .name("K8S-1")
                .startDate(LocalDate.now())
                .endDate(LocalDate.of(2024, 7, 20))
                .branchId(2L)
                .courseId(2L)
                .build());
        save(CourseGroup.builder()
                .name("PYTHON15")
                .startDate(LocalDate.now())
                .endDate(LocalDate.of(2024, 5, 10))
                .branchId(3L)
                .courseId(2L)
                .build());
        save(CourseGroup.builder()
                .name("JAVA9-BOOST")
                .startDate(LocalDate.now())
                .endDate(LocalDate.of(2024, 5, 5))
                .branchId(4L)
                .courseId(3L)
                .build());
        save(CourseGroup.builder()
                .name("JAVA10")
                .startDate(LocalDate.now())
                .endDate(LocalDate.of(2024, 5, 15))
                .branchId(4L)
                .courseId(3L)
                .build());
    }

    public CourseGroup findGroupById(Long id) {
        return findById(id).orElseThrow(() -> new RuntimeException("GROUP FALAN YOK AŞKO"));
    }

    public List<CourseGroup> findByCourse(Long courseId) {
        List<CourseGroup> groupList = courseGroupRepository.findByCourseId(courseId);
        if (groupList.isEmpty()){
            throw new RuntimeException("Bu kursa ait sınıf bulunmamaktadır");
        }
        return groupList;
    }

    public List<CourseGroup> findByBranchId(Long branchId){
        if (courseGroupRepository.findByBranchId(branchId).isEmpty()){
            throw new RuntimeException("Bu kursa ait şube bulunamamıştır");
        }
        return courseGroupRepository.findByBranchId(branchId);
    }

    public CourseGroup findByName(String name) {
        return courseGroupRepository.findByName(name).orElseThrow(() -> new RuntimeException("Bu isimle bir sınıf mevcut değil"));
    }

}
