package kr.or.kosta.betting.util;

import java.util.Calendar;

public class now {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	
		Calendar calendar = Calendar.getInstance() ;   
		int year = calendar.get(Calendar.YEAR) ;  
		int month = calendar.get(Calendar.MONTH) + 1 ;
		int date = calendar.get(Calendar.DATE) ;  
		int hour = calendar.get(Calendar.HOUR) ;  
		int minute = calendar.get(Calendar.MINUTE) ;  
		int second = calendar.get(Calendar.SECOND) ; 
		String now = null;
		
		if(month<10){
			now = year+"/0"+month;
		}else {
			now = year+"/"+month;
		}
		
		if(date<10){
			now = now+"/0"+date;
		}else{
			now = now+"/"+date;
		}
		
		if(hour<10){
			now = now+" 0"+hour;
		}else{
			now = now+" "+hour;
		}
		
		if(minute<10){
			now = now+":0"+minute;
		}else{
			now = now+":"+minute;
		}
		
		if(second<10){
			now = now+":0"+second;
		}else{
			now = now+":"+second;
		}	
		System.out.println(now);
	}
}
