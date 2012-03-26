package kr.or.kosta.moviesystem.movie;

import java.util.Date;

public class Movie {

	public ScreenTime screenTime;

	/**
	 * 영화번호
	 */
	private Number mnum;

	/**
	 * 영화이름
	 */
	private String mname;

	/**
	 * 개봉일
	 */
	private Date launchDate;

	/**
	 * 영화내용
	 */
	private String content;

	/**
	 * 영화장르
	 */
	private String genre;

	/**
	 * 영화 포스터
	 */
	private String poster;

	/**
	 * 영화 내리는 날짜
	 */
	private Date endDate;

	/**
	 * 영화 가격
	 */
	private Number mprice;

	private Reservation movie;
}
