package kr.or.kosta.auction.auction;


import java.sql.Date;

import kr.or.kosta.auction.bid.Bid;
import kr.or.kosta.auction.good.Good;
import kr.or.kosta.auction.member.Member;

public class Auction {

	public Good good;

	/**
	 * ��� ������ȣ
	 */
	private String aNum;

	/**
	 * ��� ���۰�
	 */
	private String sPrice;

	/**
	 * ����� ��ñ��Ű�
	 */
	private String imPrice;

	/**
	 * ��� ���۽ð�
	 */
	private String sTime;

	/**
	 * ��� �����ð�
	 */
	private String eTime;

	/**
	 * ���ǰ�� ��������
	 */
	private boolean sold;

	/**
	 * ���� ������
	 */
	private String cuPrice;

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
	public boolean isSold() {
		return sold;
	}

	public void setSold(boolean sold) {
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

	@Override
	public String toString() {
		return "Auction [good=" + good + ", aNum=" + aNum + ", sPrice="
				+ sPrice + ", imPrice=" + imPrice + ", sTime=" + sTime
				+ ", eTime=" + eTime + ", sold=" + sold + ", cuPrice="
				+ cuPrice + "]";
	}



}
