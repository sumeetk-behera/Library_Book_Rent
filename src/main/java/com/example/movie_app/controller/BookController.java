package com.example.movie_app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.movie_app.dto.BookDto;
import com.example.movie_app.service.BookService;

@RestController
public class BookController {

	@Autowired
	private BookService bookService;

	@PostMapping("/registerBook")
	public ResponseEntity<ResponseDto> createBook(@RequestBody BookDto dto) {

		BookDto bookDto = bookService.create(dto);
		return ResponseEntity.ok(new ResponseDto(false, "Book registered succesfully", bookDto));
	}

	@GetMapping("/getAllBook")
	public ResponseEntity<ResponseDto> getAll() {

		List<BookDto> all = bookService.readAll();
		return ResponseEntity.ok(new ResponseDto(false, "All Books fetched succesfully", all));
	}

	@GetMapping("/findByName/{search}")
	public ResponseEntity<ResponseDto> findByName(@PathVariable String search) {

		List<BookDto> bySearchString = bookService.findBySearchString(search);
		return ResponseEntity.ok(new ResponseDto(false, "Search List fetched succesfully", bySearchString));
	}
	
	@GetMapping("/findBy/{id}")
	public ResponseEntity<ResponseDto> findById(@PathVariable Integer id) {
		
		 BookDto byId = bookService.findById(id);
		return ResponseEntity.ok(new ResponseDto(false, "Search List fetched succesfully", byId));
	}

}
