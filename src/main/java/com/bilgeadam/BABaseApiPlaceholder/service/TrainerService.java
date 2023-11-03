package com.bilgeadam.BABaseApiPlaceholder.service;

import com.bilgeadam.BABaseApiPlaceholder.exception.ErrorType;
import com.bilgeadam.BABaseApiPlaceholder.exception.TrainerManagerException;
import com.bilgeadam.BABaseApiPlaceholder.repository.ITrainerRepository;
import com.bilgeadam.BABaseApiPlaceholder.repository.entity.Trainer;
import com.bilgeadam.BABaseApiPlaceholder.repository.enums.ETrainerRole;
import com.bilgeadam.BABaseApiPlaceholder.utility.Helpers;
import com.bilgeadam.BABaseApiPlaceholder.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

@Service
public class TrainerService extends ServiceManager<Trainer, Long> {
    private final ITrainerRepository trainerRepository;

    public TrainerService(ITrainerRepository trainerRepository) {
        super(trainerRepository);
        this.trainerRepository = trainerRepository;
    }

    public Trainer findTrainerById(Long id) {
        return findById(id).orElseThrow(() -> new TrainerManagerException(ErrorType.TRAINER_NOT_FOUND, "Aranan ID'de kimse bulunamadı!"));
    }

    public List<Trainer> findByName(String name) {
        List<Trainer> trainerList = trainerRepository.findByNameIgnoreCase(name);
        if (trainerList.isEmpty())
            throw new TrainerManagerException(ErrorType.TRAINER_NOT_FOUND, "Aradığınız isimde kimse yok!");
        return trainerList;
    }

    public List<Trainer> findBySurname(String surname) {
        List<Trainer> trainerList = trainerRepository.findBySurnameIgnoreCase(surname);
        if (trainerList.isEmpty())
            throw new TrainerManagerException(ErrorType.TRAINER_NOT_FOUND, "Aradığınız soyisimde kimse yok!");
        return trainerList;
    }

    public Trainer findByEmail(String email) {
        return trainerRepository.findByEmail(email).orElseThrow(() -> new TrainerManagerException(ErrorType.TRAINER_NOT_FOUND, "Aradığınız mail adresi mevcut değil!"));
    }

    public List<Trainer> findByTrainerRole(String trainerRole) {

        List<ETrainerRole> filteredList = Arrays.stream(ETrainerRole.values())
                .filter(x -> x.name().contains(Helpers.handleTurkish(trainerRole).toUpperCase(Locale.ENGLISH))).toList();
        if (filteredList.isEmpty())
            throw new TrainerManagerException(ErrorType.TRAINER_ROLE_NOT_FOUND);
        List<Trainer> trainerList = trainerRepository.findByTrainerRoleIn(filteredList);
        if (trainerList.isEmpty())
            throw new TrainerManagerException(ErrorType.TRAINER_NOT_FOUND);
        return trainerList;
    }


}
