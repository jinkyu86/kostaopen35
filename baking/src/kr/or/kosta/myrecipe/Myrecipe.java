package kr.or.kosta.myrecipe;


import java.util.Date;

import kr.or.kosta.member.Member;

public class Myrecipe {

	private int boardNum;//게시판번호
	private Member member;//회원아이디만 필요
	private String title;//글제목
	private String date;//등록시간
	private int count;//조회수
	private String img;//이미지
	private String content;//글내용
	
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
