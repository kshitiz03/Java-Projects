package com.nagarro.web.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.web.model.Flight;
import com.nagarro.web.model.FlightSearch;
import com.nagarro.web.service.FlightSearchService;
import com.nagarro.web.service.FlightStoreService;

@Controller
public class FlightController {
	
	@Autowired
	FlightSearchService flightSearchService;
	
	@Autowired
	FlightStoreService flightStoreService;
	
	@RequestMapping(value = "/flightSearch", method = RequestMethod.POST)
	public ModelAndView flightsearch(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("flightSearch") FlightSearch flightSearch)
			throws InterruptedException, IOException, ParseException {
		flightStoreService.flightStore("C:\\Users\\kshitizrawat\\eclipse-workspace\\Files");
		ModelAndView mav = new ModelAndView("flightSearch");
		List<Flight> flights = flightSearchService.findFlight(flightSearch);
		mav.addObject("flights", flights);

		return mav;
	}
}
