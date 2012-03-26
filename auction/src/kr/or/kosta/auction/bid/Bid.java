package kr.or.kosta.auction.bid;

import kr.or.kosta.auction.auction.Auction;
import kr.or.kosta.auction.member.Member;

public class Bid {

	public Member member;

	public Auction auction;

	/**
	 * 입찰고유번호
	 */
	private String bidNum;

	/**
	 * 입찰한 시간
	 */
	private String cuTime;

	/**
	 * 현재입찰가격
	 */
	private String cuPrice;
}
