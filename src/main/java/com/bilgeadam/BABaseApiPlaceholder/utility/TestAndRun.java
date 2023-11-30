package com.bilgeadam.BABaseApiPlaceholder.utility;

import com.bilgeadam.BABaseApiPlaceholder.repository.entity.Branch;
import com.bilgeadam.BABaseApiPlaceholder.repository.entity.CourseGroup;
import com.bilgeadam.BABaseApiPlaceholder.repository.entity.Student;
import com.bilgeadam.BABaseApiPlaceholder.repository.entity.Trainer;
import com.bilgeadam.BABaseApiPlaceholder.repository.enums.EStatus;
import com.bilgeadam.BABaseApiPlaceholder.repository.enums.ETrainerRole;
import com.bilgeadam.BABaseApiPlaceholder.service.BranchService;
import com.bilgeadam.BABaseApiPlaceholder.service.CourseGroupService;
import com.bilgeadam.BABaseApiPlaceholder.service.StudentService;
import com.bilgeadam.BABaseApiPlaceholder.service.TrainerService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class TestAndRun {

    public final TrainerService trainerService;
    public final CourseGroupService courseGroupService;
    public final BranchService branchService;
    public final StudentService studentService;

    @PostConstruct
    public void init() {
        Optional<Branch> byId = branchService.findById(4L);
        if (byId.isEmpty()) {
            defaultBranchData();
            defaultTrainerData();
        }
    }

    public void defaultTrainerData() {
        trainerService.save(Trainer.builder().email("trainer.selim.peon@gmail.com").name("Selim").surname("Gülnihal").trainerRole(ETrainerRole.MASTER_TRAINER).build());
        trainerService.save(Trainer.builder().email("trainer.aktasberk96@gmail.com").name("Berk").surname("Aktaş").trainerRole(ETrainerRole.MASTER_TRAINER).build());
        trainerService.save(Trainer.builder().email("trainer.doruk.tokinan@gmail.com").name("Doruk").surname("Tokinan").trainerRole(ETrainerRole.ASSISTANT_TRAINER).build());
    }

    public void defaultCourseGroupData() {
        courseGroupService.save(CourseGroup.builder()
                .name("JAVA9")
                .startDate(LocalDate.now())
                .endDate(LocalDate.of(2024, 05, 2))
                .branchId(1L)
                .courseId(1L)
                .trainers(List.of(1L, 2L))
                .build());
        courseGroupService.save(CourseGroup.builder()
                .name("REACT18")
                .startDate(LocalDate.now())
                .endDate(LocalDate.of(2024, 05, 2))
                .branchId(1L)
                .courseId(1L)
                .trainers(List.of(1L, 3L))
                .build());
        courseGroupService.save(CourseGroup.builder()
                .name("K8S-1")
                .startDate(LocalDate.now())
                .endDate(LocalDate.of(2024, 7, 20))
                .branchId(2L)
                .courseId(2L)
                .trainers(List.of(2L, 3L))
                .build());
        courseGroupService.save(CourseGroup.builder()
                .name("PYTHON15")
                .startDate(LocalDate.now())
                .endDate(LocalDate.of(2024, 5, 10))
                .branchId(3L)
                .courseId(2L)
                .build());
        courseGroupService.save(CourseGroup.builder()
                .name("JAVA9-BOOST")
                .startDate(LocalDate.now())
                .endDate(LocalDate.of(2024, 5, 5))
                .branchId(4L)
                .courseId(3L)
                .build());
        courseGroupService.save(CourseGroup.builder()
                .name("JAVA10")
                .startDate(LocalDate.now())
                .endDate(LocalDate.of(2024, 5, 15))
                .branchId(4L)
                .courseId(3L)
                .build());
    }

    public void defaultBranchData() {
        Branch build = Branch.builder().city("Ankara").name("BilgeAdam").build();
        Branch build1 = Branch.builder().city("Istanbul").name("BilgeAdam").build();
        Branch build2 = Branch.builder().city("Antalya").name("BilgeAdam").build();
        Branch build3 = Branch.builder().city("Izmir").name("BilgeAdam").build();
        List<Branch> branches = new ArrayList<>();
        branches.add(build1);
        branches.add(build2);
        branches.add(build3);
        branches.add(build);
        branchService.saveAll(branches);
    }
    public void defaultStudentData() {
        studentService.save(Student.builder()
                .name("Engin")
                .surname("Akalın")
                .personalEmail("engin@gmail.com")
                .baEmail("engin@bilgeadam.com")
                .baBoostEmail("engin@bilgeadamboost.com")
                .phoneNumber("05112323232")
                .address("Kağıthane / İstanbul")
                .school("İstanbul Üniversitesi")
                .department("Matematik Bölümü")
                .birthDate(LocalDate.of(1996,11,28))
                .birthPlace("İstanbul")
                .status(EStatus.ACTIVE)
                .internShipStatus(EStatus.PASSIVE)
                .groupId(1L)
                .branchId(1L)
                .build());
        studentService.save(Student.builder()
                .name("Berk")
                .surname("Aktaş")
                .personalEmail("berk@gmail.com")
                .baEmail("berk@bilgeadam.com")
                .baBoostEmail("berk@bilgeadamboost.com")
                .phoneNumber("05114445566")
                .address("Beykoz / İstanbul")
                .school("Marmara Üniversitesi")
                .department("Bilgisayar Mühendisliği Bölümü")
                .birthDate(LocalDate.of(1993,05,05))
                .birthPlace("Yozgat")
                .status(EStatus.ACTIVE)
                .internShipStatus(EStatus.PASSIVE)
                .groupId(2L)
                .branchId(2L)
                .build());
        studentService.save(Student.builder()
                .name("Doruk")
                .surname("Tokinan")
                .personalEmail("doruk@gmail.com")
                .baEmail("doruk@bilgeadam.com")
                .baBoostEmail("doruk@bilgeadamboost.com")
                .phoneNumber("05116666666")
                .address("Etimesgut / Ankara")
                .school("Eskişehir Osmangazi Üniversitesi")
                .department("Makine Mühendisliği Bölümü")
                .birthDate(LocalDate.of(1996,06,11))
                .birthPlace("İstanbul")
                .status(EStatus.ACTIVE)
                .internShipStatus(EStatus.PASSIVE)
                .groupId(3L)
                .branchId(3L)
                .build());
        studentService.save(Student.builder()
                .name("Levent Tarık")
                .surname("Koyuncu")
                .personalEmail("leventtarik@gmail.com")
                .baEmail("leventtarik@bilgeadam.com")
                .baBoostEmail("leventtarik@bilgeadamboost.com")
                .phoneNumber("05112323232")
                .address("Dikili / İzmir")
                .school("Ege Üniversitesi")
                .department("Yazılım Bölümü")
                .birthDate(LocalDate.of(2000,03,18))
                .birthPlace("Balıkesir")
                .status(EStatus.ACTIVE)
                .internShipStatus(EStatus.PASSIVE)
                .groupId(4L)
                .branchId(4L)
                .build());
    }
}
