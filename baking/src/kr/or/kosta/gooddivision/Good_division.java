package kr.or.kosta.gooddivision;

import kr.or.kosta.good.Good;

public class Good_division {

	/**
	 * 상품번호
	 */
	private int division;

	/**
	 * 상품이름
	 */
	private String gName;

	public int getDivision() {
		return division;
	}

	public void setDivision(int division) {
		this.division = division;
	}

	public String getgName() {
		return gName;
	}

	public void setgName(String gName) {
		this.gName = gName;
	}

	@Override
	public String toString() {
		return "Good_division [division=" + division + ", gName=" + gName + "]";
	}

//	private Good good_division;
	
}
