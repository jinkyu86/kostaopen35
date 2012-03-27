package kr.or.kosta.betting.betting;

import kr.or.kosta.betting.match.Match;

public class Betting {

	private Match match;

	/**
	 * 베팅 번호
	 */
	private String num;

	/**
	 * 경기 번호
	 */
	private String matchNum;

	/**
	 * 배팅률
	 */
	private long batRating;

	/**
	 * 선택횟수
	 */
	private long seleRating;

	/**
	 * 선택된 팀의 배팅금 총액
	 */
	private long totMineral;

	/**
	 * 홈팀과 어웨이팀 구분 번호
	 */
	private String distnum;

	/**
	 * 팀 번호
	 */
	private String teamNum;


}
