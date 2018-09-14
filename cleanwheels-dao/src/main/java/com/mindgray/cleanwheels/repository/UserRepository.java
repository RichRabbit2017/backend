package com.mindgray.cleanwheels.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mindgray.cleanwheels.dto.LoginDto;
import com.mindgray.cleanwheels.entity.User;



@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query(value = "select new com.mindgray.cleanwheels.dto.LoginDto("
            + " u.username) "
            + " from User u "
            + " where u.password=:password "
            + " and (u.mobile=:mobile OR u.email=:email) ")
    LoginDto authenticateLogin(
            @Param("mobile")Integer mobile,
            @Param("email")String email,
            @Param("password")String password);
    
    User findUserByMobileOrEmail(Integer mobile, String email);
    
    User findUserByUsername(String username);

}
