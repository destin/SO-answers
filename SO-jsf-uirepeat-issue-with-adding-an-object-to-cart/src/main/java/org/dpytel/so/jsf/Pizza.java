package org.dpytel.so.jsf;

public class Pizza {
	
	private String name;
	
	private int pizzaID;

	public Pizza(String name, int pizzaID) {
		super();
		this.name = name;
		this.pizzaID = pizzaID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPizzaID() {
		return pizzaID;
	}

	public void setPizzaID(int pizzaID) {
		this.pizzaID = pizzaID;
	}

}
