package com.desafiospringboot.Controllers;

import com.desafiospringboot.Service.UserSellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/userSellers")
public class UserSellerController {
    private UserSellerService userSellerService;

    @Autowired
    public UserSellerController(UserSellerService userSellerService) {
        this.userSellerService = userSellerService;
    }
}
