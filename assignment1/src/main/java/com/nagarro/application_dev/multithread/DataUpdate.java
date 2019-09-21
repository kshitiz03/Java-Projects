package com.nagarro.application_dev.multithread;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.nagarro.application_dev.Flights.DataInHashMap;
import com.nagarro.application_dev.Flights.Flight;
import com.nagarro.application_dev.Flights.SetFlights;
import com.nagarro.application_dev.assignment1.input.ReadFiles;

/*
 * Updates data by running it as a thread and reading multiple files at once
 */
public class DataUpdate extends Thread {
	public static List<Flight> flightsinfo;
	public static Map<String, Map<String, Map<String, Map<String, Integer>>>> deptLoc = new HashMap<>();

	// synchronized thread running
	synchronized public void run() {
		readFlightDataAnStore();
		snooze();
	}

	/**
	 * Sleep thread for 2 mins
	 */
	private void snooze() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Reads flight data from CSVs and create data set
	 */
	private void readFlightDataAnStore() {

		// ReadFiles.allRows = new ArrayList<>();
		while (true) {
			File folder = new File("C:\\Users\\kshitizrawat\\eclipse-workspace\\Files");
			File[] listoffiles = folder.listFiles();
			ReadFiles r = null;
			List<String[]> allRows = new ArrayList<>();
			List<String[]> fileRow = new ArrayList<>();

			for (int i = 0; i < listoffiles.length; i++) {
				r = new ReadFiles(listoffiles[i]);
				try {
					fileRow = r.fill();
					for (String[] row : fileRow)
						allRows.add(row);

				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			flightsinfo = SetFlights.setflights(allRows);
			deptLoc = DataInHashMap.InsertInHashMap(allRows);
		}
	}
}
