package com.desafiospringboot.Service;

import com.desafiospringboot.DTOs.PostDTO;
import com.desafiospringboot.Entities.Post;
import com.desafiospringboot.Entities.Product;
import com.desafiospringboot.Entities.UserSeller;
import com.desafiospringboot.Repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {
    private PostRepository postRepository;
    private ProductService productService;
    private UserSellerService userSellerService;

    @Autowired
    PostService(PostRepository repository, ProductService productService, UserSellerService userSellerService) {
        postRepository = repository;
        this.productService = productService;
        this.userSellerService = userSellerService;
    }

    public Post createPost(PostDTO postDTO) {
        Post post = PostDTO.convert(postDTO);
        UserSeller user = userSellerService.findUserSellerById(postDTO.getUserId());
        Product createdProduct = productService.findOrCreateProduct(postDTO.getDetail());

        post.setDetail(createdProduct);
        post.setUserSeller(user);

        return postRepository.save(post);
    }
}
