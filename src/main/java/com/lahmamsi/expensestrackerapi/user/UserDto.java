package com.lahmamsi.expensestrackerapi.user;

import jakarta.annotation.Nonnull;

public class UserDto {

	@Nonnull
	private String username;
	@Nonnull
	private String email;
	@Nonnull
	private String password;

	public String getUsername() {
		return username;
	}

	public UserDto() {
		// TODO Auto-generated constructor stub
	}

	public UserDto(String username, String email, String password) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
