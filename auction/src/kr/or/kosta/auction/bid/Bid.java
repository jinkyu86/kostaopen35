package kr.or.kosta.auction.bid;

import kr.or.kosta.auction.auction.Auction;
import kr.or.kosta.auction.member.Member;

public class Bid {

	public Member member;

	public Auction auction;

	/**
	 * ����������ȣ
	 */
	private String bidNum;

	/**
	 * ������ �ð�
	 */
	private String cuTime;

	/**
	 * ������������
	 */
	private String cuPrice;

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public Auction getAuction() {
		return auction;
	}

	public void setAuction(Auction auction) {
		this.auction = auction;
	}

	public String getBidNum() {
		return bidNum;
	}

	public void setBidNum(String bidNum) {
		this.bidNum = bidNum;
	}

	public String getCuTime() {
		return cuTime;
	}

	public void setCuTime(String cuTime) {
		this.cuTime = cuTime;
	}

	public String getCuPrice() {
		return cuPrice;
	}

	public void setCuPrice(String cuPrice) {
		this.cuPrice = cuPrice;
	}

	@Override
	public String toString() {
		return "Bid [member=" + member + ", auction=" + auction + ", bidNum="
				+ bidNum + ", cuTime=" + cuTime + ", cuPrice=" + cuPrice + "]";
	}

}
