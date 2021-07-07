package com.desafiospringboot.DTOs;


import com.desafiospringboot.Entities.UserClient;

import java.util.ArrayList;
import java.util.List;

public class UserClientFollowingDTO {
     private int userId;
     private String userName;
     private List<UserSeller> followed;

     private static class UserSeller {
        private int userId;
        private String name;

         public UserSeller(int userId, String name) {
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

    public UserClientFollowingDTO(int userId, String userName, List<UserSeller> followed) {
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

    public static UserClientFollowingDTO convert (UserClient user) {
         List<UserSeller> listSellers = new ArrayList<>();
         user.getFollowing().forEach(seller -> listSellers.add(new UserSeller(seller.getId(), seller.getName())));
         return new UserClientFollowingDTO(user.getId(), user.getName(), listSellers);
    }
}
