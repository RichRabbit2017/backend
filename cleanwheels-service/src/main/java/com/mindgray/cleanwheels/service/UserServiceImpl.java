package com.mindgray.cleanwheels.service;


import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mindgray.cleanwheels.dto.LoginDto;
import com.mindgray.cleanwheels.dto.RegistrationDto;
import com.mindgray.cleanwheels.dto.ResetPasswordDto;
import com.mindgray.cleanwheels.dto.UserProfileDto;
import com.mindgray.cleanwheels.entity.User;
import com.mindgray.cleanwheels.repository.UserRepository;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public RegistrationDto registerUSer(Integer mobile, String emailId, String password) {
        User user = new User(mobile, emailId, password, RandomStringUtils.random(10, true, true));
        User registerdUser = userRepository.save(user);
        return new RegistrationDto(registerdUser.getUsername());
    }

	@Override
	public LoginDto loginUser(Integer mobile, String emailId, String password) {
		return userRepository.authenticateLogin(mobile, emailId, password);
	}

	@Override
	public ResetPasswordDto resetPassword(Integer mobile, String emailId, String password) {
		User user = userRepository.findUserByMobileOrEmail(mobile, emailId);
		if (user != null) {
			user.setPassword(password);
			user = userRepository.save(user);
			return new ResetPasswordDto(user.getUsername(), null);
		}
		return new ResetPasswordDto(null, null);
	}
	
	@Override
	   public UserProfileDto getProfile(String username) {
	       User user = userRepository.findUserByUsername(username);
	       if(user!=null) {
	          return new UserProfileDto(user.getUsername(),user.getName(),"",user.getMobile(),"",user.getCity(),user.getSociety(),user.getSector(),user.getFlatNo());
	       }else
	       return null;
	   }
	   @Transactional
	   @Override
	   public UserProfileDto updateProfile(UserProfileDto userProfileDto) {
	       User user = userRepository.findUserByUsername(userProfileDto.getUsername());
	       if(user!=null) {
	           user.setCity(userProfileDto.getCity());
	           user.setSector(userProfileDto.getSector());
	           user.setFlatNo(userProfileDto.getFlatNo());
	           user.setMobile(userProfileDto.getMobile());
	           user.setName(userProfileDto.getFirst_name());
	          user = userRepository.save(user);
	           return userProfileDto;
	       }else
	           return null;
	   }
}
