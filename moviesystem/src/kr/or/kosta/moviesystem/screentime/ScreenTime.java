package kr.or.kosta.moviesystem.screentime;

import java.util.Date;

import kr.or.kosta.moviesystem.movie.Movie;

public class ScreenTime {

	/**
	 * ��ȭ�ð� ��ȣ
	 */
	private Number scrnum;

	/**
	 * ��ȭ�󿵽ð�
	 */
	private Date time;

	private Movie screenTime;

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

	public Movie getScreenTime() {
		return screenTime;
	}

	public void setScreenTime(Movie screenTime) {
		this.screenTime = screenTime;
	}

	@Override
	public String toString() {
		return "ScreenTime [scrnum=" + scrnum + ", time=" + time
				+ ", screenTime=" + screenTime + "]";
	}	
}
