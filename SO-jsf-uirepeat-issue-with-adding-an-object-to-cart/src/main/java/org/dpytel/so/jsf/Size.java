package org.dpytel.so.jsf;

public enum Size {
	SMALL, MEDIUM, LARGE;
	
	public int getSizeID() {
		return ordinal();
	}
	
	public String getDiameter() {
		return String.format("%d cm", getSizeID() * 10 + 20); 
	}
}
