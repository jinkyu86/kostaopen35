package kr.or.kosta.moviesystem.reservation;

import java.util.Date;

import kr.or.kosta.moviesystem.movie.Movie;
import kr.or.kosta.moviesystem.screentime.ScreenTime;

public class Reservation {

	public ScreenTime screenTime;

	public Movie movie;

	/**
	 * �����ȣ
	 */
	private Number resnum;

	/**
	 * ���೯¥
	 */
	private Date resDate;

	/**
	 * ���� ����(��ȭǥ ����)
	 */
	private Number resQty;

	/**
	 * ���� ����
	 */
	private Number payState;

	/**
	 * ��ü ����
	 */
	private Number totalPrice;
}
