package com.evaluacion.service.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.evaluacion.service.bean.ErrorResponse;

@ControllerAdvice
public class ExceptionConfig {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> exception(Exception e) {
		return new ResponseEntity<>(
				ErrorResponse.builder().message(e.getMessage()).build(),
				HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
