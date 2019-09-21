package com.nagarro.web.constants;

import java.text.SimpleDateFormat;

public class Constants {
	public static final String DATEFORMAT = "dd-MM-yyyy";
	public static final String FOLDERPATH = "<C:\\Users\\kshitizrawat\\Documents\\docs\\Assignment LinksADJava~\\Assignment Links>";

	public static SimpleDateFormat getDateFormatter() {
		return new SimpleDateFormat(DATEFORMAT);
	}

}
