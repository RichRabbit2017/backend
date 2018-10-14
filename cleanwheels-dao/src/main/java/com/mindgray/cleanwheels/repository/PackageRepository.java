package com.mindgray.cleanwheels.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindgray.cleanwheels.entity.Package;

@Repository("packageRepository")
public interface PackageRepository extends JpaRepository<Package, Integer>{

}
