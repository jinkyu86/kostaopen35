package kr.or.kosta.auction.auction;


import java.sql.Date;

import kr.or.kosta.auction.bid.Bid;
import kr.or.kosta.auction.good.Good;
import kr.or.kosta.auction.member.Member;

public class Auction {

	public Good good;

	/**
	 * 경매 고유번호
	 */
	private String aNum;

	/**
	 * 경매 시작가
	 */
	private String sPrice;

	/**
	 * 경매의 즉시구매가
	 */
	private String imPrice;

	/**
	 * 경매 시작시간
	 */
	private String sTime;

	/**
	 * 경매 마감시간
	 */
	private String eTime;

	/**
	 * 경매품의 낙찰여부
	 */
	private int sold;

	/**
	 * 현재 입찰가
	 */
	private String cuPrice;
	
	private String userid;

	public Good getGood() {
		return good;
	}

	public void setGood(Good good) {
		this.good = good;
	}

	public String getaNum() {
		return aNum;
	}

	public void setaNum(String aNum) {
		this.aNum = aNum;
	}

	public String getsPrice() {
		return sPrice;
	}

	public void setsPrice(String sPrice) {
		this.sPrice = sPrice;
	}

	public String getImPrice() {
		return imPrice;
	}

	public void setImPrice(String imPrice) {
		this.imPrice = imPrice;
	}
	

	public int getSold() {
		return sold;
	}

	public void setSold(int sold) {
		this.sold = sold;
	}

	public String getCuPrice() {
		return cuPrice;
	}

	public void setCuPrice(String cuPrice) {
		this.cuPrice = cuPrice;
	}

	public String getsTime() {
		return sTime;
	}

	public void setsTime(String sTime) {
		this.sTime = sTime;
	}

	public String geteTime() {
		return eTime;
	}

	public void seteTime(String eTime) {
		this.eTime = eTime;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	@Override
	public String toString() {
		return "Auction [good=" + good + ", aNum=" + aNum + ", sPrice="
				+ sPrice + ", imPrice=" + imPrice + ", sTime=" + sTime
				+ ", eTime=" + eTime + ", sold=" + sold + ", cuPrice="
				+ cuPrice + ", userid=" + userid + "]";
	}
	
}
