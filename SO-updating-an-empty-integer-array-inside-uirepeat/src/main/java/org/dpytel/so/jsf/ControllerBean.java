package org.dpytel.so.jsf;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;

@ManagedBean(name="controllerBean")
@RequestScoped
public class ControllerBean implements Serializable {
	
	private Schedule schedule;

	public ControllerBean() {
		setSchedule(new Schedule());
	}
	
	public void save() {
		System.out.println("Schedule: " + Arrays.toString(schedule.getScheduleTimes()));
	}

	public Schedule getSchedule() {
		return schedule;
	}

	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}
	
}
