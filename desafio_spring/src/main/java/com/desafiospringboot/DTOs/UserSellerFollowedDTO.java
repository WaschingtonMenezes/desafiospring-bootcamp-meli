package com.desafiospringboot.DTOs;


import com.desafiospringboot.Entities.UserClient;

import java.util.ArrayList;
import java.util.List;

public class UserSellerFollowedDTO {
    private int userId;
    private String userName;
    private List<UserSeller> followed;

    private static class UserSeller {
        private int userId;
        private String userName;

        public UserSeller(int userId, String userName) {
            this.userId = userId;
            this.userName = userName;
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
     }

    public UserSellerFollowedDTO(int userId, String userName, List<UserSeller> followed) {
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

    public List<UserSeller> getFollowed() {
        return followed;
    }

    public static UserSellerFollowedDTO convert (UserClient user) {
        List<UserSeller> listSellers = new ArrayList<>();
        user.getFollowing().forEach(seller -> listSellers.add(new UserSeller(seller.getId(), seller.getName())));
        return new UserSellerFollowedDTO(user.getId(), user.getName(), listSellers);
    }
}
