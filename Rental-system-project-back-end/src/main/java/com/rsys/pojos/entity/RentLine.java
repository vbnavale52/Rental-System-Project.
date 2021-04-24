package com.rsys.pojos.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class RentLine extends BaseEntity {

	private double grandTotal;

	@Column(name = "user_id", nullable = true)
	private int userId;

	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "equiepment_id", nullable = true)
	private RentalEquiepment equiepment;

	public RentLine() {

	}

	public RentLine(double grandTotal) {
		super();
		this.grandTotal = grandTotal;
	}

	public double getGrandTotal() {
		return grandTotal;
	}

	public void setGrandTotal(double grandTotal) {
		this.grandTotal = grandTotal;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public RentalEquiepment getEquiepment() {
		return equiepment;
	}

	public void setEquiepment(RentalEquiepment equiepment) {
		this.equiepment = equiepment;
	}

	@Override
	public String toString() {
		return "RentLine [grandTotal=" + grandTotal + ", getId()=" + getId() + "]";
	}

}
