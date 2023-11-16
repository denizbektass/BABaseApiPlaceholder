package com.bilgeadam.BABaseApiPlaceholder.controller;

import com.bilgeadam.BABaseApiPlaceholder.dto.request.FindByNameAndCityRequestDto;
import com.bilgeadam.BABaseApiPlaceholder.repository.entity.Branch;
import com.bilgeadam.BABaseApiPlaceholder.service.BranchService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/branch")
@RequiredArgsConstructor
public class BranchController {

    private final BranchService service;

    @GetMapping("/find-all")
    public ResponseEntity<List<Branch>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

//    @PostMapping("/save")
//    public ResponseEntity<Branch> save(Branch branch) {
//        return ResponseEntity.ok(service.save(branch));
//    }
//
//    @DeleteMapping("/delete")
//    public ResponseEntity<Void> delete(Long id){
//        service.deleteById(id);
//        return ResponseEntity.ok().build();
//    }

    @GetMapping("/find-by-id/{id}")
    public ResponseEntity<Branch> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findBranchById(id));
    }

    @GetMapping("/find-by-name/{name}")
    public ResponseEntity<List<Branch>> findByName(@PathVariable String name) {
        return ResponseEntity.ok(service.findByName(name));
    }

    @GetMapping("/find-by-city/{city}")
    public ResponseEntity<List<Branch>> findByCity(@PathVariable String city) {
        return ResponseEntity.ok(service.findByCity(city));
    }

    @GetMapping("/find-by-name-and-city")
    public ResponseEntity<Branch> findByNameAndCity(FindByNameAndCityRequestDto dto) {
        return ResponseEntity.ok(service.findByNameAndCity(dto));
    }

}
