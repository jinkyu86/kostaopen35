package kr.or.kosta.auction.good;

public class Good {

	private String gNum;
	private String gName;
	private String detail;
	private String img;

	public String getgNum() {
		return gNum;
	}
	public void setgNum(String gNum) {
		this.gNum = gNum;
	}
	public String getGnum() {
		return gNum;
	}
	public void setGnum(String gNum) {
		this.gNum = gNum;
	}	
	public String getgName() {
		return gName;
	}
	public void setgName(String gName) {
		this.gName = gName;
	}
	public String getGname() {
		return gName;
	}
	public void setGname(String gName) {
		this.gName = gName;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	@Override
	public String toString() {
		return "Good [gNum=" + gNum + ", gName=" + gName + ", detail=" + detail
				+ ", img=" + img + "]";
	}
}
