package com.desafiospringboot.Controllers;

import com.desafiospringboot.Service.UserClientService;
import com.desafiospringboot.Service.UserSellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
