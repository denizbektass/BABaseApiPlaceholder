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

    @GetMapping("/findall")
    public ResponseEntity<List<Trainer>> findAll(){
        return ResponseEntity.ok(trainerService.findAll());
    }

//    @PostMapping("/save")
//    public ResponseEntity<Trainer> save(Trainer trainer){
//        return ResponseEntity.ok(trainerService.save(trainer));
//    }

    @GetMapping("/findbyid/{id}")
    public ResponseEntity<Trainer> findTrainerById(@PathVariable Long id){
        return  ResponseEntity.ok(trainerService.findTrainerById(id));
    }

    @GetMapping("/findbyname/{name}")
    public ResponseEntity<List<Trainer>> findTrainerByName(@PathVariable String name){
        return ResponseEntity.ok(trainerService.findByName(name));
    }
    @GetMapping("/findbysurname/{surname}")
    public ResponseEntity<List<Trainer>> findTrainerBySurname(@PathVariable String surname){
        return ResponseEntity.ok(trainerService.findBySurname(surname));
    }
    @GetMapping("/findbyemail/{email}")
    public ResponseEntity<Trainer> findTrainerByEmail(@PathVariable String email){
        return ResponseEntity.ok(trainerService.findByEmail(email));
    }
    @GetMapping("/findbytrainerrole/{trainerRole}")
    public ResponseEntity<List<Trainer>> findByTrainerRole(@PathVariable String trainerRole){
        return ResponseEntity.ok(trainerService.findByTrainerRole(trainerRole));
    }

}
