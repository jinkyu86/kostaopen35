package kr.or.kosta.moviesystem.buy;

import java.util.Date;

public class Buy {

	public Good good;

	public Member member;

	/**
	 * ���Ź�ȣ
	 */
	private Number buynum;

	/**
	 * ���ż���
	 */
	private Number qty;

	/**
	 * ������ ��¥
	 */
	private Date buyDate;

	/**
	 * ���� ���� ����(���� ����Ȯ��)
	 */
	private Number payState;

	/**
	 * ��ü ����
	 */
	private Number totalPrice;
}
