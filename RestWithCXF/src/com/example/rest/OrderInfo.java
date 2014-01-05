package com.example.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("/Order/")
public interface OrderInfo {

	@GET
	@Produces("application/xml")
	@Path("{orderId}")
	public Order getOrder(@PathParam("orderId") int officeId);

	@GET
	@Produces("application/xml")
	@Path("All")
	public OrderList getAllOrders();

}