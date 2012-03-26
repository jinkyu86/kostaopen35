package kr.or.kosta.auction.auction;

import kr.or.kosta.auction.bid.Bid;
import kr.or.kosta.auction.good.Good;
import kr.or.kosta.auction.member.Member;

public class Auction {

	public Member member;

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
	private boolean sold;

	/**
	 * 현재 입찰가
	 */
	private String cuPrice;

	private Bid auction;
}
