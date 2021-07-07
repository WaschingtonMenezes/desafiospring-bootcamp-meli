package com.desafiospringboot.Service;


import com.desafiospringboot.Repositories.UserClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserClientService {
    private UserClientRepository userClientRepository;

    @Autowired
    public UserClientService(UserClientRepository userClientRepository) {
        this.userClientRepository = userClientRepository;
    }
}
