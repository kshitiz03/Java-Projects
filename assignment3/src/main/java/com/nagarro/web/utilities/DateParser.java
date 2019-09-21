package com.nagarro.web.utilities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.nagarro.web.constants.Constants;



public class DateParser {
//	final static Logger LOG = Logger.getLogger(DateParser.class);
	private static SimpleDateFormat formatter;

	public static Date getDate(String stringDate) {
		Date date = null;

		try {
			formatter = Constants.getDateFormatter();
			date = formatter.parse(stringDate);
		} catch (ParseException parseException) {

		}

		return date;
	}
}
