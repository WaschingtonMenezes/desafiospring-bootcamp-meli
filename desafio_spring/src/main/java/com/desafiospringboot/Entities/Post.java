package com.desafiospringboot.Entities;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Date date;
    private Integer category;
    private Double price;

    @OneToOne
    private Product detail;
    @ManyToOne
    private UserSeller userSeller;

    public Post(long id, Date date, Integer category, Double price, Product detail, UserSeller userSeller) {
        this.id = id;
        this.date = date;
        this.category = category;
        this.price = price;
        this.detail = detail;
        this.userSeller = userSeller;
    }

    public Post() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Product getDetail() {
        return detail;
    }

    public void setDetail(Product detail) {
        this.detail = detail;
    }

    public UserSeller getUserSeller() {
        return userSeller;
    }

    public void setUserSeller(UserSeller userSeller) {
        this.userSeller = userSeller;
    }
}
