package kr.or.kosta.moviesystem.screentime;

import java.util.Date;

import kr.or.kosta.moviesystem.movie.Movie;

public class ScreenTime {

	
	private String scrnum;//��ȭ�ð���ȣ
	private String time;//��ȭ�����ð�
	public Movie movie;	
	
	public Movie getMovie() {
		return movie;
	}
	public void setMovie(Movie movie) {
		this.movie = movie;
	}
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
		return "ScreenTime [scrnum=" + scrnum + ", time=" + time + ", movie="
				+ movie + "]";
	}


}
