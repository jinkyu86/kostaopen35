package kr.or.kosta.betting.memberbetdata;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MemberBetDataDAO {
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

//	public static ArrayList<MemberBetData> selectMemberBetDataList(int page,
//			int length) {
//
//		/**
//		 * 개인 베팅 데이터의 모든 정보 조회
//		 * 
//		 * @param page
//		 * @param length
//		 */
//
//		Connection con = null;
//		PreparedStatement psmt = null;
//		String sql = null;
//		ResultSet rs = null;
//		ArrayList<MemberBetData> mbdList = new ArrayList<MemberBetData>();
//		try {
//			con = ConnectionUtil.getConnection();
//			sql = "SELECT m.match_num,m.match_result_score"
//					+ ",m.home_team_num,h.team_name,h.photo"
//					+ ",m.away_team_num,a.team_name,a.photo"
//					+ ",m.win_team_num,w.team_name,w.photo"
//					+ ",m.loc_num,l.loc"
//					+ ",b.bet_num, b.bet_rating, b.sele_rating, b.tot_mineral"
//					+ ",b.distinguish_team, m.match_time"
//					+ ",d.bet_mineral, d.id, d.personal_betting_num, d.selecting_time"
//					+ ",d.give_mineral_confirm"
//					+ ",e.name ,e.pw ,e.email ,e.mineral"
//					+ " FROM betting b,match m,team h,team a,team w,loc l"
//					+ ",member_betting_data d,member e "
//					+ " WHERE m.home_team_num=h.team_num"
//					+ " AND m.away_team_num=a.team_num"
//					+ " AND m.win_team_num=w.team_num(+)"
//					+ " AND m.loc_num=l.loc_num"
//					+ " AND m.match_num=b.match_num"
//					+ " AND b.bet_num=d.bet_num" + " AND e.id = d.id"
//					+ " ORDER BY d.selecting_time DESC";
//
//			psmt = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE,
//					ResultSet.CONCUR_READ_ONLY);
//			rs = psmt.executeQuery();
//			if (page > 1) {
//				rs.absolute((page - 1) * length);
//			}
//			int getRecordCount = 0;
//
//			while (rs.next() && getRecordCount < length) {
//				getRecordCount++;
//
//				String matchNum = rs.getString(1);
//				String matchScore = rs.getString(2);
//				String homeNum = rs.getString(3);
//				String hTeamName = rs.getString(4);
//				String hPhoto = rs.getString(5);
//				String awayNum = rs.getString(6);
//				String aTeamName = rs.getString(7);
//				String aPhoto = rs.getString(8);
//				String winNum = rs.getString(9);
//				String wTeamName = rs.getString(10);
//				String wPhoto = rs.getString(11);
//				String locNum = rs.getString(12);
//				String loc1 = rs.getString(13);
//				String batNum = rs.getString(14);
//				double batRating = rs.getDouble(15);
//				long seleRating = rs.getLong(16);
//				long totMineral = rs.getLong(17);
//				String distinguishTeam = rs.getString(18);
//				String matchTime = rs.getString(19);
//				long betMineral = rs.getLong(20);
//				String ID = rs.getString(21);
//				String mbdNum = rs.getString(22);
//				String selectTime = rs.getString(23);
//				String gmc = rs.getString(24);
//				String name = rs.getString(25);
//				String pw = rs.getString(26);
//				String email = rs.getString(27);
//				long mineral = rs.getLong(28);
//
//				MemberBetData mbd = new MemberBetData();
//				mbd.setNum(mbdNum);
//				mbd.setBetMineral(betMineral);
//				mbd.setSeleTime(selectTime);
//				mbd.setGiveMineralConfirm(gmc);
//
//				Member member = new Member();
//				member.setId(ID);
//				member.setName(name);
//				member.setPw(pw);
//				member.setEmail(email);
//				member.setMineral(mineral);
//
//				Betting betting = new Betting();
//				betting.setNum(batNum);
//				betting.setBatRating(batRating);
//				betting.setSeleRating(seleRating);
//				betting.setTotMineral(totMineral);
//				betting.setDistnum(distinguishTeam);
//
//				Match match = new Match();
//				match.setNum(matchNum);
//				match.setMatchTime(matchTime);
//				match.setScore(matchScore);
//
//				Team homeTeam = new Team();
//				homeTeam.setNum(homeNum);
//				homeTeam.setName(hTeamName);
//				homeTeam.setPhoto(hPhoto);
//
//				Team awayTeam = new Team();
//				awayTeam.setNum(awayNum);
//				awayTeam.setName(aTeamName);
//				awayTeam.setPhoto(aPhoto);
//
//				Team winTeam = new Team();
//				winTeam.setNum(winNum);
//				winTeam.setName(wTeamName);
//				winTeam.setPhoto(wPhoto);
//
//				Loc loc = new Loc();
//				loc.setNum(locNum);
//				loc.setLoc(loc1);
//
//				match.setHomeTeam(homeTeam);
//				match.setAwayTeam(awayTeam);
//				match.setWinTeam(winTeam);
//				match.setLoc(loc);
//				betting.setMatch(match);
//
//				mbd.setBetting(betting);
//				mbd.setMember(member);
//
//				mbdList.add(mbd);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return mbdList;
//	}

	public static List<MemberBetData> selectMemberBetDataListByID(
			int page, int length, String id) {

		/**
		 * 선택된 아이디의 맴버데이터 조회 메서드
		 * 
		 * @param ID
		 */
		SqlSession session = null;
		List<MemberBetData> mbdList= null;
		try{
		session = sqlMapper.openSession(true);
		RowBounds rowBounds = new RowBounds((page-1)*length,length);
		mbdList = 
				session.selectList("selectMBDListByID",id,rowBounds);
		
		}
		finally{
			session.close();
		}
		return mbdList;
//		Connection con = null;
//		PreparedStatement psmt = null;
//		String sql = null;
//		ResultSet rs = null;
//		ArrayList<MemberBetData> mbdList = new ArrayList<MemberBetData>();
//		try {
//			con = ConnectionUtil.getConnection();
//			sql = "SELECT m.match_num,m.match_result_score"
//					+ ",m.home_team_num,h.team_name,h.photo"
//					+ ",m.away_team_num,a.team_name,a.photo"
//					+ ",m.win_team_num,w.team_name,w.photo"
//					+ ",m.loc_num,l.loc"
//					+ ",b.bet_num, b.bet_rating, b.sele_rating, b.tot_mineral"
//					+ ",b.distinguish_team, m.match_time"
//					+ ",d.bet_mineral, d.id, d.personal_betting_num, d.selecting_time"
//					+ ",d.give_mineral_confirm"
//					+ ",e.name ,e.pw ,e.email ,e.mineral"
//					+ " FROM betting b,match m,team h,team a,team w,loc l"
//					+ ",member_betting_data d,member e "
//					+ " WHERE m.home_team_num=h.team_num"
//					+ " AND m.away_team_num=a.team_num"
//					+ " AND m.win_team_num=w.team_num(+)"
//					+ " AND m.loc_num=l.loc_num"
//					+ " AND m.match_num=b.match_num"
//					+ " AND b.bet_num=d.bet_num" + " AND e.id = d.id"
//					+ " AND d.id=?" + " ORDER BY d.selecting_time DESC";
//
//			psmt = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE,
//					ResultSet.CONCUR_READ_ONLY);
//			psmt.setString(1, ID1);
//			rs = psmt.executeQuery();
//			if (page > 1) {
//				rs.absolute((page - 1) * length);
//			}
//			int getRecordCount = 0;
//
//			while (rs.next() && getRecordCount < length) {
//				getRecordCount++;
//
//				String matchNum = rs.getString(1);
//				String matchScore = rs.getString(2);
//				String homeNum = rs.getString(3);
//				String hTeamName = rs.getString(4);
//				String hPhoto = rs.getString(5);
//				String awayNum = rs.getString(6);
//				String aTeamName = rs.getString(7);
//				String aPhoto = rs.getString(8);
//				String winNum = rs.getString(9);
//				String wTeamName = rs.getString(10);
//				String wPhoto = rs.getString(11);
//				String locNum = rs.getString(12);
//				String loc1 = rs.getString(13);
//				String batNum = rs.getString(14);
//				double batRating = rs.getDouble(15);
//				long seleRating = rs.getLong(16);
//				long totMineral = rs.getLong(17);
//				String distinguishTeam = rs.getString(18);
//				String matchTime = rs.getString(19);
//				long betMineral = rs.getLong(20);
//				String ID = rs.getString(21);
//				String mbdNum = rs.getString(22);
//				String selectTime = rs.getString(23);
//				String gmc = rs.getString(24);
//				String name = rs.getString(25);
//				String pw = rs.getString(26);
//				String email = rs.getString(27);
//				long mineral = rs.getLong(28);
//
//				MemberBetData mbd = new MemberBetData();
//				mbd.setNum(mbdNum);
//				mbd.setBetMineral(betMineral);
//				mbd.setSeleTime(selectTime);
//				mbd.setGiveMineralConfirm(gmc);
//
//				Member member = new Member();
//				member.setId(ID);
//				member.setName(name);
//				member.setPw(pw);
//				member.setEmail(email);
//				member.setMineral(mineral);
//
//				Betting betting = new Betting();
//				betting.setNum(batNum);
//				betting.setBatRating(batRating);
//				betting.setSeleRating(seleRating);
//				betting.setTotMineral(totMineral);
//				betting.setDistnum(distinguishTeam);
//
//				Match match = new Match();
//				match.setNum(matchNum);
//				match.setMatchTime(matchTime);
//				match.setScore(matchScore);
//
//				Team homeTeam = new Team();
//				homeTeam.setNum(homeNum);
//				homeTeam.setName(hTeamName);
//				homeTeam.setPhoto(hPhoto);
//
//				Team awayTeam = new Team();
//				awayTeam.setNum(awayNum);
//				awayTeam.setName(aTeamName);
//				awayTeam.setPhoto(aPhoto);
//
//				Team winTeam = new Team();
//				winTeam.setNum(winNum);
//				winTeam.setName(wTeamName);
//				winTeam.setPhoto(wPhoto);
//
//				Loc loc = new Loc();
//				loc.setNum(locNum);
//				loc.setLoc(loc1);
//
//				match.setHomeTeam(homeTeam);
//				match.setAwayTeam(awayTeam);
//				match.setWinTeam(winTeam);
//				match.setLoc(loc);
//				betting.setMatch(match);
//
//				mbd.setBetting(betting);
//				mbd.setMember(member);
//
//				mbdList.add(mbd);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return mbdList;
	}

	public static void insultMemberBetData(MemberBetData mbd) {

		/**
		 * 멤버데이터 삽입 메서드
		 * 
		 * @param memberBatData
		 */
		SqlSession session = null;
		try{
		session = sqlMapper.openSession(true);
		session.insert("MBD.insertMBD",mbd);
		}
		finally{
				session.close();
		}
//		Connection con = null;
//		PreparedStatement psmt = null;
//		con = ConnectionUtil.getConnection();
//
//		try {
//			psmt = con
//					.prepareStatement("INSERT INTO member_betting_data"
//							+ "(bet_num, bet_mineral, id, personal_betting_num, selecting_time,give_mineral_confirm)"
//							+ " VALUES (?,?,?,s_bettingdata.nextval,sysdate,0)");
//			psmt.setString(1, mbd.getBetting().getNum());
//			psmt.setLong(2, mbd.getBetMineral());
//			psmt.setString(3, mbd.getMember().getId());
//			psmt.executeUpdate();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	}

	public static void deleteMemberbetData(String mbdNum) {

		/**
		 * 멤버데이터 삭제 메서드
		 * 
		 * @param num
		 */
		SqlSession session = null;
		try{
		session = sqlMapper.openSession(true);
		session.delete("MBD.deleteMBD",mbdNum);
		}
		finally{
			session.close();
		}
//		Connection con = null;
//		PreparedStatement psmt = null;
//		con = ConnectionUtil.getConnection();
//		try {
//			psmt = con.prepareStatement("DELETE FROM member_betting_data "
//					+ " WHERE personal_betting_num=?");
//
//			psmt.setString(1, num);
//
//			psmt.executeUpdate();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}

	}

	// id로 검색된 데이터 카운트 메서드
	public static int selectMemberBetDataByIDCount(String id) {
		SqlSession session = null;
		int count = 0;
		try{
			session = sqlMapper.openSession(true);
			count = session.selectOne("selectMBDListByIDCount", id);
		}
		finally{
			session.close();
		}
		return count;
//		Connection con = null;
//		PreparedStatement psmt = null;
//		String sql = null;
//		ResultSet rs = null;
//		int BatCount = 0;
//
//		try {
//			con = ConnectionUtil.getConnection();
//
//			sql = "SELECT  count(personal_betting_num)"
//					+ "  FROM  member_betting_data" + " WHERE id=?";
//
//			psmt = con.prepareStatement(sql);
//			psmt.setString(1, ID);
//			rs = psmt.executeQuery();
//
//			if (rs.next()) {
//				BatCount = rs.getInt(1);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return BatCount;
	}

	public static void updateMemberBetData(String mbdNum) {

		/**
		 * 멤버데이터 give_mineral_confirm 수정 메서드
		 * 
		 * @param memberBatData
		 */
		SqlSession session = null;
		try{
			session = sqlMapper.openSession(true);
			session.update("MBD.updateMBD",mbdNum);
		}
		finally{
			session.close();
		}
//		Connection con = null;
//		PreparedStatement psmt = null;
//		con = ConnectionUtil.getConnection();
//
//		try {
//			psmt = con.prepareStatement("UPDATE  member_betting_data "
//					+ " SET give_mineral_confirm=1 "
//					+ " WHERE personal_betting_num=?");
//			psmt.setString(1, num);
//			psmt.executeUpdate();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	}

	// 매치 넘버를 조회하는 메서드
	public static String selectMatchNum(String mbdNum) {
		SqlSession session = null;
		String matchNum = null;
		try{
			session = sqlMapper.openSession(true);
			matchNum = session.selectOne("MBD.selectMatchNum", mbdNum);
		}
		finally{
			session.close();
		}
		return matchNum;
//		Connection con = null;
//		PreparedStatement psmt = null;
//		String sql = null;
//		ResultSet rs = null;
//		String matchNum = null;
//		try {
//			con = ConnectionUtil.getConnection();
//			sql = "SELECT m.match_num"
//					+ " FROM betting b,match m,team h,team a,team w,loc l"
//					+ ",member_betting_data d,member e "
//					+ " WHERE m.home_team_num=h.team_num"
//					+ " AND m.away_team_num=a.team_num"
//					+ " AND m.win_team_num=w.team_num(+)"
//					+ " AND m.loc_num=l.loc_num"
//					+ " AND m.match_num=b.match_num"
//					+ " AND b.bet_num=d.bet_num" + " AND e.id = d.id"
//					+ " AND d.personal_betting_num=?";
//
//			psmt = con.prepareStatement(sql);
//			psmt.setString(1, num);
//			rs = psmt.executeQuery();
//
//			if (rs.next()) {
//
//				matchNum = rs.getString(1);
//
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return matchNum;

	}

	public static MemberBetData selectMemberBetData(String mbdNum) {

		/**
		 * 번호로 맴버데이터 조회 메서드
		 * 
		 * @param ID
		 */
		SqlSession session = null;
		MemberBetData mbd = null;
		
		try{
			session = sqlMapper.openSession(true);
			mbd = session.selectOne("MBD.selectMBD",mbdNum);
		}
		finally{
			session.close();
		}
		return mbd;
//		Connection con = null;
//		PreparedStatement psmt = null;
//		String sql = null;
//		ResultSet rs = null;
//		MemberBetData mbd = null;
//		try {
//			con = ConnectionUtil.getConnection();
//			sql = "SELECT m.match_num,m.match_result_score"
//					+ ",m.home_team_num,h.team_name,h.photo"
//					+ ",m.away_team_num,a.team_name,a.photo"
//					+ ",m.win_team_num,w.team_name,w.photo"
//					+ ",m.loc_num,l.loc"
//					+ ",b.bet_num, b.bet_rating, b.sele_rating, b.tot_mineral"
//					+ ",b.distinguish_team, m.match_time"
//					+ ",d.bet_mineral, d.id, d.personal_betting_num, d.selecting_time"
//					+ ",d.give_mineral_confirm"
//					+ ",e.name ,e.pw ,e.email ,e.mineral"
//					+ " FROM betting b,match m,team h,team a,team w,loc l"
//					+ ",member_betting_data d,member e "
//					+ " WHERE m.home_team_num=h.team_num"
//					+ " AND m.away_team_num=a.team_num"
//					+ " AND m.win_team_num=w.team_num(+)"
//					+ " AND m.loc_num=l.loc_num"
//					+ " AND m.match_num=b.match_num"
//					+ " AND b.bet_num=d.bet_num" + " AND e.id = d.id"
//					+ " AND d.personal_betting_num= ?";
//
//			psmt = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE,
//					ResultSet.CONCUR_READ_ONLY);
//			psmt.setString(1, num);
//			rs = psmt.executeQuery();
//
//			if (rs.next()) {
//
//				String matchNum = rs.getString(1);
//				String matchScore = rs.getString(2);
//				String homeNum = rs.getString(3);
//				String hTeamName = rs.getString(4);
//				String hPhoto = rs.getString(5);
//				String awayNum = rs.getString(6);
//				String aTeamName = rs.getString(7);
//				String aPhoto = rs.getString(8);
//				String winNum = rs.getString(9);
//				String wTeamName = rs.getString(10);
//				String wPhoto = rs.getString(11);
//				String locNum = rs.getString(12);
//				String loc1 = rs.getString(13);
//				String batNum = rs.getString(14);
//				double batRating = rs.getDouble(15);
//				long seleRating = rs.getLong(16);
//				long totMineral = rs.getLong(17);
//				String distinguishTeam = rs.getString(18);
//				String matchTime = rs.getString(19);
//				long betMineral = rs.getLong(20);
//				String ID = rs.getString(21);
//				String mbdNum = rs.getString(22);
//				String selectTime = rs.getString(23);
//				String gmc = rs.getString(24);
//				String name = rs.getString(25);
//				String pw = rs.getString(26);
//				String email = rs.getString(27);
//				long mineral = rs.getLong(28);
//
//				mbd = new MemberBetData();
//				mbd.setNum(mbdNum);
//				mbd.setBetMineral(betMineral);
//				mbd.setSeleTime(selectTime);
//				mbd.setGiveMineralConfirm(gmc);
//
//				Member member = new Member();
//				member.setId(ID);
//				member.setName(name);
//				member.setPw(pw);
//				member.setEmail(email);
//				member.setMineral(mineral);
//
//				Betting betting = new Betting();
//				betting.setNum(batNum);
//				betting.setBatRating(batRating);
//				betting.setSeleRating(seleRating);
//				betting.setTotMineral(totMineral);
//				betting.setDistnum(distinguishTeam);
//
//				Match match = new Match();
//				match.setNum(matchNum);
//				match.setMatchTime(matchTime);
//				match.setScore(matchScore);
//
//				Team homeTeam = new Team();
//				homeTeam.setNum(homeNum);
//				homeTeam.setName(hTeamName);
//				homeTeam.setPhoto(hPhoto);
//
//				Team awayTeam = new Team();
//				awayTeam.setNum(awayNum);
//				awayTeam.setName(aTeamName);
//				awayTeam.setPhoto(aPhoto);
//
//				Team winTeam = new Team();
//				winTeam.setNum(winNum);
//				winTeam.setName(wTeamName);
//				winTeam.setPhoto(wPhoto);
//
//				Loc loc = new Loc();
//				loc.setNum(locNum);
//				loc.setLoc(loc1);
//
//				match.setHomeTeam(homeTeam);
//				match.setAwayTeam(awayTeam);
//				match.setWinTeam(winTeam);
//				match.setLoc(loc);
//				betting.setMatch(match);
//
//				mbd.setBetting(betting);
//				mbd.setMember(member);
//
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return mbd;
	}
	public static int selectMineralConfirm(String mbdNum){
		SqlSession session = null;
		int confirm = 0;
		try{
		session = sqlMapper.openSession(true);
		confirm = session.selectOne("selectMineralConfirm", mbdNum);
		}
		finally{
			session.close();
		}
		return confirm;
	}
	
}
