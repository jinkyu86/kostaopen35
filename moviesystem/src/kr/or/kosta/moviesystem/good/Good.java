package kr.or.kosta.moviesystem.good;

public class Good {

	/**
	 * ��ǰ��ȣ
	 */
	private Number gnum;

	/**
	 * ��ǰ�̸�
	 */
	private String gname;

	/**
	 * ��ǰ�󼼼���
	 */
	private String detail;

	/**
	 * ��ǰ����
	 */
	private Number gprice;

	/**
	 * ��ǰ����
	 */
	private String photo;

	public Number getGnum() {
		return gnum;
	}

	public void setGnum(Number gnum) {
		this.gnum = gnum;
	}

	public String getGname() {
		return gname;
	}

	public void setGname(String gname) {
		this.gname = gname;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public Number getGprice() {
		return gprice;
	}

	public void setGprice(Number gprice) {
		this.gprice = gprice;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	@Override
	public String toString() {
		return "Good [gnum=" + gnum + ", gname=" + gname + ", detail=" + detail
				+ ", gprice=" + gprice + ", photo=" + photo + "]";
	}

}
