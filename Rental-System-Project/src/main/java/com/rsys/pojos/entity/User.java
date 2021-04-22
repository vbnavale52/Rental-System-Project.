package com.rsys.pojos.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.ColumnDefault;
import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rsys.pojos.enums.UserRole;

@Entity
@Table(name = "user_account")
public class User extends BaseEntity {

	@NotNull
	@Column(name = "user_name", length = 30, unique = true, nullable = false)
	private String userName;
	@Column(name = "password", length = 30, nullable = false)

	@NotNull
	private String password;

	@NotNull
	@Transient
	private String confirmPassword;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false/*, columnDefinition = "varchar(10) default 'CUSTOMER'"*/)
	private UserRole userRole = UserRole.CUSTOMER;

	@JsonIgnore
	@OneToOne(targetEntity = UserProfile.class, mappedBy = "user")
	private UserProfile userProfile;

	public User() {

	}

	public User(@NotNull String userName, @NotNull String password, @NotNull String confirmPassword,
			UserRole userRole) {
		super();
		this.userName = userName;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.userRole = userRole;
	}


	public String getUserName() {
		return userName;
	}

	public void setUserName(@NotNull  String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword( @NotNull String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(@NotNull String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public UserRole getUserRole() {
		return userRole;
	}

	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}

	public UserProfile getUserProfile() {
		return userProfile;
	}

	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}

	@Override
	public String toString() {
		return "User [userName=" + userName + ", password=" + password + ", confirmPassword=" + confirmPassword
				+ ", userRole=" + userRole + ", getId()=" + getId() + "]";
	}

}
