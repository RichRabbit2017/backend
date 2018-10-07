package com.mindgray.cleanwheels.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mindgray.cleanwheels.constant.Constant;
import com.mindgray.cleanwheels.constant.CwMessages;
import com.mindgray.cleanwheels.dto.AddVehicleRequestDto;
import com.mindgray.cleanwheels.dto.responseDto.VehicleDetailResponseDto;
import com.mindgray.cleanwheels.response.ResponseBody;
import com.mindgray.cleanwheels.service.VehicleService;

@RestController
@CrossOrigin
public class VehicleController {

	private final Logger logger = LoggerFactory.getLogger(VehicleController.class);
	
	@Autowired
	VehicleService vehicleService;

    @GetMapping(value = "/vehicle")
    public ResponseBody getVehicle(@RequestParam String userId) {
    	ResponseBody responseBody = new ResponseBody(false, CwMessages.FAILED.code(), CwMessages.FAILED.message());
    	
    	VehicleDetailResponseDto vehicleDetailResponseDto = vehicleService.getVehicle(userId);

        if (vehicleDetailResponseDto != null)
            return new ResponseBody(true, CwMessages.SUCCESS.code(), CwMessages.SUCCESS.message(), vehicleDetailResponseDto);
       
        return responseBody;
    }
    
    @PostMapping(value = "/vehicle")
    public ResponseBody addVehicle(@RequestBody AddVehicleRequestDto addVehicleRequestDto) {
    	ResponseBody responseBody = new ResponseBody(false, CwMessages.FAILED.code(), CwMessages.FAILED.message());

    	boolean vehicleAdded= vehicleService.addVehicle(addVehicleRequestDto);

        if (vehicleAdded == true)
            return new ResponseBody(true, CwMessages.SUCCESS.code(), CwMessages.SUCCESS.message(), Constant.VEHICLE_ADDED);
    
        return responseBody;
    }
}
