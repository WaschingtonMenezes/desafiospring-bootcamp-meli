package com.desafiospringboot.Repositories;

import com.desafiospringboot.Entities.UserClient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserClientRepository extends JpaRepository<UserClient, Long> {
}