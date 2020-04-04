package com.item.ordermanagement.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Email;

import org.hibernate.dialect.SQLServer2012Dialect;

@Entity
@Table(name="ORDERS")
public class Order extends SQLServer2012Dialect implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "seq")
	@SequenceGenerator(name="seq", sequenceName = "order_seq")
	@Column(name = "order_id", updatable = false, nullable = false)
	private Integer order_id=0;
	
	@Column	
	private Long item_id;
	
	@Column
	private String item_name;
	
	@Column
	private Integer no_of_items;
	
	@Column
	private String email_id;
	
	@Column
	private Double order_amount;
	
	public Order() {
		super();
	}
	
	
	public Order(Integer order_id, Long item_id, String item_name, Integer no_of_items, String email_id,
			Double order_amount) {
		super();
		this.order_id = order_id;
		this.item_id = item_id;
		this.item_name = item_name;
		this.no_of_items = no_of_items;
		this.email_id = email_id;
		this.order_amount = order_amount;
	}


	/**
	 * @return the order_amount
	 */
	public Double getOrder_amount() {
		return order_amount;
	}


	/**
	 * @param order_amount the order_amount to set
	 */
	public void setOrder_amount(Double order_amount) {
		this.order_amount = order_amount;
	}


	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
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
	public Integer getNo_of_items() {
		return no_of_items;
	}
	public void setNo_of_items(Integer no_of_items) {
		this.no_of_items = no_of_items;
	}
	public String getEmail_id() {
		return email_id;
	}
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	@Override
	public String toString() {
		return "Order [order_id=" + order_id + ", item_id=" + item_id + ", item_name=" + item_name + ", no_of_items="
				+ no_of_items + ", email_id=" + email_id + "]";
	}
	
	
	
}
