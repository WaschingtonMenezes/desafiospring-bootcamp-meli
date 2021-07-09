package com.desafiospringboot.Service;

import com.desafiospringboot.DTOs.UserSeller.UserSellerFollowedDTO;
import com.desafiospringboot.Entities.User;
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
	private UserClientRepository userClientRepository;
	private UserSellerRepository userSellerRepository;

	private UserSellerService userSellerService;

	@Autowired
	public UserClientService(UserClientRepository userClientRepository, UserSellerRepository userSellerRepository,
			UserSellerService userSellerService) {
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

	public void follow(int userId, int userIdToFollow) {
		UserSeller seller = userSellerService.findUserSellerById(userIdToFollow);
		UserClient client = findUserClientById(userId);

		if (client.getFollowing().indexOf(seller) != -1 || seller.getFollowers().indexOf(client) != -1) {
			throw new InvalidArgumentException(
					"Argumento inválido para essa operação: O cliente já segue o Vendedor informado.");
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
			throw new InvalidArgumentException(
					"Argumento inválido para essa operação. O cliente informado não segue o vendedor");

		seller.getFollowers().remove(indexClient);
		client.getFollowing().remove(indexSeller);

		this.userSellerRepository.save(seller);
		this.userClientRepository.save(client);
	}

	public UserSellerFollowedDTO getFollowingUsers(int userId, String order) {
		OrderEnum orderEnum = order.equalsIgnoreCase("name_asc") ? OrderEnum.ASC : OrderEnum.DESC;
		UserClient client = findUserClientById(userId);
		List<? extends User> sellers = client.getFollowing();

		SortByName.sort(sellers, orderEnum);
		
		return UserSellerFollowedDTO.convert((List<UserSeller>) sellers, client);
	}

}
