package kr.or.kosta.auction.member;

import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kr.or.kosta.auction.good.Good;
import kr.or.kosta.auction.util.ConnectionUtil;

public class MemberDAO {

	/**
	 * @param member
	 */
	private static String resource="sqlmap-config.xml";
	private static Reader sqlReader;
	static{
			try {
				sqlReader=Resources.getResourceAsReader(resource);
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
	private static SqlSessionFactory sqlMapper =
			new SqlSessionFactoryBuilder().build(sqlReader);
	
	
	public static void insertMember(Member member) {
		SqlSession session=null;
		try{
			session=sqlMapper.openSession(true);
			session.insert("Member.insertMember", member);
		}
		finally{
			session.close();
		}
	}
//	public static void insertMember(Member member) {
//		Connection con = null;
//		PreparedStatement psmt = null;
//		con = ConnectionUtil.getConnection();
//		try {
//			psmt = con.prepareStatement("INSERT INTO MEMBER"
//					+ " (userid,pw,email,name,coin,emoney)"
//					+ " VALUES(?,?,?,?,'100','5000000')");
//			psmt.setString(1, member.getUserid());
//			psmt.setString(2, member.getPw());
//			psmt.setString(3, member.getEmail());
//			psmt.setString(4, member.getName());
//			psmt.executeUpdate();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	public static void updateMember(Member member) {
		SqlSession session=null;
		try{
			session=sqlMapper.openSession(true);
			session.update("Member.updateMember", member);
		}
		finally{
			session.close();
		}
	}

//	public static void updateMember(Member member) {
//		Connection con = null;
//		PreparedStatement psmt = null;
//		con = ConnectionUtil.getConnection();
//		try {
//			psmt = con.prepareStatement("UPDATE MEMBER " +
//													  "SET pw=?," +
//													  "email=?," +
//													  "name=?," +
//													  "coin=?," +
//													  "emoney=? " +
//													  "WHERE userid=?");
//			psmt.setString(1, member.getPw());
//			psmt.setString(2, member.getEmail());
//			psmt.setString(3, member.getName());
//			psmt.setString(4, member.getCoin());
//			psmt.setString(5, member.getEmoney());
//			psmt.setString(6, member.getUserid());
//			psmt.executeUpdate();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	/**
	 * @param userid
	 */
	public static void deleteMember(String userid) {
		SqlSession session=null;
		try{
			session=sqlMapper.openSession(true);
			session.delete("Member.deleteMember", userid);
		}
		finally{
			session.close();
		}
	}
//	public static void deleteMember(String userid) {
//		Connection con = null;
//		PreparedStatement psmt = null;
//		con = ConnectionUtil.getConnection();
//		try {
//			psmt = con.prepareStatement(" DELETE FROM MEMBER"
//					+ " WHERE userid=?");
//
//			psmt.setString(1, userid);
//			psmt.executeUpdate();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	/**
	 * @param userid
	 * @return
	 */
	public static Member selectMember(String userid) {
		SqlSession session=null;
		Member member=null;
		try{
			session=sqlMapper.openSession(true);
			member=session.selectOne("selectMember", userid);
		}
		finally{
			session.close();
		}
		return member;
	}
//	public static Member selectMember(String userid) {
//		Connection con = null;
//		PreparedStatement psmt = null;
//		String sql = null;
//		ResultSet rs = null;
//		Member member = null;
//		try {
//			con = ConnectionUtil.getConnection();
//			sql = "SELECT pw,email,name,coin,emoney" + "  FROM  member "
//					+ " WHERE userid=?";
//
//			psmt = con.prepareStatement(sql);
//			psmt.setString(1, userid);
//			rs = psmt.executeQuery();
//			if (rs.next()) {
//				String pw = rs.getString(1);
//				String email = rs.getString(2);
//				String name = rs.getString(3);
//				String coin = rs.getString(4);
//				String emoney = rs.getString(5);
//
//				member = new Member();
//				member.setUserid(userid);
//				member.setPw(pw);
//				member.setEmail(email);
//				member.setName(name);
//				member.setCoin(coin);
//				member.setEmoney(emoney);
//
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return member;
//	}
	public static List<Member> selectMemberList() {
		SqlSession session=null;
		List<Member> memberList=null;
		try{
			session=sqlMapper.openSession(true);
			memberList=session.selectList("Member.selectMemberList");
		}
		finally{
			session.close();
		}
		return memberList;
	}

//	public static ArrayList<Member> selectMemberList() {
//		Connection con = null;
//		PreparedStatement psmt = null;
//		String sql = "SELECT userid,pw,email,name,coin,emoney " + " FROM member" + " ORDER BY userid";
//		ResultSet rs = null;
//		ArrayList<Member> memberList = new ArrayList<Member>();
//
//		try {
//			con = ConnectionUtil.getConnection();
//			psmt = con.prepareStatement(sql);
//			rs = psmt.executeQuery();
//			while (rs.next()) {
//				String userid = rs.getString(1);
//				String pw = rs.getString(2);
//				String email = rs.getString(3);
//				String name = rs.getString(4);
//				String coin = rs.getString(5);
//				String emoney = rs.getString(6);
//
//				Member member = new Member();
//				member.setUserid(userid);
//				member.setPw(pw);
//				member.setEmail(email);
//				member.setName(name);
//				member.setCoin(coin);
//				member.setEmoney(emoney);
//				memberList.add(member);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return memberList;
//	}
	public static List<Member> selectMemberList(int page,int length) {
		SqlSession session = sqlMapper.openSession(true);
		RowBounds rowBounds= new RowBounds((page-1)*length,length);
		List<Member> member=
		session.selectList("Member.selectMemberList",null,rowBounds);
		return member;
	}

	
	


}
