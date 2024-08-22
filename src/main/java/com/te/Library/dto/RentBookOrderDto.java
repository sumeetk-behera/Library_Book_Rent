package com.te.Library.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RentBookOrderDto {

	private Integer id;
	
	private Integer rentalHours;
	private Integer bookId;
	
	private Integer totalAmount;
	
	private BookDto bookDto;
	
	
	
}
