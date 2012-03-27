package kr.or.kosta.betting.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.or.kosta.betting.util.ConnectionUtil;

public class MemberDAO {

	public ArrayList<Member> selectMemberList(int page, int length) {

		/**
		 * 멤버의 모든 정보리스트를 조회하는 메서드
		 * 
		 * @param page
		 * @param length
		 */
		
		Connection con=null;
		PreparedStatement psmt=null;
		String sql=null;
		ResultSet rs=null;
		ArrayList<Member>MemberList=
				new ArrayList<Member>();
		try {
			con=ConnectionUtil.getConnection();
			sql="SELECT  id,name,pw,email,mineral" +
					" FROM  member" ;
			
				psmt=con.prepareStatement(sql);
				rs=psmt.executeQuery();
				while(rs.next()){
					String id=rs.getString(1);
					String name=rs.getString(2);
					String pw=rs.getString(3);
					String email=rs.getString(4);
					Long mineral=rs.getLong(5);
				
					Member member=new Member();
					member.setID(id);
					member.setName(name);
					member.setPW(pw);
					member.setEmail(email);
					member.setMineral(mineral);
					
					MemberList.add(member);

				}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return MemberList;
	}


	public void insultMember(Member member) {
		
		/**
		 * 멤버 데이터 삽입
		 * 
		 * @param member
		 */
		
		Connection con=null;
		PreparedStatement psmt=null;
		con=ConnectionUtil.getConnection();
		try{	
			psmt=con.prepareStatement(
					"INSERT INTO member " +
					"(id,name,pw,email,mineral) " +
					" VALUES (?,?,?,?,?)");
			psmt.setString(1,member.getID());
			psmt.setString(2,member.getName());
			psmt.setString(3,member.getPW());
			psmt.setString(4,member.getEmail());
			psmt.setLong(5,member.getMineral());
			psmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}	
	}

	public Member selectMemberByID(String ID) {
		
		/**
		 * 아이디를 통해 선택된 멤버데이터 조회
		 * 
		 * @param ID
		 */
		
		Connection con=null;
		PreparedStatement psmt=null;
		String sql=null;
		ResultSet rs=null;
		Member member=null;
		try {
			con=ConnectionUtil.getConnection();
			sql="SELECT  id,name,pw,email,mineral" +
					"  FROM  member" +
					" WHERE id=?";
			
				psmt=con.prepareStatement(sql);
				psmt.setString(1,ID);
				rs=psmt.executeQuery();
				if(rs.next()){
					String id=rs.getString(1);
					String name=rs.getString(2);
					String pw=rs.getString(3);
					String email=rs.getString(4);
					Long mineral=rs.getLong(5);
									
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return member;
	}

	public void deleteMember(String ID) {

		/**
		 * 아이디로 선택된 데이터 삭제
		 * 
		 * @param ID
		 */
		
		Connection con=null;
		PreparedStatement psmt=null;
		con=ConnectionUtil.getConnection();
		try{	
			psmt=con.prepareStatement(
					"DELETE FROM member" +
					"WHERE id=?");
			
		psmt.setString(1,ID);
			
			psmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public ArrayList selectMemberRankingList(int page, int length) {

		/**
		 * 미네랄 순으로 오름차순 정열된 멤버리스트
		 * 
		 * @param page
		 * @param length
		 */
		
	}

	public void updateMember(Member member) {

		/**
		 * 선택된 아이디의 정보를 업데이트 함
		 * 
		 * @param ID
		 * @param PW
		 * @param Email
		 * @param mineral
		 */
		
		Connection con=null;
		PreparedStatement psmt=null;
		con=ConnectionUtil.getConnection();
		try{	
			psmt=con.prepareStatement(
					"UPDATE  SET pw=?," +
					"email=?," +
					"mineral=? " +
					"WHERE id=?");
			
			psmt.setString(1,member.getPW());
			psmt.setString(2,member.getEmail());
			psmt.setLong(3,member.getMineral());
			psmt.setString(4,member.getID());
			
			psmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

	public int countMember() {
		
		/**
		 * 페이지 설정을 위한 멤버 카운터
		 */
		
	}
}
