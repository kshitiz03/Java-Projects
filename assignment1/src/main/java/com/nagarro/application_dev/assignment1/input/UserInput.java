package com.nagarro.application_dev.assignment1.input;

import java.util.*;

import com.nagarro.application_dev.multithread.DataUpdate;
import com.nagarro.application_dev.showoutputs.checkDisplay;

public class UserInput extends Thread {

	// running thread for user input
	public void run() {

		inputAndCheckDataFromUser();
	}

	/**
	 * Input data from user and checking for results in hashmap
	 */
	private void inputAndCheckDataFromUser() {
		Scanner sc = new Scanner(System.in);
		while (true) {
			List<String> dates = new ArrayList<>();
			List<Integer> allflights = new ArrayList<>();
			String arrcity, fclass, date;
			System.out.println("Enter Departure Location Name: ");
			String deptcity = sc.next().toUpperCase();
			// check for departure city availability
			if (DataUpdate.deptLoc.containsKey(deptcity)) {
				System.out.println("Enter Arrival Location Name: ");
				arrcity = sc.next().toUpperCase();

				// check for arrival city availability

				if (DataUpdate.deptLoc.get(deptcity).containsKey(arrcity)) {
					System.out.println("Enter date: ");
					date = sc.next();
					System.out.println("Enter class: ");
					fclass = sc.next().toUpperCase();
				} else {
					System.out.println(arrcity + " is not available.");
					continue;
				}
			} else {
				System.out.println(deptcity + " is not available.");
				continue;
			}

			// checking whole field against database
			checkDisplay cd = new checkDisplay();
			cd.checkForDisplay(deptcity, arrcity, date, dates, allflights, fclass);

			System.out.println("Enter choice if you want to enter more queries (Y/N)");
			String choice = sc.next().toUpperCase();
			if (choice.equalsIgnoreCase("N"))
				break;

		}
	}
}
