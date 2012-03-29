package kr.or.kosta.betting.match;

import kr.or.kosta.betting.loc.Loc;
import kr.or.kosta.betting.team.Team;

public class Match {

	/**
	 * ��� ��ȣ
	 */
	private String num;

	/**
	 * ��� ���ھ�
	 */
	private String score;

	/**
	 * Ȩ �� ��ȣ
	 */
	private Team homeTeam;

	/**
	 * ������� ��ȣ
	 */
	private Team awayTeam;

	/**
	 * �̱� �� ��ȣ
	 */
	private Team winTeam;

	/**
	 * ������ ��ȣ
	 */
	private Loc loc;

	/**
	 * ��� �ð�
	 */
	private String matchTime;

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public Team getHomeTeam() {
		return homeTeam;
	}

	public void setHomeTeam(Team homeTeam) {
		this.homeTeam = homeTeam;
	}

	public Team getAwayTeam() {
		return awayTeam;
	}

	public void setAwayTeam(Team awayTeam) {
		this.awayTeam = awayTeam;
	}

	public Team getWinTeam() {
		return winTeam;
	}

	public void setWinTeam(Team winTeam) {
		this.winTeam = winTeam;
	}

	public Loc getLoc() {
		return loc;
	}

	public void setLoc(Loc loc) {
		this.loc = loc;
	}

	public String getMatchTime() {
		return matchTime;
	}

	public void setMatchTime(String matchTime) {
		this.matchTime = matchTime;
	}

	@Override
	public String toString() {
		return "Match [num=" + num + ", score=" + score + ", homeTeam="
				+ homeTeam + ", awayTeam=" + awayTeam + ", winTeam=" + winTeam
				+ ", loc=" + loc + ", matchTime=" + matchTime + "]";
	}


	
}
