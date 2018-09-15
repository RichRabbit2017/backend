package com.mindgray.cleanwheels.exception;

import com.mindgray.cleanwheels.response.ResponseBody;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GenericException {

    @ExceptionHandler(CleanWheelsException.class)
    public ResponseEntity<ResponseBody> resourceNotFound(CleanWheelsException ex) {
        ResponseBody response = new ResponseBody();
        response.setSuccess(false);
        response.setCode(((CleanWheelsException)ex).getErrorCode());
        response.setMessage(ex.getMessage());

        return new ResponseEntity<ResponseBody>(response, HttpStatus.BAD_REQUEST);
    }
}
