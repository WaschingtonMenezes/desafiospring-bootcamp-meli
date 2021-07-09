package com.desafiospringboot.DTOs.UserSeller;

import java.util.List;
import java.util.stream.Collectors;

import com.desafiospringboot.Entities.User;
import com.desafiospringboot.Entities.UserSeller;

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

	public String getName() {
		return userName;
	}

	public void setName(String userName) {
		this.userName = userName;
	}
	
	public static List<UserDTO> convert(List<? extends User> users) {
		return users.stream().map(UserDTO::new).collect(Collectors.toList());
	}

}
