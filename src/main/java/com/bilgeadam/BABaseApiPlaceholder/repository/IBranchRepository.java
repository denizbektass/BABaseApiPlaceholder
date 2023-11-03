package com.bilgeadam.BABaseApiPlaceholder.repository;


import com.bilgeadam.BABaseApiPlaceholder.repository.entity.Branch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IBranchRepository extends JpaRepository<Branch, Long> {
    List<Branch> findByName(String name);

    Optional<Branch> findByNameAndCity(String name, String city);

    List<Branch> findByCity(String city);


}
