package com.desafiospringboot.Controllers;

import com.desafiospringboot.Service.UserClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/userClients")
public class UserClient {
    private UserClientService userClientService;

    @Autowired
    public UserClient(UserClientService userClientService) {
        this.userClientService = userClientService;
    }
}
