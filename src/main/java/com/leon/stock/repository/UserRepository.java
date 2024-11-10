package com.leon.stock.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.leon.stock.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer>{

	Optional<User> findByEmail(String username);
}
