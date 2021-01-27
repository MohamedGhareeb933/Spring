package com.luv.hibernate.demo.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	
	private static SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyy");
	
	public static Date parsedate(String strDate) throws ParseException{
		Date date = formater.parse(strDate);
		
		return date;
	}
	
	public static String dateToString(Date date) {
		String result = null;
		
		if(date != null) 
			result = formater.format(date);
		
		return result;
	}

}
