package kr.or.kosta.bookchange.board;

public class Deal {

	/**
	 * �ŷ���ȣ
	 */
	private int dealNo;

	/**
	 * �ŷ����
	 */
	private String dealWay;

	public int getDealNo() {
		return dealNo;
	}

	public void setDealNo(int dealNo) {
		this.dealNo = dealNo;
	}

	public String getDealWay() {
		return dealWay;
	}

	public void setDealWay(String dealWay) {
		this.dealWay = dealWay;
	}

	@Override
	public String toString() {
		return "Deal [dealNo=" + dealNo + ", dealWay=" + dealWay + "]";
	}
	
}
