package kr.or.kosta.betting.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.Date;

public class now {

	/**
	 * @param args
	 */
	public static String Date() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd", Locale.KOREA);
		Date dTime = new Date();
		String sTime = sdf.format(dTime);
		return sTime;
	}
	
	public static String Hour(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss", Locale.KOREA);
		Date dTime = new Date();
		String sTime = sdf.format(dTime);
									
		return sTime;
	}
	public static int hourCheck(String matchTime){
		
		Date newDate = null;
		Date nowDate = new Date();	
		System.out.println(nowDate);
		int check = 0;
	
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		try {
			newDate = dateFormat.parse(matchTime);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		if(nowDate.after(newDate)){
			check = 0;
		}else{
			check = 1;
		}
		return check;
	}
}
