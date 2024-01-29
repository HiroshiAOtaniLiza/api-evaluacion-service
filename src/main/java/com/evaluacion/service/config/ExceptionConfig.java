package com.evaluacion.service.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.evaluacion.service.bean.ErrorResponse;
import com.evaluacion.service.exceptions.ExistException;
import com.evaluacion.service.exceptions.NotExistException;

@ControllerAdvice
public class ExceptionConfig {

	@ExceptionHandler(ExistException.class)
	public ResponseEntity<?> existException(Exception e) {
		return new ResponseEntity<>(
				ErrorResponse.builder().message(e.getMessage()).build(),
				HttpStatus.NOT_ACCEPTABLE);
	}
	
	@ExceptionHandler(NotExistException.class)
	public ResponseEntity<?> notExistException(Exception e) {
		return new ResponseEntity<>(
				ErrorResponse.builder().message(e.getMessage()).build(),
				HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(BadCredentialsException.class)
	public ResponseEntity<?> badCredentialsException(Exception e) {
		return new ResponseEntity<>(
				ErrorResponse.builder().message(e.getMessage()).build(),
				HttpStatus.UNAUTHORIZED);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> exception(Exception e) {
		return new ResponseEntity<>(
				ErrorResponse.builder().message(e.getMessage()).build(),
				HttpStatus.FORBIDDEN);
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<?> illegalArgumentException(Exception e) {
		return new ResponseEntity<>(
				ErrorResponse.builder().message(e.getMessage()).build(),
				HttpStatus.NOT_ACCEPTABLE);
	}
	
}
