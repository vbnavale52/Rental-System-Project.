package com.rsys.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rsys.pojos.entity.BookingDetail;

public interface IBookingDetailRepository extends JpaRepository<BookingDetail, Integer> {

}
