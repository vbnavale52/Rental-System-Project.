package com.rsys.pojos.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "rental_equipment")
public class RentalEquipment extends BaseEntity {

	@Column(length = 50, nullable = false, unique = true)
	private String equipmentName;

	@Column(length = 50, nullable = false)
	private String brand;

	private int avialableQuantity;

	private double rentPerDay;

	private double offerDiscount;

	private double finalRent;

	private double delayCharges;

	@Column(length = 100, nullable = false)
	private String image;

	@Column(length = 100, nullable = false)
	private String decription;
	
	@OneToOne(targetEntity = RentLine.class, mappedBy = "equiepment")
	private RentLine rentLine;

	@ManyToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name = "equipment_category", nullable = false)
	private Category category;
	
	

	public RentalEquipment() {
	
	}

	public RentalEquipment(String equipmentName, String brand, int avialableQuantity, double rentPerDay,
			double offerDiscount, double finalRent, double delayCharges, String image, String decription) {
		super();
		this.equipmentName = equipmentName;
		this.brand = brand;
		this.avialableQuantity = avialableQuantity;
		this.rentPerDay = rentPerDay;
		this.offerDiscount = offerDiscount;
		this.finalRent = finalRent;
		this.delayCharges = delayCharges;
		this.image = image;
		this.decription = decription;
	}

	public String getEquipmentName() {
		return equipmentName;
	}

	public void setEquipmentName(String equipmentName) {
		this.equipmentName = equipmentName;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getAvialableQuantity() {
		return avialableQuantity;
	}

	public void setAvialableQuantity(int avialableQuantity) {
		this.avialableQuantity = avialableQuantity;
	}

	public double getRentPerDay() {
		return rentPerDay;
	}

	public void setRentPerDay(double rentPerDay) {
		this.rentPerDay = rentPerDay;
	}

	public double getOfferDiscount() {
		return offerDiscount;
	}

	public void setOfferDiscount(double offerDiscount) {
		this.offerDiscount = offerDiscount;
	}

	public double getFinalRent() {
		return finalRent;
	}

	public void setFinalRent(double finalRent) {
		this.finalRent = finalRent;
	}

	public double getDelayCharges() {
		return delayCharges;
	}

	public void setDelayCharges(double delayCharges) {
		this.delayCharges = delayCharges;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getDecription() {
		return decription;
	}

	public void setDecription(String decription) {
		this.decription = decription;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "RentalEquiepment [equipmentName=" + equipmentName + ", brand=" + brand + ", avialableQuantity="
				+ avialableQuantity + ", rentPerDay=" + rentPerDay + ", offerDiscount=" + offerDiscount + ", finalRent="
				+ finalRent + ", delayCharges=" + delayCharges + ", image=" + image + ", decription=" + decription
				+ ", getId()=" + getId() + "]";
	}

}
