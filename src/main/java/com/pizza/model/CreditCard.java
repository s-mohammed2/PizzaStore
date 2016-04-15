package com.pizza.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


/*
 * Model class for credit card POJO used JPA annotations here.
 */
@Entity
@Table(name="credit_card",
uniqueConstraints=@UniqueConstraint(columnNames={"number"}))
public class CreditCard {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String number;
	private Date expiration;
	private int cvv2;

	protected CreditCard(){}
	
	public CreditCard(String number, Date expiration, int cvv2) {
		this.number = number;
		this.expiration = expiration;
		this.cvv2 = cvv2;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Date getExpiration() {
		return expiration;
	}

	public void setExpiration(Date expiration) {
		this.expiration = expiration;
	}

	public int getCvv2() {
		return cvv2;
	}

	public void setCvv2(int cvv2) {
		this.cvv2 = cvv2;
	}

	@Override
	public String toString() {
		return "CreditCard []";
	}
	
	

}
