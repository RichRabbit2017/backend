package com.mindgray.cleanwheels.dto.responseDto;

import java.io.Serializable;

public class VehicleDetailResponseDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String vechileNo;

	private String parkingNo;
	
	private String vehicleType;
	
	private String vehicleCategory;
	
	public VehicleDetailResponseDto() {
	}

	public VehicleDetailResponseDto(String vechileNo, String parkingNo,
			String vehicleType, String vehicleCategory) {
		super();
		this.vechileNo = vechileNo;
		this.parkingNo = parkingNo;
		this.vehicleType = vehicleType;
		this.vehicleCategory = vehicleCategory;
	}

	public String getVechileNo() {
		return vechileNo;
	}

	public void setVechileNo(String vechileNo) {
		this.vechileNo = vechileNo;
	}

	public String getParkingNo() {
		return parkingNo;
	}

	public void setParkingNo(String parkingNo) {
		this.parkingNo = parkingNo;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public String getVehicleCategory() {
		return vehicleCategory;
	}

	public void setVehicleCategory(String vehicleCategory) {
		this.vehicleCategory = vehicleCategory;
	}

	@Override
	public String toString() {
		return "VehicleDetailResponseDto [vechileNo=" + vechileNo
				+ ", parkingNo=" + parkingNo + ", vehicleType=" + vehicleType
				+ ", vehicleCategory=" + vehicleCategory + "]";
	}

	
	
}
