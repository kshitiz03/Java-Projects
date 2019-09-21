package com.nagarro.web.dao;


import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.nagarro.web.flightOperations.FareAndDurSorter;
import com.nagarro.web.flightOperations.FareSorter;
import com.nagarro.web.flightOperations.FindFlightsTillDate;
import com.nagarro.web.model.Flight;
import com.nagarro.web.model.FlightSearch;

@Repository("flightSearchDao")
public class FlightSearchDaoImpl extends AbstractDao<Integer, Flight> implements FlightSearchDao {

	@Override
	public List<Flight> findFlight(FlightSearch flightSearch) {
		
		Criteria criteria = getSession().createCriteria(Flight.class);
		criteria.add(Restrictions.eq("departureLoc", flightSearch.getDepartureLoc()));
		criteria.add(Restrictions.eq("arrivalLoc", flightSearch.getArrivalLoc()));
		criteria.add(Restrictions.eq("fClass", flightSearch.getfClass()));
		List<Flight> flights = criteria.list();
		
		String validTill = flightSearch.getValidTill();
		
		if (flightSearch.getfClass().equals("F"))
			Collections.sort(flights, new FareSorter());
		else
			Collections.sort(flights, new FareAndDurSorter());
		List<Flight> finalFlights = new ArrayList<>();
		Flight tillDateFlight = null;
		try {
			tillDateFlight = FindFlightsTillDate.findFlightTillDate(flights, validTill, finalFlights);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while(tillDateFlight!=null) {
			finalFlights.add(tillDateFlight);
			try {
				tillDateFlight = FindFlightsTillDate.findFlightTillDate(flights, validTill, finalFlights);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return finalFlights;
	}
}