package com.desafiospringboot.DTOs.User;

import com.desafiospringboot.DTOs.Post.PostPromoDTO;
import com.desafiospringboot.Entities.Post;
import com.desafiospringboot.Entities.UserSeller;

import java.util.List;

public class UserSellerPromoPostDTO {
    private int userId;
    private String userName;
    private List<PostPromoDTO> posts;

    public UserSellerPromoPostDTO(int userId, String userName, List<PostPromoDTO> posts) {
        this.userId = userId;
        this.userName = userName;
        this.posts = posts;
    }

    public UserSellerPromoPostDTO() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public List<PostPromoDTO> getPosts() {
        return posts;
    }

    public void setPosts(List<PostPromoDTO> posts) {
        this.posts = posts;
    }

    public static UserSellerPromoPostDTO convert (UserSeller seller, List<Post> posts) {
        return new UserSellerPromoPostDTO(seller.getId(), seller.getName(), PostPromoDTO.convert(posts));
    }
}
