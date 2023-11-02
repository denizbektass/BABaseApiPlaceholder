package com.bilgeadam.BABaseApiPlaceholder.controller;

import com.bilgeadam.BABaseApiPlaceholder.repository.entity.CourseGroup;
import com.bilgeadam.BABaseApiPlaceholder.repository.entity.Student;
import com.bilgeadam.BABaseApiPlaceholder.repository.entity.Trainer;
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
    @GetMapping("/findall")
    public ResponseEntity<List<Student>> findAll(){
        return ResponseEntity.ok(studentService.findAll());
    }

    @GetMapping("/findstudentbyname/{name}")
    public ResponseEntity<List<Student>> findStudentByName(@PathVariable String name){
        return ResponseEntity.ok(studentService.findStudentByName(name));
    }
    @GetMapping("/findstudentbysurname/{surname}")
    public ResponseEntity<List<Student>> findStudentBySurname(@PathVariable String surname){
        return ResponseEntity.ok(studentService.findStudentBySurname(surname));
    }

    @GetMapping("/findstudentbyemail/{email}")
    public ResponseEntity<List<Student>> findStudentByEmail(@PathVariable String email){
        return ResponseEntity.ok(studentService.findStudentByEmail(email));
    }

    @GetMapping("/findstudentbygroupid/{groupId}")
    public ResponseEntity<List<Student>> findStudentByGroupId(@PathVariable Long groupId){
        return ResponseEntity.ok(studentService.findStudentByGroupId(groupId));
    }
}
