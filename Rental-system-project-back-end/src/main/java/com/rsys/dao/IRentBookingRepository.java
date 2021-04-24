package com.rsys.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rsys.pojos.entity.RentBooking;

public interface IRentBookingRepository extends JpaRepository<RentBooking, Integer> {

}
