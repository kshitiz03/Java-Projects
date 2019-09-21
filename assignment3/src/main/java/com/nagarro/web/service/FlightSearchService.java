package com.nagarro.web.service;

import java.util.List;

import com.nagarro.web.model.Flight;
import com.nagarro.web.model.FlightSearch;

public interface FlightSearchService {
		List<Flight> findFlight(FlightSearch flightSearch);
}
