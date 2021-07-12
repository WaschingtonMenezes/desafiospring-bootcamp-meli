package com.desafiospringboot.DTOs.User;

import com.desafiospringboot.Entities.UserClient;
import com.desafiospringboot.Entities.UserSeller;

import javax.validation.constraints.NotNull;
import java.util.List;

public class UserSellerFollowersListDTO {
    @NotNull
    private int userId;
    @NotNull
    private String userName;
    private List<UserDTO> followers;

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

    public List<UserDTO> getFollowers() {
        return followers;
    }

    public void setFollowers(List<UserDTO> followers) {
        this.followers = followers;
    }

    public UserSellerFollowersListDTO(int userId, String sellerName, List<UserDTO> followers) {
		this.userId = userId;
		this.userName = sellerName;
		this.followers = followers;
	}

    public static UserSellerFollowersListDTO convert (List<UserClient> listClients, UserSeller seller) {
    	return new UserSellerFollowersListDTO(seller.getId(), seller.getName(), UserDTO.convert(listClients));
    }
    
}
