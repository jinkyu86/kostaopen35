package kr.or.kosta.betting.match;

import java.util.Date;

import kr.or.kosta.betting.loc.Loc;
import kr.or.kosta.betting.team.Team;

public class Match {

	private Loc loc;

	private Team team;

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

	public Loc getLoc() {
		return loc;
	}

	public void setLoc(Loc loc) {
		this.loc = loc;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

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

	public String getHomeNum() {
		return homeNum;
	}

	public void setHomeNum(String homeNum) {
		this.homeNum = homeNum;
	}

	public String getAwayNum() {
		return awayNum;
	}

	public void setAwayNum(String awayNum) {
		this.awayNum = awayNum;
	}

	public String getWinNum() {
		return winNum;
	}

	public void setWinNum(String winNum) {
		this.winNum = winNum;
	}

	public String getLocNum() {
		return locNum;
	}

	public void setLocNum(String locNum) {
		this.locNum = locNum;
	}

	public Date getMatchTime() {
		return matchTime;
	}

	public void setMatchTime(Date matchTime) {
		this.matchTime = matchTime;
	}

	@Override
	public String toString() {
		return "Match [loc=" + loc + ", team=" + team + ", num=" + num
				+ ", score=" + score + ", homeNum=" + homeNum + ", awayNum="
				+ awayNum + ", winNum=" + winNum + ", locNum=" + locNum
				+ ", matchTime=" + matchTime + "]";
	}

	
}
