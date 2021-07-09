package com.desafiospringboot.DTOs.Post;

import com.desafiospringboot.DTOs.ProductDTO;
import com.desafiospringboot.Entities.Post;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public abstract class PostBaseDTO {
    private int id_post;
    @NotNull
    private int userId;
    @NotNull
    @JsonFormat(pattern="dd-MM-yyyy")
    private Date date;
    @NotNull
    private Integer category;
    @NotNull
    private Double price;
    @NotNull
    @Valid
    private ProductDTO detail;

    public int getId_post() {
        return id_post;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    public ProductDTO getDetail() {
        return detail;
    }

    public void setDetail(ProductDTO detail) {
        this.detail = detail;
    }

    public PostBaseDTO() {
    }

    public PostBaseDTO(Post post) {
        this.id_post = post.getId();
        this.userId = post.getUserSeller().getId();
        this.date = post.getDate();
        this.category = post.getCategory();
        this.price = post.getPrice();
        this.detail = new ProductDTO(post.getDetail());
    }

    public PostBaseDTO(int id_post, int userId, Date date, Integer category, Double price, ProductDTO detail) {
        this.id_post = id_post;
        this.userId = userId;
        this.date = date;
        this.category = category;
        this.price = price;
        this.detail = detail;
    }
}
