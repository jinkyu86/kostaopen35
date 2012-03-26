package kr.or.kosta.moviesystem.buy;

import java.util.Date;

public class Buy {

	public Good good;

	public Member member;

	/**
	 * 구매번호
	 */
	private Number buynum;

	/**
	 * 구매수량
	 */
	private Number qty;

	/**
	 * 구매한 날짜
	 */
	private Date buyDate;

	/**
	 * 현재 구매 상태(결제 유뮤확인)
	 */
	private Number payState;

	/**
	 * 전체 가격
	 */
	private Number totalPrice;
}
