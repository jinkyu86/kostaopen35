package kr.or.kosta.betting.member;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.kosta.betting.util.ConnectionUtil;

public class MemberDAO {

	public static ArrayList<Member> selectMemberList(int length, int page) {

		/**
		 * 멤버의 모든 정보리스트를 조회하는 메서드
		 * 
		 * @param page
		 * @param length
		 */

		Connection con = null;
		PreparedStatement psmt = null;
		String sql = null;
		ResultSet rs = null;
		ArrayList<Member> MemberList = new ArrayList<Member>();
		try {
			con = ConnectionUtil.getConnection();
			sql = "SELECT  id,name,pw,email,mineral" + " FROM  member";

			psmt = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			rs = psmt.executeQuery();
			if (page > 1) {
				rs.absolute((page - 1) * length);
			}
			int getRecordCount = 0;
			while (rs.next() && getRecordCount < length) {
				getRecordCount++;
				String id = rs.getString(1);
				String name = rs.getString(2);
				String pw = rs.getString(3);
				String email = rs.getString(4);
				Long mineral = rs.getLong(5);

				Member member = new Member();
				member.setId(id);
				member.setName(name);
				member.setPw(pw);
				member.setEmail(email);
				member.setMineral(mineral);

				MemberList.add(member);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return MemberList;
	}

	public static void insultMember(Member member) {

		/**
		 * 멤버 데이터 삽입
		 * 
		 * @param member
		 */

		Connection con = null;
		PreparedStatement psmt = null;
		con = ConnectionUtil.getConnection();
		try {
			psmt = con.prepareStatement("INSERT INTO member "
					+ "(id,name,pw,email,mineral) " + " VALUES (?,?,?,?,5000)");
			psmt.setString(1, member.getId());
			psmt.setString(2, member.getName());
			psmt.setString(3, member.getPw());
			psmt.setString(4, member.getEmail());
			psmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Member selectMemberByID(String id) {

		/**
		 * 아이디를 통해 선택된 멤버데이터 조회
		 * 
		 * @param ID
		 */

		Connection con = null;
		PreparedStatement psmt = null;
		String sql = null;
		ResultSet rs = null;
		Member member = null;
		try {
			con = ConnectionUtil.getConnection();
			sql = "SELECT  id,name,pw,email,mineral" + "  FROM  member"
					+ " WHERE id=?";

			psmt = con.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			if (rs.next()) {

				String name = rs.getString(2);
				String pw = rs.getString(3);
				String email = rs.getString(4);
				Long mineral = rs.getLong(5);

				member = new Member();
				member.setId(id);
				member.setName(name);
				member.setPw(pw);
				member.setEmail(email);
				member.setMineral(mineral);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return member;
	}

	public static void deleteMember(String id) {

		/**
		 * 아이디로 선택된 데이터 삭제
		 * 
		 * @param ID
		 */

		Connection con = null;
		PreparedStatement psmt = null;
		con = ConnectionUtil.getConnection();
		try {
			psmt = con.prepareStatement("DELETE FROM member" + " WHERE id=?");

			psmt.setString(1, id);

			psmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static ArrayList<Member> selectMemberRankingList(int length, int page) {

		/**
		 * 미네랄 순으로 오름차순 정열된 멤버리스트
		 * 
		 * @param page
		 * @param length
		 */

		Connection con = null;
		PreparedStatement psmt = null;
		String sql = null;
		ResultSet rs = null;
		ArrayList<Member> memberList = new ArrayList<Member>();
		try {
			con = ConnectionUtil.getConnection();
			sql = "SELECT  rank() over (ORDER BY mineral DESC) RANK , id, mineral"
					+ " FROM  member";

			psmt = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			rs = psmt.executeQuery();
			if (page > 1) {
				rs.absolute((page - 1) * length);
			}
			int getRecordCount = 0;
			while (rs.next() && getRecordCount < length) {
				getRecordCount++;
				
				String rank=rs.getString(1);
				String id = rs.getString(2);
				Long mineral = rs.getLong(3);
				

				Member member = new Member();
				member.setId(id);
				member.setMineral(mineral);
				member.setRank(rank);

				memberList.add(member);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return memberList;

	}

	public static void updateMember(Member member) {

		/**
		 * 선택된 아이디의 정보를 업데이트 함
		 * 
		 * @param ID
		 * @param PW
		 * @param Email
		 * @param mineral
		 */

		Connection con = null;
		PreparedStatement psmt = null;
		con = ConnectionUtil.getConnection();
		try {
			psmt = con.prepareStatement("UPDATE  member SET pw=?," + "email=?,"
					+ "WHERE id=?");

			psmt.setString(1, member.getPw());
			psmt.setString(2, member.getEmail());

			psmt.setString(3, member.getId());

			psmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static int selectMemberCount() {
		Connection con = null;
		PreparedStatement psmt = null;
		String sql = null;
		ResultSet rs = null;
		int memberCount = 0;

		try {
			con = ConnectionUtil.getConnection();
			sql = "SELECT count(id)" + " FROM member";

			psmt = con.prepareStatement(sql);
			rs = psmt.executeQuery();
			if (rs.next()) {
				memberCount = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return memberCount;
	}

	public static long selectMineralByID(String id) {

		/**
		 * 아이디를 통해 선택된 미네랄 조회
		 * 
		 * @param ID
		 */

		Connection con = null;
		PreparedStatement psmt = null;
		String sql = null;
		ResultSet rs = null;
		long mineral = 0;
		try {
			con = ConnectionUtil.getConnection();
			sql = "SELECT  mineral" + "  FROM  member" + " WHERE id=?";

			psmt = con.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			if (rs.next()) {

				mineral = rs.getLong(1);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mineral;
	}

	public static void updateMineralByID(String id, long mineral) {

		/**
		 * 미네랄 데이터 삽입
		 * 
		 * @param member
		 */

		Connection con = null;
		PreparedStatement psmt = null;
		con = ConnectionUtil.getConnection();
		try {
			psmt = con.prepareStatement("UPDATE member set mineral=?"
					+ "where id=?");
			psmt.setString(1, id);
			psmt.setLong(4, mineral);

			psmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static String selectMemberRanking(String id) {

		/**
		 * 선택된 아이디 랭크 조회
		 * 
		 * @param page
		 * @param length
		 */

		Connection con = null;
		PreparedStatement psmt = null;
		String sql = null;
		ResultSet rs = null;
		String rank=null;
		try {
			con = ConnectionUtil.getConnection();
			sql = "SELECT  rank() over (ORDER BY mineral DESC) RANK , id, mineral"
					+ " FROM  member" +
					" Where id=?";

			psmt = con.prepareStatement(sql);
			psmt.setString(1, id );
			rs = psmt.executeQuery();
			
			
			if (rs.next()) {				
				rank=rs.getString(1);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rank;

	}
}
