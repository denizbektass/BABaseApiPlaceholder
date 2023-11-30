package com.bilgeadam.BABaseApiPlaceholder.service;

import com.bilgeadam.BABaseApiPlaceholder.repository.IAbsenceRepository;
import com.bilgeadam.BABaseApiPlaceholder.repository.entity.Absence;
import com.bilgeadam.BABaseApiPlaceholder.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AbsenceService extends ServiceManager<Absence,Long> {
    private final IAbsenceRepository absenceRepository;

    public AbsenceService(IAbsenceRepository absenceRepository){
        super(absenceRepository);
        this.absenceRepository = absenceRepository;
    }

    public List<Absence> findAll(){
        return absenceRepository.findAll();
    }

}
