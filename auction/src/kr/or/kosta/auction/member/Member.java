package kr.or.kosta.auction.member;

import kr.or.kosta.auction.auction.Auction;
import kr.or.kosta.auction.bid.Bid;
import kr.or.kosta.auction.board.Board;

public class Member {

	/**
	 * 회원의 ID
	 */
	private String userid;

	/**
	 * 회원 비밀번호
	 */
	private String pw;

	/**
	 * 회원의 email
	 */
	private String email;

	/**
	 * 회원의 이름
	 */
	private String name;

	/**
	 * 회원의 coin개수
	 */
	private String coin;

	/**
	 * 회원의 e머니 보유액
	 */
	private String emoney;



	private Bid bid;

	private Board board;

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

	public Bid getBid() {
		return bid;
	}

	public void setBid(Bid bid) {
		this.bid = bid;
	}

	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}

	@Override
	public String toString() {
		return "Member [userid=" + userid + ", pw=" + pw + ", email=" + email
				+ ", name=" + name + ", coin=" + coin + ", emoney=" + emoney
				+ ", bid=" + bid + ", board=" + board
				+ "]";
	}
	
	
}
