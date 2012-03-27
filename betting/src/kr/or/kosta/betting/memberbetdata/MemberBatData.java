package kr.or.kosta.betting.memberbetdata;

import java.util.Date;

import kr.or.kosta.betting.betting.Betting;
import kr.or.kosta.betting.member.Member;

public class MemberBatData {

	private Betting betting;

	private Member member;

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

	public String getSeleTeamNum() {
		return seleTeamNum;
	}

	public void setSeleTeamNum(String seleTeamNum) {
		this.seleTeamNum = seleTeamNum;
	}

	public long getBetMineral() {
		return betMineral;
	}

	public void setBetMineral(long betMineral) {
		this.betMineral = betMineral;
	}

	public String getBetNum() {
		return betNum;
	}

	public void setBetNum(String betNum) {
		this.betNum = betNum;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public Date getSeleTime() {
		return seleTime;
	}

	public void setSeleTime(Date seleTime) {
		this.seleTime = seleTime;
	}

	public long getGiveMineralConfirm() {
		return giveMineralConfirm;
	}

	public void setGiveMineralConfirm(long giveMineralConfirm) {
		this.giveMineralConfirm = giveMineralConfirm;
	}

	@Override
	public String toString() {
		return "MemberBatData [betting=" + betting + ", member=" + member
				+ ", num=" + num + ", seleTeamNum=" + seleTeamNum
				+ ", betMineral=" + betMineral + ", betNum=" + betNum + ", ID="
				+ ID + ", seleTime=" + seleTime + ", giveMineralConfirm="
				+ giveMineralConfirm + "]";
	}
	
}
