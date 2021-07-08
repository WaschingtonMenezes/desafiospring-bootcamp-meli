package com.desafiospringboot.DTOs;

import com.desafiospringboot.Entities.UserSeller;

public class UserSellerFollowersCountDTO {
    private int userId;
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
