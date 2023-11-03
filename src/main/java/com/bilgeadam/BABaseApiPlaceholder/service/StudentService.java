package com.bilgeadam.BABaseApiPlaceholder.service;

import com.bilgeadam.BABaseApiPlaceholder.exception.ErrorType;
import com.bilgeadam.BABaseApiPlaceholder.exception.StudentManagerException;
import com.bilgeadam.BABaseApiPlaceholder.repository.IStudentRepository;
import com.bilgeadam.BABaseApiPlaceholder.repository.entity.CourseGroup;
import com.bilgeadam.BABaseApiPlaceholder.repository.entity.Student;
import com.bilgeadam.BABaseApiPlaceholder.utility.ServiceManager;
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
        Optional<Student> studentOptional = studentRepository.findByBaEmailIgnoreCase(email);
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
