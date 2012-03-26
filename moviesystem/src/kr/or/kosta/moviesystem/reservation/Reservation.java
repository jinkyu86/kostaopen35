package kr.or.kosta.moviesystem.reservation;

import java.util.Date;

public class Reservation {

	public ScreenTime screenTime;

	public Member member;

	public Movie movie;

	/**
	 * 예약번호
	 */
	private Number resnum;

	/**
	 * 예약날짜
	 */
	private Date resDate;

	/**
	 * 예매 수량(영화표 수량)
	 */
	private Number resQty;

	/**
	 * 결제 상태
	 */
	private Number payState;

	/**
	 * 전체 가격
	 */
	private Number totalPrice;
}
