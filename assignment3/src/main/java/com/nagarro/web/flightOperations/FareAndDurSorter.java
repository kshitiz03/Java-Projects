package com.nagarro.web.flightOperations;

import java.util.Comparator;

import com.nagarro.web.model.Flight;

/**
 * Override compare function of Comparator class with own compare function
 * function according to fair and duration.
 * 
 *
 */

public class FareAndDurSorter implements Comparator<Flight> {

	@Override
	public int compare(Flight o1, Flight o2) {
		if (o1.getFare() - o2.getFare() == 0)
			return (int) (o1.getFlightDur() - o2.getFlightDur());
		return o1.getFare() - o2.getFare();
	}

}
