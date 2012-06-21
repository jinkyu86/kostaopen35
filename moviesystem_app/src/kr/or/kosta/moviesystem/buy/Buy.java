package kr.or.kosta.moviesystem.buy;

import java.util.Date;

import kr.or.kosta.moviesystem.good.Good;
import kr.or.kosta.moviesystem.member.Member;

public class Buy {

	private Good good;

	private Member member;

	/**
	 * 구매번호
	 */
	private String buynum;

	/**
	 * 구매수량
	 */
	private long qty;

	/**
	 * 구매한 날짜
	 */
	private Date buyDate;
	/**
	 * 구매취소한 날짜
	 */
	private Date cancelbuyDate;
	
	/**
	 * 현재 구매 상태(결제 유뮤확인)
	 */
	private String payState;

	/**
	 * 전체 가격
	 */
	private long totalPrice;

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

	public long getQty() {
		return qty;
	}

	public void setQty(long qty) {
		this.qty = qty;
	}

	public Date getBuyDate() {
		return buyDate;
	}

	public void setBuyDate(Date buyDate) {
		this.buyDate = buyDate;
	}
	public Date getcancelbuyDate() {
		return cancelbuyDate;
	}

	public void setcancelbuyDate(Date cancelbuyDate) {
		this.cancelbuyDate = cancelbuyDate;
	}
	
	

	public String getPayState() {
		return payState;
	}

	public void setPayState(String payState) {
		this.payState = payState;
	}

	public long getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(long totalPrice) {
		this.totalPrice = totalPrice;
	}

	@Override
	public String toString() {
		return "Buy [good=" + good + ", member=" + member + ", buynum="
				+ buynum + ", qty=" + qty + ", buyDate=" + buyDate+", cancelbuyDate=" + cancelbuyDate
				+ ", payState=" + payState + ", totalPrice=" + totalPrice + "]";
	}
	
	
}
