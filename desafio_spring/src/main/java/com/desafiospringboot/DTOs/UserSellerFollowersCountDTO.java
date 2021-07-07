package com.desafiospringboot.DTOs;

import com.desafiospringboot.Entities.UserSeller;

public class UserSellerFollowersCountDTO {
    private int userId;
    private String name;
    private int count;

    public UserSellerFollowersCountDTO(int userId, String name, int count) {
        this.userId = userId;
        this.name = name;
        this.count = count;
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
        return name;
    }

    public int getCount() {
        return count;
    }
}
