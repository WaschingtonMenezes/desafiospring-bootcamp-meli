package com.desafiospringboot.DTOs.UserSeller;


import com.desafiospringboot.Entities.UserClient;
import com.desafiospringboot.Entities.UserSeller;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserSellerFollowedDTO {
    @NotNull
    private int userId;
    @NotNull
    private String userName;
    private List<UserDTO> followed;

    

    public UserSellerFollowedDTO(int userId, String userName, List<UserDTO> followed) {
        this.userId = userId;
        this.userName = userName;
        this.followed = followed;
    }

    public int getUserId() {
        return userId;
    }

    public String getuserName() {
        return userName;
    }

    public List<UserDTO> getFollowed() {
        return followed;
    }

    public static UserSellerFollowedDTO convert (List<UserSeller> listSellers, UserClient user) { 	
        return new UserSellerFollowedDTO(user.getId(), user.getName(), UserDTO.convert(listSellers));
    }
}
