package kr.or.kosta.change;

import java.util.Date;

import kr.or.kosta.bookchange.board.Board;

public class Change {

	private Board agreeBoard;//���� ���ϴ� ���� �����ȣ
	private Condition condition;//��ȯ���ɻ���
	private Board demandBoard;//���� ����� ���� �����ȣ
	private int changeNo;//��ȯ��ȣ
	private Date changeDate;//��ȯ��û�Ͻ�
	
	public Board getAgreeBoard() {
		return agreeBoard;
	}
	public void setAgreeBoard(Board agreeBoard) {
		this.agreeBoard = agreeBoard;
	}
	public Condition getCondition() {
		return condition;
	}
	public void setCondition(Condition condition) {
		this.condition = condition;
	}
	public Board getDemandBoard() {
		return demandBoard;
	}
	public void setDemandBoard(Board demandBoard) {
		this.demandBoard = demandBoard;
	}
	public int getChangeNo() {
		return changeNo;
	}
	public void setChangeNo(int changeNo) {
		this.changeNo = changeNo;
	}
	public Date getChangeDate() {
		return changeDate;
	}
	public void setChangeDate(Date changeDate) {
		this.changeDate = changeDate;
	}
	@Override
	public String toString() {
		return "Change [agreeBoard=" + agreeBoard + ", condition=" + condition
				+ ", demandBoard=" + demandBoard + ", changeNo=" + changeNo
				+ ", changeDate=" + changeDate + "]";
	}
	
	
	
}
