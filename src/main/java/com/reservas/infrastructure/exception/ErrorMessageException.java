package com.reservas.infrastructure.exception;

import org.springframework.http.HttpStatus;

public class ErrorMessageException extends RuntimeException {

	private static final long serialVersionUID = -4480558612713414226L;

	private HttpStatus errorCode;
	private String errorMessage;

	public ErrorMessageException() {

	}

	public ErrorMessageException(HttpStatus errorCode, String errorMessage) {
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}

	public HttpStatus getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(HttpStatus errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}