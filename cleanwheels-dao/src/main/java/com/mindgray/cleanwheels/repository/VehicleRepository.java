package com.mindgray.cleanwheels.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mindgray.cleanwheels.dto.responseDto.VehicleDetailResponseDto;
import com.mindgray.cleanwheels.entity.Vehicle;

@Repository("vehicleRepository")
public interface VehicleRepository extends JpaRepository<Vehicle, Integer>{

	@Query(value=" select  new com.mindgray.cleanwheels.dto.responseDto.VehicleDetailResponseDto(v.num, v.parkingNo, v.type, v.category )"
			+ " from Vehicle v"
			+ " left outer join v.user u "
			+ " where u.userId=:userId ")
	VehicleDetailResponseDto getVehicle(@Param("userId")String userId);

}
