package com.rsys.dto;

public class ResetPasswordDTO
{
	private String userName;
	private String email;

	public ResetPasswordDTO() {

	}

	public ResetPasswordDTO(String userName, String email) {
		super();
		this.userName = userName;
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
