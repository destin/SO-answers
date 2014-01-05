package com.example.rest;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "OrderList")
public class OrderList {

	@XmlElement(name = "order", required = true)
	List<Order> orders;

	public List<Order> getOrder() {
		if (orders == null) {
			orders = new ArrayList<Order>();
		}
		return this.orders;
	}
}