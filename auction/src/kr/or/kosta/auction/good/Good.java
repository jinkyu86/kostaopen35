package kr.or.kosta.auction.good;

public class Good {

	private String gNum;//물품고유번호
	private String gName;//물품의 이름
	private String detail;//물품 살세설명
	private String img;//물품의 이미지
//	private Auction auction;
	public String getgNum() {
		return gNum;
	}
	public void setgNum(String gNum) {
		this.gNum = gNum;
	}
	public String getgName() {
		return gName;
	}
	public void setgName(String gName) {
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
