package com.nagarro.application_dev.Flights;

import java.util.*;


/**
 * Structuring and filling hashmap
 * 
 * @author kshitizrawat
 *
 */
public class DataInHashMap {

	/**
	 * Structuring and filling hashmap at each level
	 * 
	 * @param allRows
	 * @return
	 */
	public static Map<String, Map<String, Map<String, Map<String, Integer>>>> InsertInHashMap(List<String[]> allRows) {
		int i = 0;
		Map<String, Integer> flightclass = null;
		Map<String, Map<String, Integer>> flightdate = null;
		Map<String, Map<String, Map<String, Integer>>> arrivalLoc = null;
		Map<String, Map<String, Map<String, Map<String, Integer>>>> deptLoc = new HashMap<>();
		for (String[] row : allRows) {
			if (!deptLoc.containsKey(row[1])) {
				arrivalLoc = new HashMap<>();
				deptLoc.put(row[1], arrivalLoc);
			}
			if (!deptLoc.get(row[1]).containsKey(row[2])) {
				flightdate = new HashMap<>();
				deptLoc.get(row[1]).put(row[2], flightdate);
			}
			if (!deptLoc.get(row[1]).get(row[2]).containsKey(row[3])) {
				flightclass = new HashMap<>();
				deptLoc.get(row[1]).get(row[2]).put(row[3], flightclass);
			}
			if (!deptLoc.get(row[1]).get(row[2]).get(row[3]).containsKey(row[8])) {
				deptLoc.get(row[1]).get(row[2]).get(row[3]).put(row[8], i);
			}
			i++;
		}
		return deptLoc;
	}
}
