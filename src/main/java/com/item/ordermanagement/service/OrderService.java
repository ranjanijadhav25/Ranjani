package com.item.ordermanagement.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.item.ordermanagement.model.Item;
import com.item.ordermanagement.model.Order;
import com.item.ordermanagement.repository.ItemDAO;
import com.item.ordermanagement.repository.OrderDAO;

@Service	
public class OrderService {

	@Autowired
	OrderDAO orderDAO;
	
	@Autowired
	ItemDAO itemDao;
	
	public Order placeOrders(Order order) {
		// TODO Auto-generated method stub
		Optional<Item> item=itemDao.findById(order.getItem_id());
		Integer item_qty=order.getNo_of_items();
		if(item.isPresent()) {
			Item newItem=item.get();
			newItem.setItem_quantity((newItem.getItem_quantity()-item_qty));
			
			newItem=itemDao.save(newItem);
			//return newItem;
		}

		order.setOrder_amount(item.get().getItem_price()*order.getNo_of_items());
		order=orderDAO.save(order);

		return order;
	}

	public List<Order> getAllOrders() {
		// TODO Auto-generated method stub
		
		List<Order> orders=orderDAO.findAll();
		
		
		if(orders.size() > 0)
			return orders;
		else
			return new ArrayList<Order>();
	}

}
