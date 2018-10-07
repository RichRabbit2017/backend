package com.mindgray.cleanwheels.service;

import com.mindgray.cleanwheels.dto.requestDto.LocationRequestDto;
import com.mindgray.cleanwheels.dto.responseDto.AddLocationResponseDto;
import com.mindgray.cleanwheels.entity.Location;

import java.util.List;

public interface LocationService {
    AddLocationResponseDto addLocation(LocationRequestDto locationRequestDto);
    List<Location> getAllLocation();

}
