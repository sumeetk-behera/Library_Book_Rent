package com.te.Library.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.te.Library.entity.RentBookOrder;

public interface RentBookOrderRepository extends JpaRepository<RentBookOrder, Integer> {

}
