package kr.or.kosta.betting.loc;

public class Loc {

	/**
	 * 연고지 번호
	 */
	private String num;

	/**
	 * 연고지 이름
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
