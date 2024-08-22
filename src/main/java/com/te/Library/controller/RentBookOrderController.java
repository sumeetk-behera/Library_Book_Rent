package com.te.Library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.te.Library.dto.RentBookOrderDto;
import com.te.Library.dto.ResponseDto;
import com.te.Library.service.RentBookOrderService;

@RestController
public class RentBookOrderController {

	@Autowired
	private RentBookOrderService bookOrderService;

	@PostMapping("/calculateTotal")
	public ResponseEntity<ResponseDto> calculateTotal(@RequestBody RentBookOrderDto dto) {

		Integer calculateTotal = bookOrderService.calculateTotal(dto);
		return ResponseEntity.ok(new ResponseDto(false, "Total Amount Below", calculateTotal));
	}

	@PostMapping("/registerRentBookOrder")
	public ResponseEntity<ResponseDto> registerRentBookOrder(@RequestBody RentBookOrderDto dto) {

		RentBookOrderDto dto2 = bookOrderService.registerRentBookOrder(dto);
		return ResponseEntity.ok(new ResponseDto(false,
				"You have successfully rented " + dto.getBookDto().getBookName() + " book", dto2));
	}
}
