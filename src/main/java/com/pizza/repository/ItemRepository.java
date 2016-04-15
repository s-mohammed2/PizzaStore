package com.pizza.repository;

import org.springframework.data.repository.CrudRepository;

import com.pizza.model.Item;

public interface ItemRepository extends CrudRepository<Item, Long>{
	
	Item findByName(String name);

}
