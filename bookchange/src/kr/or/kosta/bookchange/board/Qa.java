package kr.or.kosta.bookchange.board;

import kr.or.kosta.bookchange.member.Member;

public class Qa {

	public Member member;

	public Board board;

	/**
	 * 상품문의 내용
	 */
	private String qaContent;	

	/**
	 * 상품문의 번호
	 */
	private int qaNo;

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}

	public String getQaContent() {
		return qaContent;
	}

	public void setQaContent(String qaContent) {
		this.qaContent = qaContent;
	}

	public int getQaNo() {
		return qaNo;
	}

	public void setQaNo(int qaNo) {
		this.qaNo = qaNo;
	}

	@Override
	public String toString() {
		return "Qa [member=" + member + ", board=" + board + ", qaContent="
				+ qaContent + ", qaNo=" + qaNo + "]";
	}
	
	
}
