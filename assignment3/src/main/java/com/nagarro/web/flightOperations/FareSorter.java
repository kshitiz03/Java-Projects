package com.nagarro.web.flightOperations;

import java.util.Comparator;

import com.nagarro.web.model.Flight;

/**
 * Override compare function of Comparator class with own compare function
 * function according to fair.
 * 
 *
 */

public class FareSorter implements Comparator<Flight> {

	@Override
	public int compare(Flight o1, Flight o2) {
		return o1.getFare() - o2.getFare();
	}

}


