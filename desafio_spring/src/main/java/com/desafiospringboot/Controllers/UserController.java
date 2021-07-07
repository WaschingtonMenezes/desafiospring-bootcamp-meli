package com.desafiospringboot.Controllers;

import com.desafiospringboot.DTOs.UserSellerFollowersCountDTO;
import com.desafiospringboot.Service.UserClientService;
import com.desafiospringboot.Service.UserSellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    private UserClientService userClientService;
    private UserSellerService userSellerService;

    @Autowired
    public UserController(UserClientService userClientService, UserSellerService userSellerService) {
        this.userClientService = userClientService;
        this.userSellerService = userSellerService;
    }

    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public void follow(@PathVariable int userId, @PathVariable int userIdToFollow) {
        this.userClientService.follow(userId, userIdToFollow);
    }

    @GetMapping("/{userId}/followers/count")
    public ResponseEntity<UserSellerFollowersCountDTO> getFollowersCount(@PathVariable int userId) {
        UserSellerFollowersCountDTO sellerDTO =  this.userSellerService.countFollowers(userId);
        return new ResponseEntity<>(sellerDTO, HttpStatus.OK);
    }
}
