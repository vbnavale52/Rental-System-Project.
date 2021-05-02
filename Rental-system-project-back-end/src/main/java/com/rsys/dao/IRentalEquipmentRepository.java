package com.rsys.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.rsys.pojos.entity.Category;
import com.rsys.pojos.entity.RentalEquipment;

public interface IRentalEquipmentRepository extends JpaRepository<RentalEquipment, Integer> {

	Optional<RentalEquipment> findByEquipmentName(String equipName);

	@Query(value = "select e from RentalEquipment e where e.category=:category ")
	List<RentalEquipment> getEquipmentByCategoryName(Category category);

}
