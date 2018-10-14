package com.mindgray.cleanwheels.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mindgray.cleanwheels.constant.CwMessages;
import com.mindgray.cleanwheels.dto.requestDto.LocationRequestDto;
import com.mindgray.cleanwheels.dto.responseDto.AddLocationResponseDto;
import com.mindgray.cleanwheels.entity.Location;
import com.mindgray.cleanwheels.exception.CWException;
import com.mindgray.cleanwheels.response.ResponseBody;
import com.mindgray.cleanwheels.service.LocationService;

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
            throw new CWException(e.getMessage(), CwMessages.UNKNOWN.code());
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
            throw new CWException(e.getMessage(), CwMessages.UNKNOWN.code());
        }
    }


}
