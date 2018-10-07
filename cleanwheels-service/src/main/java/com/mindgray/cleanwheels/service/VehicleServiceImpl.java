package com.mindgray.cleanwheels.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mindgray.cleanwheels.dto.AddVehicleRequestDto;
import com.mindgray.cleanwheels.dto.responseDto.VehicleDetailResponseDto;
import com.mindgray.cleanwheels.entity.User;
import com.mindgray.cleanwheels.entity.Vehicle;
import com.mindgray.cleanwheels.repository.UserRepository;
import com.mindgray.cleanwheels.repository.VehicleRepository;

@Repository("vehicleService")
public class VehicleServiceImpl implements VehicleService{

	@Autowired
	VehicleRepository vehicleRepository; 
	
	@Autowired
	UserRepository userRepository;
	
	@Override
	public VehicleDetailResponseDto getVehicle(String userId) {
			return vehicleRepository.getVehicle(userId);
	}

	@Override
	public boolean addVehicle(AddVehicleRequestDto addVehicleRequestDto) {
		User user = userRepository.getOne(addVehicleRequestDto.getUserId());
		if (user != null) {
			Vehicle vehicle = new Vehicle(
					addVehicleRequestDto.getParkingNo(), 
					addVehicleRequestDto.getVechileNo(),
					addVehicleRequestDto.getVehicleCategory(),
					addVehicleRequestDto.getVehicleType(),
					user);
			vehicleRepository.save(vehicle);
			return true;
		}		
		return false;
	}

}
