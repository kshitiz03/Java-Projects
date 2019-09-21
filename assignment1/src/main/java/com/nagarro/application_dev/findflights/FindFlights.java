package com.nagarro.application_dev.findflights;

import java.text.ParseException;
import java.util.List;

import com.nagarro.application_dev.multithread.DataUpdate;

/**
 * find list of flights that satisfy user criteria
 * 
 * @author kshitizrawat
 *
 */
public class FindFlights {

	/**
	 * find all flights as per user input from complete storage
	 * 
	 * @param deptcity
	 * @param arrcity
	 * @param date
	 * @param dates
	 * @param allflights
	 * @param fclass
	 */
	public static void findflightdateandclass(String deptcity, String arrcity, String date, List<String> dates,
			List<Integer> allflights, String fclass) {
		String todate = null;
		try {
			// considering valid till dates to get list of all satisfying dates
			todate = FindFlightsTIllDate.findFlightTillDate(DataUpdate.deptLoc.get(deptcity).get(arrcity), date, dates);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while (todate != null) {
			try {
				todate = FindFlightsTIllDate.findFlightTillDate(DataUpdate.deptLoc.get(deptcity).get(arrcity), date,
						dates);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// dates consist list of all dates valid for that entry
			// allflights contains index of required fields
			dates.add(todate);
			if (DataUpdate.deptLoc.get(deptcity).get(arrcity).containsKey(todate)) {
				if (DataUpdate.deptLoc.get(deptcity).get(arrcity).get(todate).containsKey(fclass)) {
					allflights.add(DataUpdate.deptLoc.get(deptcity).get(arrcity).get(todate).get(fclass));
				}
			}
		}
	}
}
