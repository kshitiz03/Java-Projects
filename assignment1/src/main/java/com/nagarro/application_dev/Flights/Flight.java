package com.nagarro.application_dev.Flights;


/**
 * Getter and Setter methods for flight details
 * 
 * @author kshitizrawat
 *
 */
public class Flight {
	String flightNo;
	String departure;
	String arrival;
	String validTill;
	String flighttime;
	float duration;
	int fare;
	String availablility;
	String fClass;

	public String getFlightNo() {
		return flightNo;
	}

	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}

	public String getDeparture() {
		return departure;
	}

	public void setDeparture(String departure) {
		this.departure = departure;
	}

	public String getArrival() {
		return arrival;
	}

	public void setArrival(String arrival) {
		this.arrival = arrival;
	}

	public String getValidTill() {
		return validTill;
	}

	public void setValidTill(String validTill) {
		this.validTill = validTill;
	}

	public String getFlighttime() {
		return flighttime;
	}

	public void setFlighttime(String flighttime) {
		this.flighttime = flighttime;
	}

	public float getDuration() {
		return duration;
	}

	public void setDuration(float duration) {
		this.duration = duration;
	}

	public int getFare() {
		return fare;
	}

	public void setFare(int fare) {
		this.fare = fare;
	}

	public String getAvailablility() {
		return availablility;
	}

	public void setAvailablility(String availablility) {
		this.availablility = availablility;
	}

	public String getfClass() {
		return fClass;
	}

	public void setfClass(String fClass) {
		this.fClass = fClass;
	}
}
