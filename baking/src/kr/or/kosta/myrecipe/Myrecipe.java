package kr.or.kosta.myrecipe;


import java.util.Date;

import kr.or.kosta.member.Member;

public class Myrecipe {

	private int boardNum;//�Խ��ǹ�ȣ
	private Member member;//ȸ�����̵� �ʿ�
	private String title;//������
	private String date;//��Ͻð�
	private int count;//��ȸ��
	private String img;//�̹���
	private String content;//�۳���
	
	public int getBoardNum() {
		return boardNum;
	}
	public void setBoardNum(int boardNum) {
		this.boardNum = boardNum;
	}
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
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
		return "Myrecipe [boardNum=" + boardNum + ", member=" + member
				+ ", title=" + title + ", date=" + date + ", count=" + count
				+ ", img=" + img + ", content=" + content + "]";
	}
}
