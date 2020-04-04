package com.item.ordermanagement.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ITEM")
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long item_id;
	
	@Column
	private String item_name;
	
	@Column
	private String item_desc;
	
	@Column
	private Integer item_quantity;
	
	@Column
	private double item_price;
	
	
	public Item() {
		super();
	}
	
	public Item(Long item_id, String item_name, String item_desc, Integer item_quantity, double item_price) {
		super();
		this.item_id = item_id;
		this.item_name = item_name;
		this.item_desc = item_desc;
		this.item_quantity = item_quantity;
		this.item_price = item_price;
	}
	public Long getItem_id() {
		return item_id;
	}
	public void setItem_id(Long item_id) {
		this.item_id = item_id;
	}
	public String getItem_name() {
		return item_name;
	}
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}
	public String getItem_desc() {
		return item_desc;
	}
	public void setItem_desc(String item_desc) {
		this.item_desc = item_desc;
	}
	public Integer getItem_quantity() {
		return item_quantity;
	}
	public void setItem_quantity(Integer item_quantity) {
		this.item_quantity = item_quantity;
	}
	public double getItem_price() {
		return item_price;
	}
	public void setItem_price(double item_price) {
		this.item_price = item_price;
	}

	@Override
	public String toString() {
		return "Item [item_id=" + item_id + ", item_name=" + item_name + ", item_desc=" + item_desc + ", item_quantity="
				+ item_quantity + ", item_price=" + item_price + "]";
	}
	
	
}
