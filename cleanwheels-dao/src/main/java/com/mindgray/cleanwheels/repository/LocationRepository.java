package com.mindgray.cleanwheels.repository;

import com.mindgray.cleanwheels.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LocationRepository extends JpaRepository<Location, Integer> {

    @Override
    List<Location> findAll();

    @Override
    Location getOne(Integer integer);

}
