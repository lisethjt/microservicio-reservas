package com.reservas.infrastructure.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class BookingControllerAdvice {

	@ExceptionHandler(ErrorMessageException.class)
	public ResponseEntity<String> handleEmptyInput(ErrorMessageException emptyInputException) {
		return new ResponseEntity<String>(emptyInputException.getErrorMessage(), emptyInputException.getErrorCode());
	}
}