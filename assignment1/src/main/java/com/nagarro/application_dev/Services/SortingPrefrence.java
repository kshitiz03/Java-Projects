package com.nagarro.application_dev.Services;

import java.util.*;

import com.nagarro.application_dev.Flights.Flight;
import com.nagarro.application_dev.multithread.DataUpdate;

/**
 * input sorting preference from user
 * 
 * @author kshitizrawat
 *
 */
public class SortingPrefrence {

	/**
	 * input from user for output preference
	 * 
	 * @param allflights
	 * @return sorted list as per preference from user
	 */
	public static List<Flight> Sorting(List<Integer> allflights) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter sorting prefrences\nF: By fare\nB: Both by fare and duration");
		String outputPrefrences = sc.next();
		// sc.close();
		List<Flight> finalflights = new ArrayList<>();
		for (int k = 0; k < allflights.size(); k++) {

			// list of final flights list
			finalflights.add(DataUpdate.flightsinfo.get(allflights.get(k)));
		}
		// setting comparator to sort as per user preference among 2 options
		Comparator<Flight> comparator = null;
		switch (outputPrefrences.toUpperCase()) {
		case "F":
			comparator = (flightClass1, flightClass2) -> (int) (flightClass1.getFare() - flightClass2.getFare());
			break;

		case "B":
			comparator = (flightClass1, flightsClass2) -> {
				if (flightClass1.getFare() - flightsClass2.getFare() > 0) {
					return (int) (flightClass1.getFare() - flightsClass2.getFare());
				} else if (flightClass1.getFare() - flightsClass2.getFare() < 0)
					return (int) (flightClass1.getFare() - flightsClass2.getFare());

				else {
					if (flightClass1.getDuration() - flightsClass2.getDuration() >= 0)
						return 1;
					else
						return -1;
				}
			};
			break;
		}
		Collections.sort(finalflights, comparator);
		return finalflights;
	}
}
