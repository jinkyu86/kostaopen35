package kr.or.kosta.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import kr.or.kosta.util.ConnectionUtil;

public class MemberDAO {

	/**
	 * 회원가입 Member테이블의 회원정보삽입
	 * 
	 * @param member
	 */
	public static void insertMember(Member member) {
		Connection con=null;
		PreparedStatement psmt=null;
		con=ConnectionUtil.getConnection();
		try {
			psmt=con.prepareStatement(
					"INSERT INTO member" +
					"(memberid,password,name,regi_number,pw_hint,pw_answer,zipcode,address," +
					"str_address,email,phone_number,tel_number)" +
					"values(?,?,?,?,?,?,?,?,?,?,?,?)");
			psmt.setString(1,member.getMemberid());
			psmt.setString(2,member.getPassword());
			psmt.setString(3,member.getName());
			psmt.setString(4,member.getZipcode());
			psmt.setString(5,member.getAddress());
			psmt.setString(6,member.getEmail());
			psmt.setString(7,member.getRegiNumber());
			psmt.setString(8,member.getPwHint());
			psmt.setString(9,member.getPwAnswer());
			psmt.setString(10,member.getStrAddress());
			psmt.setString(11,member.getPhoneNumber());
			psmt.setString(12,member.getTelNumber());
			
			psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	/**
	 * 아이디찾기 회원이름,주민등록번호가 일치하는 아이디찾기
	 * 
	 * @param name
	 * @param reginum
	 */
	public static Member selectMemberByid(String name, String reginum) {
		Connection con=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		Member member=new Member();
		try {
			con=ConnectionUtil.getConnection();
			psmt=con.prepareStatement(
					"SELECT memberid,password,name,regi_number,pw_hint,pw_answer,zipcode,address," +
					"str_address,email,phone_number,tel_number" +
					" FROM member" +
					" WHERE name=? and reginum=? ");
			psmt.setString(1,name);
			psmt.setString(2,reginum);
			rs=psmt.executeQuery();
			while(rs.next()){
				String memberid=rs.getString(1);
				String password=rs.getString(2);
				String pw_hint=rs.getString(3);
				String pw_answer=rs.getString(4);
				String zipcode=rs.getString(5);
				String address=rs.getString(6);
				String str_address=rs.getString(7);
				String email=rs.getString(8);
				String phone_number=rs.getString(9);
				String tel_number=rs.getString(10);
				
				
				
				member.setMemberid(memberid);
				member.setPassword(password);
				member.setName(name);
				member.setRegiNumber(reginum);
				member.setPwHint(pw_hint);
				member.setPwAnswer(pw_answer);
				member.setZipcode(zipcode);
				member.setAddress(address);
				member.setStrAddress(str_address);
				member.setEmail(email);
				member.setPhoneNumber(phone_number);
				member.setTelNumber(tel_number);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return member;
	}

	/**
	 * 패스워드찾기 힌트의질문/답변과 일치하는 정보찾기
	 * 
	 * @param hint
	 * @param answer
	 */
	public static Member selectMemberBypw(String hint, String answer) {
		Connection con=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		Member member=new Member();
		try {
			con=ConnectionUtil.getConnection();
			psmt=con.prepareStatement(
					"SELECT memberid,password,name,regi_number,pw_hint,pw_answer,zipcode,address," +
					"str_address,email,phone_number,tel_number" +
					" FROM member" +
					" WHERE hint=? and answer=? ");
			psmt.setString(1,hint);
			psmt.setString(2,answer);
			rs=psmt.executeQuery();
			while(rs.next()){
				String memberid=rs.getString(1);
				String password=rs.getString(2);
				String name=rs.getString(3);
				String regi_number=rs.getString(4);
				String pw_hint=rs.getString(5);
				String pw_answer=rs.getString(6);
				String zipcode=rs.getString(7);
				String address=rs.getString(8);
				String str_address=rs.getString(9);
				String email=rs.getString(10);
				String phone_number=rs.getString(11);
				String tel_number=rs.getString(12);
				
				
				
				member.setMemberid(memberid);
				member.setPassword(password);
				member.setName(name);
				member.setRegiNumber(regi_number);
				member.setPwHint(pw_hint);
				member.setPwAnswer(pw_answer);
				member.setZipcode(zipcode);
				member.setAddress(address);
				member.setStrAddress(str_address);
				member.setEmail(email);
				member.setPhoneNumber(phone_number);
				member.setTelNumber(tel_number);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return member;
	}

	/**
	 * 회원탈퇴 회원비밀번호, 주민등록번호가 일치시 회원탈퇴
	 * 
	 * @param pw
	 * @param reginum
	 */
	public static void deleteMember(String pw, String reginum) {
		Connection con=null;
		PreparedStatement psmt=null;
		con=ConnectionUtil.getConnection();
		try {
			psmt=con.prepareStatement(
					"DELETE FROM member" +
					" WHERE pw=? and reginum=? ");
			psmt.setString(1,pw);
			psmt.setString(2,reginum);
			psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}

	/**
	 * 회원정보 수정
	 * 
	 * @param member
	 */
	public static void updateMember(Member member) {
		Connection con=null;
		PreparedStatement psmt=null;
		con=ConnectionUtil.getConnection();
		try {
			psmt=con.prepareStatement(
					"UPDATE member" +
					" SET password=? , name=?, zipcode=?, address=?, email=?, regi_number=?, " +
					"pw_hint=?, pw_answer=?, str_address=?, phone_number=?, tel_number=? " +
					" WHERE memberid=? ");
			psmt.setString(1,member.getMemberid());
			psmt.setString(2,member.getPassword());
			psmt.setString(3,member.getName());
			psmt.setString(4,member.getZipcode());
			psmt.setString(5,member.getAddress());
			psmt.setString(6,member.getEmail());
			psmt.setString(7,member.getRegiNumber());
			psmt.setString(8,member.getPwHint());
			psmt.setString(9,member.getPwAnswer());
			psmt.setString(10,member.getStrAddress());
			psmt.setString(11,member.getPhoneNumber());
			psmt.setString(12,member.getTelNumber());
			psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
//	public static Member login(String memberid,String password){
//		Member member=null;
//		Connection con=null;
//		PreparedStatement psmt=null;
//		ResultSet rs=null;
//		String sql="select memberid,password,name,regi_number,pw_hint,pw_answer,zipcode,address,str_address,email,phone_number,tel_number"+
//				     " from member"+
//				     " where memberid=? and password=?";
//		try {
//			con=ConnectionUtil.getConnection();
//			psmt=con.prepareStatement(sql);
//			psmt.setString(1, memberid);
//			psmt.setString(2, password);
//			rs=psmt.executeQuery();
//			if(rs.next()){
//				member = new Member(memberid,password,rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10));
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return member;
//	}
}