package com.mindgray.cleanwheels.service;

import com.mindgray.cleanwheels.dto.LocationResponseDto;
import com.mindgray.cleanwheels.dto.requestDto.LocationRequestDto;
import com.mindgray.cleanwheels.entity.Location;

import java.util.List;

public interface LocationService {
    boolean addLocation(LocationRequestDto locationRequestDto);
    List<Location> getAllLocation();

}
