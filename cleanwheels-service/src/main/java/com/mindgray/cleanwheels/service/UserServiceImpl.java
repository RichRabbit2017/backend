package com.mindgray.cleanwheels.service;


import com.mindgray.cleanwheels.dto.requestDto.RegisterRequestDTO;
import com.mindgray.cleanwheels.exception.CleanWheelsException;
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
    public RegistrationDto registerUSer(RegisterRequestDTO registerRequestDTO) throws Exception {
			User user = new User(registerRequestDTO.getMobile(), registerRequestDTO.getEmail(), registerRequestDTO.getPassword(), RandomStringUtils.random(4, true, true));
			User registerdUser = userRepository.save(user);
			return new RegistrationDto(registerdUser.getUser_id());

    }


	@Override
	public LoginDto loginUser(RegisterRequestDTO registerRequestDTO) {
		return userRepository.authenticateLogin(registerRequestDTO.getMobile(), registerRequestDTO.getEmail(), registerRequestDTO.getPassword());
	}

	@Override
	public ResetPasswordDto resetPassword(RegisterRequestDTO registerRequestDTO) {
		User user = userRepository.findUserByMobileOrEmail(registerRequestDTO.getMobile(), registerRequestDTO.getEmail());
		if (user != null && registerRequestDTO.getPassword()!=null && !registerRequestDTO.getPassword().isEmpty()) {
			user.setPassword(registerRequestDTO.getPassword());
			user = userRepository.save(user);
			return new ResetPasswordDto(user.getUser_id(), null);
		}
		return new ResetPasswordDto(null, null);
	}
	
	@Override
	   public UserProfileDto getProfile(String username) {
	       User user = userRepository.findUserByUserId(username);
	       if(user!=null) {
	          return new UserProfileDto(user.getUser_id(),user.getF_name(),"",user.getMobile(),"",user.getCity(),user.getSociety(),user.getSector(),user.getFlatNo());
	       }else
	       return null;
	   }
	   @Transactional
	   @Override
	   public UserProfileDto updateProfile(UserProfileDto userProfileDto) {
	       User user = userRepository.findUserByUserId(userProfileDto.getUsername());
	       if(user!=null) {
	           user.setCity(userProfileDto.getCity());
	           user.setSector(userProfileDto.getSector());
	           user.setFlatNo(userProfileDto.getFlatNo());
	           user.setMobile(userProfileDto.getMobile());
	           user.setF_name(userProfileDto.getFirst_name());
	          user = userRepository.save(user);
	           return userProfileDto;
	       }else
	           return null;
	   }
}
