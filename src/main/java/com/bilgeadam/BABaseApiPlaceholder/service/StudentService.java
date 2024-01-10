package com.bilgeadam.BABaseApiPlaceholder.service;

import com.bilgeadam.BABaseApiPlaceholder.dto.response.SendStudentsResponseDto;
import com.bilgeadam.BABaseApiPlaceholder.exception.ErrorType;
import com.bilgeadam.BABaseApiPlaceholder.exception.StudentManagerException;
import com.bilgeadam.BABaseApiPlaceholder.manager.IUserManager;
import com.bilgeadam.BABaseApiPlaceholder.repository.IStudentRepository;
import com.bilgeadam.BABaseApiPlaceholder.repository.entity.Student;
import com.bilgeadam.BABaseApiPlaceholder.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StudentService extends ServiceManager<Student,Long> {
    private final IStudentRepository studentRepository;
    private final IUserManager userManager;

    public StudentService(IStudentRepository studentRepository, IUserManager userManager) {
        super(studentRepository);
        this.studentRepository = studentRepository;
        this.userManager = userManager;
    }

    public List<SendStudentsResponseDto> findAllBaseStudents() {
        List<Student> students = studentRepository.findAll();


        return convertToDtoList(students);
    }

    private List<SendStudentsResponseDto> convertToDtoList(List<Student> students) {
        List<SendStudentsResponseDto> studentDtos = new ArrayList<>();

        for (Student student : students) {
            SendStudentsResponseDto dto = new SendStudentsResponseDto();
            dto.setUserId(student.getUuid().toString());
            dto.setName(student.getName());
            dto.setSurname(student.getSurname());
            dto.setEmail(student.getPersonalEmail());
            dto.setPhoneNumber(student.getPhoneNumber());
            dto.setAddress(student.getAddress());
            dto.setSchool(student.getSchool());
            dto.setDepartment(student.getDepartment());
            dto.setBirthDate(student.getBirthDate());
            dto.setBirthPlace(student.getBirthPlace());
            dto.setStatus(student.getStatus());
            dto.setInternShipStatus(student.getInternShipStatus());
            dto.setGroupNameList(List.of(student.getCourseName()));
            dto.setUpdateDate(student.getUpdateDate());
            dto.setSaleDate(student.getSaleDate());
            studentDtos.add(dto);
        }

        return studentDtos;
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
