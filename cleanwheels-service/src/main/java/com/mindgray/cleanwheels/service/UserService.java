package com.mindgray.cleanwheels.service;

import com.mindgray.cleanwheels.dto.LoginDto;
import com.mindgray.cleanwheels.dto.RegistrationDto;
import com.mindgray.cleanwheels.dto.ResetPasswordDto;
import com.mindgray.cleanwheels.dto.UserProfileDto;
import com.mindgray.cleanwheels.dto.requestDto.RegisterRequestDTO;

public interface UserService {

	RegistrationDto registerUSer(RegisterRequestDTO registerRequestDTO) throws Exception;

	LoginDto loginUser(RegisterRequestDTO registerRequestDTO);

	ResetPasswordDto resetPassword(RegisterRequestDTO registerRequestDTO);

	UserProfileDto getProfile(String username);

	UserProfileDto updateProfile(UserProfileDto userProfileDto);

}
