package com.rsys.services.impls;

import java.util.List;
import java.util.Optional;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rsys.dao.ICategoryRepository;
import com.rsys.dao.IRentalEquipmentRepository;
import com.rsys.exception.UserException;
import com.rsys.pojos.entity.Category;
import com.rsys.pojos.entity.RentalEquipment;
import com.rsys.services.interfaces.IRentalEquipmentService;

@Service
@Transactional
public class RentalEquipmentImpl implements IRentalEquipmentService {

	@Autowired
	IRentalEquipmentRepository equipmentRepository;

	@Autowired
	ICategoryRepository categoryRepository;

	@Override
	public List<RentalEquipment> getAllEquipment() {
		return equipmentRepository.findAll();
	}

	@Override
	public RentalEquipment getEquipmentById(int equipId) {
		Optional<RentalEquipment> optionalEquipment = equipmentRepository.findById(equipId);
		RentalEquipment equipment = optionalEquipment
				.orElseThrow(() -> new UserException("Equipment is not found with id " + equipId));
		return equipment;
	}

	@Override
	public RentalEquipment getEquipmentByName(String equipName) {
		Optional<RentalEquipment> optionalEquipment = equipmentRepository.findByEquipmentName(equipName);
		RentalEquipment equipment = optionalEquipment
				.orElseThrow(() -> new UserException("Equipment is not found with Name " + equipName));
		return equipment;
	}

	@Override
	public RentalEquipment addNewEquipment(RentalEquipment equipment, int catId) {
		//get a category from category table
		Optional<Category> optionalUser = categoryRepository.findById(catId);
		Category category = optionalUser.orElseThrow(() -> new UserException("Category is not found with id " + catId));
		//set category to the equipment
		equipment.setCategory(category);
		//persist equipment into table
		RentalEquipment addedEquipement = equipmentRepository.save(equipment);
		//add equipment to category for bi-directional relationship between category and equipment table
		List<RentalEquipment> equipmentsList = category.getEquipments();
		equipmentsList.add(addedEquipement);
		category.setEquipments(equipmentsList);
		//persist updated category.............
		categoryRepository.save(category);
		return addedEquipement;
	}

	@Override
	public RentalEquipment removeEquipment(int equipId) {
		Optional<RentalEquipment> optionalEquipment = equipmentRepository.findById(equipId);
		RentalEquipment equipment = optionalEquipment
				.orElseThrow(() -> new UserException("Equipment is not found with id " + equipId));
		equipmentRepository.deleteById(equipId);
		return equipment;
	}

	@Override
	public List<RentalEquipment> getEquipmentByCategoryName(@NotNull String catName) {
		Optional<Category> optionalUser = categoryRepository.findByCategoryName(catName);
		Category category = optionalUser
				.orElseThrow(() -> new UserException("Category is not found with name " + catName));
		return equipmentRepository.getEquipmentByCategoryName(category);
	}

}
