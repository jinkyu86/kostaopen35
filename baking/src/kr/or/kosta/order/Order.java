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

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public Good getGood() {
		return good;
	}

	public void setGood(Good good) {
		this.good = good;
	}

	public int getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}

	public String getMemberid() {
		return memberid;
	}

	public void setMemberid(String memberid) {
		this.memberid = memberid;
	}

	public int getGoodNum() {
		return goodNum;
	}

	public void setGoodNum(int goodNum) {
		this.goodNum = goodNum;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Date getBuyDate() {
		return buyDate;
	}

	public void setBuyDate(Date buyDate) {
		this.buyDate = buyDate;
	}

	@Override
	public String toString() {
		return "Order [member=" + member + ", good=" + good + ", orderNum="
				+ orderNum + ", memberid=" + memberid + ", goodNum=" + goodNum
				+ ", qty=" + qty + ", price=" + price + ", buyDate=" + buyDate
				+ "]";
	}
}
