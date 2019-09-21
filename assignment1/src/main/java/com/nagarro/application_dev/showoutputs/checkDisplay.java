package com.nagarro.application_dev.showoutputs;

import java.util.List;

import com.nagarro.application_dev.Services.SortingPrefrence;
import com.nagarro.application_dev.findflights.FindFlights;

public class checkDisplay {

	/*
	 * accessing resultant list of flights and sorting them as per preference
	 * checking availability
	 */
	public void checkForDisplay(String deptcity, String arrcity, String date, List<String> dates,
			List<Integer> allflights, String fclass) {
		FindFlights.findflightdateandclass(deptcity, arrcity, date, dates, allflights, fclass);

		if (allflights.size() != 0) {
			ShowflightDetails.showdetails(SortingPrefrence.Sorting(allflights));
		} else {
			System.out.println("No flights available");
		}
	}

}
