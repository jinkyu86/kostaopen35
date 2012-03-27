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
	public void insertMember(Member member) {
		/* default generated stub */;
	}

	/**
	 * @param member
	 */
	public void updateMember(Member member) {
		/* default generated stub */;
	}

	/**
	 * @param userid
	 */
	public void deleteMember(String userid) {
		/* default generated stub */;
	}

	/**
	 * @param userid
	 */
	public static Member selectMember(String userid) {
		Connection con=null;
		PreparedStatement psmt=null;
		String sql=null;
		ResultSet rs=null;
		Member member=null;
		try {
			con=ConnectionUtil.getConnection();
			sql="SELECT  userid,pw,email,name,coin,emoney" +
					"  FROM  member " ;
			
				psmt=con.prepareStatement(sql);
				psmt.setString(1,userid);
				rs=psmt.executeQuery();
				if(rs.next()){
					String pw=rs.getString(2);
					String email=rs.getString(3);
					String name=rs.getString(4);
					String coin=rs.getString(5);
					String emoney=rs.getString(6);
					
					member=new Member();
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
