package com.nagarro.application_dev.showoutputs;

import java.util.List;

import com.nagarro.application_dev.Flights.Flight;

/**
 * constant setters and display required output
 * 
 * @author kshitizrawat
 *
 */
public class ShowflightDetails {
	public static String fclass1 = "EB";
	public static String choice = "Y";

	/**
	 * Display list of flights that final match all criteria and ask for more input
	 * 
	 * @param finalflights
	 */
	public static void showdetails(List<Flight> finalflights) {
		for (int k = 0; k < finalflights.size(); k++) {
			double fare = 0;
			if (fclass1.equalsIgnoreCase(finalflights.get(k).getfClass()))
				fare = finalflights.get(k).getFare() + 0.4 * finalflights.get(k).getFare();
			else
				fare = finalflights.get(k).getFare();
			if (finalflights.get(k).getAvailablility().equals(choice))
				System.out.println(finalflights.get(k).getFlightNo() + " " + fare + " "
						+ finalflights.get(k).getfClass() + " " + finalflights.get(k).getValidTill() + " "
						+ finalflights.get(k).getDuration() + " " + finalflights.get(k).getDeparture() + " "
						+ finalflights.get(k).getArrival() + " " + finalflights.get(k).getAvailablility());
		}
	}
}
