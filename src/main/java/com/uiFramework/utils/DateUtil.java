package com.uiFramework.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateUtil {
	

	/*This method is used to generate the random date 
	 * it generates date by adding dates accepting {amountOfDays} parameter*/
	public static String genarateDate(int amountOfDays){
		String pattern ="dd-MM-yyyy";
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, amountOfDays);
		SimpleDateFormat formatter = new SimpleDateFormat(pattern);
		return formatter.format(cal.getTime());
	}
	
	

}
