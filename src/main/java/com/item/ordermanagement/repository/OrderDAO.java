package com.item.ordermanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.item.ordermanagement.model.Order;

@Repository
public interface OrderDAO extends JpaRepository<Order, Integer>{

}
