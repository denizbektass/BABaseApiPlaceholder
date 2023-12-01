package com.bilgeadam.BABaseApiPlaceholder.repository;

import com.bilgeadam.BABaseApiPlaceholder.repository.entity.Absence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAbsenceRepository extends JpaRepository<Absence,Long> {

}
