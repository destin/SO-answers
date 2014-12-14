package org.dpytel.so.jsf;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named("bean")
@RequestScoped
public class SomeBean {
	
	public String getSomething() {
		return "Something";
	}
	
	public void method1() {
		System.out.println("method1");
	}
	
	public void method2() {
		System.out.println("method2");
	}

}
