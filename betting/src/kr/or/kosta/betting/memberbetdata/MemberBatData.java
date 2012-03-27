package kr.or.kosta.betting.memberbetdata;

import java.util.Date;

import kr.or.kosta.betting.betting.Betting;
import kr.or.kosta.betting.member.Member;

public class MemberBatData {

	private Betting betting;

	private Member member;

	/**
	 * ������ ��ȣ
	 */
	private String num;

	/**
	 * ������ ����ȣ
	 */
	private String seleTeamNum;

	/**
	 * ���ÿ� ���� �̳׶�
	 */
	private long betMineral;

	/**
	 * ���� ��ȣ
	 */
	private String betNum;

	/**
	 * ���̵�
	 */
	private String ID;

	/**
	 * ���� �� �ð�
	 */
	private Date seleTime;

	/**
	 * ������ �޾Ҵ� �� �ʹ޾Ҵ��� Ȯ�� ��ȣ
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
