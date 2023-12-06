package com.bilgeadam.BABaseApiPlaceholder.controller;

import com.bilgeadam.BABaseApiPlaceholder.dto.response.SendAbsenceResponseDto;
import com.bilgeadam.BABaseApiPlaceholder.repository.entity.Absence;
import com.bilgeadam.BABaseApiPlaceholder.service.AbsenceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/absence")
@RequiredArgsConstructor
public class AbsenceController {
    private final AbsenceService absenceService;

    @GetMapping
    public ResponseEntity<List<Absence>> getAllAbsences(){
        List<Absence> absences = absenceService.findAll();
        return ResponseEntity.ok(absences);
    }

    @GetMapping("/find-all-base-absences")
    public ResponseEntity<List<SendAbsenceResponseDto>> findAllAbsences(){
        List<SendAbsenceResponseDto> absenceRequestDtos = absenceService.findAllAbsences();
        return ResponseEntity.ok(absenceRequestDtos);
    }

}
