package com.mindgray.cleanwheels.service;

import com.mindgray.cleanwheels.dto.LoginDto;
import com.mindgray.cleanwheels.dto.RegistrationDto;
import com.mindgray.cleanwheels.dto.ResetPasswordDto;
import com.mindgray.cleanwheels.dto.UserProfileDto;
import com.mindgray.cleanwheels.dto.requestDto.ProfileRequestDTO;
import com.mindgray.cleanwheels.dto.requestDto.RegisterRequestDTO;
import com.mindgray.cleanwheels.dto.requestDto.UpdateProfileRequestDTO;

public interface UserService {

	RegistrationDto registerUSer(RegisterRequestDTO registerRequestDTO) throws Exception;

	LoginDto loginUser(RegisterRequestDTO registerRequestDTO) throws Exception;

	ResetPasswordDto resetPassword(RegisterRequestDTO registerRequestDTO) throws Exception;

	UserProfileDto getProfile(ProfileRequestDTO profileRequestDTO) throws Exception;

	UpdateProfileRequestDTO updateProfile(UpdateProfileRequestDTO updateProfileRequestDTO) throws Exception;

}
