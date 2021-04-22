package com.rsys.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rsys.pojos.entity.UserProfile;

public interface IUserProfileRepository extends JpaRepository<UserProfile, Integer> {

}
