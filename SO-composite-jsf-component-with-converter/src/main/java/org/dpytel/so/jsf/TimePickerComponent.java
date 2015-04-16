package org.dpytel.so.jsf;

import java.io.IOException;

import javax.faces.component.FacesComponent;
import javax.faces.component.NamingContainer;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.component.UINamingContainer;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;

@FacesComponent("timePickerComponent")
public class TimePickerComponent extends UIInput implements NamingContainer {
	
	private String hour;
	
	private String minutes;
	
	@Override
    public String getFamily() {
        return UINamingContainer.COMPONENT_FAMILY;
    }
	
	@Override
	public void encodeBegin(FacesContext context) throws IOException {
		super.encodeBegin(context);
	}
	
	@Override
	public Object getSubmittedValue() {
		UIInput hourComp = (UIInput) findComponent("timepicker_hour");
		UIInput minutesComp = (UIInput) findComponent("timepicker_minutes");
		return hourComp.getSubmittedValue() + ":" + minutesComp.getSubmittedValue();
	}
	
	@Override
	protected Object getConvertedValue(FacesContext context,
			Object newSubmittedValue) throws ConverterException {
		Converter converter = (Converter) getAttributes().get("converter");
		if (converter != null) {
			return converter.getAsObject(context, this, (String) newSubmittedValue);
		} else {
			return newSubmittedValue;
		}
	}

	public String getHour() {
		return hour;
	}

	public void setHour(String hour) {
		this.hour = hour;
	}

	public String getMinutes() {
		return minutes;
	}

	public void setMinutes(String minutes) {
		this.minutes = minutes;
	}
}
