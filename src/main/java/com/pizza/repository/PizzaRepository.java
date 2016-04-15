package com.pizza.repository;

import org.springframework.data.repository.CrudRepository;

import com.pizza.model.Pizza;

public interface PizzaRepository extends CrudRepository<Pizza, Long>{
	
	public Pizza findByName(String name); 

}
