package kr.or.kosta.change;

import java.util.Date;

import kr.or.kosta.bookchange.board.Board;

public class Change {

	private Board youBoard;//내가 원하는 물건 보드번호
	private Condition condition;//교환가능상태
	private Board myBoard;//내가 등록한 물건 보드번호
	private int changeNo;//교환번호
	private Date changeDate;//교환신청일시
	
	public Board getYouBoard() {
		return youBoard;
	}
	public void setYouBoard(Board youBoard) {
		this.youBoard = youBoard;
	}
	public Condition getCondition() {
		return condition;
	}
	public void setCondition(Condition condition) {
		this.condition = condition;
	}
	public Board getMyBoard() {
		return myBoard;
	}
	public void setMyBoard(Board myBoard) {
		this.myBoard = myBoard;
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
		return "Change [youBoard=" + youBoard + ", condition=" + condition
				+ ", myBoard=" + myBoard + ", changeNo=" + changeNo
				+ ", changeDate=" + changeDate + "]";
	}
	
	
}
