package kr.or.kosta.betting.loc;

public class Loc {

	/**
	 * ������ ��ȣ
	 */
	private String num;

	/**
	 * ������ �̸�
	 */
	private String loc;

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

	@Override
	public String toString() {
		return "Loc [num=" + num + ", loc=" + loc + "]";
	}


}
