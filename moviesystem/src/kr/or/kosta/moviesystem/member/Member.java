package kr.or.kosta.moviesystem.member;

import java.util.Date;

public class Member {

	/**
	 * 회원 아이디
	 */
	private String userid;

	/**
	 * 회원번호
	 */
	private Number userNum;

	/**
	 * 이름
	 */
	private String name;

	/**
	 * 회원 비밀번호
	 */
	private String pw;

	/**
	 * 회원 이메일
	 */
	private String email;

	/**
	 * 회원 전화번호
	 */
	private String phone;

	/**
	 * 회원 우편번호
	 */
	private String zipcode;

	/**
	 * 주소
	 */
	private String addr;

	/**
	 * 회원 등록일
	 */
	private Date regDate;

	/**
	 * 회원상태(탈퇴  또는 회원)
	 */
	private String memState;

	/**
	 * 탈퇴이유
	 */
	private String dropReason;

	/**
	 * 탈퇴한 날짜
	 */
	private Date dropDate;

	private Reservation member;

	private Buy member;
}
