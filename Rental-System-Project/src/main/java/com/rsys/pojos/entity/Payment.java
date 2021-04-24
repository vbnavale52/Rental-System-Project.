package com.rsys.pojos.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToOne;

import com.rsys.pojos.enums.PaymentGatway;
import com.rsys.pojos.enums.PaymentStatus;

@Entity
public class Payment extends BaseEntity{
	@Enumerated(EnumType.STRING)
	@Column(length = 20, nullable = false)
	private PaymentGatway paymentGatway;

	private LocalDate paymentDate;

	@Enumerated(EnumType.STRING)
	@Column(length = 20, nullable = false)
	private PaymentStatus paymentStatus;

	@OneToOne(targetEntity = RentBooking.class, mappedBy = "payment")
	private RentBooking rentBooking;

	public Payment() {

	}

	public Payment(PaymentGatway paymentGatway, LocalDate paymentDate, PaymentStatus paymentStatus) {
		super();
		this.paymentGatway = paymentGatway;
		this.paymentDate = paymentDate;
		this.paymentStatus = paymentStatus;
	}

	public PaymentGatway getPaymentGatway() {
		return paymentGatway;
	}

	public void setPaymentGatway(PaymentGatway paymentGatway) {
		this.paymentGatway = paymentGatway;
	}

	public LocalDate getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(LocalDate paymentDate) {
		this.paymentDate = paymentDate;
	}

	public PaymentStatus getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(PaymentStatus paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public RentBooking getRentBooking() {
		return rentBooking;
	}

	public void setRentBooking(RentBooking rentBooking) {
		this.rentBooking = rentBooking;
	}

	@Override
	public String toString() {
		return "Payment [paymentGatway=" + paymentGatway + ", paymentDate=" + paymentDate + ", paymentStatus="
				+ paymentStatus + "]";
	}

}
