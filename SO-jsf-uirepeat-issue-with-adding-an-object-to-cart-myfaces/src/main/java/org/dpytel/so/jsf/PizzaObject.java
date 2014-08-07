package org.dpytel.so.jsf;

import java.util.ArrayList;
import java.util.List;

public class PizzaObject {
	
	private Pizza pizza;
	
	private List<Size> sizeList = new ArrayList<Size>();
	
	public PizzaObject(String name, int pizzaID) {
		super();
		this.setPizza(new Pizza(name, pizzaID));
		sizeList.add(Size.SMALL);
		sizeList.add(Size.MEDIUM);
		sizeList.add(Size.LARGE);
	}

	public Pizza getPizza() {
		return pizza;
	}

	public void setPizza(Pizza pizza) {
		this.pizza = pizza;
	}

	public List<Size> getSizeList() {
		return sizeList;
	}

	public void setSizeList(List<Size> sizeList) {
		this.sizeList = sizeList;
	}

}
