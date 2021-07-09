package com.desafiospringboot.DTOs.Post;

import com.desafiospringboot.DTOs.UserSeller.UserSellerFollowersCountDTO;
import com.desafiospringboot.Entities.UserSeller;

import javax.validation.constraints.NotNull;

public class PostPromoCountDTO {
    @NotNull
    private int userId;
    @NotNull
    private String userName;
    private int post_promo_count;

    public PostPromoCountDTO(int userId, String userName, int post_promo_count) {
        this.userId = userId;
        this.userName = userName;
        this.post_promo_count = post_promo_count;
    }

    public PostPromoCountDTO() {
    }

    public int getUserId() {
        return userId;
    }

    public String getName() {
        return userName;
    }

    public int getCount() {
        return post_promo_count;
    }
}
