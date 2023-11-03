package com.bilgeadam.BABaseApiPlaceholder.repository;

import com.bilgeadam.BABaseApiPlaceholder.repository.entity.Trainer;
import com.bilgeadam.BABaseApiPlaceholder.repository.enums.ETrainerRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ITrainerRepository extends JpaRepository<Trainer, Long> {
    List<Trainer> findByNameIgnoreCase(String name);

    List<Trainer> findBySurnameIgnoreCase(String surname);

    Optional<Trainer> findByEmail(String email);

    List<Trainer> findByTrainerRoleIn(List<ETrainerRole> trainerRoles);
}