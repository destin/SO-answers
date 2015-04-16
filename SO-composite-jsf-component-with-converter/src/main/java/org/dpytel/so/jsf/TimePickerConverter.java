package org.dpytel.so.jsf;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Named;

@Named
@ApplicationScoped
public class TimePickerConverter implements Converter, Serializable {

	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		String[] values = value.split(":");
		return new Time(Integer.parseInt(values[0]), Integer.parseInt(values[1]));
	}

	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		// TODO Auto-generated method stub
		return null;
	}

}
