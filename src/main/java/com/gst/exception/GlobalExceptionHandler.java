package com.gst.exception;

import com.gst.common.ApiResponse;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<ApiResponse<Object>> handleNoSuchElement(NoSuchElementException e) {

		ApiResponse<Object> response = new ApiResponse<>("FAILURE", e.getMessage(), null);

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
	}

	@ExceptionHandler(InvalidInputException.class)
	public ResponseEntity<ApiResponse<Object>> handleInvalidInput(InvalidInputException e) {

		ApiResponse<Object> response = new ApiResponse<>("FAILURE", e.getMessage(), null);

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
	}

	@ExceptionHandler(EmptyResultDataAccessException.class)
	public ResponseEntity<ApiResponse<Object>> handleEmptyResult(EmptyResultDataAccessException e) {

		ApiResponse<Object> response = new ApiResponse<>("FAILURE", "Resource not found", null);

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
	}

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponse<Object>> handleResourceNotFound(ResourceNotFoundException e) {

		ApiResponse<Object> response = new ApiResponse<>("FAILURE", e.getMessage(), null);

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ApiResponse<Object>> handleGenericException(Exception e) {

		ApiResponse<Object> response = new ApiResponse<>("FAILURE", "Internal server error", null);

		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
	}
}
