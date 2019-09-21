package com.nagarro.web.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nagarro.web.dao.FlightSearchDao;
import com.nagarro.web.model.Flight;
import com.nagarro.web.model.FlightSearch;

@Service("flightSearchService")
@Transactional
public class FlightSearchServiceImpl implements FlightSearchService {
	
	@Autowired
	public FlightSearchDao flightSearchDao;
	
	public List<Flight> findFlight(FlightSearch flightSearch) {
		
		
		return flightSearchDao.findFlight(flightSearch);
	}

}

