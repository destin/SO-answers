package org.dpytel.so.jsf;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named("someBean")
@RequestScoped
public class SomeBean {
	
	private Time timeLocal;
	
	public String getSomething() {
		return "Something";
	}

	public Time getTimeLocal() {
		return timeLocal;
	}

	public void setTimeLocal(Time timeLocal) {
		this.timeLocal = timeLocal;
	}
	
	public String submit() {
		System.out.println(timeLocal);
		return null;
	}

}
