package com.bilgeadam.BABaseApiPlaceholder.service;

import com.bilgeadam.BABaseApiPlaceholder.dto.response.SendAbsenceResponseDto;
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

    public List<SendAbsenceResponseDto> findAllAbsences(){
        List<Absence> absences = absenceRepository.findAll();
        return convertToDtoList(absences);
    }

    private List<SendAbsenceResponseDto> convertToDtoList(List<Absence> absences){
        List<SendAbsenceResponseDto> absenceRequestDtos = new ArrayList<>();
        for (Absence absence : absences){
            SendAbsenceResponseDto dto = new SendAbsenceResponseDto();
            dto.setAbsenceId(absence.getUuid().toString());
            dto.setUserId(absence.getStudentId().toString());
            dto.setGroup(absence.getCourse());
            dto.setGroupName(absence.getCourseGroup());
            dto.setAbsenceDateTheo(absence.getAbsenceDateTheo());
            dto.setAbsenceDatePrac(absence.getAbsenceDatePrac());
            dto.setHourOfAbsenceTheo(absence.getHourOfAbsenceTheo());
            dto.setHourOfAbsencePrac(absence.getHourOfAbsencePrac());
            dto.setTotalCourseHoursTheo(absence.getTotalCourseHoursTheo());
            dto.setTotalCourseHoursPrac(absence.getTotalCourseHoursPrac());
            dto.setHourOfAbsenceLimitTheo(absence.getHourOfAbsenceLimitTheo());
            dto.setHourOfAbsenceLimitPrac(absence.getHourOfAbsenceLimitPrac());
            absenceRequestDtos.add(dto);
        }
        return absenceRequestDtos;
    }

}
