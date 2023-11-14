package com.bilgeadam.BABaseApiPlaceholder.controller;

import com.bilgeadam.BABaseApiPlaceholder.repository.entity.Trainer;
import com.bilgeadam.BABaseApiPlaceholder.service.TrainerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/trainer")
public class TrainerController{

    private final TrainerService trainerService;

    @GetMapping("/find-all")
    public ResponseEntity<List<Trainer>> findAll(){
        return ResponseEntity.ok(trainerService.findAll());
    }

//    @PostMapping("/save")
//    public ResponseEntity<Trainer> save(Trainer trainer){
//        return ResponseEntity.ok(trainerService.save(trainer));
//    }

    @GetMapping("/find-by-id/{id}")
    public ResponseEntity<Trainer> findTrainerById(@PathVariable Long id){
        return  ResponseEntity.ok(trainerService.findTrainerById(id));
    }

    @GetMapping("/find-by-name/{name}")
    public ResponseEntity<List<Trainer>> findTrainerByName(@PathVariable String name){
        return ResponseEntity.ok(trainerService.findByName(name));
    }
    @GetMapping("/find-by-surname/{surname}")
    public ResponseEntity<List<Trainer>> findTrainerBySurname(@PathVariable String surname){
        return ResponseEntity.ok(trainerService.findBySurname(surname));
    }
    @GetMapping("/find-by-email/{email}")
    public ResponseEntity<Trainer> findTrainerByEmail(@PathVariable String email){
        return ResponseEntity.ok(trainerService.findByEmail(email));
    }
    @GetMapping("/find-by-trainer-role/{trainerRole}")
    public ResponseEntity<List<Trainer>> findByTrainerRole(@PathVariable String trainerRole){
        return ResponseEntity.ok(trainerService.findByTrainerRole(trainerRole));
    }

}
