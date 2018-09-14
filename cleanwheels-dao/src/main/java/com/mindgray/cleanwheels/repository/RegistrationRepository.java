package com.mindgray.cleanwheels.repository;

import com.mindgray.cleanwheels.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistrationRepository extends JpaRepository<User,Integer> {
}
