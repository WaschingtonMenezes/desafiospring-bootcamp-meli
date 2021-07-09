package com.desafiospringboot.DTOs;

import com.desafiospringboot.DTOs.Post.PostDTO;

import java.util.List;

public class UserFollowedPostsDTO {
    private int userId;
    private List<PostDTO> posts;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public List<PostDTO> getPosts() {
        return posts;
    }

    public void setPosts(List<PostDTO> posts) {
        this.posts = posts;
    }

    public UserFollowedPostsDTO() {
    }

    public UserFollowedPostsDTO(int userId, List<PostDTO> posts) {
        this.userId = userId;
        this.posts = posts;
    }
}
