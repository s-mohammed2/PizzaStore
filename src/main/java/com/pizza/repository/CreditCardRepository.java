package com.pizza.repository;

import org.springframework.data.repository.CrudRepository;

import com.pizza.model.CreditCard;

public interface CreditCardRepository extends CrudRepository<CreditCard, Long> {
	
	public CreditCard findByNumber(String number);
}
