package com.mindgray.cleanwheels.constant;

public enum CwMessages {

	//#Common message and code
	SUCCESS("0000","success"),
	UNAVAILABLE("0001","No result found"),
	UNAUTHORIZED("0002","Authentication failed"),
	FAILED("0003","failed"),
	

	
	UNKNOWN("9999","");

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
