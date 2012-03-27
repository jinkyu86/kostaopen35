package kr.or.kosta.bookchange.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import kr.or.kosta.util.ConnectionUtil;

public class MemberDAO {

	/**
	 * (관리자 전용)회원명단 조회
	 * 
	 * @param length
	 * @param page
	 */
	public static ArrayList<Member> selectMemberList(int length, int page) {
		/* default generated stub */;
		Connection con=null;
		PreparedStatement ps=null;
		String sql=null;
		ResultSet rs=null;
		ArrayList<Member> memberList=new ArrayList<Member>();
		try {
			con=ConnectionUtil.getConnection();
			sql="select email,tel,address,pw from tb_member ";
			ps=con.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,
										ResultSet.CONCUR_READ_ONLY);
			rs=ps.executeQuery();
			if(page>1){
				rs.absolute((page-1)*length);
			}
			//가져온 레코드 개수
			int getRecord=0;
			while (rs.next()&&getRecord<length) {
				getRecord++;
				String email=rs.getString(1);
				String tel=rs.getString(2);
				String address=rs.getString(3);
				String pw=rs.getString(4);
				Member member=new Member();
				member.setEmail(email);
				member.setAddress(address);
				member.setTel(tel);
				member.setPw(pw);
				memberList.add(member);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return memberList;
	}

	/**
	 * 전체 회원수 리턴
	 */
	public static int selectMemberCount() {
		Connection con=null;
		PreparedStatement ps=null;
		String sql=null;
		ResultSet rs=null;
		int memberCount=0;
		try {
			con=ConnectionUtil.getConnection();
			sql="select count(email) from tb_member "; 
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			if(rs.next()){
				memberCount=rs.getInt(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return memberCount;
	}

	/**
	 * 회원정보보기
	 * 
	 * @param email
	 */
	public static Member selectMember(String email) {
		Connection con=null;
		PreparedStatement ps=null;
		String sql=null;
		ResultSet rs=null;
		Member member=null;
		try {
			con=ConnectionUtil.getConnection();
			sql="select email,tel,address from tb_member where email=?";
			ps=con.prepareStatement(sql);
			ps.setString(1, email);
			rs=ps.executeQuery();
			if (rs.next()) {
				 email=rs.getString(1);
				 String tel=rs.getString(2);
				 String address=rs.getString(3);
				 
				 member=new Member();
				 member.setEmail(email);
				 member.setTel(tel);
				 member.setAddress(address);
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return member;
	}


	/**
	 * 회원가입시 DB에 추가
	 * 
	 * @param member
	 */
	public static void insertMember(Member member) {
		/* default generated stub */;
		Connection con=null;
		PreparedStatement ps=null;
		con=ConnectionUtil.getConnection();
		try {
			ps=con.prepareStatement("insert into tb_member " +
					"(email,tel,address,pw)" +
					"values(?,?,?,?)");
			ps.setString(1, member.getEmail());
			ps.setString(2, member.getTel());
			ps.setString(3, member.getAddress());
			ps.setString(4, member.getPw());
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	/**
	 * 회원수정
	 * 
	 * @param email
	 */
	public static Member updateMember(Member member) {
		/* default generated stub */;
		Connection con= null;
		PreparedStatement ps=null;
		con=ConnectionUtil.getConnection();
		
		try {
			ps=con.prepareStatement(
					"update tb_member" +
					"set tel=?,pw=?,address=? where email=?");
			ps.setString(1, member.getTel());
			ps.setString(2, member.getAddress());
			ps.setString(3, member.getPw());
			ps.setString(4, member.getEmail());
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return member;
	}

	/**
	 * 회원탈퇴(DB에서 삭제)
	 * 
	 * @param email
	 */
	public static void deleteMember(String email) {
		/* default generated stub */;
		
	}
}
