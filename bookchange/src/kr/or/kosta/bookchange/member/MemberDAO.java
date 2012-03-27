package kr.or.kosta.bookchange.member;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import kr.or.kosta.util.ConnectionUtil;



import com.sun.corba.se.pept.transport.Connection;

public class MemberDAO {

	/**
	 * (관리자 전용)회원명단 조회
	 * 
	 * @param length
	 * @param page
	 */
	public ArrayList<Member> selectMemberList(int length, int page, String email) {
		/* default generated stub */;
		Connection con=null;
		PreparedStatement psmt=null;
		String sql=null;
		ResultSet rs=null;
		ArrayList<Member> memberList=new ArrayList<Member>();
		try {
			con=(Connection) ConnectionUtil.getConnection();
			sql="select from where";
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		return memberList;
	}

	/**
	 * 전체 회원수 리턴
	 */
	public int selectMemberCount() {
		/* default generated stub */;
		return 0;
	}

	/**
	 * 회원정보보기
	 * 
	 * @param email
	 */
	public Member selectMember(String email) {
		/* default generated stub */;
		return null;
	}

	/**
	 * Email로 회원 검색(로그인시 중복 아이디 있는지 검색할 때나 관리자가 회원 검색 시 사용)
	 * 
	 * @param email
	 */
	public Member selectMemberbyEmail(String email) {
		/* default generated stub */;
		return null;
	}

	/**
	 * 회원가입시 DB에 추가
	 * 
	 * @param member
	 */
	public void insertMember(Member member) {
		/* default generated stub */;
	}

	/**
	 * 회원수정
	 * 
	 * @param email
	 */
	public Member updateMember(String email) {
		/* default generated stub */;
		return null;
	}

	/**
	 * 회원탈퇴(DB에서 삭제)
	 * 
	 * @param email
	 */
	public void deleteMember(String email) {
		/* default generated stub */;
		
	}
}
