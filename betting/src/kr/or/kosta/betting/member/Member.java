package kr.or.kosta.betting.member;

public class Member {

	private String ID;

	private String name;

	private String PW;

	private String Email;

	private long Mineral;

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPW() {
		return PW;
	}

	public void setPW(String pW) {
		PW = pW;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public long getMineral() {
		return Mineral;
	}

	public void setMineral(long mineral) {
		Mineral = mineral;
	}

	@Override
	public String toString() {
		return "Member [ID=" + ID + ", name=" + name + ", PW=" + PW
				+ ", Email=" + Email + ", Mineral=" + Mineral + "]";
	}

	
}
