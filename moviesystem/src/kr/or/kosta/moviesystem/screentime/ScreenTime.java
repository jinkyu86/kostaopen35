package kr.or.kosta.moviesystem.screentime;

import java.util.Date;

public class ScreenTime {

	private String scrnum;//영화시간번호
	private String time;//영화상형시간
	
	public String getScrnum() {
		return scrnum;
	}
	public void setScrnum(String scrnum) {
		this.scrnum = scrnum;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	@Override
	public String toString() {
		return "ScreenTime [scrnum=" + scrnum + ", time=" + time + "]";
	}

}
