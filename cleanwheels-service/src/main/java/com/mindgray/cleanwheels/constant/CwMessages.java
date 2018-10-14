package com.mindgray.cleanwheels.constant;

public enum CwMessages {

	//#Common message and code
	UNKNOWN("1000",""), 
	SUCCESS("0000","success"),
	UNAVAILABLE("0001","No result found"),
	UNAUTHORIZED("0002","Authentication failed"),
	REGISTRATION_FAILED("4001","Registration failed"),
	FAILED("0003","failed"),
	
	
	VEHICLE_UNREGISTERED("4021" ,"Unregistered vehicle"),
	VEHICLE_ADDED("4022", "vehicle added successfully"),
	
	
	PACKAGE_INVALID("4041", "Invalid package"),
	PACKAGE_EXPIRED("4042", "package expired"),
	
	VOUCHER_INVALID("4061" ,"Invalid voucher"),
	VOUCHER_REEDEMED("4062" ,"Voucher alredy redeemed"), 
	VOUCHER_EXPIRED("4063", "Voucher expired ");

	private String code;
	private String message;

	CwMessages(String code, String message) {
		this.code = code;
		this.message = message;
	}

	public String message() {
		return message;
	}

	public String code() {
		return code;
	}

}
