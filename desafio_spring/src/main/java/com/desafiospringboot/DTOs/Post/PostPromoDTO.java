package com.desafiospringboot.DTOs.Post;

import com.desafiospringboot.DTOs.ProductDTO;
import com.desafiospringboot.Entities.Post;

import java.util.List;
import java.util.stream.Collectors;

public class PostPromoDTO extends PostBaseDTO {
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
        post.setHasPromo(promoPostDTO.getHasPromo());
        post.setDiscount(promoPostDTO.getDiscount());

        return post;
    }

    public static List<PostPromoDTO> convert(List<Post> posts) {
        return posts.stream().map(PostPromoDTO::new).collect(Collectors.toList());
    }
}
