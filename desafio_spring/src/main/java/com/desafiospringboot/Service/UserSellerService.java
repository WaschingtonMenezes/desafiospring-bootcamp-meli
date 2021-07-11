package com.desafiospringboot.Service;

import com.desafiospringboot.DTOs.User.UserSellerFollowersCountDTO;
import com.desafiospringboot.DTOs.User.UserSellerFollowersListDTO;
import com.desafiospringboot.Entities.UserClient;
import com.desafiospringboot.Entities.UserSeller;
import com.desafiospringboot.Enum.OrderEnum;
import com.desafiospringboot.Exception.UserNotFoundException;
import com.desafiospringboot.Repositories.UserSellerRepository;
import com.desafiospringboot.Utils.SortByName;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserSellerService {
    private final UserSellerRepository userSellerRepository;

    @Autowired
    public UserSellerService(UserSellerRepository repository) {
        this.userSellerRepository = repository;
    }

    public UserSellerFollowersCountDTO countFollowers(int userId) {
        UserSeller seller = findUserSellerById(userId);
        return UserSellerFollowersCountDTO.convert(seller);
    }

    public UserSeller findUserSellerById(int userId) {
        UserSeller seller = this.userSellerRepository.findById(userId).stream().findFirst().orElse(null);
        if (seller == null) {
            throw new UserNotFoundException("Vendedor não encontrado");
        }
        return seller;
    }
      
    public UserSellerFollowersListDTO getFollowersUsers(int userId, String order) {
		OrderEnum orderEnum = order.equalsIgnoreCase("name_asc") ? OrderEnum.ASC : OrderEnum.DESC;
		UserSeller seller = findUserSellerById(userId);
		List<? extends User> clients = seller.getFollowers();

		SortByName.sort(clients, orderEnum);
		
		return UserSellerFollowersListDTO.convert((List<UserClient>) clients, seller);
	}
}
