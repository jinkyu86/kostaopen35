package kr.or.kosta.betting.memberbetdata;

import java.util.Date;

public class MemberBatData {

	public Betting betting;

	public Member member;

	/**
	 * 데이터 번호
	 */
	private String num;

	/**
	 * 선택한 팀번호
	 */
	private String seleTeamNum;

	/**
	 * 베팅에 걸은 미네랄
	 */
	private long betMineral;

	/**
	 * 베팅 번호
	 */
	private String betNum;

	/**
	 * 아이디
	 */
	private String ID;

	/**
	 * 베팅 건 시간
	 */
	private Date seleTime;

	/**
	 * 배당금을 받았는 지 않받았는지 확인 번호
	 */
	private long giveMineralConfirm;
}
