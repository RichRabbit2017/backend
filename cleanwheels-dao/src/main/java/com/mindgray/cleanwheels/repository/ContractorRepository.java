package com.mindgray.cleanwheels.repository;

import com.mindgray.cleanwheels.entity.Contractor;
import com.mindgray.cleanwheels.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContractorRepository extends JpaRepository<Contractor,Integer> {

    Contractor findContractorById(Integer id);

    @Override
    List<Contractor> findAll();
}
