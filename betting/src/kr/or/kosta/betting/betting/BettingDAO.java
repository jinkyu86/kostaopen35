package kr.or.kosta.betting.betting;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.or.kosta.betting.loc.Loc;
import kr.or.kosta.betting.match.Match;
import kr.or.kosta.betting.team.Team;
import kr.or.kosta.betting.util.ConnectionUtil;

public class BettingDAO {


	public static ArrayList<Betting> selectBettingList(int page, int length) {
	 
		/**
		 * ���� �������� ��� ������ ��ȸ �ϴ� �޼���
		 * 
		 * @param page
		 * @param length
		 */
		
		Connection con = null;
		PreparedStatement psmt = null;
		String sql = null;
		ResultSet rs = null;
		ArrayList<Betting> bettingList = new ArrayList<Betting>();
		try {
			con = ConnectionUtil.getConnection();
			sql = "SELECT m.match_num,m.match_result_score"+
					",m.home_team_num,h.team_name,h.photo"+
					",m.away_team_num,a.team_name,a.photo"+
					",m.win_team_num,w.team_name,w.photo"+
					",m.loc_num,l.loc"+
					",b.bet_num, b.bet_rating, b.sele_rating, b.tot_mineral"+
			        ",b.distinguish_team,m.match_time"+
					" FROM betting b,match m,team h,team a,team w,loc l"+
					 " WHERE m.home_team_num=h.team_num"+
					 " AND m.away_team_num=a.team_num"+
					 " AND m.win_team_num=w.team_num(+)"+
					 " AND m.loc_num=l.loc_num"+
					 " AND m.match_num=b.match_num" +
					 " ORDER BY m.match_num DESC, b.bet_num";
			
			psmt = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			rs = psmt.executeQuery();
			
			if (page > 1) {
				rs.absolute((page - 1) * length);
			}
			int getRecordCount = 0;
			while(rs.next()&&getRecordCount<length){
			    getRecordCount++;
				
			    String matchNum=rs.getString(1);
				String matchScore = rs.getString(2);
				String homeNum = rs.getString(3);
				String hTeamName = rs.getString(4);
				String hPhoto = rs.getString(5);
				String awayNum = rs.getString(6);
				String aTeamName = rs.getString(7);
				String aPhoto = rs.getString(8);
				String winNum = rs.getString(9);
				String wTeamName = rs.getString(10);
				String wPhoto = rs.getString(11);
				String locNum=rs.getString(12);
				String loc1 = rs.getString(13);
			    String batNum = rs.getString(14);
				double batRating = rs.getDouble(15);
				long seleRating = rs.getLong(16);
				long totMineral = rs.getLong(17);
				String distinguishTeam = rs.getString(18);
				String matchTime = rs.getString(19);
				
				Betting betting = new Betting();
				betting.setNum(batNum);
				betting.setBatRating(batRating);
				betting.setSeleRating(seleRating);
				betting.setTotMineral(totMineral);
				betting.setDistnum(distinguishTeam);
											
				Match match = new Match();
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
				
				match.setHomeTeam(homeTeam);
				match.setAwayTeam(awayTeam);
				match.setWinTeam(winTeam);
				betting.setMatch(match);
				match.setLoc(loc);
				
				bettingList.add(betting);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bettingList;
	}

	
	public static ArrayList<Betting> selectBettingListByDate(String date) {
		
		/**
		 * �ش� ��¥�� ����� �����͸� ��ȸ�ϴ� �޼���
		 * 
		 * @param Date
		 */
		
		Connection con = null;
		PreparedStatement psmt = null;
		String sql = null;
		ResultSet rs = null;
		ArrayList<Betting> BettingList = new ArrayList<Betting>();
		try {
			
			con = ConnectionUtil.getConnection();
			sql = "SELECT m.match_num,m.match_result_score"+
					",m.home_team_num,h.team_name,h.photo"+
					",m.away_team_num,a.team_name,a.photo"+
					",m.win_team_num,w.team_name,w.photo"+
					",m.loc_num,l.loc"+
					",b.bet_num, b.bet_rating, b.sele_rating, b.tot_mineral"+
			        ",b.distinguish_team,m.match_time"+
					" FROM betting b,match m,team h,team a,team w,loc l"+
					 " WHERE m.home_team_num=h.team_num"+
					 " AND m.away_team_num=a.team_num"+
					 " AND m.win_team_num=w.team_num(+)"+
					 " AND m.loc_num=l.loc_num"+
					 " AND m.match_num=b.match_num"+
					 " AND TO_CHAR(m.match_time,'YYYY/MM/DD')= ?" +
					 " ORDER BY m.match_num DESC, b.bet_num";
			
			psmt = con.prepareStatement(sql);
			
			psmt.setString(1, date);
			rs = psmt.executeQuery();
			
			while(rs.next()){
			   	
				String matchNum=rs.getString(1);
				String matchScore = rs.getString(2);
				String homeNum = rs.getString(3);
				String hTeamName = rs.getString(4);
				String hPhoto = rs.getString(5);
				String awayNum = rs.getString(6);
				String aTeamName = rs.getString(7);
				String aPhoto = rs.getString(8);
				String winNum = rs.getString(9);
				String wTeamName = rs.getString(10);
				String wPhoto = rs.getString(11);
				String locNum=rs.getString(12);
				String loc1 = rs.getString(13);
			    String batNum = rs.getString(14);
				double batRating = rs.getDouble(15);
				long seleRating = rs.getLong(16);
				long totMineral = rs.getLong(17);
				String distinguishTeam = rs.getString(18);
				String matchTime = rs.getString(19);
				
				Betting betting = new Betting();
				betting.setNum(batNum);
				betting.setBatRating(batRating);
				betting.setSeleRating(seleRating);
				betting.setTotMineral(totMineral);
				betting.setDistnum(distinguishTeam);
											
				Match match = new Match();
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
				
                match.setHomeTeam(homeTeam);
				match.setAwayTeam(awayTeam);
				match.setWinTeam(winTeam);
				betting.setMatch(match);
				match.setLoc(loc);
				
				BettingList.add(betting);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return BettingList;
	}

	public static Betting selectBettingListByHome(String num) {
		
		/**
		 * ��ġ��ȣ�� Ȩ��⸸ ��ȸ�ϴ� �޼���
		 * 
		 * @param Date
		 */
		
		Connection con = null;
		PreparedStatement psmt = null;
		String sql = null;
		ResultSet rs = null;
		Betting betting = null;
		try {
			
			con = ConnectionUtil.getConnection();
			sql = "SELECT m.match_num,m.match_result_score"+
					",m.home_team_num,h.team_name,h.photo"+
					",m.away_team_num,a.team_name,a.photo"+
					",m.win_team_num,w.team_name,w.photo"+
					",m.loc_num,l.loc"+
					",b.bet_num, b.bet_rating, b.sele_rating, b.tot_mineral"+
			        ",b.distinguish_team" +
			        ",TO_CHAR(match_time,'yyyy/mm/dd hh24:mi:ss')"+
					" FROM betting b,match m,team h,team a,team w,loc l"+
					 " WHERE m.home_team_num=h.team_num"+
					 " AND m.away_team_num=a.team_num"+
					 " AND m.win_team_num=w.team_num(+)"+
					 " AND m.loc_num=l.loc_num"+
					 " AND m.match_num=b.match_num"+
					 " AND m.match_num= ?" +
					 " AND b.distinguish_team=? ";
			
			psmt = con.prepareStatement(sql);
			
			psmt.setString(1, num);
			psmt.setString(2, "1");
			rs = psmt.executeQuery();
			
			if(rs.next()){
			   	
				String matchNum=rs.getString(1);
				String matchScore = rs.getString(2);
				String homeNum = rs.getString(3);
				String hTeamName = rs.getString(4);
				String hPhoto = rs.getString(5);
				String awayNum = rs.getString(6);
				String aTeamName = rs.getString(7);
				String aPhoto = rs.getString(8);
				String winNum = rs.getString(9);
				String wTeamName = rs.getString(10);
				String wPhoto = rs.getString(11);
				String locNum=rs.getString(12);
				String loc1 = rs.getString(13);
			    String batNum = rs.getString(14);
				double batRating = rs.getDouble(15);
				long seleRating = rs.getLong(16);
				long totMineral = rs.getLong(17);
				String distinguishTeam = rs.getString(18);
				String matchTime = rs.getString(19);
				
				betting = new Betting();
				betting.setNum(batNum);
				betting.setBatRating(batRating);
				betting.setSeleRating(seleRating);
				betting.setTotMineral(totMineral);
				betting.setDistnum(distinguishTeam);
											
				Match match = new Match();
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
				
				match.setHomeTeam(homeTeam);
				match.setWinTeam(winTeam);
				betting.setMatch(match);
				match.setLoc(loc);
	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return betting;
	}
	
	public static Betting selectBettingListByAway(String num) {
		
		/**
		 * ��ġ�ѹ��� ���� ����̰�� �����͸� ��ȸ�ϴ� �޼���
		 * 
		 * @param Date
		 */
		
		Connection con = null;
		PreparedStatement psmt = null;
		String sql = null;
		ResultSet rs = null;
		Betting betting =null;
		try {
			
			con = ConnectionUtil.getConnection();
			sql = "SELECT m.match_num,m.match_result_score"+
					",m.home_team_num,h.team_name,h.photo"+
					",m.away_team_num,a.team_name,a.photo"+
					",m.win_team_num,w.team_name,w.photo"+
					",m.loc_num,l.loc"+
					",b.bet_num, b.bet_rating, b.sele_rating, b.tot_mineral"+
			        ",b.distinguish_team" +
			        ",TO_CHAR(match_time,'yyyy/mm/dd hh24:mi:ss')"+
					" FROM betting b,match m,team h,team a,team w,loc l"+
					 " WHERE m.home_team_num=h.team_num"+
					 " AND m.away_team_num=a.team_num"+
					 " AND m.win_team_num=w.team_num(+)"+
					 " AND m.loc_num=l.loc_num"+
					 " AND m.match_num=b.match_num"+
					 " AND m.match_num= ?" +
					 " AND b.distinguish_team=?";
			
			psmt = con.prepareStatement(sql);
			
			psmt.setString(1, num);
			psmt.setString(2, "2");
			rs = psmt.executeQuery();
			
			if(rs.next()){
			   	
				String matchNum=rs.getString(1);
				String matchScore = rs.getString(2);
				String homeNum = rs.getString(3);
				String hTeamName = rs.getString(4);
				String hPhoto = rs.getString(5);
				String awayNum = rs.getString(6);
				String aTeamName = rs.getString(7);
				String aPhoto = rs.getString(8);
				String winNum = rs.getString(9);
				String wTeamName = rs.getString(10);
				String wPhoto = rs.getString(11);
				String locNum=rs.getString(12);
				String loc1 = rs.getString(13);
			    String batNum = rs.getString(14);
				double batRating = rs.getDouble(15);
				long seleRating = rs.getLong(16);
				long totMineral = rs.getLong(17);
				String distinguishTeam = rs.getString(18);
				String matchTime = rs.getString(19);
				
				betting = new Betting();
				betting.setNum(batNum);
				betting.setBatRating(batRating);
				betting.setSeleRating(seleRating);
				betting.setTotMineral(totMineral);
				betting.setDistnum(distinguishTeam);
											
				Match match = new Match();
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
				
				match.setAwayTeam(awayTeam);
				match.setWinTeam(winTeam);
				betting.setMatch(match);
				match.setLoc(loc);
				
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return betting;
	}
	public static void updateBetting(Betting betting){

		/**
		 * ���ù�ȣ�� ���õ� �������� ������Ʈ
		 * 
		 * @param num
		 * @param batRating
		 * @param seleRating
		 * @param totMineral
		 */
		
		Connection con = null;
		PreparedStatement psmt = null;
		con = ConnectionUtil.getConnection();
		try {
			psmt = con.prepareStatement(
					"UPDATE betting SET bet_rating=?,sele_rating=?"+
			         ",tot_mineral=? "+
			        "WHERE bet_num=?");

			psmt.setDouble(1, betting.getBatRating());
			psmt.setLong(2, betting.getSeleRating());
			psmt.setLong(3, betting.getTotMineral());
			psmt.setString(4, betting.getNum());
			psmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

		
	}

	/**
	 * ���õ� ��ȣ�� ���÷� ��ȸ
	 * 
	 * @param num
	 */
	public static double selectBettingRating(String num) {
		/* default generated stub */;
		Connection con = null;
		PreparedStatement ps = null;
		String sql = null;
		ResultSet rs =null;
		sql="SELECT bet_rating"+
				" FROM betting"+
				" WHERE bet_num=?";
		double batRating = 0;
		con=ConnectionUtil.getConnection();
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, num);
			rs=ps.executeQuery();
			
			if(rs.next()){
				batRating=rs.getDouble(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return batRating;
		
	}

	/**
	 * ���õ� ��ȣ�� �������� ���÷�
	 * 
	 * @param num
	 */
	public static long selectBettingSeleRating(String num) {
		/* default generated stub */;
		Connection con = null;
		PreparedStatement ps = null;
		String sql = null;
		ResultSet rs =null;
		sql="SELECT sele_rating"+
				" FROM betting"+
				" WHERE bet_num=?";
		long seleRating = 0;
		con=ConnectionUtil.getConnection();
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, num);
			rs=ps.executeQuery();
			
			if(rs.next()){
				seleRating=rs.getLong(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return seleRating;
		
	}

	/**
	 * ���õ� ���� ��ȣ�� ���� ������ ���� �ݾ��� ��ȸ
	 * 
	 * @param num
	 */
	public static long selectBettingTotMineral(String num) {
		/* default generated stub */;
		Connection con = null;
		PreparedStatement ps = null;
		String sql = null;
		ResultSet rs =null;
		sql="SELECT tot_mineral"+
				" FROM betting"+
				" WHERE bet_num=?";
		long totMineral=0;
		con=ConnectionUtil.getConnection();
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, num);
			rs=ps.executeQuery();
			
			if(rs.next()){
				totMineral=rs.getLong(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return totMineral;
		
	}
	//���� ���̺��� Ȩ�� �÷� ���� �޼���
	public static void insertHomeBetting(String num){
		/* default generated stub */;
		Connection con = null;
		PreparedStatement ps = null;
		String sql = null;
				
		try {
		con=ConnectionUtil.getConnection();
		sql="INSERT INTO betting (bet_num, bet_rating, sele_rating," +
				" tot_mineral, distinguish_team, match_num) "+
				 " VALUES(s_home.nextval,1,0,0,1,?)";
				 			
			ps=con.prepareStatement(sql);
			
			ps.setString(1, num);
						
			ps.executeUpdate();
									
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//���� ���̺��� ������� �÷� ���� �޼���
	public static void insertAwayBetting(String num){
		/* default generated stub */;
		Connection con = null;
		PreparedStatement ps = null;
		String sql = null;
		
		try {
		con=ConnectionUtil.getConnection();
		sql="INSERT INTO betting (bet_num, bet_rating, sele_rating," +
				" tot_mineral, distinguish_team, match_num) "+
				 " VALUES(s_away.nextval,1,0,0,2,?)";
							
			ps=con.prepareStatement(sql);
			
			ps.setString(1, num);
				
			ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//���ø���Ʈ ī���͸� ���� �޼���
	public static int selectBettingCount(){
		Connection con = null;
		PreparedStatement psmt = null;
		String sql = null;
		ResultSet rs =null;
		int bettingCount=0;
				
		try {
		con=ConnectionUtil.getConnection();
		sql = "SELECT COUNT(b.bet_num)"+
				" FROM betting b,match m,team h,team a,team w,loc l"+
				 " WHERE m.home_team_num=h.team_num"+
				 " AND m.away_team_num=a.team_num"+
				 " AND m.win_team_num=w.team_num(+)"+
				 " AND m.loc_num=l.loc_num"+
				 " AND m.match_num=b.match_num";
			
			psmt=con.prepareStatement(sql);
			rs=psmt.executeQuery();
			if(rs.next()){
				bettingCount=rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bettingCount;
	}
	
	//���ø���Ʈ ī���͸� ���� �޼���
		public static int selectBettingMatchCount(String num){
			Connection con = null;
			PreparedStatement psmt = null;
			String sql = null;
			ResultSet rs =null;
			int matchCount=0;
					
			try {
			con=ConnectionUtil.getConnection();
			sql = "SELECT COUNT(m.match_num)"+
					" FROM betting b,match m,team h,team a,team w,loc l"+
					 " WHERE m.home_team_num=h.team_num"+
					 " AND m.away_team_num=a.team_num"+
					 " AND m.win_team_num=w.team_num(+)"+
					 " AND m.loc_num=l.loc_num"+
					 " AND m.match_num=b.match_num" +
					 " AND m.match_num=?";
				
				psmt=con.prepareStatement(sql);
				psmt.setString(1, num);
				rs=psmt.executeQuery();
				if(rs.next()){
					matchCount=rs.getInt(1);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return matchCount;
		}
}


