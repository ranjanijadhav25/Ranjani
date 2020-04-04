package com.item.ordermanagement.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.item.ordermanagement.exception.RecordNotFoundException;
import com.item.ordermanagement.model.Item;
import com.item.ordermanagement.model.Order;
import com.item.ordermanagement.repository.ItemDAO;
import com.item.ordermanagement.service.ItemService;
import com.item.ordermanagement.service.OrderService;

@RestController
public class OrderController {

	@Autowired
	private ItemService itemService;
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	ItemDAO itemDao;
	
	@GetMapping("/")
    public ModelAndView showLoginPage(Model model) {
        model.addAttribute("message", "Welcome to Java4s Spring Boot Tutorials");

        return new ModelAndView("index");
    }
	
	@RequestMapping(path="/listofItems", produces="application/json")
	public ModelAndView getItems(Model model) {
		List<Item> item=itemService.getAllItems();
		
		model.addAttribute("items", item);
		
		   return new ModelAndView("list-item");
	}
	
    @RequestMapping(path = {"/edit", "/edit/{item_id}"})
	public ModelAndView editItemsById(Model model, @PathVariable("item_id") Optional<Long> id) throws RecordNotFoundException {
		
   
		if(id.isPresent()) {
			Item item=itemService.getItemById(id.get());
			
			model.addAttribute("item", item);
		}
		else {
			model.addAttribute("item", new Item());
		}
		return new ModelAndView("add-edit-item");
	}
	
	@RequestMapping(path="/createItem", method = RequestMethod.POST)
	public ModelAndView createItems(Item item) {
		itemService.createorupdateItem(item);
		ModelAndView model=new ModelAndView();
		model.setViewName("success");
        return model;
	}
	
	@RequestMapping(path = "/delete/{item_id}")
    public ModelAndView deleteEmployeeById(Model model, @PathVariable("item_id") Long id) 
                            throws RecordNotFoundException 
    {
		itemService.deleteEmployeeById(id);
        return new ModelAndView("deleteSuccess");
    }
	
	@RequestMapping(path="/placeorder")
	public ModelAndView placeOrder(Model model) {
		List<String> products=itemService.getAllProducts();
		model.addAttribute("itemList", products);
		model.addAttribute("order", new Order());
		return new ModelAndView("place-order");
	}
	
	@RequestMapping(path="/placeitemorder", method = RequestMethod.POST)
	public ModelAndView placeOrderForItems(Order order) {
		
		List<Item> items=itemDao.findAll();
		for(Item item:items) {
			if(item.getItem_name().equalsIgnoreCase(order.getItem_name())) {
				order.setItem_id(item.getItem_id());

				if(order.getNo_of_items() < item.getItem_quantity()) {

					orderService.placeOrders(order);
					return new ModelAndView("success-order");

				}
				else
				{

					return new ModelAndView("out-of-stock");
				}
			}

		}

		return new ModelAndView("order-failed");

		
	}
	
	@RequestMapping(path="orderList")
	public ModelAndView getAllOrders(Model model) {
		List<Order> order=orderService.getAllOrders();
		
		model.addAttribute("orders", order);
		
		   return new ModelAndView("list-orders");
	}
	
}
