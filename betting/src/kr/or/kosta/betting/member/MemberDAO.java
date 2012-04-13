package kr.or.kosta.betting.member;

import java.io.IOException;
import java.io.Reader;
import java.util.List;
//import java.util.HashMap;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MemberDAO {
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

	public static List<Member> selectMemberList(int length, int page) {

		/**
		 * 멤버의 모든 정보리스트를 조회하는 메서드
		 * 
		 * @param page
		 * @param length
		 */
		SqlSession session = null;
		List<Member> memberList= null;
		try{
		session = sqlMapper.openSession(true);
		RowBounds rowBounds = new RowBounds((page-1)*length,length);
		memberList = 
				session.selectList("selectMemberList",null,rowBounds);
		
		}
		finally{
			session.close();
		}
		return memberList;
//		Connection con = null;
//		PreparedStatement psmt = null;
//		String sql = null;
//		ResultSet rs = null;
//		ArrayList<Member> MemberList = new ArrayList<Member>();
//		try {
//			con = ConnectionUtil.getConnection();
//			sql = "SELECT  id,name,pw,email,mineral" + " FROM  member";
//
//			psmt = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE,
//					ResultSet.CONCUR_READ_ONLY);
//			rs = psmt.executeQuery();
//			if (page > 1) {
//				rs.absolute((page - 1) * length);
//			}
//			int getRecordCount = 0;
//			while (rs.next() && getRecordCount < length) {
//				getRecordCount++;
//				String id = rs.getString(1);
//				String name = rs.getString(2);
//				String pw = rs.getString(3);
//				String email = rs.getString(4);
//				Long mineral = rs.getLong(5);
//
//				Member member = new Member();
//				member.setId(id);
//				member.setName(name);
//				member.setPw(pw);
//				member.setEmail(email);
//				member.setMineral(mineral);
//
//				MemberList.add(member);
//
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return MemberList;
	}

	public static void insultMember(Member member) {

		/**
		 * 멤버 데이터 삽입
		 * 
		 * @param member
		 */
		SqlSession session = null;
		try{
			session = sqlMapper.openSession(true);
			session.insert("Member.insertMember", member);
		}
		finally{
			session.close();
		}
//		Connection con = null;
//		PreparedStatement psmt = null;
//		con = ConnectionUtil.getConnection();
//		try {
//			psmt = con.prepareStatement("INSERT INTO member "
//					+ "(id,name,pw,email,mineral) " + " VALUES (?,?,?,?,5000)");
//			psmt.setString(1, member.getId());
//			psmt.setString(2, member.getName());
//			psmt.setString(3, member.getPw());
//			psmt.setString(4, member.getEmail());
//			psmt.executeUpdate();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	}

	public static Member selectMemberByID(String id) {

		/**
		 * 아이디를 통해 선택된 멤버데이터 조회
		 * 
		 * @param ID
		 */
		SqlSession session = null;
		Member member = null;
		try{
			session = sqlMapper.openSession(true);
			member = session.selectOne("Member.selectMember",id);
		}
		finally{
			session.close();
		}
		return member;
				
//		Connection con = null;
//		PreparedStatement psmt = null;
//		String sql = null;
//		ResultSet rs = null;
//		Member member = null;
//		try {
//			con = ConnectionUtil.getConnection();
//			sql = "SELECT  id,name,pw,email,mineral" + "  FROM  member"
//					+ " WHERE id=?";
//
//			psmt = con.prepareStatement(sql);
//			psmt.setString(1, id);
//			rs = psmt.executeQuery();
//			if (rs.next()) {
//
//				String name = rs.getString(2);
//				String pw = rs.getString(3);
//				String email = rs.getString(4);
//				Long mineral = rs.getLong(5);
//
//				member = new Member();
//				member.setId(id);
//				member.setName(name);
//				member.setPw(pw);
//				member.setEmail(email);
//				member.setMineral(mineral);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return member;
	}

	public static void deleteMember(String id) {

		/**
		 * 아이디로 선택된 데이터 삭제
		 * 
		 * @param ID
		 */
		SqlSession session = null;
		try{
			session = sqlMapper.openSession(true);
			session.delete("Member.deleteMember", id);
		}
		finally{
			session.close();
		}
//		Connection con = null;
//		PreparedStatement psmt = null;
//		con = ConnectionUtil.getConnection();
//		try {
//			psmt = con.prepareStatement("DELETE FROM member" + " WHERE id=?");
//
//			psmt.setString(1, id);
//
//			psmt.executeUpdate();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	}

	public static List<Member> selectMemberRankingList(int length, int page) {

		/**
		 * 미네랄 순으로 오름차순 정열된 멤버리스트
		 * 
		 * @param page
		 * @param length
		 */
		SqlSession session = null;
		List<Member> memberList= null;
		try{
		session = sqlMapper.openSession(true);
		RowBounds rowBounds = new RowBounds((page-1)*length,length);
		memberList = 
				session.selectList("selectMemberRankingList",null,rowBounds);
		
		}
		finally{
			session.close();
		}
		return memberList;
//		Connection con = null;
//		PreparedStatement psmt = null;
//		String sql = null;
//		ResultSet rs = null;
//		ArrayList<Member> memberList = new ArrayList<Member>();
//		try {
//			con = ConnectionUtil.getConnection();
//			sql = "SELECT  rank() over (ORDER BY mineral DESC) RANK , id, mineral"
//					+ " FROM  member";
//
//			psmt = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE,
//					ResultSet.CONCUR_READ_ONLY);
//			rs = psmt.executeQuery();
//			if (page > 1) {
//				rs.absolute((page - 1) * length);
//			}
//			int getRecordCount = 0;
//			while (rs.next() && getRecordCount < length) {
//				getRecordCount++;
//				
//				String rank=rs.getString(1);
//				String id = rs.getString(2);
//				Long mineral = rs.getLong(3);
//				
//
//				Member member = new Member();
//				member.setId(id);
//				member.setMineral(mineral);
//				member.setRank(rank);
//
//				memberList.add(member);
//
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return memberList;

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
		SqlSession session = null;
		try{
			session = sqlMapper.openSession(true);
			session.insert("Member.updateMember", member);
		}
		finally{
			session.close();
		}
//		Connection con = null;
//		PreparedStatement psmt = null;
//		con = ConnectionUtil.getConnection();
//		try {
//			psmt = con.prepareStatement("UPDATE  member SET pw=?," + "email=?,"
//					+ "WHERE id=?");
//
//			psmt.setString(1, member.getPw());
//			psmt.setString(2, member.getEmail());
//
//			psmt.setString(3, member.getId());
//
//			psmt.executeUpdate();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}

	}

	public static int selectMemberCount() {
		SqlSession session = null;
		int count = 0;
		try{
			session = sqlMapper.openSession(true);
			count = session.selectOne("Member.selectMemberCount");
		}
		finally{
			session.close();
		}
		return count;
//		Connection con = null;
//		PreparedStatement psmt = null;
//		String sql = null;
//		ResultSet rs = null;
//		int memberCount = 0;
//
//		try {
//			con = ConnectionUtil.getConnection();
//			sql = "SELECT count(id)" + " FROM member";
//
//			psmt = con.prepareStatement(sql);
//			rs = psmt.executeQuery();
//			if (rs.next()) {
//				memberCount = rs.getInt(1);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return memberCount;
	}

	public static long selectMineralByID(String id) {

		/**
		 * 아이디를 통해 선택된 미네랄 조회
		 * 
		 * @param ID
		 */
		SqlSession session = null;
		long mineral = 0;
		try{
			session = sqlMapper.openSession(true);
			mineral = session.selectOne("Member.selectMineralByID", id);
		}
		finally{
			session.close();
		}
		return mineral;
//		Connection con = null;
//		PreparedStatement psmt = null;
//		String sql = null;
//		ResultSet rs = null;
//		long mineral = 0;
//		try {
//			con = ConnectionUtil.getConnection();
//			sql = "SELECT  mineral" + "  FROM  member" + " WHERE id=?";
//
//			psmt = con.prepareStatement(sql);
//			psmt.setString(1, id);
//			rs = psmt.executeQuery();
//			if (rs.next()) {
//
//				mineral = rs.getLong(1);
//
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return mineral;
	}

	public static void updateMineralByID(Member member) {

		/**
		 * 미네랄 데이터 삽입
		 * 
		 * @param member
		 */
		SqlSession session = null;
		try{
			session = sqlMapper.openSession(true);
			session.update("Member.updateMember",member );

		}
		finally{
			session.close();
		}
//		Connection con = null;
//		PreparedStatement psmt = null;
//		con = ConnectionUtil.getConnection();
//		try {
//			psmt = con.prepareStatement("UPDATE member SET mineral=?"
//					+"where id=?");
//			psmt.setLong(1,mineral);			
//			psmt.setString(2, id);
//
//			psmt.executeUpdate();
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	}
	
	public static long selectMemberRanking(String id) {

		/**
		 * 선택된 아이디 랭크 조회
		 * 
		 * @param page
		 * @param length
		 */
		SqlSession session = null;
		long rank = 0;
		try{
			session = sqlMapper.openSession(true);
			session.insert("Member.selectMemberRanking",id );
		}
		finally{
			session.close();
		}
//		Connection con = null;
//		PreparedStatement psmt = null;
//		String sql = null;
//		ResultSet rs = null;
//		long rank=0;
//		try {
//			con = ConnectionUtil.getConnection();
//			sql = " select count(*)"+
//					" from member"+
//					" where mineral>(select mineral from member Where id=?)";
//
//			psmt = con.prepareStatement(sql);
//			psmt.setString(1, id );
//			rs = psmt.executeQuery();
//			
//			
//			if (rs.next()) {				
//				rank=rs.getLong(1);
//
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
		return rank+1;

	}
}
