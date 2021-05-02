package com.rsys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rsys.dto.ForgotPasswordDto;
import com.rsys.dto.LoginDTO;
import com.rsys.dto.ResetPasswordDTO;
import com.rsys.dto.ResponseDTO;
import com.rsys.pojos.entity.User;
import com.rsys.services.interfaces.IAutenticationService;

@RestController
@CrossOrigin
@RequestMapping("/api/auth")
public class AutenticationController {
	
	@Autowired
	private IAutenticationService autenticationService;
	
	public AutenticationController() {
		
	}
	
	@PostMapping("/signin")
	public ResponseDTO<?> userLogin(@RequestBody LoginDTO loginRequest) {
		try {
			User autenticatedUser = autenticationService.autenticateUser(loginRequest);
		//	System.out.println(autenticatedUser);
			return new ResponseDTO<>(HttpStatus.OK, autenticatedUser, "You are successfully logged in........");
		} catch (Exception e) {
			return new ResponseDTO<>(HttpStatus.INTERNAL_SERVER_ERROR, null, e.getMessage());
		}
	}
	
	@PutMapping("/forgot-password")
	public ResponseDTO<?> forgotPassword(@RequestBody  ForgotPasswordDto forgotPasswordDto) {
		try {
			User autenticatedUser = autenticationService.forgotPassword(forgotPasswordDto);
		//	System.out.println(autenticatedUser);
			return new ResponseDTO<>(HttpStatus.OK, autenticatedUser, "You are successfully logged in........");
		} catch (Exception e) {
			return new ResponseDTO<>(HttpStatus.INTERNAL_SERVER_ERROR, null, e.getMessage());
		}
	}
	@PostMapping("/reset-password")
	public ResponseDTO<?> forgotPassword(@RequestBody ResetPasswordDTO resetPasswordDTO  ) {

	  try {
		  User autenticatedUser = autenticationService.resetPassword(resetPasswordDTO);
			return new ResponseDTO<>(HttpStatus.OK, autenticatedUser, "You are successfully logged in........");
		} catch (Exception e) {
			return new ResponseDTO<>(HttpStatus.INTERNAL_SERVER_ERROR, null, e.getMessage());
		}

	}
}
