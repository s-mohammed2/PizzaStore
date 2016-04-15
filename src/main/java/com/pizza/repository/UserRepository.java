package com.pizza.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import com.pizza.model.User;

public interface UserRepository extends CrudRepository<User, Long>{
		
	List<User> findByName(String name);
	User findByEmail(String email);
	
	
}
