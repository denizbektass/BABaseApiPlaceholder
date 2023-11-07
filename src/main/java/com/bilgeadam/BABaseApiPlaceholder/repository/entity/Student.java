package com.bilgeadam.BABaseApiPlaceholder.repository.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

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
    private Long groupId;
    private Long branchId;

}