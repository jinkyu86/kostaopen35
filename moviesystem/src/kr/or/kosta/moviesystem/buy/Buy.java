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
	private String buynum;

	/**
	 * ���ż���
	 */
	private Long qty;

	/**
	 * ������ ��¥
	 */
	private Date buyDate;

	/**
	 * ���� ���� ����(���� ����Ȯ��)
	 */
	private String payState;

	/**
	 * ��ü ����
	 */
	private Long totalPrice;

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

	public String getBuynum() {
		return buynum;
	}

	public void setBuynum(String buynum) {
		this.buynum = buynum;
	}

	public Long getQty() {
		return qty;
	}

	public void setQty(Long qty) {
		this.qty = qty;
	}

	public Date getBuyDate() {
		return buyDate;
	}

	public void setBuyDate(Date buyDate) {
		this.buyDate = buyDate;
	}

	public String getPayState() {
		return payState;
	}

	public void setPayState(String payState) {
		this.payState = payState;
	}

	public Long getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Long totalPrice) {
		this.totalPrice = totalPrice;
	}

	@Override
	public String toString() {
		return "Buy [good=" + good + ", member=" + member + ", buynum="
				+ buynum + ", qty=" + qty + ", buyDate=" + buyDate
				+ ", payState=" + payState + ", totalPrice=" + totalPrice + "]";
	}

	
}
