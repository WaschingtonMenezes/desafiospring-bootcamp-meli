package com.desafiospringboot.Controllers;

import com.desafiospringboot.DTOs.UserSeller.UserSellerFollowedDTO;
import com.desafiospringboot.DTOs.UserSeller.UserSellerFollowersCountDTO;
import com.desafiospringboot.DTOs.UserSeller.UserSellerFollowersListDTO;
import com.desafiospringboot.Entities.UserSeller;
import com.desafiospringboot.Entities.UserClient;
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

    @PostMapping("/{userId}/unfollow/{userIdToUnfollow}")
    public void unfollow(@PathVariable int userId, @PathVariable int userIdToUnfollow){
        this.userClientService.unfollow(userId, userIdToUnfollow);
    }

    @GetMapping("/{userId}/followed/list")
    public ResponseEntity<UserSellerFollowedDTO> getSellersFollowedList(@PathVariable int userId) {
        UserClient client =  this.userClientService.findUserClientById(userId);
        return new ResponseEntity<>(UserSellerFollowedDTO.convert(client), HttpStatus.OK);
    }

    @GetMapping("/{userId}/followers/list")
    public ResponseEntity<UserSellerFollowersListDTO> getFollowersList(@PathVariable int userId) {
        UserSeller seller =  this.userSellerService.findUserSellerById(userId);
        return new ResponseEntity<>(UserSellerFollowersListDTO.convert(seller), HttpStatus.OK);
    }
}
