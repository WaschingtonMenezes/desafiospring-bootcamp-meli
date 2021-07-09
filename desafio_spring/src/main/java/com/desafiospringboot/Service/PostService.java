package com.desafiospringboot.Service;

import com.desafiospringboot.DTOs.Post.PostDTO;
import com.desafiospringboot.DTOs.Post.PostPromoCountDTO;
import com.desafiospringboot.DTOs.Post.PostPromoDTO;
import com.desafiospringboot.DTOs.UserSeller.UserSellerPromoPostDTO;
import com.desafiospringboot.Entities.Post;
import com.desafiospringboot.Entities.Product;
import com.desafiospringboot.Entities.UserSeller;
import com.desafiospringboot.Repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    public Post createPromoPost(PostPromoDTO promoPostDTO) {
        Post post = PostPromoDTO.convert(promoPostDTO);
        UserSeller user = userSellerService.findUserSellerById(promoPostDTO.getUserId());
        Product createdProduct = productService.findOrCreateProduct(promoPostDTO.getDetail());

        post.setDetail(createdProduct);
        post.setUserSeller(user);

        return postRepository.save(post);
    }

    public UserSellerPromoPostDTO getPromoPostList(int userId) {
        UserSeller seller = userSellerService.findUserSellerById(userId);
        List<Post> list = seller.getPosts().stream().filter(post -> post.getHasPromo()).collect(Collectors.toList());
        return UserSellerPromoPostDTO.convert(seller, list);
    }
  
    public PostPromoCountDTO getPostPromoCount(int sellerId) {
        UserSeller seller = userSellerService.findUserSellerById(sellerId);
        int qnt = (int)seller.getPosts().stream().filter(post -> post.getHasPromo()).count();
        return new PostPromoCountDTO(seller.getId(), seller.getName(), qnt);
    }
}
