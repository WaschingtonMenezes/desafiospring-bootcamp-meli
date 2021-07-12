package com.desafiospringboot.Repositories;

import com.desafiospringboot.Entities.UserSeller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserSellerRepository extends JpaRepository<UserSeller, Integer> {
}
