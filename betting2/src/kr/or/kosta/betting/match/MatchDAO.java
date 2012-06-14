package kr.or.kosta.betting.match;

import java.io.IOException;  
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.mybatis.spring.support.SqlSessionDaoSupport;

public class MatchDAO extends SqlSessionDaoSupport 
		implements IMatch{
//	private static String resource="sqlmap-config.xml";
//	private static Reader sqlReader;
//	static{
//			try {
//				sqlReader=Resources.getResourceAsReader(resource);
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//	}
//	private static SqlSessionFactory sqlMapper =
//			new SqlSessionFactoryBuilder().build(sqlReader);

	/**
	 * ��ġ�� ��� ������ ����Ʈ ��ȸ �޼���
	 * 
	 * @param page
	 * @param length
	 */
	@Override
	public List<Match> selectMatchList(int page,int length) {
		/* default generated stub */;
		SqlSession session = null;
		List<Match> matchList= null;
		session = getSqlSession();
		RowBounds rowBounds = new RowBounds((page-1)*length,length);
		matchList = 
				session.selectList("selectMatchList",null,rowBounds);
		return matchList;
//		Connection con = null;
//		PreparedStatement ps = null;
//		String sql = null;
//		ResultSet rs =null;
//		ArrayList<Match>matchList=new ArrayList<Match>();
//		Match match = null;
//		
//		try {
//		con=ConnectionUtil.getConnection();
//		sql="SELECT match_num" +
//				",TO_CHAR(match_time,'yyyy/mm/dd hh24:mi:ss')" +
//				",match_result_score," +
//				"home_team_num,h.team_name,h.photo" +
//				",away_team_num,a.team_name,a.photo" +
//				",win_team_num,w.team_name,w.photo" +
//				",m.loc_num,l.loc"+
//				" FROM match m,team h,team a,team w,loc l"+
//				" WHERE m.home_team_num=h.team_num " +
//				" AND m.away_team_num=a.team_num" +
//				" AND m.win_team_num=w.team_num(+)" +
//				" AND m.loc_num=l.loc_num" +
//				" ORDER BY match_num DESC";
//			
//		//rs.absolute()�� �����ϵ��� ����
//			ps=con.prepareStatement(sql,
//					ResultSet.TYPE_SCROLL_INSENSITIVE,
//					ResultSet.CONCUR_READ_ONLY);
//			rs=ps.executeQuery();
//			
//			if(page>1){
//				rs.absolute((page-1)*length);
//			}
//			
//			int getRecordCount=0;
//			while(rs.next()&&getRecordCount<length){
//				getRecordCount++;
//				String matchNum=rs.getString(1);
//				String matchTime = rs.getString(2);
//				String matchScore = rs.getString(3);
//				String homeNum = rs.getString(4);
//				String hTeamName = rs.getString(5);
//				String hPhoto = rs.getString(6);
//				String awayNum = rs.getString(7);
//				String aTeamName = rs.getString(8);
//				String aPhoto = rs.getString(9);
//				String winNum = rs.getString(10);
//				String wTeamName = rs.getString(11);
//				String wPhoto = rs.getString(12);
//				String locNum=rs.getString(13);
//				String loc1 = rs.getString(14);
//				
//				match = new Match();
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
//				match.setWinTeam(winTeam);
//				match.setHomeTeam(homeTeam);
//				match.setAwayTeam(awayTeam);
//				match.setLoc(loc);
//				
//				matchList.add(match);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return matchList;
	}

	/**
	 * ������ ��¥�� �ϴ� ��� ������ ��ȸ �޼���
	 * 
	 * @param Date
	 */
	@Override
	public List<Match> selectMatchByDate(String date) {
		/* default generated stub */;
		SqlSession session = null;
		List<Match> matchList= null;
		session = getSqlSession();
		matchList = 
				session.selectList("selectMatchByDate",date);
		return matchList;
//		Connection con = null;
//		PreparedStatement ps = null;
//		String sql = null;
//		ResultSet rs =null;
//		ArrayList<Match>matchList=new ArrayList<Match>();
//		Match match = null;
//		
//		try {
//		con=ConnectionUtil.getConnection();
//		sql="SELECT match_num" +
//				",TO_CHAR(match_time,'yyyy/mm/dd hh24:mi:ss')" +
//				",match_result_score" +
//				",home_team_num,h.team_name,h.photo" +
//				",away_team_num,a.team_name,a.photo" +
//				",win_team_num,w.team_name,w.photo" +
//				",m.loc_num,l.loc"+
//				" FROM match m,team h,team a,team w,loc l"+
//				" WHERE m.home_team_num=h.team_num " +
//				" AND m.away_team_num=a.team_num" +
//				" AND m.win_team_num=w.team_num(+)" +
//				" AND m.loc_num=l.loc_num"+
//				" AND TO_CHAR(m.match_time,'YYYY/MM/DD')= ?" +
//				" ORDER BY match_num DESC";
//			
//			ps=con.prepareStatement(sql);
//			ps.setString(1, date);
//			rs=ps.executeQuery();
//			
//			while(rs.next()){
//				String matchNum=rs.getString(1);
//				String matchTime = rs.getString(2);
//				String matchScore = rs.getString(3);
//				String homeNum = rs.getString(4);
//				String hTeamName = rs.getString(5);
//				String hPhoto = rs.getString(6);
//				String awayNum = rs.getString(7);
//				String aTeamName = rs.getString(8);
//				String aPhoto = rs.getString(9);
//				String winNum = rs.getString(10);
//				String wTeamName = rs.getString(11);
//				String wPhoto = rs.getString(12);
//				String locNum=rs.getString(13);
//				String loc1 = rs.getString(14);
//				
//				match = new Match();
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
//				match.setWinTeam(winTeam);
//				match.setAwayTeam(awayTeam);
//				match.setHomeTeam(homeTeam);
//				match.setLoc(loc);
//				
//				matchList.add(match);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return matchList;
	}

	/**
	 * ������ ��ġ ��ȣ�� ������ ��ȸ �޼���
	 * 
	 * @param num
	 * @param score
	 * @param winNum
	 */
	@Override
	public Match selectMatch(String num) {
		/* default generated stub */;
		SqlSession session = null;
		Match match= null;
		session = getSqlSession();
		match = session.selectOne("selectMatch",num);
		return match;
//		Connection con = null;
//		PreparedStatement ps = null;
//		String sql = null;
//		ResultSet rs =null;
//		Match match = null;
//		
//		try {
//		con=ConnectionUtil.getConnection();
//		sql="SELECT match_num" +
//				",TO_CHAR(match_time,'yyyy/mm/dd hh24:mi:ss')" +
//				",match_result_score" +
//				",home_team_num,h.team_name,h.photo" +
//				",away_team_num,a.team_name,a.photo" +
//				",win_team_num,w.team_name,w.photo" +
//				",m.loc_num,l.loc"+
//				" FROM match m,team h,team a,team w,loc l"+
//				" WHERE m.home_team_num=h.team_num " +
//				" AND m.away_team_num=a.team_num" +
//				" AND m.win_team_num=w.team_num(+)" +
//				" AND m.loc_num=l.loc_num"+
//				" AND match_num= ?";
//			
//			ps=con.prepareStatement(sql);
//			ps.setString(1, num);
//			rs=ps.executeQuery();
//			
//			if(rs.next()){
//				String matchNum=rs.getString(1);
//				String matchTime = rs.getString(2);
//				String matchScore = rs.getString(3);
//				String homeNum = rs.getString(4);
//				String hTeamName = rs.getString(5);
//				String hPhoto = rs.getString(6);
//				String awayNum = rs.getString(7);
//				String aTeamName = rs.getString(8);
//				String aPhoto = rs.getString(9);
//				String winNum = rs.getString(10);
//				String wTeamName = rs.getString(11);
//				String wPhoto = rs.getString(12);
//				String locNum=rs.getString(13);
//				String loc1 = rs.getString(14);
//				
//				match = new Match();
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
//				match.setWinTeam(winTeam);
//				match.setAwayTeam(awayTeam);
//				match.setHomeTeam(homeTeam);
//				match.setLoc(loc);
//				
//				
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return match;
	}
	
	//��ġ ������Ʈ
	@Override
	public void updateMatch(Match match) {
		/* default generated stub */;
		SqlSession session = null; 
		session = getSqlSession();
		session.update("Match.updateMatch",match);
		
//		Connection con = null;
//		PreparedStatement ps = null;
//		String sql = null;
//				
//		try {
//		con=ConnectionUtil.getConnection();
//		sql="UPDATE match" +
//				" SET match_num=?" +
//				", match_time=TO_DATE(?,'yyyy/mm/dd hh24:mi:ss')" +
//				", match_result_score=? " +
//				",home_team_num=?, away_team_num=? ,win_team_num=? " +
//				" ,loc_num=?"+
//				" WHERE match_num=?";
//			
//			ps=con.prepareStatement(sql);
//			ps.setString(1, match.getNum());
//			ps.setString(2, match.getMatchTime().toString());
//			ps.setString(3, match.getScore());
//			ps.setString(4, match.getHomeTeam().getNum());
//			ps.setString(5, match.getAwayTeam().getNum());
//			ps.setString(6, match.getWinTeam().getNum());
//			ps.setString(7, match.getLoc().getNum());
//			ps.setString(8, match.getNum());
//			ps.executeUpdate();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
	}

	/**
	 * ��ġ ������ ���� �޼���
	 * 
	 * @param match
	 */
	@Override
	public void insertMatch(Match match) {
		/* default generated stub */;
		SqlSession session = null;
		session = getSqlSession();
		session.insert("Match.insertMatch",match);
//		Connection con = null;
//		PreparedStatement ps = null;
//		String sql = null;
//				
//		try {
//		con=ConnectionUtil.getConnection();
//		sql="INSERT INTO match (match_num" +
//				", match_time" +
//				",home_team_num, away_team_num " +
//				" ,loc_num) "+
//				 " VALUES(s_match.nextval,TO_DATE(?,'yyyy/mm/dd hh24:mi:ss'),?,?,?)";
//			
//			ps=con.prepareStatement(sql);
//			ps.setString(1, match.getMatchTime());
//			ps.setString(2, match.getHomeTeam().getNum());
//			ps.setString(3, match.getAwayTeam().getNum());
//			ps.setString(4, match.getLoc().getNum());
//			ps.executeUpdate();			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	}


	//match ī��Ʈ �޼���
	@Override
	public int selectMatchCount(){
		
		SqlSession session = null;
		int count=0;
		session = getSqlSession();
		count = session.selectOne("selectMatchCount");
		return count;
		
//		Connection con = null;
//		PreparedStatement psmt = null;
//		String sql = null;
//		ResultSet rs =null;
//		int matchCount=0;
//				
//		try {
//			con = ConnectionUtil.getConnection();
//			sql = "SELECT COUNT(match_num)"
//					+ " FROM match m,team h,team a,team w,loc l"
//					+ " WHERE m.home_team_num=h.team_num "
//					+ " AND m.away_team_num=a.team_num"
//					+ " AND m.win_team_num=w.team_num(+)"
//					+ " AND m.loc_num=l.loc_num";
//
//			psmt = con.prepareStatement(sql);
//			rs = psmt.executeQuery();
//			if (rs.next()) {
//				matchCount = rs.getInt(1);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return matchCount;
	}
	//��ⵥ���� ���� �޼���
	
	@Override
	public void deleteMatch (String matchNum) {
		// TODO Auto-generated method stub
		SqlSession session = null;
		session = getSqlSession();
		session.delete("deleteMatch",matchNum);
//		Connection con = null;
//		PreparedStatement psmt = null;
//		con = ConnectionUtil.getConnection();
//		try {
//			psmt = con.prepareStatement("DELETE FROM tb_match "+
//			                                                    " WHERE match_num = ?");
//			psmt.setString(1, matchNum);
//			psmt.executeUpdate();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}		
	}
	
	@Override
	public String selectMatchTime(String matchNum){
		
		SqlSession session = null;
		String matchTime= null;
		session = getSqlSession();
		matchTime= session.selectOne("selectMatchTime",matchNum);
		return matchTime;
//		Connection con = null;
//		PreparedStatement psmt = null;
//		String sql = null;
//		ResultSet rs =null;
//		String matchTime=null;
//				
//		try {
//			con = ConnectionUtil.getConnection();
//			sql = "SELECT TO_CHAR(match_time,'yyyy/mm/dd hh24:mi:ss')"
//					+ " FROM match m,team h,team a,team w,loc l"
//					+ " WHERE m.home_team_num=h.team_num "
//					+ " AND m.away_team_num=a.team_num"
//					+ " AND m.win_team_num=w.team_num(+)"
//					+ " AND m.loc_num=l.loc_num"
//					+ " AND m.match_num=?";
//
//			psmt = con.prepareStatement(sql);
//			psmt.setString(1, matchNum);
//			rs = psmt.executeQuery();
//			if (rs.next()) {
//				matchTime = rs.getString(1);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return matchTime;
	}
	
	
}