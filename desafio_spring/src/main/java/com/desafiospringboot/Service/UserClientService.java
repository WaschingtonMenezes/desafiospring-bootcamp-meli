package com.desafiospringboot.Service;


import com.desafiospringboot.Entities.UserClient;
import com.desafiospringboot.Entities.UserSeller;
import com.desafiospringboot.Exception.UserNotFoundException;
import com.desafiospringboot.Repositories.UserClientRepository;
import com.desafiospringboot.Repositories.UserSellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserClientService {
    private UserClientRepository userClientRepository;
    private UserSellerRepository userSellerRepository;

    @Autowired
    public UserClientService(UserClientRepository userClientRepository, UserSellerRepository userSellerRepository) {
        this.userClientRepository = userClientRepository;
        this.userSellerRepository = userSellerRepository;
    }
    
    public void follow(int userId, int userIdToFollow) {
        UserClient client = this.userClientRepository.findById(userId).stream().findFirst().orElse(null);
        UserSeller seller = this.userSellerRepository.findById(userIdToFollow).stream().findFirst().orElse(null);
        if (client == null) {
            throw new UserNotFoundException("Cliente não encontrado");
        }
        if (seller == null) {
            throw new UserNotFoundException("Vendedor não encontrado");
        }
        seller.getFollowers().add(client);
        client.getFollowing().add(seller);
        this.userSellerRepository.save(seller);
        this.userClientRepository.save(client);
    }
}
