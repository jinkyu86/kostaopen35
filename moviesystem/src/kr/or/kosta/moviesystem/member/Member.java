package kr.or.kosta.moviesystem.member;

import java.util.Date;

public class Member {

	/**
	 * ȸ�� ���̵�
	 */
	private String userid;

	/**
	 * ȸ����ȣ
	 */
	private Number userNum;

	/**
	 * �̸�
	 */
	private String name;

	/**
	 * ȸ�� ��й�ȣ
	 */
	private String pw;

	/**
	 * ȸ�� �̸���
	 */
	private String email;

	/**
	 * ȸ�� ��ȭ��ȣ
	 */
	private String phone;

	/**
	 * ȸ�� �����ȣ
	 */
	private String zipcode;

	/**
	 * �ּ�
	 */
	private String addr;

	/**
	 * ȸ�� �����
	 */
	private Date regDate;

	/**
	 * ȸ������(Ż��  �Ǵ� ȸ��)
	 */
	private String memState;

	/**
	 * Ż������
	 */
	private String dropReason;

	/**
	 * Ż���� ��¥
	 */
	private Date dropDate;

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public Number getUserNum() {
		return userNum;
	}

	public void setUserNum(Number userNum) {
		this.userNum = userNum;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public String getMemState() {
		return memState;
	}

	public void setMemState(String memState) {
		this.memState = memState;
	}

	public String getDropReason() {
		return dropReason;
	}

	public void setDropReason(String dropReason) {
		this.dropReason = dropReason;
	}

	public Date getDropDate() {
		return dropDate;
	}

	public void setDropDate(Date dropDate) {
		this.dropDate = dropDate;
	}

	@Override
	public String toString() {
		return "Member [userid=" + userid + ", userNum=" + userNum + ", name="
				+ name + ", pw=" + pw + ", email=" + email + ", phone=" + phone
				+ ", zipcode=" + zipcode + ", addr=" + addr + ", regDate="
				+ regDate + ", memState=" + memState + ", dropReason="
				+ dropReason + ", dropDate=" + dropDate + "]";
	}
	
	

}
