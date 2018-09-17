package com.mindgray.cleanwheels.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mindgray.cleanwheels.constant.CwMessages;
import com.mindgray.cleanwheels.dto.LoginDto;
import com.mindgray.cleanwheels.dto.RegistrationDto;
import com.mindgray.cleanwheels.dto.ResetPasswordDto;
import com.mindgray.cleanwheels.dto.UserProfileDto;
import com.mindgray.cleanwheels.dto.requestDto.ProfileRequestDTO;
import com.mindgray.cleanwheels.dto.requestDto.RegisterRequestDTO;
import com.mindgray.cleanwheels.dto.requestDto.UpdateProfileRequestDTO;
import com.mindgray.cleanwheels.exception.CleanWheelsException;
import com.mindgray.cleanwheels.response.ResponseBody;
import com.mindgray.cleanwheels.service.UserService;

@RestController
@CrossOrigin
public class UserController {
    private final Logger logger = LoggerFactory.getLogger(UserController.class.getSimpleName());

    @Autowired
    UserService userService;

    @PostMapping(value = "/register")
    public ResponseBody register(@RequestBody RegisterRequestDTO registerRequestDTO) {
        try {
            RegistrationDto registrationDto = userService.registerUSer(registerRequestDTO);


        if (registrationDto.getUserId() != null)
            return new ResponseBody(true, CwMessages.SUCCESS.code(), CwMessages.SUCCESS.message(), registrationDto);
        else
            return new ResponseBody(false, CwMessages.FAILED.code(), CwMessages.FAILED.message());
        }catch (Exception e)
        {
            logger.error(e.getMessage());
            throw new CleanWheelsException(CwMessages.REGISTRATION_FAILED.message(),CwMessages.REGISTRATION_FAILED.code());
        }
    }
    
    @PostMapping(value = "/login")
    public ResponseBody login(@RequestBody RegisterRequestDTO registerRequestDTO) {
        try {
            LoginDto loginDto = userService.loginUser(registerRequestDTO);
            if (loginDto != null && loginDto.getUserId() != null)
                return new ResponseBody(true, CwMessages.SUCCESS.code(), CwMessages.SUCCESS.message(), loginDto);
            else
                return new ResponseBody(false, CwMessages.FAILED.code(), CwMessages.FAILED.message());
        }catch (Exception e)
        {
            logger.error(e.getMessage());
            throw new CleanWheelsException(e.getMessage(),CwMessages.UNKNOWN.code());
        }
    }
    
    @PostMapping(value = "/resetPassword")
    public ResponseBody resetPassword(@RequestBody RegisterRequestDTO registerRequestDTO) {
        try {
            ResetPasswordDto loginDto = userService.resetPassword(registerRequestDTO);
            if (loginDto != null && loginDto.getUserId() != null)
                return new ResponseBody(true, CwMessages.SUCCESS.code(), CwMessages.SUCCESS.message(), loginDto);
            else
                return new ResponseBody(false, CwMessages.FAILED.code(), CwMessages.FAILED.message());
        }catch (Exception e)
        {
            logger.error(e.getMessage());
            throw new CleanWheelsException(e.getMessage(),CwMessages.UNKNOWN.code());
        }
    }
    
    @PostMapping(value = "/getProfile",consumes={MediaType.APPLICATION_JSON_VALUE})
    public ResponseBody getProfile(@RequestBody ProfileRequestDTO profileRequestDTO) {
        try {
            UserProfileDto user = userService.getProfile(profileRequestDTO);
            if (user != null)
                return new ResponseBody(true, CwMessages.SUCCESS.code(), CwMessages.SUCCESS.message(), user);
            else
                return new ResponseBody(false, CwMessages.FAILED.code(), CwMessages.FAILED.message());
        }catch (Exception e)
        {
            logger.error(e.getMessage());
            throw new CleanWheelsException(e.getMessage(),CwMessages.UNKNOWN.code());
        }

    }

    @PostMapping(value = {"/updateProfile"},consumes={MediaType.APPLICATION_JSON_VALUE})
    public ResponseBody getProfile(@RequestBody UpdateProfileRequestDTO updateProfileRequestDTO) {
        try {
            UpdateProfileRequestDTO user = userService.updateProfile(updateProfileRequestDTO);
            if (user != null)
                return new ResponseBody(true, CwMessages.SUCCESS.code(), CwMessages.SUCCESS.message(), user);
            else
                return new ResponseBody(false, CwMessages.FAILED.code(), CwMessages.FAILED.message());
        }catch (Exception e)
        {
            logger.error(e.getMessage());
            throw new CleanWheelsException(e.getMessage(),CwMessages.UNKNOWN.code());
        }

    }
}
