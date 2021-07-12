package com.desafiospringboot.DTOs.Post;

import javax.validation.constraints.NotNull;

public class PostPromoCountDTO {
    @NotNull
    private int userId;
    @NotNull
    private String userName;
    private int promoproducts_count;

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

    public int getPromoproducts_count() {
        return promoproducts_count;
    }

    public void setPromoproducts_count(int promoproducts_count) {
        this.promoproducts_count = promoproducts_count;
    }

    public PostPromoCountDTO(int userId, String userName, int post_promo_count) {
        this.userId = userId;
        this.userName = userName;
        this.promoproducts_count = post_promo_count;
    }

    public PostPromoCountDTO() {
    }
}
