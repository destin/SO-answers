package org.dpytel.so.jsf;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class PizzaSearch {

	// variables in order to submit the search criteria
	private List<PizzaObject> results = new ArrayList<PizzaObject>();
	
	public PizzaSearch() {
		int counter = 0;
		results.add(new PizzaObject("Pizza A", counter++));
		results.add(new PizzaObject("Pizza B", counter++));
		results.add(new PizzaObject("Pizza C", counter++));
		results.add(new PizzaObject("Pizza D", counter++));
		results.add(new PizzaObject("Pizza E", counter++));
	}

	public List<PizzaObject> getResults() {
		return results;
	}

	public void setResults(List<PizzaObject> results) {
		this.results = results;
	}

	// methods to generate the search
	// each search result will fill/replace the list of pizza objects 'results'

	// getter and setter methods

}
