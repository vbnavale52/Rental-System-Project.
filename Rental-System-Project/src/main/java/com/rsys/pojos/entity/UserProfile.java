package com.rsys.pojos.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
public class UserProfile extends BaseEntity {

	@NotNull
	@Column(name = "first_name", length = 30, nullable = false)
	private String firstName;

	@NotNull
	@Column(name = "last_name", length = 30, nullable = false)
	private String lastName;

	@NotNull
	@Column(name = "email", length = 30, unique = true, nullable = false)
	private String email;

	@NotNull
	@Column(length = 10, unique = false, nullable = false)
	private Long phoneNumber;

	@NotNull
	// @Check(constraLongs =
	// ((Period.between(dateOfBirth,LocalDate.now()).getYears())>18))
	@Column(nullable = false)
	private LocalDate dateOfBirth;
	
	@NotNull
	@Column(length = 150, unique = false, nullable = false)
	private String  profileImage;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

	public UserProfile() {

	}

	public UserProfile(@NotNull String firstName, @NotNull String lastName, @NotNull String email,
			@NotNull Long phoneNumber, @NotNull LocalDate dateOfBirth, @NotNull String profileImage) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.dateOfBirth = dateOfBirth;
		this.profileImage = profileImage;
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

	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getProfileImage() {
		return profileImage;
	}

	public void setProfileImage(String profileImage) {
		this.profileImage = profileImage;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "UserProfile [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", phoneNumber="
				+ phoneNumber + ", dateOfBirth=" + dateOfBirth + ", profileImage=" + profileImage + "]";
	}
}
