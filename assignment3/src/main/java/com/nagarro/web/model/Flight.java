package com.nagarro.web.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "flights")
public class Flight {
	@Id
	@Column(name = "flightId")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int flightId;

	@Column(name = "flightNo")
	private String flightNo;
	
	@Column(name = "departureLoc")
	private String departureLoc;

	@Column(name = "arrivalLoc")
	private String arrivalLoc;

	@Column(name = "validTill")
	private String validTill;

	@Column(name = "flightTime")
	private int flightTime;

	@Column(name = "flightDur")
	private double flightDur;

	@Column(name = "fare")
	private int fare;

	@Column(name = "seatAvail")
	private String seatAvail;

	@Column(name = "fClass")
	private String fClass;

	public int getFlightId() {
		return flightId;
	}

	public String getFlightNo() {
		return flightNo;
	}

	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}
	
	public String getDepartureLoc() {
		return departureLoc;
	}

	public void setDepartureLoc(String departureLoc) {
		this.departureLoc = departureLoc;
	}

	public String getArrivalLoc() {
		return arrivalLoc;
	}

	public void setArrivalLoc(String arrivalLoc) {
		this.arrivalLoc = arrivalLoc;
	}

	public String getValidTill() {
		return validTill;
	}

	public void setValidTill(String validTill) {
		this.validTill = validTill;
	}

	public int getFlightTime() {
		return flightTime;
	}

	public void setFlightTime(int flightTime) {
		this.flightTime = flightTime;
	}

	public double getFlightDur() {
		return flightDur;
	}

	public void setFlightDur(double flightDur) {
		this.flightDur = flightDur;
	}

	public int getFare() {
		return fare;
	}

	public void setFare(int fare) {
		this.fare = fare;
	}

	public String getSeatAvail() {
		return seatAvail;
	}

	public void setSeatAvail(String seatAvail) {
		this.seatAvail = seatAvail;
	}

	public String getfClass() {
		return fClass;
	}

	public void setfClass(String fClass) {
		this.fClass = fClass;
	}
	
}