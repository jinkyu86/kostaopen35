package kr.or.kosta.moviesystem.buy;

import java.util.Date;

import kr.or.kosta.moviesystem.good.Good;
import kr.or.kosta.moviesystem.member.Member;

public class Buy {

	private Good good;

	private Member member;

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

	public Good getGood() {
		return good;
	}

	public void setGood(Good good) {
		this.good = good;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public Number getBuynum() {
		return buynum;
	}

	public void setBuynum(Number buynum) {
		this.buynum = buynum;
	}

	public Number getQty() {
		return qty;
	}

	public void setQty(Number qty) {
		this.qty = qty;
	}

	public Date getBuyDate() {
		return buyDate;
	}

	public void setBuyDate(Date buyDate) {
		this.buyDate = buyDate;
	}

	public Number getPayState() {
		return payState;
	}

	public void setPayState(Number payState) {
		this.payState = payState;
	}

	public Number getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Number totalPrice) {
		this.totalPrice = totalPrice;
	}

	@Override
	public String toString() {
		return "Buy [good=" + good + ", member=" + member + ", buynum="
				+ buynum + ", qty=" + qty + ", buyDate=" + buyDate
				+ ", payState=" + payState + ", totalPrice=" + totalPrice + "]";
	}
	
}
