package com.example.rest;

import java.util.ArrayList;
import java.util.List;

public class OrderInfoImpl implements OrderInfo {

	List<Order> list = new ArrayList<Order>();

	OrderInfoImpl() {
		Order order = new Order();
		order.setOrderId(1);
		order.setItemName("Soap");
		order.setQuantity(120);
		order.setCustomerName("Sandeep");
		order.setShippingAddress("Gurgaon");
		list.add(0, order);

		order.setOrderId(2);
		order.setItemName("Shampoo");
		order.setQuantity(50);
		order.setCustomerName("Sandeep");
		order.setShippingAddress("Gurgaon");
		list.add(1, order);
	}

	@Override
	public Order getOrder(int orderId) {
		System.out.println("Inside the GetOrder...");
		if (list.get(0).getOrderId() == orderId) {
			return list.get(0);
		} else if (list.get(1).getOrderId() == orderId) {
			return list.get(1);
		} else {
			return null;
		}
	}

	@Override
	public OrderList getAllOrders() {
		OrderList details = new OrderList();
		for (Order order : list) {
			details.getOrder().add(order);
		}
		return details;
	}
}