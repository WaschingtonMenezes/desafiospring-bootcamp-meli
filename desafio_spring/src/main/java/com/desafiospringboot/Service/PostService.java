package com.desafiospringboot.Service;

import com.desafiospringboot.DTOs.Post.PostDTO;
import com.desafiospringboot.DTOs.Post.PostPromoCountDTO;
import com.desafiospringboot.DTOs.Post.PostPromoDTO;
import com.desafiospringboot.DTOs.UserFollowedPostsDTO;
import com.desafiospringboot.Entities.Post;
import com.desafiospringboot.Entities.Product;
import com.desafiospringboot.Entities.UserSeller;
import com.desafiospringboot.Enum.OrderEnum;
import com.desafiospringboot.Repositories.PostRepository;
import com.desafiospringboot.Utils.SortByDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostService {
    private final PostRepository postRepository;
    private final ProductService productService;
    private final UserSellerService userSellerService;
    private final UserClientService userClientService;

    @Autowired
    PostService(PostRepository repository, ProductService productService, UserSellerService userSellerService, UserClientService userClientService) {
        postRepository = repository;
        this.productService = productService;
        this.userSellerService = userSellerService;
        this.userClientService = userClientService;
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

    public PostPromoCountDTO getPostPromoCount(int sellerId) {
        UserSeller seller = userSellerService.findUserSellerById(sellerId);
        int qnt = (int)seller.getPosts().stream().filter(post -> post.getHasPromo() != null && post.getHasPromo()).count();
        return new PostPromoCountDTO(seller.getId(), seller.getName(), qnt);
    }

    public UserFollowedPostsDTO getPostsFromFollowedUsers(int userID) {
        List<UserSeller> followedUsers = this.userClientService.getFollowedUsersList(userID);
        List<Post> followedPosts = followedUsers
                .stream()
                .map(UserSeller::getPosts)
                .flatMap(List::stream)
                .filter(post -> post.getDate().after(Date.valueOf(LocalDate.now().minusWeeks(2))))
                .collect(Collectors.toList());

        SortByDate.sort(followedPosts, OrderEnum.DESC);

        return new UserFollowedPostsDTO(userID, PostDTO.convert(followedPosts));
    }
}
