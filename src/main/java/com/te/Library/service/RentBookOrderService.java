package com.te.Library.service;

import com.te.Library.dto.RentBookOrderDto;

public interface RentBookOrderService {

	Integer calculateTotal(RentBookOrderDto dto);

	RentBookOrderDto registerRentBookOrder(RentBookOrderDto dto);

}
