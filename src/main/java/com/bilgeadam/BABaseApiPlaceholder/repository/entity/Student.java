package com.bilgeadam.BABaseApiPlaceholder.repository.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Student extends BaseEntity {
    @Id
    @GeneratedValue
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
/*
 *
 */
