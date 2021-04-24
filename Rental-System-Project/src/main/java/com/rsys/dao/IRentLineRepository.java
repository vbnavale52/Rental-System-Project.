package com.rsys.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rsys.pojos.entity.RentLine;

public interface IRentLineRepository extends JpaRepository<RentLine, Integer> {

}
