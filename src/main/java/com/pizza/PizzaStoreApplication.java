package com.pizza;

import java.util.Date;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.pizza.repository.CreditCardRepository;
import com.pizza.repository.ItemRepository;
import com.pizza.repository.PizzaRepository;
import com.pizza.repository.UserRepository;
import com.pizza.model.CreditCard;
import com.pizza.model.Item;
import com.pizza.model.Pizza;
import com.pizza.model.Types;
import com.pizza.model.User;

@SpringBootApplication
public class PizzaStoreApplication {

	/*
	 * Start of the application starts with this main method
	 */
	public static void main(String[] args) {
		SpringApplication.run(PizzaStoreApplication.class, args);
	}
	
	
	/*
	 * This bean is configured to create sample database that can be present in the 
	 * database to test or use application. more sample data is written in 
	 * UserController hence its is recommended to run that first. 
	 */
	@Bean
	public CommandLineRunner demo(ItemRepository itemRepository,
			UserRepository userRepository,PizzaRepository pizzaRepository,
			CreditCardRepository creditCardRepository) {
		return (args) -> {
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
			cheeseSpeical.addItem(handTossed);
			cheeseSpeical.addItem(mozzarella);
			cheeseSpeical.addItem(aCheese);
			pizzaRepository.save(cheeseSpeical);
			User adam = new User("Adam", "msalman89@yahoo.com.in", "848-478-9557" );
			User ravi = new User("Ravi", "Brian@pizzabyte.com", "123-456-7890");
			User arshad = new User("Arshad", "Khan@pizzabyte.com", "309-361-7299"); 
			CreditCard arshadC = new CreditCard("01234567890123456", new Date(), 748);
			creditCardRepository.save(arshadC);
			CreditCard adamCard = new CreditCard("01234548790123456", new Date(), 478);
			creditCardRepository.save(adamCard);
			adam.setCreditCards(adamCard);
			CreditCard adamCard2 = new CreditCard("01234784890123456", new Date(), 408);
			creditCardRepository.save(adamCard2);
			userRepository.save(adam);
			adam.setCreditCards(adamCard2);
			userRepository.save(adam);
			CreditCard raviC= new CreditCard("01234567890127846", new Date(), 874);
			creditCardRepository.save(raviC);
			userRepository.save(ravi);
			arshad.setCreditCards(arshadC);
			userRepository.save(arshad);
		};
	}
}
