package kr.or.kosta.betting.betting;

import kr.or.kosta.betting.match.Match;

public class Betting {

	/**
	 * ���� ��ȣ
	 */
	private String num;

	/**
	 * ��ġ �Ӽ�
	 */
	private Match match;

	/**
	 * ���÷�
	 */
	private long batRating;

	/**
	 * ����Ƚ��
	 */
	private long seleRating;

	/**
	 * ���õ� ���� ���ñ� �Ѿ�
	 */
	private long totMineral;

	/**
	 * Ȩ���� ������� ���� ��ȣ
	 */
	private String distnum;

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public Match getMatch() {
		return match;
	}

	public void setMatch(Match match) {
		this.match = match;
	}

	public long getBatRating() {
		return batRating;
	}

	public void setBatRating(long batRating) {
		this.batRating = batRating;
	}

	public long getSeleRating() {
		return seleRating;
	}

	public void setSeleRating(long seleRating) {
		this.seleRating = seleRating;
	}

	public long getTotMineral() {
		return totMineral;
	}

	public void setTotMineral(long totMineral) {
		this.totMineral = totMineral;
	}

	public String getDistnum() {
		return distnum;
	}

	public void setDistnum(String distnum) {
		this.distnum = distnum;
	}

	@Override
	public String toString() {
		return "Betting [num=" + num + ", match=" + match + ", batRating="
				+ batRating + ", seleRating=" + seleRating + ", totMineral="
				+ totMineral + ", distnum=" + distnum + "]";
	}

}
