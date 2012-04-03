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
	public void insertMember(Member member) {
		/* default generated stub */;
//		return null;
	}

	/**
	 * 아이디찾기 회원이름,주민등록번호가 일치하는 아이디찾기
	 * 
	 * @param name
	 * @param reginum
	 */
	public Member selectMemberByid(String name, String reginum) {
		/* default generated stub */;
		return null;
	}

	/**
	 * 패스워드찾기 힌트의질문/답변과 일치하는 정보찾기
	 * 
	 * @param hint
	 * @param answer
	 */
	public Member selectMemberBypw(String hint, String answer) {
		/* default generated stub */;
		return null;
	}

	/**
	 * 회원탈퇴 회원비밀번호, 주민등록번호가 일치시 회원탈퇴
	 * 
	 * @param pw
	 * @param reginum
	 */
	public void deleteMember(String pw, String reginum) {
		/* default generated stub */;
//		return null;
	}

	/**
	 * 회원정보 수정
	 * 
	 * @param member
	 */
	public void updateMember(Member member) {
		/* default generated stub */;
//		return null;
	}
	
	public static Member login(String memberid,String password){
		Member member=null;
		Connection con=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		String sql="select memberid,password,name,regi_number,pw_hint,pw_answer,zipcode,address,str_address,email,phone_number,tel_number"+
				     " from member"+
				     " where memberid=? and password=?";
		try {
			con=ConnectionUtil.getConnection();
			psmt=con.prepareStatement(sql);
			psmt.setString(1, memberid);
			psmt.setString(2, password);
			rs=psmt.executeQuery();
			if(rs.next()){
				member = new Member(memberid,password,rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return member;
	}
}