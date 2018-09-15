package com.mindgray.cleanwheels.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"success","code", "message", "response"})
public class ResponseBody {

	private Boolean success;
	private String code;
	private String message;
	private Object response;
	
	public ResponseBody(){
		
	}

	public ResponseBody(Boolean success, String code, String message) {
		this.success = success;
		this.code = code;
		this.message = message;
	}

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	

	public Object getResponse() {
		return response;
	}

	public void setResponse(Object response) {
		this.response = response;
	}

	public ResponseBody(Boolean success, String code, String message, Object response) {
		super();
		this.success = success;
		this.code = code;
		this.message = message;
		this.response = response;
	}
}
