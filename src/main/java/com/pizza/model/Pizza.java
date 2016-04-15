package com.pizza.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;

/*
 * Pizza entity POJO which can have items with many to many realtionship.
 * This M-M realtionship is not really good 1-M realtionship can work 
 *but I choose m-m as JPA configuration were not allowing me to save 
 *duplicate pizza
 */
@Entity
public class Pizza {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@NotNull
	private String name;
	private float price;
	@ManyToMany(targetEntity=Item.class)
	private List<Item> items;
	
	public Pizza(){}
	
	public Pizza(String name, float price, List<Item> items) {
		this.name = name;
		this.price = price;
		this.items = items;
		items = new ArrayList<Item>();
	}

	public Pizza(String name, float price) {
		this.name = name;
		this.price = price;
		items = new ArrayList<Item>();
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

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}
	
	public void addItem(Item item){
		this.items.add(item);
	}

	@Override
	public String toString() {
		return "Pizza [name=" + name + ", price=" + price + ", items=" + items + "]";
	}

	
}
