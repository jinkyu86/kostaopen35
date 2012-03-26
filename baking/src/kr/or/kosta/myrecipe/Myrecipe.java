package kr.or.kosta.myrecipe;


import java.util.Date;

import kr.or.kosta.member.Member;

public class Myrecipe {

	private Member member;

	/**
	 * 게시판번호
	 */
	private int boardNum;

	/**
	 * 회원아이디
	 */
	private String memberid;

	/**
	 * 글제목
	 */
	private String title;

	/**
	 * 등록시간
	 */
	private Date date;

	/**
	 * 조회수
	 */
	private int count;

	/**
	 * 이미지
	 */
	private String img;

	/**
	 * 글내용
	 */
	private String content;
}
