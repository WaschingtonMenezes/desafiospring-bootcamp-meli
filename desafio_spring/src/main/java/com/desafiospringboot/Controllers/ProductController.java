package com.desafiospringboot.Controllers;

import com.desafiospringboot.DTOs.PostDTO;
import com.desafiospringboot.Entities.Post;
import com.desafiospringboot.Service.PostService;
import com.desafiospringboot.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;
    private PostService postService;

    @Autowired
    public ProductController(ProductService productService, PostService postService) {
        this.postService = postService;
        this.productService = productService;
    }

    @PostMapping("/newpost")
    public ResponseEntity<PostDTO> createPost(@RequestBody @Valid PostDTO newPost) {
        Post createdPost = postService.createPost(newPost);

        return ResponseEntity.ok(PostDTO.convert(createdPost));
    }
}
