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
	private String bidTime;

	/**
	 * ������������
	 */
	private String bidPrice;

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

	public String getBidTime() {
		return bidTime;
	}

	public void setBidTime(String bidTime) {
		this.bidTime = bidTime;
	}

	public String getBidPrice() {
		return bidPrice;
	}

	public void setBidPrice(String bidPrice) {
		this.bidPrice = bidPrice;
	}

	@Override
	public String toString() {
		return "Bid [member=" + member + ", auction=" + auction + ", bidNum="
				+ bidNum + ", bidTime=" + bidTime + ", bidPrice=" + bidPrice
				+ "]";
	}
}
