package kr.or.kosta.moviesystem.movie;

import java.util.Date;

public class Movie {

	public ScreenTime screenTime;

	/**
	 * ��ȭ��ȣ
	 */
	private Number mnum;

	/**
	 * ��ȭ�̸�
	 */
	private String mname;

	/**
	 * ������
	 */
	private Date launchDate;

	/**
	 * ��ȭ����
	 */
	private String content;

	/**
	 * ��ȭ�帣
	 */
	private String genre;

	/**
	 * ��ȭ ������
	 */
	private String poster;

	/**
	 * ��ȭ ������ ��¥
	 */
	private Date endDate;

	/**
	 * ��ȭ ����
	 */
	private Number mprice;

	private Reservation movie;
}
