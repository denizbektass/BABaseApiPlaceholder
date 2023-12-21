package com.bilgeadam.BABaseApiPlaceholder.repository.entity;

import com.bilgeadam.BABaseApiPlaceholder.repository.enums.EStatus;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.List;

@SuperBuilder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Student extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    @Column(unique = true)
    private String personalEmail;
    @Column(unique = true)
    private String baEmail;
    @Column(unique = true)
    private String baBoostEmail;
    private String phoneNumber;
    private String address;
    private String school;
    private String department;
    private LocalDate birthDate;
    private String birthPlace;
    @Builder.Default
    private EStatus status = EStatus.ACTIVE;
    @Builder.Default
    private EStatus internShipStatus = EStatus.PASSIVE;
    private String courseName;
    private Long groupId;
    private Long branchId;
    private LocalDate saleDate;

}