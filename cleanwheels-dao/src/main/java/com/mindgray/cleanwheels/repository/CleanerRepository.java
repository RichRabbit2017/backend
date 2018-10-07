package com.mindgray.cleanwheels.repository;

import com.mindgray.cleanwheels.entity.Cleaner;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CleanerRepository extends JpaRepository<Cleaner,Integer> {
    @Override
    Cleaner getOne(Integer integer);

   List<Cleaner> findCleanerByLocationId(int locationId);
}
