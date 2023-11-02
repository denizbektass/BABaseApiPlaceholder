package com.bilgeadam.BABaseApiPlaceholder.service;


import com.bilgeadam.BABaseApiPlaceholder.dto.request.FindByNameAndCityRequestDto;
import com.bilgeadam.BABaseApiPlaceholder.exception.ErrorType;
import com.bilgeadam.BABaseApiPlaceholder.exception.FakeBaseApiManagerException;
import com.bilgeadam.BABaseApiPlaceholder.repository.IBranchRepository;
import com.bilgeadam.BABaseApiPlaceholder.repository.entity.Branch;
import com.bilgeadam.utility.ServiceManager;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BranchService extends ServiceManager<Branch,Long> {

    private final IBranchRepository repository;

    public BranchService(IBranchRepository repository) {
        super(repository);
        this.repository = repository;
    }

    @PostConstruct
    public void defaultData() {
        Branch build = Branch.builder().city("Ankara").name("BilgeAdam").build();
        Branch build1 = Branch.builder().city("Istanbul").name("BilgeAdam").build();
        Branch build2 = Branch.builder().city("Antalya").name("BilgeAdam").build();
        Branch build3 = Branch.builder().city("Izmir").name("BilgeAdam").build();
        List<Branch> branches = new ArrayList<>();
        branches.add(build1);
        branches.add(build2);
        branches.add(build3);
        branches.add(build);

        saveAll(branches);
    }


    public Branch findBranchById(Long id) {
        Optional<Branch> byId = findById(id);
        if (byId.isEmpty())
            throw new FakeBaseApiManagerException(ErrorType.BRANCH_NOT_FOUND);
         return byId.get();
    }

    public Branch findBranchById2(Long id) {
       return findById(id).orElseThrow(()-> new FakeBaseApiManagerException(ErrorType.BRANCH_NOT_FOUND));
    }

    public List<Branch> findByName(String name) {
        List<Branch> branchList = repository.findByName(name);
        if (branchList.isEmpty())
            throw new FakeBaseApiManagerException(ErrorType.BRANCH_NOT_FOUND);
        return branchList;
    }

    public List<Branch> findByCity(String city) {
        List<Branch> branchList = repository.findByCity(city);

        if (branchList.isEmpty())
            throw new FakeBaseApiManagerException(ErrorType.BRANCH_NOT_FOUND);
        return branchList;
    }

    public Branch findByNameAndCity(FindByNameAndCityRequestDto dto) {
        Optional<Branch> optionalBranch = repository.findByNameAndCity(dto.getName(), dto.getCity());

        if (optionalBranch.isEmpty())
            throw new FakeBaseApiManagerException(ErrorType.BRANCH_NOT_FOUND);
        return optionalBranch.get();
    }
}
