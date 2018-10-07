package com.mindgray.cleanwheels.controller;

import com.mindgray.cleanwheels.constant.CwMessages;
import com.mindgray.cleanwheels.dto.requestDto.LocationRequestDto;
import com.mindgray.cleanwheels.dto.requestDto.RegisterRequestDTO;
import com.mindgray.cleanwheels.dto.responseDto.AddLocationResponseDto;
import com.mindgray.cleanwheels.entity.Location;
import com.mindgray.cleanwheels.exception.CleanWheelsException;
import com.mindgray.cleanwheels.repository.LocationRepository;
import com.mindgray.cleanwheels.response.ResponseBody;
import com.mindgray.cleanwheels.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class LocationController {

    @Autowired
    LocationService locationService;

    @PostMapping(value = "/addLocation")
    public ResponseBody addLocation(@RequestBody LocationRequestDto locationRequestDto) {
        try {
            AddLocationResponseDto isLocationAdded = locationService.addLocation(locationRequestDto);

            if (isLocationAdded!=null)
                return new ResponseBody(true, CwMessages.SUCCESS.code(), CwMessages.SUCCESS.message(), isLocationAdded);
            else
                return new ResponseBody(false, CwMessages.FAILED.code(), CwMessages.FAILED.message());

        } catch (Exception e) {
            throw new CleanWheelsException(e.getMessage(), CwMessages.UNKNOWN.code());
        }

    }

    @GetMapping(value = "/getLocation")
    public ResponseBody getLocation() {
        try {
            List<Location> locationList = locationService.getAllLocation();

            if (locationList != null)
                return new ResponseBody(true, CwMessages.SUCCESS.code(), CwMessages.SUCCESS.message(), locationList);
            else
                return new ResponseBody(false, CwMessages.FAILED.code(), CwMessages.FAILED.message());

        } catch (Exception e) {
            throw new CleanWheelsException(e.getMessage(), CwMessages.UNKNOWN.code());
        }
    }


}
