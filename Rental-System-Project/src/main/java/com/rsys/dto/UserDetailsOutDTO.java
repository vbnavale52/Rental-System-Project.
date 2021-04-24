package com.rsys.dto;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import org.springframework.web.multipart.MultipartFile;

public class UserDetailsOutDTO {
	@NotNull
	private int userId;

	@NotNull
	private String firstName;

	@NotNull
	private String lastName;
	@NotNull
	private int phoneNumber;

	@NotNull
	private String email;

	@NotNull
	private LocalDate dateOfBirth;

	private MultipartFile profileImage;

	public UserDetailsOutDTO() {
		// TODO Auto-generated constructor stub
	}

	public UserDetailsOutDTO(@NotNull int userId, @NotNull String firstName, @NotNull String lastName,
			@NotNull int phoneNumber, @NotNull String email, @NotNull LocalDate dateOfBirth,
			MultipartFile profileImage) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.dateOfBirth = dateOfBirth;
		this.profileImage = profileImage;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(@NotNull int userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public MultipartFile getProfileImage() {
		return profileImage;
	}

	public void setProfileImage(MultipartFile profileImage) {
		this.profileImage = profileImage;
	}

}