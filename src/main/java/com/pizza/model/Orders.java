package com.pizza.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/*
 * Orders entity POJO, used to store orders 
 * in database with pizza's,user and credit 
 * card.
 */
@Entity
public class Orders {

		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private long id;
		@OneToMany(targetEntity=Pizza.class)
		private List<Pizza> pizzaList;
		@OneToOne
		private User user;
		@OneToOne
		private CreditCard creditCard;
		
		public Orders(){
			pizzaList = new ArrayList<Pizza>();
		}
		
		public Orders(List<Pizza> pizzaList, User user, CreditCard creditCard) {
			this.pizzaList = pizzaList;
			this.user = user;
			this.creditCard = creditCard;
			pizzaList = new ArrayList<Pizza>();
		}

		public List<Pizza> getPizzaList() {
			return pizzaList;
		}

		public void setPizzaList(List<Pizza> pizzaList) {
			this.pizzaList = pizzaList;
		}
		
		public void setPizza(Pizza pizza) {
			this.pizzaList.add(pizza);
		}

		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}

		public CreditCard getCreditCard() {
			return creditCard;
		}

		public void setCreditCard(CreditCard creditCard) {
			this.creditCard = creditCard;
		}

		@Override
		public String toString() {
			return "Orders [pizzaList=" + pizzaList + ", user=" + user + ", creditCard=" + creditCard + "]";
		}
}
