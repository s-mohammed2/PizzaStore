package com.pizza.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/*
 * Item POJO. 
 * Item is any sub item which pizza may be have example bread,cheese,veggies
 */
@Entity
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;
	private float price;
	private Types type;
	
	protected Item(){}
	
	public Item(String name, float price) {
		this.name = name;
		this.price = price;
	}
	
	public Item(String name, float price,Types type) {
		this.name = name;
		this.price = price;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getType() {
		return type.toString();
	}

	public void setType(Types type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Item [name=" + name + ", price=" + price + ", type=" + type + "]";
	}

	
}
