package kr.or.kosta.order;


import java.util.Date;

import kr.or.kosta.good.Good;
import kr.or.kosta.member.Member;

public class Order {

	private Member member;

	private Good good;

	/**
	 * �ֹ���ȣ
	 */
	private int orderNum;

	/**
	 * ����ھ��̵�
	 */
	private String memberid;

	/**
	 * ��ǰ��ȣ
	 */
	private int goodNum;

	/**
	 * ��ǰ����
	 */
	private int qty;

	/**
	 * ��ǰ����
	 */
	private int price;

	/**
	 * �ֹ�����
	 */
	private Date buyDate;
}
