package com.bilgeadam.BABaseApiPlaceholder.controller;

import com.bilgeadam.BABaseApiPlaceholder.dto.response.SendStudentsResponseDto;
import com.bilgeadam.BABaseApiPlaceholder.repository.entity.Student;
import com.bilgeadam.BABaseApiPlaceholder.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;
    @GetMapping("/find-all")
    public ResponseEntity<List<Student>> findAll(){
        return ResponseEntity.ok(studentService.findAll());
    }

    @GetMapping("/find-student-by-name/{name}")
    public ResponseEntity<List<Student>> findStudentByName(@PathVariable String name){
        return ResponseEntity.ok(studentService.findStudentByName(name));
    }
    @GetMapping("/find-student-by-surname/{surname}")
    public ResponseEntity<List<Student>> findStudentBySurname(@PathVariable String surname){
        return ResponseEntity.ok(studentService.findStudentBySurname(surname));
    }

    @GetMapping("/find-student-by-email/{email}")
    public ResponseEntity<List<Student>> findStudentByEmail(@PathVariable String email){
        return ResponseEntity.ok(studentService.findStudentByEmail(email));
    }

    @GetMapping("/find-student-by-group-id/{groupId}")
    public ResponseEntity<List<Student>> findStudentByGroupId(@PathVariable Long groupId){
        return ResponseEntity.ok(studentService.findStudentByGroupId(groupId));
    }

    @GetMapping("/find-all-base-students")
    public ResponseEntity<List<SendStudentsResponseDto>> findAllBaseStudents() {
        List<SendStudentsResponseDto> studentDtos = studentService.findAllBaseStudents();
        return ResponseEntity.ok(studentDtos);
    }

}
