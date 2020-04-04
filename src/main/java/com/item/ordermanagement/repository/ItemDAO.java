package com.item.ordermanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.item.ordermanagement.model.Item;

@Repository
public interface ItemDAO extends JpaRepository<Item, Long>{

}
