package kr.or.kosta.myrecipe;


import java.util.Date;

import kr.or.kosta.member.Member;

public class Myrecipe {

	private Member member;

	/**
	 * �Խ��ǹ�ȣ
	 */
	private int boardNum;

	/**
	 * ȸ�����̵�
	 */
	private String memberid;

	/**
	 * ������
	 */
	private String title;

	/**
	 * ��Ͻð�
	 */
	private Date date;

	/**
	 * ��ȸ��
	 */
	private int count;

	/**
	 * �̹���
	 */
	private String img;

	/**
	 * �۳���
	 */
	private String content;

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public int getBoardNum() {
		return boardNum;
	}

	public void setBoardNum(int boardNum) {
		this.boardNum = boardNum;
	}

	public String getMemberid() {
		return memberid;
	}

	public void setMemberid(String memberid) {
		this.memberid = memberid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "Myrecipe [member=" + member + ", boardNum=" + boardNum
				+ ", memberid=" + memberid + ", title=" + title + ", date="
				+ date + ", count=" + count + ", img=" + img + ", content="
				+ content + "]";
	}
}
