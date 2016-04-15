package com.pizza.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/*
 * User entity POJO this have relationship with orders and credit card.
 */
@Entity
@Table(name="User",
      uniqueConstraints=@UniqueConstraint(columnNames={"email"}))
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;
	private String email;
	private String phone;
	@ManyToMany(targetEntity=CreditCard.class)
	private List<CreditCard> creditCards;
	
	public User(){}
	
	public User(String email){
		this.email = email;
	}

	public User(String name, String email, String phone) {
		this.name = name;
		this.email = email;
		this.phone = phone;
		creditCards = new ArrayList<CreditCard>();
	}

	public User(String name, String email, String phone, List<CreditCard> creditCards) {
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.creditCards = creditCards;
		creditCards = new ArrayList<CreditCard>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public List<CreditCard> getCreditCards() {
		return creditCards;
	}

	public void setCreditCards(List<CreditCard> creditCards) {
		this.creditCards = creditCards;
	}
	
	public void setCreditCards(CreditCard creditCards) {
		this.creditCards.add(creditCards);
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", email=" + email + ", phone=" + phone + "]";
	}
	
}