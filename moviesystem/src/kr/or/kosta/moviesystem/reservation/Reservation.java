package kr.or.kosta.moviesystem.reservation;

import java.util.Date;

public class Reservation {

	public ScreenTime screenTime;

	public Member member;

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
