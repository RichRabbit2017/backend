package com.mindgray.cleanwheels.service;

import com.mindgray.cleanwheels.dto.responseDto.LoginDto;
import com.mindgray.cleanwheels.dto.responseDto.RegistrationDto;
import com.mindgray.cleanwheels.dto.responseDto.ResetPasswordDto;
import com.mindgray.cleanwheels.dto.responseDto.UserProfileDto;
import com.mindgray.cleanwheels.dto.requestDto.ProfileRequestDTO;
import com.mindgray.cleanwheels.dto.requestDto.RegisterRequestDTO;
import com.mindgray.cleanwheels.dto.requestDto.UpdateProfileRequestDTO;

public interface UserService {

	RegistrationDto registerUSer(RegisterRequestDTO registerRequestDTO);

	LoginDto loginUser(RegisterRequestDTO registerRequestDTO);

	ResetPasswordDto resetPassword(RegisterRequestDTO registerRequestDTO);

	UserProfileDto getProfile(ProfileRequestDTO profileRequestDTO);

	UpdateProfileRequestDTO updateProfile(UpdateProfileRequestDTO updateProfileRequestDTO);

}
