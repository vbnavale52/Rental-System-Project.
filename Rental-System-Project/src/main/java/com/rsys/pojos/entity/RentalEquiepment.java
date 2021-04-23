package com.rsys.pojos.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "rental_equipement")
public class RentalEquiepment extends BaseEntity {
	
	@Column(length = 50,nullable = false,unique = true)
	private String equipementName;
	
	@Column(length = 50,nullable = false)
	private String brand;
	
	@Column(length = 100,nullable = false)
	private String image;
	
	private int avialableQuantity;
	
	private double rentPerDay;
	
	@Column(length = 100,nullable = false)
	private String decription;
	
	@ManyToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name = "equipement_category",nullable = false)
	private Category category;
	
	public RentalEquiepment(String equipementName, String brand, String image, int avialableQuantity, double rentPerDay) {
		super();
		this.equipementName = equipementName;
		this.brand = brand;
		this.image = image;
		this.avialableQuantity = avialableQuantity;
		this.rentPerDay = rentPerDay;
	}

	@Override
	public String toString() {
		return "Product [equipementName=" + equipementName + ", brand=" + brand + ", image=" + image
				+ ", avialableQuantity=" + avialableQuantity + ", rentPerDay=" + rentPerDay + ", decription="
				+ decription + "]";
	}

}
