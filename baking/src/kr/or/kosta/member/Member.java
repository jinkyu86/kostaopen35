package kr.or.kosta.member;

import kr.or.kosta.myrecipe.Myrecipe;
import kr.or.kosta.order.Order;

public class Member {

	/**
	 * 회원아이디 ghgh
	 */
	private String memberid;

	/**
	 * 패스워드
	 */
	private String password;

	/**
	 * 회원이름
	 */
	private String name;

	/**
	 * 주민등록번호
	 */
	private String regiNumber;

	/**
	 * 비밀번호찾기힌트
	 */
	private String pwHint;

	/**
	 * 패스워드찾기정답
	 */
	private String pwAnswer;

	/**
	 * 우편번호
	 */
	private String zipcode;

	/**
	 * 주소
	 */
	private String address;

	/**
	 * 상세주소
	 */
	private String strAddress;

	/**
	 * 이메일
	 */
	private String email;

	/**
	 * 핸드폰번호
	 */
	private String phoneNumber;

	/**
	 * 유선전화번호
	 */
	private String telNumber;

	public String getMemberid() {
		return memberid;
	}

	public void setMemberid(String memberid) {
		this.memberid = memberid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRegiNumber() {
		return regiNumber;
	}

	public void setRegiNumber(String regiNumber) {
		this.regiNumber = regiNumber;
	}

	public String getPwHint() {
		return pwHint;
	}

	public void setPwHint(String pwHint) {
		this.pwHint = pwHint;
	}

	public String getPwAnswer() {
		return pwAnswer;
	}

	public void setPwAnswer(String pwAnswer) {
		this.pwAnswer = pwAnswer;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getStrAddress() {
		return strAddress;
	}

	public void setStrAddress(String strAddress) {
		this.strAddress = strAddress;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getTelNumber() {
		return telNumber;
	}

	public void setTelNumber(String telNumber) {
		this.telNumber = telNumber;
	}

	@Override
	public String toString() {
		return "Member [memberid=" + memberid + ", password=" + password
				+ ", name=" + name + ", regiNumber=" + regiNumber + ", pwHint="
				+ pwHint + ", pwAnswer=" + pwAnswer + ", zipcode=" + zipcode
				+ ", address=" + address + ", strAddress=" + strAddress
				+ ", email=" + email + ", phoneNumber=" + phoneNumber
				+ ", telNumber=" + telNumber + "]";
	}

//	private Order member;

//	private Myrecipe member;
	
}
