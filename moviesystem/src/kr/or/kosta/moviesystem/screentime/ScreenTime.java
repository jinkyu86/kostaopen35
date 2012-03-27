package kr.or.kosta.moviesystem.screentime;

import java.util.Date;

public class ScreenTime {

	private Number scrnum;//영화시간번호
	private Date time;//영화상형시간
	public Number getScrnum() {
		return scrnum;
	}
	public void setScrnum(Number scrnum) {
		this.scrnum = scrnum;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	@Override
	public String toString() {
		return "ScreenTime [scrnum=" + scrnum + ", time=" + time + "]";
	}

}
