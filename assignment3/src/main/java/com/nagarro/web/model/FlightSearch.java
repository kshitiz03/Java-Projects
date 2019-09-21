package com.nagarro.web.model;

import java.io.Serializable;
import java.sql.Date;

public class FlightSearch implements Serializable {

	private String departureLoc;

	private String arrivalLoc;

	private String validTill;

	private String fSort;

	private String fClass;

	public String getDepartureLoc() {
		return departureLoc;
	}

	public void setDepartureLoc(String departureLoc) {
		this.departureLoc = departureLoc;
	}

	public String getfSort() {
		return fSort;
	}

	public void setfSort(String fSort) {
		this.fSort = fSort;
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

	public String getfClass() {
		return fClass;
	}

	public void setfClass(String fClass) {
		this.fClass = fClass;
	}

}
