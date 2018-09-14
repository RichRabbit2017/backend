package com.mindgray.cleanwheels.service;

import com.mindgray.cleanwheels.dto.LoginDto;
import com.mindgray.cleanwheels.dto.RegistrationDto;
import com.mindgray.cleanwheels.dto.ResetPasswordDto;
import com.mindgray.cleanwheels.dto.UserProfileDto;

public interface UserService {

	RegistrationDto registerUSer(Integer mobile, String emailId, String password);

	LoginDto loginUser(Integer mobile, String emailId, String password);

	ResetPasswordDto resetPassword(Integer mobile, String emailId, String password);

	UserProfileDto getProfile(String username);

	UserProfileDto updateProfile(UserProfileDto userProfileDto);

}
