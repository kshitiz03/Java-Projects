package com.nagarro.web.fileOperations;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.nagarro.web.model.Flight;

import au.com.bytecode.opencsv.CSVReader;

/**
 * Class that reads a particular CSV file and store into the allRows arraylist.
 * 
 *
 */

public class ReadFiles {
	private File path;

	public ReadFiles(File listoffiles) {
		this.path = listoffiles;
	}

	public List<Flight> fill() throws IOException {
		CSVReader reader = new CSVReader(new FileReader(path), '|', '"', 1);
		List<String[]> allRows = reader.readAll();
		List<Flight> flights = new ArrayList<>();
		for (String[] row : allRows) {
			Flight flight = new Flight();
			flight.setFlightNo(row[0]);
			flight.setDepartureLoc(row[1]);
			flight.setArrivalLoc(row[2]);
			flight.setValidTill(row[3]);
			flight.setFlightTime(Integer.parseInt(row[4]));
			flight.setFlightDur(Float.parseFloat(row[5]));
			flight.setFare(Integer.parseInt(row[6]));
			flight.setSeatAvail(row[7]);
			flight.setfClass(row[8]);
			flights.add(flight);
		}
		reader.close();
		return flights;
	}
}
