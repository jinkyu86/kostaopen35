package kr.or.kosta.betting.memberbetdata;

import kr.or.kosta.betting.betting.Betting;
import kr.or.kosta.betting.member.Member;

public class MemberBetData {

	private Betting betting;

	private Member member;

	/**
	 * ������ ��ȣ
	 */
	private String num;

//	/**
//	 * ������ ����ȣ
//	 */
//	private String seleTeamNum;

	/**
	 * ���ÿ� ���� �̳׶�
	 */
	private long betMineral;

	/**
	 * ���� �� �ð�
	 */
	private String seleTime;

	/**
	 * ������ �޾Ҵ� �� �ʹ޾Ҵ��� Ȯ�� ��ȣ
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
