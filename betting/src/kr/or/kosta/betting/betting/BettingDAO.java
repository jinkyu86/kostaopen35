package kr.or.kosta.betting.betting;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import kr.or.kosta.betting.match.Match;
import kr.or.kosta.betting.util.ConnectionUtil;
1234
public class BettingDAO {

	public ArrayList<Betting> selectBettingList(int page, int length) {
		
		/**
		 * 베팅 데이터의 모든 데이터 조회 하는 메서드
		 * 
		 * @param page
		 * @param length
		 */
		
		Connection con = null;
		PreparedStatement psmt = null;
		String sql = null;
		ResultSet rs = null;
		ArrayList<Betting> BettingList = new ArrayList<Betting>();
		try {
			con = ConnectionUtil.getConnection();
			sql = "SELECT  b.bat_num, b.bat_rating, b.sele_rating, b.tot_mineral, b.distinguish_team, b.team_num" +
			         "m.match_num"+
			         " FROM  b.betting, m.match"+
					 " Where b.match_num=m.match_num";
			
			psmt = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			rs = psmt.executeQuery();
			if (page > 1) {
				rs.absolute((page - 1) * length);
			}
			int getRecordCount = 0;
			while(rs.next()&&getRecordCount<length){
			    getRecordCount++;
				
			    String batNum = rs.getString(1);
				Long batRating = rs.getLong(2);
				Long seleRating = rs.getLong(3);
				Long totMineral = rs.getLong(4);
				String distinguishTeam = rs.getString(5);
				String teamNum = rs.getString(6);
				String matchNum = rs.getString(7);
				
				Betting betting = new Betting();
				betting.setNum(batNum);;
				betting.setBatRating(batRating);
				betting.setSeleRating(seleRating);
				betting.setTotMineral(totMineral);
				betting.setDistnum(distinguishTeam);
				betting.setTeamNum(teamNum);
				
				Match match=new Match();
				match.setNum(matchNum);

				BettingList.add(betting);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return BettingList;
	}

	
	public ArrayList<Betting> selectBettingListByDate(Date date) {
		
		/**
		 * 해당 날짜의 경기의 데이터만 조회하는 메서드
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
			sql = "SELECT  b.bat_num, b.bat_rating, b.sele_rating, b.tot_mineral, b.distinguish_team, b.team_num" +
			         "m.match_num"+
			         " FROM  b.betting, m.match"+
					 " Where b.match_num=m.match_num AND m.match_time=?";
			
			psmt = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			
			psmt.setString(1, date.toString());
			rs = psmt.executeQuery();
			
			while(rs.next()){
			   	
			    String batNum = rs.getString(1);
				Long batRating = rs.getLong(2);
				Long seleRating = rs.getLong(3);
				Long totMineral = rs.getLong(4);
				String distinguishTeam = rs.getString(5);
				String teamNum = rs.getString(6);
				String matchNum = rs.getString(7);
				
				Betting betting = new Betting();
				betting.setNum(batNum);;
				betting.setBatRating(batRating);
				betting.setSeleRating(seleRating);
				betting.setTotMineral(totMineral);
				betting.setDistnum(distinguishTeam);
				betting.setTeamNum(teamNum);
				
				Match match=new Match();
				match.setNum(matchNum);

				BettingList.add(betting);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return BettingList;
	}

//	 public void insertBetting(Betting betting) {
//		
//		/**
//		 * 베팅 데이터 입력하는 메서드
//		 * 
//		 * @param betting
//		 */
//		
//		Connection con = null;
//		PreparedStatement psmt = null;
//		con = ConnectionUtil.getConnection();
//		try {
//			psmt = con.prepareStatement("INSERT INTO betting "
//					+ "(match_num,bat_rating, sele_rating, tot_mineral, bet_num,distinguish_team,team_num) "
//					+ " VALUES (?,?,?,?,?,?,?)");
//			psmt.setString(1, betting.getMatchNum());
//			psmt.setLong(2, betting.getBatRating());
//			psmt.setLong(3, betting.getSeleRating());
//			psmt.setLong(4, betting.getTotMineral());
//			psmt.setString(5, betting.getNum());
//			psmt.setString(6, betting.getDistnum());
//			psmt.setString(7, betting.getTeamNum());
//			psmt.executeUpdate();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//	}

	public void updateBetting(Betting betting){

		/**
		 * 베팅번호로 선택된 데이터의 업데이트
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
			psmt = con.prepareStatement("UPDATE  SET match_num=?," + "bat_rating=?,"
					+ "sele_rating=? " +"tot_mineral=? "+"distinguish_team=?" +"team_num" + 
					"WHERE bet_num=?");

			psmt.setString(1, betting.getMatchNum());
			psmt.setLong(2, betting.getBatRating());
			psmt.setLong(3, betting.getSeleRating());
			psmt.setLong(4, betting.getTotMineral());
			psmt.setString(5, betting.getDistnum());
			psmt.setString(6, betting.getTeamNum());

			psmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

		
	}

	/**
	 * 선택된 번호의 베팅률 조회
	 * 
	 * @param num
	 */
	public long selectBettingRating(String num) {
		/* default generated stub */;
		Connection con = null;
		PreparedStatement ps = null;
		String sql = null;
		ResultSet rs =null;
		sql="SELECT bat_rating"+
				" FROM betting"+
				" WHERE bet_num=?";
		long batRating = 0;
		con=ConnectionUtil.getConnection();
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, num);
			rs=ps.executeQuery();
			
			if(rs.next()){
				batRating=rs.getLong(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return batRating;
		
	}

	/**
	 * 선택된 번호의 베팅팀의 선택률
	 * 
	 * @param num
	 */
	public long selectBettingSeleRating(String num) {
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
	 * 선택된 베팅 번호의 팀의 누적된 베팅 금액을 조회
	 * 
	 * @param num
	 */
	public long selectBettingTotMineral(String num) {
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
}
