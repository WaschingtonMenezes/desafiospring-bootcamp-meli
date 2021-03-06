package com.desafiospringboot.DTOs.User;

import java.util.List;
import java.util.stream.Collectors;

import com.desafiospringboot.Entities.User;

public class UserDTO {

	private int userId;
	private String userName;

	public UserDTO() {
	}

	public UserDTO(User user ) {
		this.userId = user.getId();
		this.userName = user.getName();
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public static List<UserDTO> convert(List<? extends User> users) {
		return users.stream().map(UserDTO::new).collect(Collectors.toList());
	}

}
