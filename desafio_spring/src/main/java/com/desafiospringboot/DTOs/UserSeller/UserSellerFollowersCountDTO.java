package com.desafiospringboot.DTOs.UserSeller;

import com.desafiospringboot.Entities.UserSeller;

import javax.validation.constraints.NotNull;

public class UserSellerFollowersCountDTO {
    @NotNull
    private int userId;
    @NotNull
    private String userName;
    private int followers_count;

    public UserSellerFollowersCountDTO(int userId, String userName, int followers_count) {
        this.userId = userId;
        this.userName = userName;
        this.followers_count = followers_count;
    }

    public UserSellerFollowersCountDTO() {
    }

    public static UserSellerFollowersCountDTO convert(UserSeller seller) {
        return new UserSellerFollowersCountDTO(seller.getId(), seller.getName(), (int) seller.getFollowers().stream().count());
    }

    public int getUserId() {
        return userId;
    }

    public String getName() {
        return userName;
    }

    public int getCount() {
        return followers_count;
    }
}
