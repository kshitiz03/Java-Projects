package com.nagarro.application_dev.findflights;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import com.nagarro.application_dev.multithread.DataUpdate;

/**
 * finding flights for that date
 * 
 * @author kshitizrawat
 *
 */
public class FindFlightsTIllDate {

	/**
	 * string to date format conversion and comparison from required date
	 * 
	 * @param flightdate
	 * @param fdate
	 * @param dates
	 * @return
	 * @throws ParseException
	 */
	public static String findFlightTillDate(Map<String, Map<String, Integer>> flightdate, String fdate,
			List<String> dates) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		Date start = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH).parse(fdate);
		for (String key : flightdate.keySet()) {
			Date end = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH).parse(key);
			// System.out.println(key);
			if (start.compareTo(end) <= 0) {
				if (!dates.contains(key))
					return key;
			}
		}
		return null;
	}

}
