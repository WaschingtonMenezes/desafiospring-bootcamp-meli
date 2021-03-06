package com.desafiospringboot.Entities;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
public class UserClient extends User{
    @ManyToMany
    private List<UserSeller> following;

    public UserClient(int id, String name, List<UserSeller> following) {
        super(id, name);
        this.following = following;
    }

    public UserClient() {
    }

    public List<UserSeller> getFollowing() {
        return following;
    }

    public void setFollowing(List<UserSeller> following) {
        this.following = following;
    }
}
