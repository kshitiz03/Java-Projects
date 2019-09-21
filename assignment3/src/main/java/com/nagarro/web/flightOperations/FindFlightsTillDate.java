package com.nagarro.web.flightOperations;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import com.nagarro.web.model.Flight;

/**
 * Class for finding flights till/User input date.
 * 
 *
 */

public class FindFlightsTillDate {
	/*
	 * Function for finding flights according to user input date.	
	 */
	public static Flight findFlightTillDate(List<Flight> flights, String fdate,
			List<Flight> finalFlights) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		Date start = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH).parse(fdate);
		for (Flight flight : flights) {
			Date end = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH).parse(flight.getValidTill());
			// System.out.println(key);
			if (start.compareTo(end) <= 0) {
				if (!finalFlights.contains(flight))
					return flight;
			}
		}
		return null;
	}

}
