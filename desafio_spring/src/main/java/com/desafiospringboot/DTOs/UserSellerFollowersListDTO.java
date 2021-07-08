package com.desafiospringboot.DTOs;

import com.desafiospringboot.Entities.UserSeller;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

public class UserSellerFollowersListDTO {
    @NotNull
    private int userId;
    @NotNull
    private String sellerName;
    private List<UserClient> followers;

    private static class UserClient {
        private int userId;
        private String name;

        public UserClient(int userId, String name) {
            this.userId = userId;
            this.name = name;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
    public UserSellerFollowersListDTO(int userId, String sellerName, List<UserClient> followers) {
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

    public List<UserClient> getFollowers() {
        return followers;
    }

    public static UserSellerFollowersListDTO convert (UserSeller seller) {
        List<UserClient> listClient = new ArrayList<>();
        seller.getFollowers().forEach(user -> listClient.add(new UserClient(user.getId(), user.getName())));
        return new UserSellerFollowersListDTO(seller.getId(), seller.getName(), listClient);
    }
}
