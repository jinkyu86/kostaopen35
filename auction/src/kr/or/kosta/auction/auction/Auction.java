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
	private Date sTime;

	/**
	 * ��� �����ð�
	 */
	private Date eTime;

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


	public Date getsTime() {
		return sTime;
	}

	public void setsTime(Date sTime) {
		this.sTime = sTime;
	}

	public Date geteTime() {
		return eTime;
	}

	public void seteTime(Date eTime) {
		this.eTime = eTime;
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

	@Override
	public String toString() {
		return "Auction [good=" + good + ", aNum=" + aNum + ", sPrice="
				+ sPrice + ", imPrice=" + imPrice + ", sTime=" + sTime
				+ ", eTime=" + eTime + ", sold=" + sold + ", cuPrice="
				+ cuPrice + "]";
	}

}
