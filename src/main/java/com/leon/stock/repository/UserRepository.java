package com.leon.stock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.leon.stock.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer>{

	  User findByEmail(String username);
}
