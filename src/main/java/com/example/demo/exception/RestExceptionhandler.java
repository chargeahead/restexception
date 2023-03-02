package com.example.demo.exception;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.demo.controller.CustomException;

@RestControllerAdvice
public class RestExceptionhandler extends ResponseEntityExceptionHandler{
	@ExceptionHandler(value= {IllegalArgumentException.class})
	@ResponseStatus(HttpStatus.FORBIDDEN)
	protected ErrorResponse errorHandler(IllegalArgumentException ex, WebRequest req){
		ErrorResponse err = new ErrorResponse();
		err.setMessage(ex.getMessage());
		err.setErrorCode("errorCodeIA");
		err.setTime(new java.util.Date());
		return err;
	}
	@ExceptionHandler(value= {IOException.class})
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	protected ErrorResponse errorHandlerIO(IOException ex, WebRequest req){
		ErrorResponse err = new ErrorResponse();
		err.setMessage(ex.getMessage());
		err.setErrorCode("errorCodeIO");
		err.setTime(new java.util.Date());
		return err;
	}
	@ExceptionHandler(value= {CustomException.class})
	@ResponseStatus(HttpStatus.NOT_FOUND)
	protected ErrorResponse errorHandlerCustom(CustomException ex, WebRequest req){
		ErrorResponse err = new ErrorResponse();
		err.setMessage(ex.getMessage());
		err.setErrorCode("errorCodeCustom");
		err.setTime(new java.util.Date());
		return err;
	}
	@ExceptionHandler(value= {Exception.class})
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	protected ErrorResponse errorHandlerExc(Exception ex, WebRequest req){
		ErrorResponse err = new ErrorResponse();
		err.setMessage(ex.getMessage());
		err.setErrorCode("errorCodeException");
		err.setTime(new java.util.Date());
		return err;
	}

}
