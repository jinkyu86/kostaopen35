package kr.or.kosta.moviesystem.good;

public class Good {

	/**
	 * 상품번호
	 */
	private String gnum;

	/**
	 * 상품이름
	 */
	private String gname;

	/**
	 * 상품상세설명
	 */
	private String detail;

	/**
	 * 상품가격
	 */
	private long gprice;

	/**
	 * 상품사진
	 */
	private String photo;

	public String getGnum() {
		return gnum;
	}

	public void setGnum(String gnum) {
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

	public long getGprice() {
		return gprice;
	}

	public void setGprice(long gprice) {
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
