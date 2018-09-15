package com.mindgray.cleanwheels.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Not found")
public class CleanWheelsException extends RuntimeException {
	private final Logger logger = LoggerFactory.getLogger(CleanWheelsException.class.getSimpleName());
	private static final long serialVersionUID = 2542889652563715900L;
	String errorCode;

	public CleanWheelsException(String msg) {
		super(msg);
	}

	public CleanWheelsException(String errorMsg, String errorCode) {
		super(errorMsg);
		this.errorCode = errorCode;
		logger.error("errorCode :"+errorCode +" errorMessage :"+errorMsg);
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
}
