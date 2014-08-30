package org.dpytel.so.jsf;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@SessionScoped
@Named("bean")
public class A implements Serializable {
	public String getMyClass() {
		return this.getClass().getCanonicalName();
	}
}
