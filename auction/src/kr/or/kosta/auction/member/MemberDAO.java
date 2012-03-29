package kr.or.kosta.auction.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import kr.or.kosta.auction.util.ConnectionUtil;



public class MemberDAO {

	/**
	 * @param member
	 */
	public static void insertMember(Member member) {
		Connection con = null;
		PreparedStatement psmt =null;
		con = ConnectionUtil.getConnection();
		try{
		psmt = con.prepareStatement("INSERT INTO MEMBER" +
		                         " (userid,pw,email,name,coin,emoney)"+
				                  " VALUES(?,?,?,?,'100','50')");
		psmt.setString(1, member.getUserid());
		psmt.setString(2, member.getPw());
		psmt.setString(3, member.getEmail());
		psmt.setString(4, member.getName());
		psmt.executeUpdate();
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	

	/**
	 * @param member
	 */
	public static void updateMember(Member member) {
		Connection con = null;
		PreparedStatement psmt = null;
		con = ConnectionUtil.getConnection();
		try {
			psmt = con.prepareStatement(" UPDATE MEMBER " +
		                                " SET  pw=?,email=?,name=?,coin=?,emoney=?" + 
					                    " WHERE userid=? ");
			
			
			psmt.setString(1, member.getPw());
			psmt.setString(2, member.getEmail());
			psmt.setString(3, member.getName());
			psmt.setString(4, member.getCoin());
			psmt.setString(5, member.getEmoney());
			psmt.setString(6, member.getUserid());
			psmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * @param userid
	 */
	public static void deleteMember(String userid) {
		Connection con = null;
		PreparedStatement psmt = null;
		con = ConnectionUtil.getConnection();
		try{
			psmt=con.prepareStatement(" DELETE FROM MEMBER" +
		                                " WHERE userid=?");
		
		psmt.setString(1, userid);
		psmt.executeUpdate();
		}catch (Exception e){
			e.printStackTrace();
		}
	}

	/**
	 * @param userid
	 * @return 
	 */
	public static Member selectMember(String userid) {
		Connection con=null;
		PreparedStatement psmt=null;
		String sql=null;
		ResultSet rs=null;
		Member member=null;
		try {
			con=ConnectionUtil.getConnection();
			sql="SELECT pw,email,name,coin,emoney" +
					"  FROM  member " +
					" WHERE userid=?";
			
				psmt=con.prepareStatement(sql);
				psmt.setString(1,userid);
				rs=psmt.executeQuery();
				if(rs.next()){
					String pw=rs.getString(1);
					String email=rs.getString(2);
					String name=rs.getString(3);
					String coin=rs.getString(4);
					String emoney=rs.getString(5);
					
					member=new Member();
					member.setUserid(userid);
					member.setPw(pw);
					member.setEmail(email);
					member.setName(name);
					member.setCoin(coin);
					member.setEmoney(emoney);
					
				
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return member;
	}
}
