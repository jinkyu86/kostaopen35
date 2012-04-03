package kr.or.kosta.betting.match;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.or.kosta.betting.loc.Loc;
import kr.or.kosta.betting.team.Team;
import kr.or.kosta.betting.util.ConnectionUtil;




public class MatchDAO {

	/**
	 * 매치의 모든 데이터 리스트 조회 메서드
	 * 
	 * @param page
	 * @param length
	 */
	public static ArrayList<Match> selectMatchList(int page,int length) {
		/* default generated stub */;
		Connection con = null;
		PreparedStatement ps = null;
		String sql = null;
		ResultSet rs =null;
		ArrayList<Match>matchList=new ArrayList<Match>();
		Match match = null;
		
		try {
		con=ConnectionUtil.getConnection();
		sql="SELECT match_num" +
				",TO_CHAR(match_time,'yyyy/mm/dd hh24:mi:ss')" +
				",match_result_score," +
				"home_team_num,h.team_name,h.photo" +
				",away_team_num,a.team_name,a.photo" +
				",win_team_num,w.team_name,w.photo" +
				",m.loc_num,l.loc"+
				" FROM match m,team h,team a,team w,loc l"+
				" WHERE m.home_team_num=h.team_num " +
				" AND m.away_team_num=a.team_num" +
				" AND m.win_team_num=w.team_num(+)" +
				" AND m.loc_num=l.loc_num" +
				" ORDER BY match_num DESC";
			
		//rs.absolute()가 가능하도록 설정
			ps=con.prepareStatement(sql,
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			rs=ps.executeQuery();
			
			if(page>1){
				rs.absolute((page-1)*length);
			}
			
			int getRecordCount=0;
			while(rs.next()&&getRecordCount<length){
				getRecordCount++;
				String matchNum=rs.getString(1);
				String matchTime = rs.getString(2);
				String matchScore = rs.getString(3);
				String homeNum = rs.getString(4);
				String hTeamName = rs.getString(5);
				String hPhoto = rs.getString(6);
				String awayNum = rs.getString(7);
				String aTeamName = rs.getString(8);
				String aPhoto = rs.getString(9);
				String winNum = rs.getString(10);
				String wTeamName = rs.getString(11);
				String wPhoto = rs.getString(12);
				String locNum=rs.getString(13);
				String loc1 = rs.getString(14);
				
				match = new Match();
				match.setNum(matchNum);
				match.setMatchTime(matchTime);
				match.setScore(matchScore);
				
				Team homeTeam = new Team();
				homeTeam.setNum(homeNum);
				homeTeam.setName(hTeamName);
				homeTeam.setPhoto(hPhoto);
				
				Team awayTeam = new Team();
				awayTeam.setNum(awayNum);
				awayTeam.setName(aTeamName);
				awayTeam.setPhoto(aPhoto);
				
				Team winTeam = new Team();
				winTeam.setNum(winNum);
				winTeam.setName(wTeamName);
				winTeam.setPhoto(wPhoto);
				
				Loc loc = new Loc();
				loc.setNum(locNum);
				loc.setLoc(loc1);
				
				match.setWinTeam(winTeam);
				match.setHomeTeam(homeTeam);
				match.setAwayTeam(awayTeam);
				match.setLoc(loc);
				
				matchList.add(match);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return matchList;
	}

	/**
	 * 선택한 날짜에 하는 경기 데이터 조회 메서드
	 * 
	 * @param Date
	 */
	public static ArrayList<Match> selectMatchByDate(String date) {
		/* default generated stub */;
		Connection con = null;
		PreparedStatement ps = null;
		String sql = null;
		ResultSet rs =null;
		ArrayList<Match>matchList=new ArrayList<Match>();
		Match match = null;
		
		try {
		con=ConnectionUtil.getConnection();
		sql="SELECT match_num" +
				",TO_CHAR(match_time,'yyyy/mm/dd hh24:mi:ss')" +
				",match_result_score" +
				",home_team_num,h.team_name,h.photo" +
				",away_team_num,a.team_name,a.photo" +
				",win_team_num,w.team_name,w.photo" +
				",m.loc_num,l.loc"+
				" FROM match m,team h,team a,team w,loc l"+
				" WHERE m.home_team_num=h.team_num " +
				" AND m.away_team_num=a.team_num" +
				" AND m.win_team_num=w.team_num(+)" +
				" AND m.loc_num=l.loc_num"+
				" AND TO_CHAR(m.match_time,'YYYY/MM/DD')= ?" +
				" ORDER BY match_num DESC";
			
			ps=con.prepareStatement(sql);
			ps.setString(1, date);
			rs=ps.executeQuery();
			
			while(rs.next()){
				String matchNum=rs.getString(1);
				String matchTime = rs.getString(2);
				String matchScore = rs.getString(3);
				String homeNum = rs.getString(4);
				String hTeamName = rs.getString(5);
				String hPhoto = rs.getString(6);
				String awayNum = rs.getString(7);
				String aTeamName = rs.getString(8);
				String aPhoto = rs.getString(9);
				String winNum = rs.getString(10);
				String wTeamName = rs.getString(11);
				String wPhoto = rs.getString(12);
				String locNum=rs.getString(13);
				String loc1 = rs.getString(14);
				
				match = new Match();
				match.setNum(matchNum);
				match.setMatchTime(matchTime);
				match.setScore(matchScore);
				
				Team homeTeam = new Team();
				homeTeam.setNum(homeNum);
				homeTeam.setName(hTeamName);
				homeTeam.setPhoto(hPhoto);
				
				Team awayTeam = new Team();
				awayTeam.setNum(awayNum);
				awayTeam.setName(aTeamName);
				awayTeam.setPhoto(aPhoto);
				
				Team winTeam = new Team();
				winTeam.setNum(winNum);
				winTeam.setName(wTeamName);
				winTeam.setPhoto(wPhoto);
				
				Loc loc = new Loc();
				loc.setNum(locNum);
				loc.setLoc(loc1);
				
				match.setWinTeam(winTeam);
				match.setAwayTeam(awayTeam);
				match.setHomeTeam(homeTeam);
				match.setLoc(loc);
				
				matchList.add(match);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return matchList;
	}

	/**
	 * 선택한 매치 번호의 데이터 조회 메서드
	 * 
	 * @param num
	 * @param score
	 * @param winNum
	 */
	public static Match selectMatch(String num) {
		/* default generated stub */;
		Connection con = null;
		PreparedStatement ps = null;
		String sql = null;
		ResultSet rs =null;
		Match match = null;
		
		try {
		con=ConnectionUtil.getConnection();
		sql="SELECT match_num" +
				",TO_CHAR(match_time,'yyyy/mm/dd hh24:mi:ss')" +
				",match_result_score" +
				",home_team_num,h.team_name,h.photo" +
				",away_team_num,a.team_name,a.photo" +
				",win_team_num,w.team_name,w.photo" +
				",m.loc_num,l.loc"+
				" FROM match m,team h,team a,team w,loc l"+
				" WHERE m.home_team_num=h.team_num " +
				" AND m.away_team_num=a.team_num" +
				" AND m.win_team_num=w.team_num(+)" +
				" AND m.loc_num=l.loc_num"+
				" AND match_num= ?";
			
			ps=con.prepareStatement(sql);
			ps.setString(1, num);
			rs=ps.executeQuery();
			
			if(rs.next()){
				String matchNum=rs.getString(1);
				String matchTime = rs.getString(2);
				String matchScore = rs.getString(3);
				String homeNum = rs.getString(4);
				String hTeamName = rs.getString(5);
				String hPhoto = rs.getString(6);
				String awayNum = rs.getString(7);
				String aTeamName = rs.getString(8);
				String aPhoto = rs.getString(9);
				String winNum = rs.getString(10);
				String wTeamName = rs.getString(11);
				String wPhoto = rs.getString(12);
				String locNum=rs.getString(13);
				String loc1 = rs.getString(14);
				
				match = new Match();
				match.setNum(matchNum);
				match.setMatchTime(matchTime);
				match.setScore(matchScore);
				
				Team homeTeam = new Team();
				homeTeam.setNum(homeNum);
				homeTeam.setName(hTeamName);
				homeTeam.setPhoto(hPhoto);
				
				Team awayTeam = new Team();
				awayTeam.setNum(awayNum);
				awayTeam.setName(aTeamName);
				awayTeam.setPhoto(aPhoto);
				
				Team winTeam = new Team();
				winTeam.setNum(winNum);
				winTeam.setName(wTeamName);
				winTeam.setPhoto(wPhoto);
				
				Loc loc = new Loc();
				loc.setNum(locNum);
				loc.setLoc(loc1);
				
				match.setWinTeam(winTeam);
				match.setAwayTeam(awayTeam);
				match.setHomeTeam(homeTeam);
				match.setLoc(loc);
				
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return match;
	}
	
	//매치 업데이트
	public static void updateMatch(Match match) {
		/* default generated stub */;
		Connection con = null;
		PreparedStatement ps = null;
		String sql = null;
				
		try {
		con=ConnectionUtil.getConnection();
		sql="UPDATE match" +
				" SET match_num=?" +
				", match_time=TO_DATE(?,'yyyy/mm/dd hh24:mi:ss')" +
				", match_result_score=? " +
				",home_team_num=?, away_team_num=? ,win_team_num=? " +
				" ,loc_num=?"+
				" WHERE match_num=?";
			
			ps=con.prepareStatement(sql);
			ps.setString(1, match.getNum());
			ps.setString(2, match.getMatchTime().toString());
			ps.setString(3, match.getScore());
			ps.setString(4, match.getHomeTeam().getNum());
			ps.setString(5, match.getAwayTeam().getNum());
			ps.setString(6, match.getWinTeam().getNum());
			ps.setString(7, match.getLoc().getNum());
			ps.setString(8, match.getNum());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * 매치 데이터 삽입 메서드
	 * 
	 * @param match
	 */
	public static void insertMatch(Match match) {
		/* default generated stub */;
		Connection con = null;
		PreparedStatement ps = null;
		String sql = null;
				
		try {
		con=ConnectionUtil.getConnection();
		sql="INSERT INTO match (match_num" +
				", match_time" +
				",home_team_num, away_team_num " +
				" ,loc_num) "+
				 " VALUES(s_match.nextval,TO_DATE(?,'yyyy/mm/dd hh24:mi:ss'),?,?,?)";
			
			ps=con.prepareStatement(sql);
			ps.setString(1, match.getMatchTime());
			ps.setString(2, match.getHomeTeam().getNum());
			ps.setString(3, match.getAwayTeam().getNum());
			ps.setString(4, match.getLoc().getNum());
			ps.executeUpdate();			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	/**
	 * 선택된 경기번호의 이긴팀 번호를 조회하는 메서드
	 * 
	 * @param matchnum
	 */
	public static String selectWinTeam(String matchNum) {
		/* default generated stub */;
		Connection con = null;
		PreparedStatement ps = null;
		String sql = null;
		ResultSet rs =null;
		sql="SELECT win_team_num"+
				" FROM match"+
				" WHERE match_num=?";
		String winTeam = null;
		con=ConnectionUtil.getConnection();
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, matchNum);
			rs=ps.executeQuery();
			
			if(rs.next()){
				winTeam=rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return winTeam;
	
	
	}
	//match 카운트 메서드
	public static int selectMatchCount(){
		Connection con = null;
		PreparedStatement psmt = null;
		String sql = null;
		ResultSet rs =null;
		int matchCount=0;
				
		try {
			con = ConnectionUtil.getConnection();
			sql = "SELECT COUNT(match_num)"
					+ " FROM match m,team h,team a,team w,loc l"
					+ " WHERE m.home_team_num=h.team_num "
					+ " AND m.away_team_num=a.team_num"
					+ " AND m.win_team_num=w.team_num(+)"
					+ " AND m.loc_num=l.loc_num";

			psmt = con.prepareStatement(sql);
			rs = psmt.executeQuery();
			if (rs.next()) {
				matchCount = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return matchCount;
	}
	//경기데이터 삭제 메서드
	public static void deleteMatch (String matchNum) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement psmt = null;
		con = ConnectionUtil.getConnection();
		try {
			psmt = con.prepareStatement("DELETE FROM match "+
			                                                    " WHERE match_num = ?");
			psmt.setString(1, matchNum);
			psmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	public static String selectMatchTime(String matchNum){
		Connection con = null;
		PreparedStatement psmt = null;
		String sql = null;
		ResultSet rs =null;
		String matchTime=null;
				
		try {
			con = ConnectionUtil.getConnection();
			sql = "SELECT TO_CHAR(match_time,'yyyy/mm/dd hh24:mi:ss')"
					+ " FROM match m,team h,team a,team w,loc l"
					+ " WHERE m.home_team_num=h.team_num "
					+ " AND m.away_team_num=a.team_num"
					+ " AND m.win_team_num=w.team_num(+)"
					+ " AND m.loc_num=l.loc_num"
					+ " AND m.match_num=?";

			psmt = con.prepareStatement(sql);
			psmt.setString(1, matchNum);
			rs = psmt.executeQuery();
			if (rs.next()) {
				matchTime = rs.getString(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return matchTime;
	}
	
	
}