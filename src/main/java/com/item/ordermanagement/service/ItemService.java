package com.item.ordermanagement.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.item.ordermanagement.exception.RecordNotFoundException;
import com.item.ordermanagement.model.Item;
import com.item.ordermanagement.repository.ItemDAO;

@Service	
public class ItemService {

	@Autowired
	ItemDAO itemDao;
	
	
	
	public List<Item> getAllItems(){
		
		List<Item> itemList=itemDao.findAll();
		
		if(itemList.size() > 0) {
			return itemList;
		}
		else
			return new ArrayList<Item>();
	}

	public Item createorupdateItem(Item item) {
		// TODO Auto-generated method stub
		if(item.getItem_id() == null) {
			item=itemDao.save(item);
			return item;
		}
		else
		{
			Optional<Item> itementity=itemDao.findById(item.getItem_id());
			
			if(itementity.isPresent()) {
				Item newItem=itementity.get();
				newItem.setItem_name(item.getItem_name());
				newItem.setItem_desc(item.getItem_desc());
				newItem.setItem_quantity(item.getItem_quantity());
				newItem.setItem_price(item.getItem_price());
				
				newItem=itemDao.save(newItem);
				return newItem;
			}
			else {
				item=itemDao.save(item);
				
				return item;
			}
			
		}
	}

	public Item getItemById(Long item_id) {
		// TODO Auto-generated method stub
		
		Optional<Item> item=itemDao.findById(item_id);
		
		if(item.isPresent())
			return item.get();
		else
			throw new RecordNotFoundException("No Item record exist for given item_id");
		
	}

	public void deleteEmployeeById(Long id) {
		// TODO Auto-generated method stub
		Optional<Item> item=itemDao.findById(id);
		if(item.isPresent())
			itemDao.deleteById(id);
		else
			throw new RecordNotFoundException("No Item record exist for given item_id");

		

	}

	public List<String> getAllProducts() {
		// TODO Auto-generated method stub
		
		List<Item> items=itemDao.findAll();
		List<String> products=new ArrayList<>();
		
		if(items.size()>0) {
			for(Item item:items) {
				products.add(item.getItem_name());
			}
			if(products.size()>0)
				return products;
			
			else
				return new ArrayList<String>();
			
		  }
		else 
		    {
		    	return new ArrayList<String>();
		    }
	}
	
}
