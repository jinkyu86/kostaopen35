package kr.or.kosta.auction.member;

import kr.or.kosta.auction.auction.Auction;
import kr.or.kosta.auction.bid.Bid;
import kr.or.kosta.auction.board.Board;

public class Member {

	/**
	 * ȸ���� ID
	 */
	private String userid;

	/**
	 * ȸ�� ��й�ȣ
	 */
	private String pw;

	/**
	 * ȸ���� email
	 */
	private String email;

	/**
	 * ȸ���� �̸�
	 */
	private String name;

	/**
	 * ȸ���� coin����
	 */
	private String coin;

	/**
	 * ȸ���� e�Ӵ� ������
	 */
	private String emoney;

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCoin() {
		return coin;
	}

	public void setCoin(String coin) {
		this.coin = coin;
	}

	public String getEmoney() {
		return emoney;
	}

	public void setEmoney(String emoney) {
		this.emoney = emoney;
	}

	@Override
	public String toString() {
		return "Member [userid=" + userid + ", pw=" + pw + ", email=" + email
				+ ", name=" + name + ", coin=" + coin + ", emoney=" + emoney
				+ "]";
	}

	
	
}
