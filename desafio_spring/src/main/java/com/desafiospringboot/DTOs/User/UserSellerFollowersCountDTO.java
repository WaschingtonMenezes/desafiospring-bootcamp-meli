package com.desafiospringboot.DTOs.User;

import com.desafiospringboot.Entities.UserSeller;

import javax.validation.constraints.NotNull;

public class UserSellerFollowersCountDTO {
    @NotNull
    private int userId;
    @NotNull
    private String userName;
    private int followers_count;

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

    public int getFollowers_count() {
        return followers_count;
    }

    public void setFollowers_count(int followers_count) {
        this.followers_count = followers_count;
    }

    public UserSellerFollowersCountDTO(int userId, String userName, int followers_count) {
        this.userId = userId;
        this.userName = userName;
        this.followers_count = followers_count;
    }

    public UserSellerFollowersCountDTO() {
    }

    public static UserSellerFollowersCountDTO convert(UserSeller seller) {
        return new UserSellerFollowersCountDTO(seller.getId(), seller.getName(), seller.getFollowers().size());
    }
}
