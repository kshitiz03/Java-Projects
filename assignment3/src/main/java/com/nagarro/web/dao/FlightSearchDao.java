package com.nagarro.web.dao;

import java.util.List;

import com.nagarro.web.model.Flight;
import com.nagarro.web.model.FlightSearch;

public interface FlightSearchDao {
	List<Flight> findFlight(FlightSearch flightSearch);
}
