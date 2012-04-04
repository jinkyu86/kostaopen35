package kr.or.kosta.betting.memberbetdata;

import kr.or.kosta.betting.betting.Betting;
import kr.or.kosta.betting.member.Member;

public class MemberBetData {

	private Betting betting;

	private Member member;

	/**
	 * 데이터 번호
	 */
	private String num;

//	/**
//	 * 선택한 팀번호
//	 */
//	private String seleTeamNum;

	/**
	 * 베팅에 걸은 미네랄
	 */
	private long betMineral;

	/**
	 * 베팅 건 시간
	 */
	private String seleTime;

	/**
	 * 배당금을 받았는 지 않받았는지 확인 번호
	 */
	private String giveMineralConfirm;

	public Betting getBetting() {
		return betting;
	}

	public void setBetting(Betting betting) {
		this.betting = betting;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public long getBetMineral() {
		return betMineral;
	}

	public void setBetMineral(long betMineral) {
		this.betMineral = betMineral;
	}

	public String getSeleTime() {
		return seleTime;
	}

	public void setSeleTime(String seleTime) {
		this.seleTime = seleTime;
	}

	public String getGiveMineralConfirm() {
		return giveMineralConfirm;
	}

	public void setGiveMineralConfirm(String giveMineralConfirm) {
		this.giveMineralConfirm = giveMineralConfirm;
	}

	@Override
	public String toString() {
		return "MemberBatData [betting=" + betting + ", member=" + member
				+ ", num=" + num + ", betMineral=" + betMineral + ", seleTime="
				+ seleTime + ", giveMineralConfirm=" + giveMineralConfirm + "]";
	}



}
