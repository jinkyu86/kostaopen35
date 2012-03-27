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
		 * ����� ��� ��������Ʈ�� ��ȸ�ϴ� �޼���
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
		 * ��� ������ ����
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
		 * ���̵� ���� ���õ� ��������� ��ȸ
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
		 * ���̵�� ���õ� ������ ����
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
		 * �̳׶� ������ �������� ������ �������Ʈ
		 * 
		 * @param page
		 * @param length
		 */
		
	}

	public void updateMember(Member member) {

		/**
		 * ���õ� ���̵��� ������ ������Ʈ ��
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
		 * ������ ������ ���� ��� ī����
		 */
		
	}
}
