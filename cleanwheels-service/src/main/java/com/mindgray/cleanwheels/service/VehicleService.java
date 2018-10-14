package com.mindgray.cleanwheels.service;

import com.mindgray.cleanwheels.dto.AddVehicleRequestDto;
import com.mindgray.cleanwheels.dto.BookServiceRequestDto;
import com.mindgray.cleanwheels.dto.responseDto.VehicleDetailResponseDto;

public interface VehicleService {

	VehicleDetailResponseDto getVehicle(String userId);

	boolean addVehicle(AddVehicleRequestDto addVehicleRequestDto);

	boolean bookService(BookServiceRequestDto bookServiceRequestDto);

}
