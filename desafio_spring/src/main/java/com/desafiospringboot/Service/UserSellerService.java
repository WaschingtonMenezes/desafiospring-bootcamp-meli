package com.desafiospringboot.Service;

import com.desafiospringboot.DTOs.UserSellerFollowersCountDTO;
import com.desafiospringboot.Entities.UserSeller;
import com.desafiospringboot.Exception.UserNotFoundException;
import com.desafiospringboot.Repositories.UserClientRepository;
import com.desafiospringboot.Repositories.UserSellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserSellerService {
    private UserSellerRepository userSellerRepository;

    @Autowired
    public UserSellerService(UserSellerRepository repository) {
        this.userSellerRepository = repository;
    }

    public UserSellerFollowersCountDTO countFollowers(int userId) {
        UserSeller seller = this.userSellerRepository.findById(userId).stream().findFirst().orElse(null);
        if(seller == null) {
            throw new UserNotFoundException("Vendedor não encontrado");
        }

        return UserSellerFollowersCountDTO.convert(seller);
    }
}
