package com.nagarro.application_dev.assignment1.input;

import java.io.*;
import java.util.*;


import au.com.bytecode.opencsv.CSVReader;

/**
 * class to read fromCSV files and repeatedly
 * 
 * @author kshitizrawat
 *
 */
public class ReadFiles {

	// path of each file
	private File path;

	// assigning path
	public ReadFiles(File listoffiles) {
		this.path = listoffiles;
	}

	/**
	 * Read file of particular file and store it
	 * 
	 * @return list of all entries in one file
	 * @throws IOException
	 */
	public List<String[]> fill() throws IOException {
		List<String[]> allRows = new ArrayList<>();
		// CSV setting
		CSVReader reader = new CSVReader(new FileReader(path), '|', '"', 1);
		allRows.addAll(reader.readAll());
		reader.close();
		return allRows;
	}
}
