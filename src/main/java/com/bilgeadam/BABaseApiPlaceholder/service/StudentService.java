package com.bilgeadam.BABaseApiPlaceholder.service;

import com.bilgeadam.BABaseApiPlaceholder.exception.ErrorType;
import com.bilgeadam.BABaseApiPlaceholder.exception.StudentManagerException;
import com.bilgeadam.BABaseApiPlaceholder.repository.IStudentRepository;
import com.bilgeadam.BABaseApiPlaceholder.repository.entity.CourseGroup;
import com.bilgeadam.BABaseApiPlaceholder.repository.entity.Student;
import com.bilgeadam.utility.ServiceManager;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService extends ServiceManager<Student,Long> {
    private final IStudentRepository studentRepository;

    public StudentService(IStudentRepository studentRepository) {
        super(studentRepository);
        this.studentRepository = studentRepository;
    }

    @PostConstruct
    public void defaultData() {
        save(Student.builder()
                .name("Engin")
                .surname("Akalın")
                .personalEmail("engin@gmail.com")
                .baEmail("engin@bilgeadam.com")
                .baBoostEmail("engin@bilgeadamboost.com")
                .groupId(1L)
                .branchId(1L)
                .build());
        save(Student.builder()
                .name("Berk")
                .surname("Aktaş")
                .personalEmail("berk@gmail.com")
                .baEmail("berk@bilgeadam.com")
                .baBoostEmail("berk@bilgeadamboost.com")
                .groupId(2L)
                .branchId(2L)
                .build());
        save(Student.builder()
                .name("Doruk")
                .surname("Tokinan")
                .personalEmail("doruk@gmail.com")
                .baEmail("doruk@bilgeadam.com")
                .baBoostEmail("doruk@bilgeadamboost.com")
                .groupId(3L)
                .branchId(3L)
                .build());
        save(Student.builder()
                .name("Levent Tarık")
                .surname("Koyuncu")
                .personalEmail("leventtarik@gmail.com")
                .baEmail("leventtarik@bilgeadam.com")
                .baBoostEmail("leventtarik@bilgeadamboost.com")
                .groupId(4L)
                .branchId(4L)
                .build());
    }

    public List<Student> findStudentByName(String name) {
        List<Student> studentsList = studentRepository.findByNameIgnoreCase(name);
        if (studentsList.isEmpty()) {
            throw new StudentManagerException(ErrorType.STUDENT_NOT_FOUND, "Aradığınız isimde öğrenci bulunamadı.");
        }
        return studentsList;
    }

    public List<Student> findStudentBySurname(String surname) {
        List<Student> studentsList = studentRepository.findBySurnameIgnoreCase(surname);
        if (studentsList.isEmpty()) {
            throw new StudentManagerException(ErrorType.STUDENT_NOT_FOUND, "Aradığınız soyisimde öğrenci bulunamadı.");
        }
        return studentsList;
    }

    public List<Student> findStudentByEmail(String email) {
        Optional<Student> studentOptional = studentRepository.findByEmailIgnoreCase(email);
        return studentOptional.map(Collections::singletonList).orElse(Collections.emptyList());
    }

    public List<Student> findStudentByGroupId(Long groupId) {
        List<Student> studentsList = studentRepository.findByGroupId(groupId);
        if (studentsList.isEmpty()) {
            throw new StudentManagerException(ErrorType.STUDENT_NOT_FOUND, "Aradığınız grupta öğrenci bulunmamaktadır.");
        }
        return studentsList;
    }
}
