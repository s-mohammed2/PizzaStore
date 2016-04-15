package com.pizza.controller;
import com.pizza.model.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.pizza.repository.CreditCardRepository;
import com.pizza.repository.ItemRepository;
import com.pizza.repository.OrdersRepository;
import com.pizza.repository.PizzaRepository;
import com.pizza.repository.UserRepository;

/*
 * This is user controller 
 * Just for creating sample data used in for testing not meant to be test 
 * restful services
 */
@RestController
public class UserController {
	
	@Autowired
	ItemRepository itemRepository;
	@Autowired
	PizzaRepository pizzaRepository;
	@Autowired
	OrdersRepository ordersRepository;
	@Autowired
	UserRepository userRepository;
	@Autowired
	CreditCardRepository creditCardRepository;

	@RequestMapping(value = "/create", method=RequestMethod.PUT)
	public String create(){
		Item thinCrust = new Item("Thin Crust", 3, Types.Bread);
		Item handTossed = new Item("Hand Tossed", 2, Types.Bread);
		Item aCheese = new Item("American Cheese", 2, Types.Cheese);
		Item mozzarella = new Item("Mozzarella", 2, Types.Cheese);
		Item chicken = new Item("Chicken", 3, Types.Meat);
		Item pepperoni = new Item("Pepperoni", 2, Types.Meat);
		Item sausage = new Item("Sausage", 4, Types.Meat);
		Item greenPeppers = new Item("Green Peppers", 0.5f, Types.Veggies);
		Item olives = new Item("Black Olives", 0.3f, Types.Veggies);
		Item onions = new Item("Onions", 1, Types.Veggies);
		Item pineapple = new Item("Pineapple", 0.9f, Types.Veggies);
		itemRepository.save(thinCrust);
		itemRepository.save(handTossed);
		itemRepository.save(aCheese);
		itemRepository.save(mozzarella);
		itemRepository.save(chicken);
		itemRepository.save(pepperoni);
		itemRepository.save(sausage);
		itemRepository.save(greenPeppers);
		itemRepository.save(olives);
		itemRepository.save(onions);
		itemRepository.save(pineapple);
		Pizza meatLovers = new Pizza("Meat Special", 12); 
		meatLovers.addItem(thinCrust);
		meatLovers.addItem(pepperoni);
		meatLovers.addItem(sausage);
		meatLovers.addItem(aCheese);
		pizzaRepository.save(meatLovers);
		Pizza cheeseSpeical = new Pizza("Cheese Special", 8);
		cheeseSpeical.addItem(itemRepository.findByName("Hand Tossed"));
		cheeseSpeical.addItem(itemRepository.findByName("Mozzarella"));
		cheeseSpeical.addItem(itemRepository.findByName("American Cheese"));
		pizzaRepository.save(cheeseSpeical);
		return "Sucess";
	}
	
}
