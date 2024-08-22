package com.example.movie_app.service;

import java.util.List;

import com.te.Library.dto.BookDto;

public interface BookService {

	BookDto create(BookDto bookDto);

	List<BookDto> readAll();

	List<BookDto> findBySearchString(String searchString);

	BookDto findById(Integer id);
}
