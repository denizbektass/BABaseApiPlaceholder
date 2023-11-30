package com.bilgeadam.BABaseApiPlaceholder.repository.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.JdbcTypeCode;

import java.sql.Types;
import java.util.UUID;

@SuperBuilder
@Data
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class BaseEntity {

    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid" , strategy = "uuid")
    @JdbcTypeCode(java.sql.Types.VARCHAR)
    private UUID uuid;
    private Long createDate;
    private Long updateDate;

    @PrePersist
    public void onCreate() {
        setUuid(java.util.UUID.randomUUID());
    }
}
