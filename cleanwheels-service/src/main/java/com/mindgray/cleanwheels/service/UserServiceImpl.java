package com.mindgray.cleanwheels.service;


import com.mindgray.cleanwheels.dto.requestDto.ProfileRequestDTO;
import com.mindgray.cleanwheels.dto.requestDto.RegisterRequestDTO;
import com.mindgray.cleanwheels.dto.requestDto.UpdateProfileRequestDTO;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mindgray.cleanwheels.dto.responseDto.LoginDto;
import com.mindgray.cleanwheels.dto.responseDto.RegistrationDto;
import com.mindgray.cleanwheels.dto.responseDto.ResetPasswordDto;
import com.mindgray.cleanwheels.dto.responseDto.UserProfileDto;
import com.mindgray.cleanwheels.entity.User;
import com.mindgray.cleanwheels.repository.UserRepository;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public RegistrationDto registerUSer(RegisterRequestDTO registerRequestDTO) {
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
	   public UserProfileDto getProfile(ProfileRequestDTO profileRequestDTO) {
	       User user = userRepository.getOne(profileRequestDTO.getUserId());
	       if(user!=null) {
	          return new UserProfileDto(user.getUser_id(),user.getF_name(),"",user.getMobile(),"",user.getCity(),user.getSociety(),user.getSector(),user.getFlatNo());
	       }else
	       return null;
	   }
	   @Transactional
	   @Override
	   public UpdateProfileRequestDTO updateProfile(UpdateProfileRequestDTO updateProfileRequestDTO) {
	       User user = userRepository.getOne(updateProfileRequestDTO.getUserId());
	       if(user!=null) {
	           user.setCity(updateProfileRequestDTO.getCity());
	           user.setSector(updateProfileRequestDTO.getSector());
			   user.setSociety(updateProfileRequestDTO.getSociety());
	           user.setFlatNo(updateProfileRequestDTO.getFlatNo());
	           user.setF_name(updateProfileRequestDTO.getFirst_name());
			   user.setL_name(updateProfileRequestDTO.getLast_name());
			   user.setEmail(updateProfileRequestDTO.getEmail());
	          user = userRepository.save(user);
	           return updateProfileRequestDTO;
	       }else
	           return null;
	   }
}
