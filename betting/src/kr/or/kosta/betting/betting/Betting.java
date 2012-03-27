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

	public Match getMatch() {
		return match;
	}

	public void setMatch(Match match) {
		this.match = match;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getMatchNum() {
		return matchNum;
	}

	public void setMatchNum(String matchNum) {
		this.matchNum = matchNum;
	}

	public long getBatRating() {
		return batRating;
	}

	public void setBatRating(long batRating) {
		this.batRating = batRating;
	}

	public long getSeleRating() {
		return seleRating;
	}

	public void setSeleRating(long seleRating) {
		this.seleRating = seleRating;
	}

	public long getTotMineral() {
		return totMineral;
	}

	public void setTotMineral(long totMineral) {
		this.totMineral = totMineral;
	}

	public String getDistnum() {
		return distnum;
	}

	public void setDistnum(String distnum) {
		this.distnum = distnum;
	}

	public String getTeamNum() {
		return teamNum;
	}

	public void setTeamNum(String teamNum) {
		this.teamNum = teamNum;
	}

	@Override
	public String toString() {
		return "Betting [match=" + match + ", num=" + num + ", matchNum="
				+ matchNum + ", batRating=" + batRating + ", seleRating="
				+ seleRating + ", totMineral=" + totMineral + ", distnum="
				+ distnum + ", teamNum=" + teamNum + "]";
	}

	
}
