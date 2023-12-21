package com.bilgeadam.BABaseApiPlaceholder.service;

import com.bilgeadam.BABaseApiPlaceholder.repository.*;
import com.bilgeadam.BABaseApiPlaceholder.repository.entity.*;
import com.bilgeadam.BABaseApiPlaceholder.repository.enums.ETrainerRole;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
@Service
public class FakeDataService {
    private final Faker faker;
    private final IStudentRepository studentRepository;
    private final ITrainerRepository trainerRepository;
    private final IBranchRepository branchRepository;
    private final ICourseRepository courseRepository;
    private final ICourseGroupRepository courseGroupRepository;
    private final IAbsenceRepository absenceRepository;

    @Autowired
    public FakeDataService(IStudentRepository studentRepository, ITrainerRepository trainerRepository, IBranchRepository branchRepository, ICourseRepository courseRepository, ICourseGroupRepository courseGroupRepository, IAbsenceRepository absenceRepository) {
        this.absenceRepository = absenceRepository;
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
        generateCourseGroups();
        generateStudents();
        generateTrainers();
        generateBranches();
        generateCourses();
        generateAbsences();
    }

    private void generateStudents() {
        List<CourseGroup> allCourseGroups = courseGroupRepository.findAll();
        Random random = new Random();
        for (int i = 0; i < 40; i++) {
            Student student = new Student();
            String firstName = faker.name().firstName();
            String lastName = faker.name().lastName();
            String streetAddress = faker.address().streetAddress();
            String city = faker.address().city();
            String formattedPhoneNumber = customizePhoneNumber();
            String schoolName = faker.university().name();
            String departmentName = faker.educator().course();
            String cityBorn = faker.address().city();
            LocalDate birthdayDate = faker.date().birthday().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            CourseGroup randomCourseGroup = allCourseGroups.get(random.nextInt(allCourseGroups.size()));
            LocalDate saleDate = faker.date()
                    .between(
                            Date.from(LocalDate.now().minusYears(3).atStartOfDay(ZoneId.systemDefault()).toInstant()),
                            Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant())
                    ).toInstant().atZone(ZoneId.systemDefault()).toLocalDate();


            student.setName(firstName);
            student.setSurname(lastName);
            student.setPersonalEmail(firstName.toLowerCase() + "." + lastName.toLowerCase() + "@gmail.com");
            student.setBaEmail(firstName.toLowerCase() + "." + lastName.toLowerCase() + "@bilgeadam.com");
            student.setBaBoostEmail(firstName.toLowerCase() + "." + lastName.toLowerCase() + "@bilgeadamboost.com");
            student.setAddress(streetAddress + " / " + city);
            student.setPhoneNumber(formattedPhoneNumber);
            student.setDepartment(departmentName);
            student.setSchool(schoolName);
            student.setBirthPlace(cityBorn);
            student.setBirthDate(birthdayDate);
            student.setGroupId(randomCourseGroup.getId());
            student.setBranchId((long) faker.number().numberBetween(1, 5));
            student.setCreateDate(generateRandomEpochDay(LocalDate.now(), LocalDate.now().plusMonths(3)));
            student.setUpdateDate(generateRandomEpochDay(LocalDate.now().plusMonths(3), LocalDate.now().plusMonths(6)));
            student.setCourseName(randomCourseGroup.getName());
            student.setSaleDate(saleDate);
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
        Course course1 = Course.builder()
                .name("Boost Java Eğitimi")
                .build();
        courseRepository.save(course1);

        Course course2 = Course.builder()
                .name("Boost .Net Eğitimi")
                .build();
        courseRepository.save(course2);
    }


