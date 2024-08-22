package com.example.movie_app.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.te.Library.dto.ResponseDto;
import com.te.Library.exception.BookNotAvailableException;
import com.te.Library.exception.DataNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(DataNotFoundException.class)
	public ResponseEntity<ResponseDto> dataNotFound(DataNotFoundException e){
		return ResponseEntity.badRequest().body(new ResponseDto(true,e.getMessage() , null));
	}
	
	@ExceptionHandler(BookNotAvailableException.class)
	public ResponseEntity<ResponseDto> bookNotFound(BookNotAvailableException e){
		return ResponseEntity.badRequest().body(new ResponseDto(true,e.getMessage() , null));
	}
}
