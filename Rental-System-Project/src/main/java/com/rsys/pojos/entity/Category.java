package com.rsys.pojos.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "equipement_category")
public class Category extends BaseEntity {

	@Column(length = 30, nullable = false)
	private String categoryName;
	@Column(length = 200, nullable = true)
	private String categoryImage;

	@OneToMany(mappedBy = "category")
	private List<RentalEquiepment> product;

	public Category(String categoryName, String categoryImage) {
		super();
		this.categoryName = categoryName;
		this.categoryImage = categoryImage;
	}

	public void setProduct(List<RentalEquiepment> product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "Category [categoryName=" + categoryName + ", categoryImage=" + categoryImage + ", product=" + product
				+ "]";
	}

}