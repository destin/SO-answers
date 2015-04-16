package org.dpytel.so.jsf;

public class Time {
	
	private int hour;
	
	private int minutes;

	public Time(int hour, int minutes) {
		super();
		this.hour = hour;
		this.minutes = minutes;
	}

	public int getHour() {
		return hour;
	}

	public int getMinutes() {
		return minutes;
	}

	@Override
	public String toString() {
		return hour + ":" + minutes;
	}
	
	

}
