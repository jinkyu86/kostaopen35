package kr.or.kosta.betting.member;

public class Member {

	private String id;

	private String name;

	private String pw;

	private String email;

	private long mineral;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getMineral() {
		return mineral;
	}

	public void setMineral(long mineral) {
		this.mineral = mineral;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", name=" + name + ", pw=" + pw
				+ ", email=" + email + ", mineral=" + mineral + "]";
	}

	
	
}
