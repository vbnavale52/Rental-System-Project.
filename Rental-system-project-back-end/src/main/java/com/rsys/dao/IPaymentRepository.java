package com.rsys.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rsys.pojos.entity.Payment;

public interface IPaymentRepository extends JpaRepository<Payment, Integer> {

}
