package com.mindgray.cleanwheels.constant;

public enum CwMessages {

	//#Common message and code
	SUCCESS("0000","success"),

	UNAVAILABLE("0001","No result found"),
	UNAUTHORIZED("0002","Authentication failed"),
	REGISTRATION_FAILED("4001","Registration failed"),
	FAILED("0003","failed"),
	

	
	UNKNOWN("1000","");

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
