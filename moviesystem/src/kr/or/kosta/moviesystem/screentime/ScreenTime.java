package kr.or.kosta.moviesystem.screentime;

import java.util.Date;

import kr.or.kosta.moviesystem.movie.Movie;

public class ScreenTime {

	/**
	 * 영화시간 번호
	 */
	private String scrnum;

	/**
	 * 영화상영시간
	 */
	private Date time;

	public String getScrnum() {
		return scrnum;
	}

	public void setScrnum(String scrnum) {
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
		return "ScreenTime [scrnum=" + scrnum + ", time=" + time
				+ "]";
	}	
}
