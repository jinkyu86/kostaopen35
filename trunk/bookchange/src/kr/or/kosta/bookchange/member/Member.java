package kr.or.kosta.bookchange.member;

public class Member {

	/**
	 * email (email�� ���̵�� ����)
	 */
	private String email;

	/**
	 * ��ȭ��ȣ
	 */
	private String tel;

	/**
	 * �ּ�
	 */
	private String address;

	/**
	 * ��й�ȣ
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
