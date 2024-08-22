package com.example.movie_app.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.Library.dto.BookDto;
import com.te.Library.entity.Book;
import com.te.Library.exception.DataNotFoundException;
import com.te.Library.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepository;

	private Book convertToEntity(BookDto bookDto) {
		Book book = new Book();
		BeanUtils.copyProperties(bookDto, book);
		return book;
	}

	public BookDto convertToDto(Book book) {
		BookDto dto = new BookDto();
		BeanUtils.copyProperties(book, dto);
		return dto;
	}

	@Override
	public BookDto create(BookDto bookDto) {
		Book book = convertToEntity(bookDto);
		Book savedBook = bookRepository.save(book);
		BookDto dto = convertToDto(savedBook);
		return dto;
	}

	@Override
	public List<BookDto> readAll() {
		List<Book> all = bookRepository.findAll();
		List<BookDto> collect = all.stream().map(this::convertToDto).collect(Collectors.toList());
		return collect;
	}

	@Override
	public List<BookDto> findBySearchString(String searchString) {
		List<Book> list = bookRepository.findBySearchString(searchString);
		if (list.size() != 0) {
			List<BookDto> collect = list.stream().map(this::convertToDto).collect(Collectors.toList());
			return collect;
		}else {
			throw new DataNotFoundException("No data found with term: "+searchString);
		}
	}

	@Override
	public BookDto findById(Integer id) {
		Optional<Book> optional = bookRepository.findById(id);
		BookDto convertToDto = convertToDto(optional.get());
		return convertToDto;
	}

}
