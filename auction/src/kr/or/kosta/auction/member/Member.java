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

	private Auction auction;

	private Bid bid;

	private Board board;
}
