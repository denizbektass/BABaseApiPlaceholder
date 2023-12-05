package com.bilgeadam.BABaseApiPlaceholder.service;

import com.bilgeadam.BABaseApiPlaceholder.dto.request.SendAbsenceRequestDto;
import com.bilgeadam.BABaseApiPlaceholder.manager.IAbsenceManager;
import com.bilgeadam.BABaseApiPlaceholder.repository.IAbsenceRepository;
import com.bilgeadam.BABaseApiPlaceholder.repository.entity.Absence;
import com.bilgeadam.BABaseApiPlaceholder.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AbsenceService extends ServiceManager<Absence,Long> {
    private final IAbsenceRepository absenceRepository;
    private final IAbsenceManager absenceManager;

    public AbsenceService(IAbsenceRepository absenceRepository, IAbsenceManager absenceManager){
        super(absenceRepository);
        this.absenceRepository = absenceRepository;
        this.absenceManager = absenceManager;
    }

    public List<SendAbsenceRequestDto> findAllAbsences(){
        List<Absence> absences = absenceRepository.findAll();
        return convertToDtoList(absences);
    }

    private List<SendAbsenceRequestDto> convertToDtoList(List<Absence> absences){
        List<SendAbsenceRequestDto> absenceRequestDtos = new ArrayList<>();
        for (Absence absence : absences){
            SendAbsenceRequestDto dto = new SendAbsenceRequestDto();
            dto.setAbsenceId(absence.getUuid().toString());
            dto.setUserId(absence.getStudentId().toString());
            dto.setAbsenceDate(absence.getAbsenceDate());
            dto.setGroup(absence.getCourse());
            dto.setGroupName(absence.getCourseGroup());
            dto.setHourOfAbsence(absence.getHourOfAbsence());
            dto.setTotalCourseHours(absence.getTotalCourseHours());
            dto.setHourOfAbsenceLimit(absence.getHourOfAbsenceLimit());
            absenceRequestDtos.add(dto);
        }
        return absenceRequestDtos;
    }

}
