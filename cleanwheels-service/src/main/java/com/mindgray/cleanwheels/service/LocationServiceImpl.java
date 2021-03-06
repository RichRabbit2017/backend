package com.mindgray.cleanwheels.service;

import com.mindgray.cleanwheels.dto.requestDto.LocationRequestDto;
import com.mindgray.cleanwheels.dto.responseDto.AddLocationResponseDto;
import com.mindgray.cleanwheels.entity.Location;
import com.mindgray.cleanwheels.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("LocationService")
public class LocationServiceImpl implements LocationService {

    @Autowired
    LocationRepository locationRepository;

    @Override
    public AddLocationResponseDto addLocation(LocationRequestDto locationRequestDto) {
        Location location = locationRepository.save(new Location(locationRequestDto.getCity(), locationRequestDto.getSociety()));
        if (location != null)

            return new AddLocationResponseDto(location.getId());
        else
            return null;
    }

    @Override
    public List<Location> getAllLocation() {
        return locationRepository.findAll();
    }
}
