package com.bilgeadam.BABaseApiPlaceholder.repository.entity;


import com.bilgeadam.BABaseApiPlaceholder.repository.enums.ETrainerRole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
@AllArgsConstructor
@NoArgsConstructor
@Data
@SuperBuilder
@Entity
public class Trainer extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    @Column(unique = true)
    private String email;
    @Enumerated(EnumType.STRING)
    private ETrainerRole trainerRole;


}
