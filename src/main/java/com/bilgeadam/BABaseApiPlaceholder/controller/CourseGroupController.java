package com.bilgeadam.BABaseApiPlaceholder.controller;

import com.bilgeadam.BABaseApiPlaceholder.repository.entity.CourseGroup;
import com.bilgeadam.BABaseApiPlaceholder.service.CourseGroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/group")
public class CourseGroupController {
    private final CourseGroupService courseGroupService;
    @GetMapping
    public ResponseEntity<String> test() {
        return ResponseEntity.ok("Max Width");
    }
    @GetMapping("/findall")
    public ResponseEntity<List<CourseGroup>> findAll(){
        return ResponseEntity.ok(courseGroupService.findAll());
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<CourseGroup> findGroupById(@PathVariable Long id){
        return ResponseEntity.ok(courseGroupService.findGroupById(id));
    }
    @GetMapping("/findgroupsbycourse/{course}")
    public ResponseEntity<List<CourseGroup>> findByCourse(@PathVariable("course") Long courseId){
        return ResponseEntity.ok(courseGroupService.findByCourse(courseId));
    }

    @GetMapping("/findgroupbybranch/{branch}")
    public ResponseEntity<List<CourseGroup>> findGroupByBranch(@PathVariable("branch") Long branchId){
        return ResponseEntity.ok(courseGroupService.findByBranchId(branchId));
    }

    @GetMapping("/findgroupbyname/{name}")
    public ResponseEntity<CourseGroup> findByName(@PathVariable("name") String name){
        return ResponseEntity.ok(courseGroupService.findByName(name));
    }
}
