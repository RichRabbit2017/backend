package com.mindgray.cleanwheels.dto;

import java.io.Serializable;

public class RegistrationDto implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private String userId;
	
	public RegistrationDto(String userId) {
		this.userId = userId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	

	
}
