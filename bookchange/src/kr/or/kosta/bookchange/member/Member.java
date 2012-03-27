package kr.or.kosta.bookchange.member;

public class Member {

	/**
	 * email (email을 아이디로 쓴다)
	 */
	private String email;

	/**
	 * 전화번호
	 */
	private String tel;

	/**
	 * 주소
	 */
	private String address;

	/**
	 * 비밀번호
	 */
	private String pw;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	@Override
	public String toString() {
		return "Member [email=" + email + ", tel=" + tel + ", address="
				+ address + ", pw=" + pw + "]";
	}

	


	
}
