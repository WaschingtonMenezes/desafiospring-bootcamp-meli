package com.desafiospringboot.Entities;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    private Date date;
    @NotNull
    private Integer category;
    @NotNull
    private Double price;
    @NotNull
    private Boolean hasPromo = false;
    @NotNull
    private Double discount;

    @OneToOne
    private Product detail;

    @ManyToOne(optional = false)
    private UserSeller userSeller;

    public Post(int id, Date date, Integer category, Double price, Product detail, UserSeller userSeller) {
        this.id = id;
        this.date = date;
        this.category = category;
        this.price = price;
        this.detail = detail;
        this.userSeller = userSeller;
    }

    public Post() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public Boolean getHasPromo() {
        return hasPromo;
    }

    public void setHasPromo(Boolean hasPromo) {
        this.hasPromo = hasPromo;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }
}
