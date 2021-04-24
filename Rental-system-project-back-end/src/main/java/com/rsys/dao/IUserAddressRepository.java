package com.rsys.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rsys.pojos.entity.UserAddress;

public interface IUserAddressRepository extends JpaRepository<UserAddress, Integer> {

}
