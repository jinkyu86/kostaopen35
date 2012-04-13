package kr.or.kosta.member;

import kr.or.kosta.myrecipe.Myrecipe;
import kr.or.kosta.order.Order;

public class Member {

	private String memberid;	//회원아이디
	private String password;	//패스워드
	private String name;		//회원이름
	private String regiNumber;	//주민번호
	private String pwHint;		//비밀번호힌트
	private String pwAnswer;	//비밀번호정답
	private String zipcode;		//우편번호
	private String address;		//주소
	private String strAddress;	//상세주소
	private String email;		//메일
	private String phoneNumber;	//핸드폰번호
	private String telNumber;	//유선전화

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

	public Member(String memberid, String password, String name,
			String regiNumber, String pwHint, String pwAnswer, String zipcode,
			String address, String strAddress, String email,
			String phoneNumber, String telNumber) {
		super();
		this.memberid = memberid;
		this.password = password;
		this.name = name;
		this.regiNumber = regiNumber;
		this.pwHint = pwHint;
		this.pwAnswer = pwAnswer;
		this.zipcode = zipcode;
		this.address = address;
		this.strAddress = strAddress;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.telNumber = telNumber;
	}

	public Member() {
		super();
		// TODO Auto-generated constructor stub
	}

//	private Order member;

//	private Myrecipe member;
	
}
