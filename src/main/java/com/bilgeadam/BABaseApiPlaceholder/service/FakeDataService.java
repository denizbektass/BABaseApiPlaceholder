package com.bilgeadam.BABaseApiPlaceholder.service;

import com.bilgeadam.BABaseApiPlaceholder.repository.*;
import com.bilgeadam.BABaseApiPlaceholder.repository.entity.*;
import com.bilgeadam.BABaseApiPlaceholder.repository.enums.ETrainerRole;
import com.github.javafaker.Faker;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class FakeDataService {
    private final Faker faker;
    private final IStudentRepository studentRepository;
    private final ITrainerRepository trainerRepository;
    private final IBranchRepository branchRepository;
    private final ICourseRepository courseRepository;
    private final ICourseGroupRepository courseGroupRepository;

    @Autowired
    public FakeDataService(IStudentRepository studentRepository, ITrainerRepository trainerRepository, IBranchRepository branchRepository, ICourseRepository courseRepository, ICourseGroupRepository courseGroupRepository) {
        this.faker = new Faker();
        this.branchRepository = branchRepository;
        this.courseRepository = courseRepository;
        this.courseGroupRepository = courseGroupRepository;
        this.studentRepository = studentRepository;
        this.trainerRepository = trainerRepository;
    }

    @Bean
    public ApplicationRunner applicationRunner(FakeDataService fakeDataService) {
        return args -> {
            fakeDataService.generateFakeData();
        };
    }

    public void generateFakeData() {
        generateStudents();
        generateTrainers();
        generateBranches();
        generateCourses();
        generateCourseGroups();
    }

    private void generateStudents() {
        for (int i = 0; i < 100; i++) {
            Student student = new Student();
            String firstName = faker.name().firstName();
            String lastName = faker.name().lastName();


            student.setName(firstName);
            student.setSurname(lastName);
            student.setPersonalEmail(firstName.toLowerCase() + "." + lastName.toLowerCase() + "@gmail.com");
            student.setBaEmail(firstName.toLowerCase() + "." + lastName.toLowerCase() + "@bilgeadam.com");
            student.setBaBoostEmail(firstName.toLowerCase() + "." + lastName.toLowerCase() + "@bilgeadamboost.com");
            student.setGroupId((long) faker.number().numberBetween(1, 10));
            student.setBranchId((long) faker.number().numberBetween(1, 5));
            student.setCreateDate(generateRandomEpochDay(LocalDate.now(), LocalDate.now().plusMonths(3)));
            student.setUpdateDate(generateRandomEpochDay(LocalDate.now().plusMonths(3), LocalDate.now().plusMonths(6)));
            studentRepository.save(student);
        }
    }

    private void generateTrainers() {
        for (int i = 0; i < 10; i++) {
            Trainer trainer = new Trainer();
            String firstName = faker.name().firstName();
            String lastName = faker.name().lastName();


            trainer.setName(firstName);
            trainer.setSurname(lastName);
            trainer.setEmail(firstName.toLowerCase() + "." + lastName.toLowerCase() + "@bilgeadam.com");
            trainer.setTrainerRole(ETrainerRole.values()[i % ETrainerRole.values().length]);
            trainerRepository.save(trainer);
        }
    }

    private void generateBranches() {
        for (int i = 0; i < 5; i++) {
            Branch branch = new Branch();
            branch.setName(faker.company().name());
            branch.setCity(faker.address().city());
            branchRepository.save(branch);
        }
    }

    private void generateCourses() {
        for (int i = 0; i < 5; i++) {
            Course course = new Course();
            course.setName(faker.company().name());
            courseRepository.save(course);
        }
    }

    private void generateCourseGroups() {
        for (int i = 0; i < 10; i++) {
            CourseGroup courseGroup = CourseGroup.builder()
                    .name(faker.name().name())
                    .courseId((long) faker.number().numberBetween(1, 5))
                    .branchId((long) faker.number().numberBetween(1, 5))
                    .startDate(generateRandomLocalDate(LocalDate.now(), LocalDate.now().plusMonths(3)))
                    .endDate(generateRandomLocalDate(LocalDate.now().plusMonths(3), LocalDate.now().plusMonths(6)))
                    .trainers(generateTrainerIds(3)) // Her kurs grubuna 3 eğitmen
                    .build();
            courseGroupRepository.save(courseGroup);
        }
    }

    private List<Long> generateTrainerIds(int count) {
        List<Long> trainerIds = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Long trainerId = (long) faker.number().numberBetween(1, 10); // Eğitmenlerin rastgele ID'lerini seçin
            trainerIds.add(trainerId);
        }
        return trainerIds;
    }

    private LocalDate generateRandomLocalDate(LocalDate start, LocalDate end) {
        long startEpochDay = start.toEpochDay();
        long endEpochDay = end.toEpochDay();
        long randomEpochDay = ThreadLocalRandom.current().nextLong(startEpochDay, endEpochDay);
        return LocalDate.ofEpochDay(randomEpochDay);
    }

    private Long generateRandomEpochDay(LocalDate start, LocalDate end) {
        long startEpochDay = start.toEpochDay();
        long endEpochDay = end.toEpochDay();
        return ThreadLocalRandom.current().nextLong(startEpochDay, endEpochDay + 1);
    }
}
