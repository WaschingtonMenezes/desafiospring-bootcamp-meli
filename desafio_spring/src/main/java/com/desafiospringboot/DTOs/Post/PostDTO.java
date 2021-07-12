package com.desafiospringboot.DTOs.Post;

import com.desafiospringboot.DTOs.ProductDTO;
import com.desafiospringboot.Entities.Post;

import java.util.List;
import java.util.stream.Collectors;

public class PostDTO extends PostBaseDTO{
    public PostDTO() {}

    public PostDTO(Post post) {
        super(post);
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

    public static List<PostDTO> convert(List<Post> posts) {
        return posts.stream().map(PostDTO::new).collect(Collectors.toList());
    }
}
