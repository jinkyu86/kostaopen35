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

	private Auction auction;

	private Bid bid;

	private Board board;
}
