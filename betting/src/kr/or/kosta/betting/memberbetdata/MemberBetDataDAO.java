package kr.or.kosta.betting.memberbetdata;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.or.kosta.betting.betting.Betting;
import kr.or.kosta.betting.loc.Loc;
import kr.or.kosta.betting.match.Match;
import kr.or.kosta.betting.member.Member;
import kr.or.kosta.betting.team.Team;
import kr.or.kosta.betting.util.ConnectionUtil;


public class MemberBetDataDAO {

	public static ArrayList<MemberBatData> 
									selectMemberBetDataList(int page, int length) {

		/**
		 * 개인 베팅 데이터의 모든 정보 조회
		 * 
		 * @param page
		 * @param length
		 */

		Connection con = null;
		PreparedStatement psmt = null;
		String sql = null;
		ResultSet rs = null;
		ArrayList<MemberBatData> mbdList = new ArrayList<MemberBatData>();
		try {
			con = ConnectionUtil.getConnection();
			sql ="SELECT m.match_num,m.match_result_score"+
					",m.home_team_num,h.team_name,h.photo"+
					",m.away_team_num,a.team_name,a.photo"+
					",m.win_team_num,w.team_name,w.photo"+
					",m.loc_num,l.loc"+
					",b.bet_num, b.bet_rating, b.sele_rating, b.tot_mineral"+
			        ",b.distinguish_team, m.match_time" +
			        ",d.bet_mineral, d.id, d.personal_betting_num, d.selecting_time" +
			        ",d.give_mineral_confirm" +
			        ",e.name ,e.pw ,e.email ,e.mineral"+
					" FROM betting b,match m,team h,team a,team w,loc l" +
					",member_betting_data d,member e "+
					 " WHERE m.home_team_num=h.team_num"+
					 " AND m.away_team_num=a.team_num"+
					 " AND m.win_team_num=w.team_num(+)"+
					 " AND m.loc_num=l.loc_num"+
					 " AND m.match_num=b.match_num" +
					 " AND b.bet_num=d.bet_num" +
					 " AND e.id = d.id" +
					 " ORDER BY d.selecting_time DESC"; 
		
			psmt = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			rs = psmt.executeQuery();
			if (page > 1) {
				rs.absolute((page - 1) * length);
			}
			int getRecordCount = 0;
			
			while (rs.next() && getRecordCount < length) {
				getRecordCount++;
				
				String matchNum = rs.getString(1);
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
				String locNum = rs.getString(12);
				String loc1 = rs.getString(13);
				String batNum = rs.getString(14);
				Long batRating = rs.getLong(15);
				Long seleRating = rs.getLong(16);
				Long totMineral = rs.getLong(17);
				String distinguishTeam = rs.getString(18);
				String matchTime = rs.getString(19);
				long betMineral = rs.getLong(20);
				String ID = rs.getString(21);
				String mbdNum = rs.getString(22);
				String selectTime = rs.getString(23);
				String gmc = rs.getString(24);
				String name = rs.getString(25);
				String pw = rs.getString(26);
				String email = rs.getString(27);
				long mineral = rs.getLong(28);

				MemberBatData mbd = new MemberBatData();
				mbd.setNum(mbdNum);
				mbd.setBetMineral(betMineral);
				mbd.setSeleTime(selectTime);
				mbd.setGiveMineralConfirm(gmc);

				Member member = new Member();
				member.setID(ID);
				member.setName(name);
				member.setPW(pw);
				member.setEmail(email);
				member.setMineral(mineral);

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
				winTeam.setName(winNum);
				winTeam.setName(wTeamName);
				winTeam.setPhoto(wPhoto);

				Loc loc = new Loc();
				loc.setNum(locNum);
				loc.setLoc(loc1);

				if (distinguishTeam.equals("1")) {
					match.setHomeTeam(homeTeam);
				} else {
					match.setAwayTeam(awayTeam);
				}
				match.setWinTeam(winTeam);
				match.setLoc(loc);
				betting.setMatch(match);

				mbd.setBetting(betting);
				mbd.setMember(member);

				mbdList.add(mbd);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mbdList;
	}

	public static ArrayList<MemberBatData> 
	 						selectMemberBetDataListByID(int page, int length,String ID1) {

		/**
		 * 선택된 아이디의 맴버데이터 조회 메서드
		 * 
		 * @param ID
		 */
		Connection con = null;
		PreparedStatement psmt = null;
		String sql = null;
		ResultSet rs = null;
		ArrayList<MemberBatData> mbdList = new ArrayList<MemberBatData>();
		try {
			con = ConnectionUtil.getConnection();
			sql ="SELECT m.match_num,m.match_result_score"+
					",m.home_team_num,h.team_name,h.photo"+
					",m.away_team_num,a.team_name,a.photo"+
					",m.win_team_num,w.team_name,w.photo"+
					",m.loc_num,l.loc"+
					",b.bet_num, b.bet_rating, b.sele_rating, b.tot_mineral"+
			        ",b.distinguish_team, m.match_time" +
			        ",d.bet_mineral, d.id, d.personal_betting_num, d.selecting_time" +
			        ",d.give_mineral_confirm" +
			        ",e.name ,e.pw ,e.email ,e.mineral"+
					" FROM betting b,match m,team h,team a,team w,loc l" +
					",member_betting_data d,member e "+
					 " WHERE m.home_team_num=h.team_num"+
					 " AND m.away_team_num=a.team_num"+
					 " AND m.win_team_num=w.team_num(+)"+
					 " AND m.loc_num=l.loc_num"+
					 " AND m.match_num=b.match_num" +
					 " AND b.bet_num=d.bet_num" +
					 " AND e.id = d.id" +
					 " AND d.id=?"+
					 " ORDER BY d.selecting_time DESC";
		
			psmt = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			psmt.setString(1,ID1);
			rs = psmt.executeQuery();
			if (page > 1) {
				rs.absolute((page - 1) * length);
			}
			int getRecordCount = 0;
			
			while (rs.next() && getRecordCount < length) {
				getRecordCount++;
				
				String matchNum = rs.getString(1);
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
				String locNum = rs.getString(12);
				String loc1 = rs.getString(13);
				String batNum = rs.getString(14);
				Long batRating = rs.getLong(15);
				Long seleRating = rs.getLong(16);
				Long totMineral = rs.getLong(17);
				String distinguishTeam = rs.getString(18);
				String matchTime = rs.getString(19);
				long betMineral = rs.getLong(20);
				String ID = rs.getString(21);
				String mbdNum = rs.getString(22);
				String selectTime = rs.getString(23);
				String gmc = rs.getString(24);
				String name = rs.getString(25);
				String pw = rs.getString(26);
				String email = rs.getString(27);
				long mineral = rs.getLong(28);

				MemberBatData mbd = new MemberBatData();
				mbd.setNum(mbdNum);
				mbd.setBetMineral(betMineral);
				mbd.setSeleTime(selectTime);
				mbd.setGiveMineralConfirm(gmc);

				Member member = new Member();
				member.setID(ID);
				member.setName(name);
				member.setPW(pw);
				member.setEmail(email);
				member.setMineral(mineral);

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
				winTeam.setName(winNum);
				winTeam.setName(wTeamName);
				winTeam.setPhoto(wPhoto);

				Loc loc = new Loc();
				loc.setNum(locNum);
				loc.setLoc(loc1);

				if (distinguishTeam.equals("1")) {
					match.setHomeTeam(homeTeam);
				} else {
					match.setAwayTeam(awayTeam);
				}
				match.setWinTeam(winTeam);
				match.setLoc(loc);
				betting.setMatch(match);

				mbd.setBetting(betting);
				mbd.setMember(member);

				mbdList.add(mbd);
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mbdList;
	}

	public static void insultMemberBetData(MemberBatData mbd) {

		/**
		 * 멤버데이터 삽입 메서드
		 * 
		 * @param memberBatData
		 */
		
		Connection con=null;
		PreparedStatement psmt=null;
		con=ConnectionUtil.getConnection();
		
		try{	
			psmt=con.prepareStatement(
					"INSERT INTO member_betting_data" +
					"(bet_num, bet_mineral, id, personal_betting_num, selecting_time,give_mineral_confirm)"+
					" VALUES (?,?,?,s_bettingdata.nextval,sysdate,0)");
			psmt.setString(1,mbd.getBetting().getNum());
			psmt.setLong(2,mbd.getBetMineral());
			psmt.setString(3,mbd.getMember().getID());
			psmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public static void deleteMemberbetData(String num) {
		
		/**
		 * 멤버데이터 삭제 메서드
		 * 
		 * @param num
		 */
		
		Connection con=null;
		PreparedStatement psmt=null;
		con=ConnectionUtil.getConnection();
		try{	
			psmt=con.prepareStatement(
					"DELETE FROM member_betting_data " +
					" WHERE personal_betting_num=?");
			
		psmt.setString(1,num);
			
			psmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}

	}

	public static long selectMemberBetDataByIDCount(String ID){
		Connection con = null;
		PreparedStatement psmt = null;
		String sql = null;
		ResultSet rs =null;
		long BatCount=0;
	
		try {
			con=ConnectionUtil.getConnection();
//			sql="SELECT count(m.match_num)"+
//					" FROM match m,team t,loc l"+
//					" WHERE m.home_team=t.num AND m.away_team_num=t.num" +
//					"	AND m.win_team_num=t.num AND m.loc_num=l.loc_num" +
//					" AND match_time=?";
			sql = "SELECT  count(personal_betting_num)"
					+ "  FROM  member_betting_data"
					+ " WHERE id=?";
			
				psmt=con.prepareStatement(sql);
				psmt.setString(1, ID);
				rs=psmt.executeQuery();
				

			if(rs.next()){
				BatCount=rs.getInt(1);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return BatCount;
		}
	public static void updateMemberBetData(String num) {

		/**
		 * 멤버데이터 삽입 메서드
		 * 
		 * @param memberBatData
		 */
		
		Connection con=null;
		PreparedStatement psmt=null;
		con=ConnectionUtil.getConnection();
		
		try{	
			psmt=con.prepareStatement(
					"UPDATE  member_betting_data " +
					" SET give_mineral_confirm=1 " + 
					" WHERE personal_betting_num=?");
			psmt.setString(1,num);	
			psmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static int selectMemberbetdataCount() {
		Connection con = null;
		PreparedStatement psmt = null;
		String sql = null;
		ResultSet rs = null;
		int memberbetdataCount = 0;

		try {
			con = ConnectionUtil.getConnection();
			sql = "SELECT count(personal_betting_num)" + " FROM member_betting_data";

			psmt = con.prepareStatement(sql);
			rs = psmt.executeQuery();
			if (rs.next()) {
				memberbetdataCount = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return memberbetdataCount;
	}
}
