package com.desafiospringboot.Entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class UserSeller extends User{
    @ManyToMany(mappedBy = "following")
    private List<UserClient> followers;

    @OneToMany(mappedBy = "userSeller")
    private List<Post> posts;

    public UserSeller(int id, String name, List<UserClient> followers) {
        super(id, name);
        this.followers = followers;
    }

    public UserSeller() {
    }

    public List<UserClient> getFollowers() {
        return followers;
    }

    public void setFollowers(List<UserClient> followers) {
        this.followers = followers;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
}
