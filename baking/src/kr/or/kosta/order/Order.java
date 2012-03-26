package kr.or.kosta.order;


import java.util.Date;

import kr.or.kosta.good.Good;
import kr.or.kosta.member.Member;

public class Order {

	private Member member;

	private Good good;

	/**
	 * 주문번호
	 */
	private int orderNum;

	/**
	 * 사용자아이디
	 */
	private String memberid;

	/**
	 * 제품번호
	 */
	private int goodNum;

	/**
	 * 제품수량
	 */
	private int qty;

	/**
	 * 제품가격
	 */
	private int price;

	/**
	 * 주문일자
	 */
	private Date buyDate;
}
