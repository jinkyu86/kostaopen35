package kr.or.kosta.auction.auction;

import kr.or.kosta.auction.bid.Bid;
import kr.or.kosta.auction.good.Good;
import kr.or.kosta.auction.member.Member;

public class Auction {

	public Member member;

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

	private Bid auction;
}
