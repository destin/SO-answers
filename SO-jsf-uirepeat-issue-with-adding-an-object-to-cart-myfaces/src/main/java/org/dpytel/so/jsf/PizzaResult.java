package org.dpytel.so.jsf;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class PizzaResult {

	// injection of PizzaSearch
	@ManagedProperty(value = "#{pizzaSearch}")
	private PizzaSearch pizzaSearch;

	// variables
	private List<PizzaObject> results;
	private int _chosenSize;
	private int _chosenQuantity;

	@PostConstruct
	public void initResults() {
		this.setResults(getPizzaSearch().getResults());
	}

	// method to add the pizza object to the cart
	// a simple text output for testings
	public void addToCart(int chosenPizzaID) {
		System.out.println("chosen pizza ID: " + chosenPizzaID);
		System.out.println("chosen size:     " + getChosenSize());
		System.out.println("chosen quantity: " + getChosenQuantity());
	}

	public PizzaSearch getPizzaSearch() {
		return pizzaSearch;
	}

	public void setPizzaSearch(PizzaSearch pizzaSearch) {
		this.pizzaSearch = pizzaSearch;
	}

	public List<PizzaObject> getResults() {
		if (results == null) {
			initResults();
		}
		return results;
	}

	public void setResults(List<PizzaObject> results) {
		this.results = results;
	}

	public int getChosenSize() {
		return _chosenSize;
	}

	public void setChosenSize(int _chosenSize) {
		this._chosenSize = _chosenSize;
	}

	public int getChosenQuantity() {
		return _chosenQuantity;
	}

	public void setChosenQuantity(int _chosenQuantity) {
		this._chosenQuantity = _chosenQuantity;
	}

	// getter and setter methods
}
