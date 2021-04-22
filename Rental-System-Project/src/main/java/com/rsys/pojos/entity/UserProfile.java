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
	//@Check(constraints = ((Period.between(dateOfBirth,LocalDate.now()).getYears())>18))
	@Column( nullable = false)
	private LocalDate dateOfBirth;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

	public UserProfile() {
		// TODO Auto-generated constructor stub
	}

	public UserProfile(@NotNull String firstName, @NotNull String lastName, @NotNull String email,
			@NotNull @NotNull LocalDate dateOfBirth) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.dateOfBirth = dateOfBirth;
		
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

	public @NotNull LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(@NotNull LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "UserProfile [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", dateOfBirth="
				+ dateOfBirth + ", getId()=" + getId() + "]";
	}

}
