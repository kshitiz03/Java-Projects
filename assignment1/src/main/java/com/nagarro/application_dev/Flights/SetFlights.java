package com.nagarro.application_dev.Flights;

import java.util.ArrayList;
import java.util.List;

import com.nagarro.application_dev.assignment1.input.ReadFiles;

public class SetFlights {

	/**
	 * set all details of flights in list and adding to final list
	 * 
	 * @param allRows
	 * @return
	 */
	public static List<Flight> setflights(List<String[]> allRows) {
		List<Flight> flightsInfo = new ArrayList<>();

		for (String[] row : allRows) {
			Flight flight = new Flight();
			flight.setFlightNo(row[0]);
			flight.setDeparture(row[1]);
			flight.setArrival(row[2]);
			flight.setValidTill(row[3]);
			flight.setFlighttime(row[4]);
			flight.setDuration(Float.parseFloat(row[5]));
			flight.setFare(Integer.parseInt(row[6]));
			flight.setAvailablility(row[7]);
			flight.setfClass(row[8]);
			flightsInfo.add(flight);
		}
		return flightsInfo;
	}
}
