package com.bilgeadam.BABaseApiPlaceholder.repository.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Data
@Entity
public class Absence extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    int hourOfAbsence;
    Long studentId;
    String course;
    String courseGroup;
    int absenceDate;
    int totalCourseHours;
    int hourOfAbsenceLimit;
}
