package kr.or.kosta.betting.match;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

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
	public static ArrayList<Match> selectMatchList(int page, int length) {
		/* default generated stub */;
		Connection con = null;
		PreparedStatement ps = null;
		String sql = null;
		ResultSet rs =null;
		ArrayList<Match>matchList=new ArrayList<Match>();
		Match match = null;
		
		try {
		con=ConnectionUtil.getConnection();
		sql="SELECT match_num,match_time,match_result_score,home_team_num," +
				"away_team_num,win_team_num,m.loc_num"+
				" FROM match m,team t,loc l"+
				" WHERE m.home_team=t.num AND m.away_team_num=t.num" +
				"	AND m.win_team_num=t.num AND m.loc_num=l.loc_num";
			
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
				Date matchTime = rs.getDate(2);
				String matchScore = rs.getString(3);
				String homeNum = rs.getString(4);
				String awayNum = rs.getString(5);
				String winNum = rs.getString(6);
				String locNum=rs.getString(7);
				
				match = new Match();
				match.setNum(matchNum);
				match.setMatchTime(matchTime);
				match.setScore(matchScore);
				
				Team homeTeam = new Team();
				homeTeam.setNum(homeNum);
				
				Team awayTeam = new Team();
				awayTeam.setNum(awayNum);
				
				Team winTeam = new Team();
				winTeam.setName(winNum);
				
				Loc loc = new Loc();
				loc.setNum(locNum);
				
				match.setTeam(winTeam);
				match.setTeam(awayTeam);
				match.setTeam(homeTeam);
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
	public ArrayList<Match> selectMatchByDate(Date date) {
		/* default generated stub */;
		Connection con = null;
		PreparedStatement ps = null;
		String sql = null;
		ResultSet rs =null;
		ArrayList<Match>matchList=new ArrayList<Match>();
		Match match = null;
		
		try {
		con=ConnectionUtil.getConnection();
		sql="SELECT match_num,match_time,match_result_score,home_team_num," +
				"away_team_num,win_team_num,m.loc_num"+
				" FROM match m,team t,loc l"+
				" WHERE m.home_team=t.num AND m.away_team_num=t.num" +
				"	AND m.win_team_num=t.num AND m.loc_num=l.loc_num" +
				" AND m.match_time=?";
			
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			
			while(rs.next()){
				String matchNum=rs.getString(1);
				String matchScore = rs.getString(3);
				String homeNum = rs.getString(4);
				String awayNum = rs.getString(5);
				String winNum = rs.getString(6);
				String locNum=rs.getString(7);
				
				match = new Match();
				match.setNum(matchNum);
				match.setMatchTime(date);
				match.setScore(matchScore);
				
				Team homeTeam = new Team();
				homeTeam.setNum(homeNum);
				
				Team awayTeam = new Team();
				awayTeam.setNum(awayNum);
				
				Team winTeam = new Team();
				winTeam.setName(winNum);
				
				Loc loc = new Loc();
				loc.setNum(locNum);
				
				match.setTeam(winTeam);
				match.setTeam(awayTeam);
				match.setTeam(homeTeam);
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
	public void updateMatch(Match match) {
		/* default generated stub */;
		Connection con = null;
		PreparedStatement ps = null;
		String sql = null;
				
		try {
		con=ConnectionUtil.getConnection();
		sql="UPDATE match" +
				" SET match_num=?, match_time=?, match_result_score=? " +
				",home_team_num=?, away_team_num=? ,win_team_num=? " +
				" ,loc_num=?"+
				" WHERE match_num=?";
			
			ps=con.prepareStatement(sql);
			ps.setString(1, match.getNum());
			ps.setString(2, match.getMatchTime().toString());
			ps.setString(3, match.getScore());
			ps.setString(4, match.getHomeNum());
			ps.setString(5, match.getAwayNum());
			ps.setString(6, match.getWinNum());
			ps.setString(7, match.getLocNum());
			ps.setString(8, match.getNum());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * 매치 데이서 삽입 메서드
	 * 
	 * @param match
	 */
	public void insertMatch(Match match) {
		/* default generated stub */;
		Connection con = null;
		PreparedStatement ps = null;
		String sql = null;
				
		try {
		con=ConnectionUtil.getConnection();
		sql="INSERT INTO match (match_num, match_time, match_result_score " +
				",home_team_num, away_team_num ,win_team_num " +
				" ,loc_num) "+
				 " VALUES(s_match.nextval,?,?,?,?,?,?)";
			
			ps=con.prepareStatement(sql);
			ps.setString(1, match.getMatchTime().toString());
			ps.setString(2, match.getScore());
			ps.setString(3, match.getHomeNum());
			ps.setString(4, match.getAwayNum());
			ps.setString(5, match.getWinNum());
			ps.setString(6, match.getLocNum());
			ps.setString(7, match.getNum());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 선택된 날짜의 경기의 수만큼 카운터하는 메서드
	 * 
	 * @param date
	 */
	public ArrayList<Match> selectMatchByDate(int length,int page,Date date){
		/* default generated stub */;
		Connection con = null;
		PreparedStatement psmt = null;
		String sql = null;
		ResultSet rs =null;
		ArrayList<Match>matchList=new ArrayList<Match>();
					
			try {
			con=ConnectionUtil.getConnection();
			sql="SELECT match_num,match_time,match_result_score,home_team_num," +
					"away_team_num,win_team_num,m.loc_num"+
					" FROM match m,team t,loc l"+
					" WHERE m.home_team=t.num AND m.away_team_num=t.num" +
					"	AND m.win_team_num=t.num AND m.loc_num=l.loc_num" +
					" AND match_time=?";
				
			//rs.absolute()가 가능하도록 설정
				psmt=con.prepareStatement(sql,
						ResultSet.TYPE_SCROLL_INSENSITIVE,
						ResultSet.CONCUR_READ_ONLY);
				psmt.setString(1, date.toString());
				rs=psmt.executeQuery();
				Match match = null;
				
				if(page>1){
					rs.absolute((page-1)*length);
				}
				//가져온 레코드 개수
				int getRecordCount=0;
				while(rs.next()&&getRecordCount<length){
					getRecordCount++;
					String matchNum=rs.getString(1);
					Date matchTime = rs.getDate(2);
					String matchScore = rs.getString(3);
					String homeNum = rs.getString(4);
					String awayNum = rs.getString(5);
					String winNum = rs.getString(6);
					String locNum=rs.getString(7);
					
					match = new Match();
					match.setNum(matchNum);
					match.setMatchTime(matchTime);
					match.setScore(matchScore);
					
					Team homeTeam = new Team();
					homeTeam.setNum(homeNum);
					
					Team awayTeam = new Team();
					awayTeam.setNum(awayNum);
					
					Team winTeam = new Team();
					winTeam.setName(winNum);
					
					Loc loc = new Loc();
					loc.setNum(locNum);
					
					match.setTeam(winTeam);
					match.setTeam(awayTeam);
					match.setTeam(homeTeam);
					match.setLoc(loc);
					
					matchList.add(match);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return matchList;
		
	}
	
	public static int selectMatchByDateCount(Date date){
		Connection con = null;
		PreparedStatement psmt = null;
		String sql = null;
		ResultSet rs =null;
		int matchCount=0;
				
		try {
		con=ConnectionUtil.getConnection();
		sql="SELECT count(m.match_num)"+
				" FROM match m,team t,loc l"+
				" WHERE m.home_team=t.num AND m.away_team_num=t.num" +
				"	AND m.win_team_num=t.num AND m.loc_num=l.loc_num" +
				" AND match_time=?";
					
		
			psmt=con.prepareStatement(sql);
			psmt.setString(1, date.toString());
			rs=psmt.executeQuery();
			

		if(rs.next()){
				matchCount=rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return matchCount;
	}
	/**
	 * 선택된 팀번호의 이긴팀 번호를 조회하는 메서드
	 * 
	 * @param matchnum
	 */
	public String selectWinTeam(String matchNum) {
		/* default generated stub */;
		Connection con = null;
		PreparedStatement ps = null;
		String sql = null;
		ResultSet rs =null;
		sql="SELECT win_num"+
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
	public void insertHomeBetting(Match match){
		/* default generated stub */;
		Connection con = null;
		PreparedStatement ps = null;
		String sql = null;
				
		try {
		con=ConnectionUtil.getConnection();
		sql="INSERT INTO betting (bat_num, bat_rating, sele_rating," +
				" tot_mineral, distinguish_team, team_num, match_num) "+
				 " VALUES(s_home.nextval,1,0,0,1,?,?)";
			
			ps=con.prepareStatement(sql);
			
			ps.setString(1, match.getHomeNum());
			ps.setString(2, match.getNum());
									
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void insertAwayBetting(Match match){
		/* default generated stub */;
		Connection con = null;
		PreparedStatement ps = null;
		String sql = null;
				
		try {
		con=ConnectionUtil.getConnection();
		sql="INSERT INTO betting (bat_num, bat_rating, sele_rating," +
				" tot_mineral, distinguish_team, team_num, match_num) "+
				 " VALUES(s_away.nextval,1,0,0,2,?,?)";
			
			ps=con.prepareStatement(sql);
			
			ps.setString(1, match.getAwayNum());
			ps.setString(2, match.getNum());
									
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
