package com.desafiospringboot.DTOs.User;


import com.desafiospringboot.Entities.UserClient;
import com.desafiospringboot.Entities.UserSeller;

import javax.validation.constraints.NotNull;
import java.util.List;

public class UserSellerFollowedListDTO {
    @NotNull
    private int userId;
    @NotNull
    private String userName;
    private List<UserDTO> followed;

    public UserSellerFollowedListDTO(int userId, String userName, List<UserDTO> followed) {
        this.userId = userId;
        this.userName = userName;
        this.followed = followed;
    }

    public int getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public List<UserDTO> getFollowed() {
        return followed;
    }

    public static UserSellerFollowedListDTO convert (List<UserSeller> listSellers, UserClient user) {
        return new UserSellerFollowedListDTO(user.getId(), user.getName(), UserDTO.convert(listSellers));
    }
}
