package com.desafiospringboot.DTOs.User;

import com.desafiospringboot.Entities.UserClient;
import com.desafiospringboot.Entities.UserSeller;

import javax.validation.constraints.NotNull;
import java.util.List;

public class UserSellerFollowersListDTO {
    @NotNull
    private int userId;
    @NotNull
    private String sellerName;
    private List<UserDTO> followers;

    public UserSellerFollowersListDTO(int userId,String sellerName, List<UserDTO> followers) {
		
		this.userId = userId;
		this.sellerName = sellerName;
		this.followers = followers;
	}

	public int getUserId() {
        return userId;
    }

    public String getSellerName() {
        return sellerName;
    }

    public List<UserDTO> getFollowers() {
        return followers;
    }

    public static UserSellerFollowersListDTO convert (List<UserClient> listClients, UserSeller seller) {
    	return new UserSellerFollowersListDTO(seller.getId(), seller.getName(), UserDTO.convert(listClients));
    }
    
}
