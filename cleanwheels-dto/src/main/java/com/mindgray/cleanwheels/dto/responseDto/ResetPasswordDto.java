package com.mindgray.cleanwheels.dto.responseDto;

import java.io.Serializable;

public class ResetPasswordDto implements Serializable{

	private static final long serialVersionUID = 1L;

	public ResetPasswordDto() {

	}

	public ResetPasswordDto(String userId, String jwt) {
		this.userId = userId;
		this.jwt = jwt;
	}

	private String userId;

	private String jwt;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getJwt() {
		return jwt;
	}

	public void setJwt(String jwt) {
		this.jwt = jwt;
	}
}
