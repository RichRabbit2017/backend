package com.mindgray.cleanwheels.controller;

import com.mindgray.cleanwheels.dto.requestDto.RegisterRequestDTO;
import com.mindgray.cleanwheels.exception.CleanWheelsException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mindgray.cleanwheels.constant.CwMessages;
import com.mindgray.cleanwheels.dto.LoginDto;
import com.mindgray.cleanwheels.dto.RegistrationDto;
import com.mindgray.cleanwheels.dto.ResetPasswordDto;
import com.mindgray.cleanwheels.dto.UserProfileDto;
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
    	LoginDto loginDto = userService.loginUser(registerRequestDTO);
        if (loginDto != null && loginDto.getUserId() != null)
            return new ResponseBody(true, CwMessages.SUCCESS.code(), CwMessages.SUCCESS.message(), loginDto);
        else
            return new ResponseBody(false, CwMessages.FAILED.code(), CwMessages.FAILED.message());
    }
    
    @PostMapping(value = "/resetPassword")
    public ResponseBody resetPassword(@RequestBody RegisterRequestDTO registerRequestDTO) {
    	ResetPasswordDto loginDto = userService.resetPassword(registerRequestDTO);
        if (loginDto != null && loginDto.getUserId() != null)
            return new ResponseBody(true, CwMessages.SUCCESS.code(), CwMessages.SUCCESS.message(), loginDto);
        else
            return new ResponseBody(false, CwMessages.FAILED.code(), CwMessages.FAILED.message());
    }
    
    @PostMapping(value = "/getProfile",consumes={MediaType.APPLICATION_JSON_VALUE})
    public ResponseBody getProfile(@RequestParam(required = true) String username) {
      UserProfileDto user = userService.getProfile(username);
           if(user!=null)
               return new ResponseBody(true, CwMessages.SUCCESS.code(), CwMessages.SUCCESS.message(), user);
            else
               return new ResponseBody(false, CwMessages.FAILED.code(), CwMessages.FAILED.message());

    }

    @PostMapping(value = {"/updateProfile"},consumes={MediaType.APPLICATION_JSON_VALUE})
    public ResponseBody getProfile(@RequestBody UserProfileDto userProfileDto) {
    	UserProfileDto user = userService.updateProfile(userProfileDto);
        if(user!=null)
            return new ResponseBody(true, CwMessages.SUCCESS.code(), CwMessages.SUCCESS.message(), user);
        else
            return new ResponseBody(false, CwMessages.FAILED.code(), CwMessages.FAILED.message());

    }
}
