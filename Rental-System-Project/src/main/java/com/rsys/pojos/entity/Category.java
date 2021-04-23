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
	
	@Column(length = 30 , nullable = false)
	private String categoryName;
	
	@OneToMany(mappedBy = "category")
	private List<RentalEquiepment> product;

	public Category(String categoryName) {
		super();
		this.categoryName = categoryName;
	}

	@Override
	public String toString() {
		return "Category [categoryName=" + categoryName + "]";
	}

}
