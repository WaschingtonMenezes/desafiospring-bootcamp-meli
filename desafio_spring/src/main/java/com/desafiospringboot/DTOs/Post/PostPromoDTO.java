package com.desafiospringboot.DTOs.Post;

import com.desafiospringboot.DTOs.ProductDTO;
import com.desafiospringboot.Entities.Post;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PostPromoDTO extends PostBaseDTO{
    private Boolean hasPromo;
    private Double discount;

    public PostPromoDTO() {
    }

    public PostPromoDTO(Post post) {
        super(post);
        this.hasPromo = post.getHasPromo();
        this.discount = post.getDiscount();
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

    public static PostPromoDTO convert(Post post) {
        return new PostPromoDTO(post);
    }

    public static Post convert(PostPromoDTO promoPostDTO) {
        Post post = new Post();

        post.setId(promoPostDTO.getId_post());
        post.setCategory(promoPostDTO.getCategory());
        post.setDate(promoPostDTO.getDate());
        post.setPrice(promoPostDTO.getPrice());
        post.setDetail(ProductDTO.convert(promoPostDTO.getDetail()));
        post.setHasPromo(true);
        post.setDiscount(promoPostDTO.getDiscount());
        return post;
    }


    public static List<PostPromoDTO> convert(List<Post> posts) {
        List<PostPromoDTO> postsDTO = new ArrayList<>();
        posts.forEach(post -> postsDTO.add(new PostPromoDTO(post)));
        return postsDTO;
    }
}