    private void generateCourseGroups() {
        String[] courseNames = {"Java", ".Net"};
        for (int i = 0; i < 10; i++) {
            String selectedCourseName = courseNames[new Random().nextInt(courseNames.length)];
            int versionNumber = new Random().nextInt(6) + 5;
            String courseGroupName = selectedCourseName + versionNumber;
            int totalCourseHours = faker.number().numberBetween(30, 600);

            // Java eğitimi ID 1, .Net eğitimi ID 2
            long courseId = selectedCourseName.equals("Java") ? 1L : 2L;

            CourseGroup courseGroup = CourseGroup.builder()
                    .name(courseGroupName)
                    .courseId(courseId) // Java için ID 1, .Net için ID 2
                    .branchId((long) faker.number().numberBetween(1, 5))
                    .startDate(generateRandomLocalDate(LocalDate.now(), LocalDate.now().plusMonths(3)))
                    .endDate(generateRandomLocalDate(LocalDate.now().plusMonths(3), LocalDate.now().plusMonths(6)))
                    .trainers(generateTrainerIds(3)) // Her kurs grubuna 3 eğitmen
                    .totalCourseHours(totalCourseHours)
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
    private String customizePhoneNumber() {
        return String.format("+90 (%s) %s-%s",
                faker.number().numberBetween(500, 599),
                faker.number().numberBetween(100, 999),
                faker.number().numberBetween(1000, 9999));
    }

    /*private void generateAbsences(){
        List<Student> students = studentRepository.findAll();
        List<Course> courses = courseRepository.findAll();

        for (Student student : students){
            Optional<CourseGroup> courseGroupOpt = courseGroupRepository.findById(student.getGroupId());
            if (courseGroupOpt.isPresent()) {
                CourseGroup courseGroup = courseGroupOpt.get();
                Optional<Course> courseOpt = courses.stream().filter(c -> c.getId().equals(courseGroup.getCourseId())).findFirst();
                if (courseOpt.isPresent()){
                    Course course = courseOpt.get();
                    int totalCourseHours = courseGroup.getTotalCourseHours();
                    int hourOfAbsenceLimit = (int) Math.ceil(totalCourseHours * 0.10);

                    Absence absence = new Absence();
                    absence.setStudentId(student.getUuid());
                    absence.setCourse(course.getName());
                    absence.setCourseGroup(courseGroup.getName());
                    absence.setAbsenceDate(faker.number().numberBetween(1, 365));
                    absence.setTotalCourseHours(totalCourseHours);
                    absence.setHourOfAbsence(faker.number().numberBetween(0, hourOfAbsenceLimit));
                    absence.setHourOfAbsenceLimit(hourOfAbsenceLimit);
                    absence.setCreateDate(generateRandomEpochDay(LocalDate.now(), LocalDate.now().plusMonths(3)));
                    absence.setUpdateDate(generateRandomEpochDay(LocalDate.now().plusMonths(3), LocalDate.now().plusMonths(6)));

                    absenceRepository.save(absence);
                }
            }
        }
    }*/

    private void generateAbsences(){
        List<Student> students = studentRepository.findAll();
        List<Course> courses = courseRepository.findAll();

        for (Student student : students){
            Optional<CourseGroup> courseGroupOpt = courseGroupRepository.findById(student.getGroupId());
            if (courseGroupOpt.isPresent()) {
                CourseGroup courseGroup = courseGroupOpt.get();
                Optional<Course> courseOpt = courses.stream().filter(c -> c.getId().equals(courseGroup.getCourseId())).findFirst();
                if (courseOpt.isPresent()){
                    Course course = courseOpt.get();
                    int totalCourseHours = courseGroup.getTotalCourseHours();
                    int hourOfAbsenceLimitTheo = (int) Math.ceil(totalCourseHours * 0.10);
                    int hourOfAbsenceLimitPrac = (int) Math.ceil(totalCourseHours * 0.10);

                    // Teorik Yoklama
                    Absence absenceTheo = new Absence();
                    absenceTheo.setStudentId(student.getUuid());
                    absenceTheo.setCourse(course.getName());
                    absenceTheo.setCourseGroup(courseGroup.getName());
                    absenceTheo.setAbsenceDateTheo(faker.number().numberBetween(1, 365));
                    absenceTheo.setHourOfAbsenceTheo(faker.number().numberBetween(0, hourOfAbsenceLimitTheo));
                    absenceTheo.setTotalCourseHoursTheo(totalCourseHours);
                    absenceTheo.setHourOfAbsenceLimitTheo(hourOfAbsenceLimitTheo);
                    absenceTheo.setCreateDate(generateRandomEpochDay(LocalDate.now(), LocalDate.now().plusMonths(3)));
                    absenceTheo.setUpdateDate(generateRandomEpochDay(LocalDate.now().plusMonths(3), LocalDate.now().plusMonths(6)));
                    absenceRepository.save(absenceTheo);

                    // Pratik Yoklama
                    Absence absencePrac = new Absence();
                    absencePrac.setStudentId(student.getUuid());
                    absencePrac.setCourse(course.getName());
                    absencePrac.setCourseGroup(courseGroup.getName());
                    absencePrac.setAbsenceDatePrac(faker.number().numberBetween(1, 365));
                    absencePrac.setHourOfAbsencePrac(faker.number().numberBetween(0, hourOfAbsenceLimitPrac));
                    absencePrac.setTotalCourseHoursPrac(totalCourseHours);
                    absencePrac.setHourOfAbsenceLimitPrac(hourOfAbsenceLimitPrac);
                    absencePrac.setCreateDate(generateRandomEpochDay(LocalDate.now(), LocalDate.now().plusMonths(3)));
                    absencePrac.setUpdateDate(generateRandomEpochDay(LocalDate.now().plusMonths(3), LocalDate.now().plusMonths(6)));
                    absenceRepository.save(absencePrac);
                }
            }
        }
    }







}
