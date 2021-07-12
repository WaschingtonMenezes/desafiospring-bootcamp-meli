package com.desafiospringboot.Service;

import com.desafiospringboot.DTOs.User.UserSellerFollowedListDTO;
import com.desafiospringboot.Entities.UserClient;
import com.desafiospringboot.Entities.UserSeller;
import com.desafiospringboot.Enum.OrderEnum;
import com.desafiospringboot.Exception.InvalidArgumentException;
import com.desafiospringboot.Exception.UserNotFoundException;
import com.desafiospringboot.Repositories.UserClientRepository;
import com.desafiospringboot.Repositories.UserSellerRepository;
import com.desafiospringboot.Utils.SortByName;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserClientService {
	private final UserClientRepository userClientRepository;
	private final UserSellerRepository userSellerRepository;
	private final UserSellerService userSellerService;

    @Autowired
    public UserClientService(UserClientRepository userClientRepository, UserSellerRepository userSellerRepository, UserSellerService userSellerService) {
        this.userClientRepository = userClientRepository;
        this.userSellerRepository = userSellerRepository;
        this.userSellerService = userSellerService;
    }

    public UserClient findUserClientById(int userId) {
        UserClient client = this.userClientRepository.findById(userId).stream().findFirst().orElse(null);

        if (client == null) {
            throw new UserNotFoundException("Cliente não encontrado");
        }

        return client;
    }

    public List<UserSeller> getFollowedUsersList(int userId) {
        UserClient client = findUserClientById(userId);

        return client.getFollowing();
    }
    
    public void follow(int userId, int userIdToFollow) {
        UserSeller seller = userSellerService.findUserSellerById(userIdToFollow);
        UserClient client = findUserClientById(userId);

        if (client.getFollowing().contains(seller) || seller.getFollowers().contains(client)) {
            throw new InvalidArgumentException("Argumento inválido para essa operação: O cliente já segue o Vendedor informado.");
        }

        seller.getFollowers().add(client);
        client.getFollowing().add(seller);

        this.userSellerRepository.save(seller);
        this.userClientRepository.save(client);
    }

    public void unfollow(int userId, int userIdToUnfollow) {
        UserSeller seller = userSellerService.findUserSellerById(userIdToUnfollow);
        UserClient client = findUserClientById(userId);

        int indexClient = seller.getFollowers().indexOf(client);
        int indexSeller = client.getFollowing().indexOf(seller);

        if (indexClient == -1 || indexSeller == -1)
        	throw new InvalidArgumentException("Argumento inválido para essa operação. O cliente informado não segue o vendedor");

        seller.getFollowers().remove(indexClient);
        client.getFollowing().remove(indexSeller);

        this.userSellerRepository.save(seller);
        this.userClientRepository.save(client);
    }

	public UserSellerFollowedListDTO getFollowedUsersDTO(int userId, String order) {
		OrderEnum orderEnum = order.equalsIgnoreCase("name_asc") ? OrderEnum.ASC : OrderEnum.DESC;
		UserClient client = findUserClientById(userId);
		List<UserSeller> sellers = client.getFollowing();

		SortByName.sort(sellers, orderEnum);

		return UserSellerFollowedListDTO.convert(sellers, client);
	}

}
