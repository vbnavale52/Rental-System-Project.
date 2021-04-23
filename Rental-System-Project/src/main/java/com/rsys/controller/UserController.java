package com.rsys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rsys.dto.ResponseDTO;
import com.rsys.dto.UserProfileInDto;
import com.rsys.pojos.entity.User;
import com.rsys.pojos.entity.UserProfile;
import com.rsys.services.interfaces.IUserServices;

@RestController
@CrossOrigin
@RequestMapping("/api/user")
public class UserController {
	@Autowired
	private IUserServices userServices;

	public UserController() {
		System.out.println("User controller invoked...............");
	}

	@PostMapping("/signup")
	public ResponseDTO<?> registerNew(@RequestBody User newUser) {
		try {
			
			User registerdUser = userServices.registerNew(newUser);
			return new ResponseDTO<>(HttpStatus.OK, registerdUser, "User registered successfully........");
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseDTO<>(HttpStatus.INTERNAL_SERVER_ERROR, null, e.getMessage());
		}
	}
	
	@PostMapping("/user_profile")
	public ResponseDTO<?> addUserProfile(@RequestBody UserProfileInDto newUser) {
		try {
			UserProfile profileDetails = userServices.addUserProfile(newUser);
			return new ResponseDTO<>(HttpStatus.OK, profileDetails, "User profile detrails added successfully........");
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseDTO<>(HttpStatus.INTERNAL_SERVER_ERROR, null, e.getMessage());
		}
	}
	
	@GetMapping("/user_profile/{userId}")
	public ResponseDTO<?> getUserProfile(@PathVariable int userId) {
		try {
			UserProfile profileDetails = userServices.getUserProfile(userId);
			System.out.println(profileDetails);
			return new ResponseDTO<>(HttpStatus.OK, profileDetails, "User profile detrails added successfully........");
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseDTO<>(HttpStatus.INTERNAL_SERVER_ERROR, null, e.getMessage());
		}
	}

	@GetMapping("/get_by_id/{userId}")
	public ResponseDTO<?> getUserById(@PathVariable int userId) {
		try {
			User user = userServices.getUserById(userId);
			return new ResponseDTO<>(HttpStatus.OK, user, "User is found with id  " + userId + " ........");
		} catch (Exception e) {
			return new ResponseDTO<>(HttpStatus.INTERNAL_SERVER_ERROR, null, e.getMessage());
		}
	}

}
