package com.desafiospringboot.DTOs.Post;

import com.desafiospringboot.DTOs.ProductDTO;
import com.desafiospringboot.Entities.Post;

import java.util.Date;

public class PostDTO extends PostBaseDTO{
    public PostDTO() {
    }

    public PostDTO(Post post) {
        super(post);
    }

    public PostDTO(int id_post, int userId, Date date, Integer category, Double price, ProductDTO detail) {
        super(id_post, userId, date, category, price, detail);
    }

    public static PostDTO convert(Post post) {
        return new PostDTO(post);
    }

    public static Post convert(PostDTO promoPostBaseDTO) {
        Post post = new Post();

        post.setId(promoPostBaseDTO.getId_post());
        post.setCategory(promoPostBaseDTO.getCategory());
        post.setDate(promoPostBaseDTO.getDate());
        post.setPrice(promoPostBaseDTO.getPrice());
        post.setDetail(ProductDTO.convert(promoPostBaseDTO.getDetail()));

        return post;
    }
}
