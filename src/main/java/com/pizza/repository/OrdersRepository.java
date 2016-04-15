package com.pizza.repository;

import org.springframework.data.repository.CrudRepository;

import com.pizza.model.Orders;

public interface OrdersRepository extends CrudRepository<Orders, Long> {

}
