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
}
