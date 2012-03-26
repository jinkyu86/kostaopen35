package kr.or.kosta.auction.board;

import kr.or.kosta.auction.member.Member;

public class Board {

	public Member member;

	/**
	 * 게시물 번호
	 */
	private String bNum;

	/**
	 * 게시물 제목
	 */
	private String title;

	/**
	 * 게시물 내용
	 */
	private String content;

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public String getbNum() {
		return bNum;
	}

	public void setbNum(String bNum) {
		this.bNum = bNum;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "Board [member=" + member + ", bNum=" + bNum + ", title="
				+ title + ", content=" + content + "]";
	}
	
}
