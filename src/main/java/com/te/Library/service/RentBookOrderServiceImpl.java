package com.te.Library.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.Library.dto.BookDto;
import com.te.Library.dto.RentBookOrderDto;
import com.te.Library.entity.Book;
import com.te.Library.entity.RentBookOrder;
import com.te.Library.exception.BookNotAvailableException;
import com.te.Library.exception.DataNotFoundException;
import com.te.Library.repository.BookRepository;
import com.te.Library.repository.RentBookOrderRepository;

@Service
public class RentBookOrderServiceImpl implements RentBookOrderService {

	@Autowired
	private RentBookOrderRepository repository;

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private BookServiceImpl bookServiceImpl;

	@Override
	public Integer calculateTotal(RentBookOrderDto dto) {
		Book book = bookRepository.findById(dto.getBookId())
				.orElseThrow(() -> new DataNotFoundException("No book with id: " + dto.getBookId()));
		Integer totalAmount = book.getPrice_per_hour() * dto.getRentalHours();
		return totalAmount;
	}

	@Override
	public RentBookOrderDto registerRentBookOrder(RentBookOrderDto dto) {
		Book book = bookRepository.findById(dto.getBookId())
				.orElseThrow(() -> new DataNotFoundException("No book with id: " + dto.getBookId()));

		BookDto bookDto = bookServiceImpl.convertToDto(book);
		dto.setBookDto(bookDto);

		if (!book.isRentedOrNot()) {
			Integer calculateTotal = calculateTotal(dto);
			dto.setTotalAmount(calculateTotal);

			book.setRentedOrNot(true);
			bookRepository.save(book);

			RentBookOrder rentBookOrder = new RentBookOrder();
			BeanUtils.copyProperties(dto, rentBookOrder);
			rentBookOrder.setBook(book);
			rentBookOrder.setRentedHour(dto.getRentalHours());
			RentBookOrder savedRentBookOrder = repository.save(rentBookOrder);

			BeanUtils.copyProperties(savedRentBookOrder, dto);
			return dto;
		} else {
			throw new BookNotAvailableException("Currently " + dto.getBookDto().getBookName() + " is not available");
		}
	}

}
