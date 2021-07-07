package com.desafiospringboot.Entities;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class UserSeller extends User{
    @ManyToMany
    private List<UserClient> followers;

    @OneToMany
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
}
