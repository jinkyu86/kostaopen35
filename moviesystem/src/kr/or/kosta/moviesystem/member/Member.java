package kr.or.kosta.moviesystem.member;

import java.util.Date;

public class Member {

	/**
	 * ȸ�� ���̵�
	 */
	private String userid;

	/**
	 * ȸ����ȣ
	 */
	private Number userNum;

	/**
	 * �̸�
	 */
	private String name;

	/**
	 * ȸ�� ��й�ȣ
	 */
	private String pw;

	/**
	 * ȸ�� �̸���
	 */
	private String email;

	/**
	 * ȸ�� ��ȭ��ȣ
	 */
	private String phone;

	/**
	 * ȸ�� �����ȣ
	 */
	private String zipcode;

	/**
	 * �ּ�
	 */
	private String addr;

	/**
	 * ȸ�� �����
	 */
	private Date regDate;

	/**
	 * ȸ������(Ż��  �Ǵ� ȸ��)
	 */
	private String memState;

	/**
	 * Ż������
	 */
	private String dropReason;

	/**
	 * Ż���� ��¥
	 */
	private Date dropDate;

	private Reservation member;

	private Buy member;
}
