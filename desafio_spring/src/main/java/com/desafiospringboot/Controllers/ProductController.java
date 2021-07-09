package com.desafiospringboot.Controllers;

import com.desafiospringboot.DTOs.Post.PostDTO;
import com.desafiospringboot.DTOs.Post.PostPromoCountDTO;
import com.desafiospringboot.DTOs.Post.PostPromoDTO;
import com.desafiospringboot.DTOs.UserSeller.UserSellerPromoPostDTO;
import com.desafiospringboot.DTOs.UserSeller.UserSellerFollowedDTO;
import com.desafiospringboot.Entities.Post;
import com.desafiospringboot.Entities.UserClient;
import com.desafiospringboot.Service.PostService;
import com.desafiospringboot.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @PostMapping("/newpromopost")
    public ResponseEntity<PostPromoDTO> createPromoPost(@RequestBody @Valid PostPromoDTO newPost) {
        Post createdPost = postService.createPromoPost(newPost);
        return ResponseEntity.ok(PostPromoDTO.convert(createdPost));
    }

    @GetMapping("/{userId}/list/")
    public ResponseEntity<UserSellerPromoPostDTO> getPromoPostList(@PathVariable int userId) {
        UserSellerPromoPostDTO sellerPromoPosts = postService.getPromoPostList(userId);
        return ResponseEntity.ok(sellerPromoPosts);

      @GetMapping("/{userId}/countPromo")
    public ResponseEntity<PostPromoCountDTO> getPostPromo(@PathVariable int userId) {
        PostPromoCountDTO promo =  this.postService.getPostPromoCount(userId);
        return new ResponseEntity<>(promo, HttpStatus.OK);
    }
}
