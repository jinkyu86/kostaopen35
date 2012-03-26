package kr.or.kosta.betting.match;

import java.util.Date;

public class Match {

	public Loc loc;

	public Team team;

	/**
	 * 경기 번호
	 */
	private String num;

	/**
	 * 경기 스코어
	 */
	private String score;

	/**
	 * 홈 팀 번호
	 */
	private String homeNum;

	/**
	 * 어웨이팀 번호
	 */
	private String awayNum;

	/**
	 * 이긴 팀 번호
	 */
	private String winNum;

	/**
	 * 연고지 번호
	 */
	private String locNum;

	/**
	 * 경기 시간
	 */
	private Date matchTime;

	private Betting Match;
}
