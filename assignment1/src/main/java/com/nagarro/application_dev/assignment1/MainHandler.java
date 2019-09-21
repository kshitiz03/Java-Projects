package com.nagarro.application_dev.assignment1;


import com.nagarro.application_dev.assignment1.input.UserInput;
import com.nagarro.application_dev.multithread.DataUpdate;

/**
 * Main class that controls flow of program
 * 
 * @author kshitizrawat
 *
 */
public class MainHandler {
	/**
	 * handler function
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		// to update data from CSV files repeatedly
		DataUpdate du = new DataUpdate();

		// to take user inputs
		UserInput ui = new UserInput();

		du.start();
		ui.start();

	}
}
