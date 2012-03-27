package kr.or.kosta.betting.memberbetdata;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import kr.or.kosta.betting.betting.Betting;
import kr.or.kosta.betting.util.ConnectionUtil;


public class MemberBatDataDAO {

	public ArrayList<MemberBatData> selectMemberBatDataList(int page, int length) {

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
			sql = "SELECT  m.sele_team_num, m.bet_mineral, m.id, m.persinal_betting_num, m.selecting_time"
					+ "              b.bet_num"
					+ "  FROM  b.betting, m.member_betting_data"
					+ " WHERE b.bet_num=m.bet_num";

			psmt = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			rs = psmt.executeQuery();
			if (page > 1) {
				rs.absolute((page - 1) * length);
			}
			int getRecordCount = 0;
			
			while (rs.next() && getRecordCount < length) {
				getRecordCount++;
				
				String seleTeamNum = rs.getString(1);
				long betMineral = rs.getLong(2);
				String betNum = rs.getString(3);
				String ID = rs.getString(4);
				String personalBettingNum = rs.getString(5);
				Date selectingTime = rs.getDate(6);

				MemberBatData mbd = new MemberBatData();
				mbd.setSeleTeamNum(seleTeamNum);
				mbd.setBetMineral(betMineral);
				mbd.setID(ID);
				mbd.setNum(personalBettingNum);
				mbd.setSeleTime(selectingTime);

				Betting betting = new Betting();
				betting.setNum(betNum);
				
				mbd.setBetting(betting);

				mbdList.add(mbd);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mbdList;
	}

	public ArrayList<MemberBatData> selectMemberBatDataListByID(int length,int page,String ID) {

		/**
		 * 선택된 아이디의 맴버데이터 조회 메서드
		 * 
		 * @param ID
		 */
		
		Connection con=null;
		PreparedStatement psmt=null;
		String sql=null;
		ResultSet rs=null;
		MemberBatData mbd=null;
		ArrayList<MemberBatData> mbdList = new ArrayList<MemberBatData>();
		try {
			con=ConnectionUtil.getConnection();
			sql = "SELECT  m.sele_team_num, m.bet_mineral, m.id, m.persinal_betting_num, m.selecting_time"
					+ "              b.bet_num"
					+ "  FROM  b.betting, m.member_betting_data"
					+ " WHERE b.bet_num=m.bet_num AND m.id=?";
			
			psmt=con.prepareStatement(sql,
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
				psmt.setString(1,ID);
				rs=psmt.executeQuery();
				
				if(page>1){
					rs.absolute((page-1)*length);
				}
				
				int getRecordCount=0;
				while(rs.next()&&getRecordCount<length){
					getRecordCount++;
					
					String seleTeamNum = rs.getString(1);
					long betMineral = rs.getLong(2);
					String betNum = rs.getString(3);
					String personalBettingNum = rs.getString(4);
					Date selectingTime = rs.getDate(5);
					
			        mbd = new MemberBatData();
					mbd.setSeleTeamNum(seleTeamNum);
					mbd.setBetMineral(betMineral);
					mbd.setID(ID);
					mbd.setNum(personalBettingNum);
					mbd.setSeleTime(selectingTime);
					
					Betting betting = new Betting();
					betting.setNum(betNum);
					
					mbd.setBetting(betting);
				
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mbdList;
	}

	public void insultMemberBatData(MemberBatData mbd) {

		/**
		 * 멤버데이터 삽이 메서드
		 * 
		 * @param memberBatData
		 */
		
		Connection con=null;
		PreparedStatement psmt=null;
		con=ConnectionUtil.getConnection();
		
		try{	
			psmt=con.prepareStatement(
					"INSERT INTO member_batting_data" +
					"(sele_team_num, bet_num, bet_mineral, id, persinal_betting_num, selecting_time)"+
					" VALUES (s_bettingdata.nextval,?,?,?,?,?)");
			psmt.setString(1,mbd.getBetNum());
			psmt.setLong(2,mbd.getBetMineral());
			psmt.setString(3,mbd.getID());
			psmt.setString(4,mbd.getNum());
			psmt.setString(5,mbd.getSeleTime().toString());
			psmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public void deleteMemberbatData(String num) {
		
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
					"DELETE FROM member_batting_data " +
					"WHERE num=?");
			
		psmt.setString(1,num);
			
			psmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}

	}

	public static int selectMemberBatDataByIDCount(String ID){
		Connection con = null;
		PreparedStatement psmt = null;
		String sql = null;
		ResultSet rs =null;
		int BatCount=0;
	
		try {
			con=ConnectionUtil.getConnection();
			sql="SELECT count(m.match_num)"+
					" FROM match m,team t,loc l"+
					" WHERE m.home_team=t.num AND m.away_team_num=t.num" +
					"	AND m.win_team_num=t.num AND m.loc_num=l.loc_num" +
					" AND match_time=?";
			sql = "SELECT  count(persinal_betting_num)"
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
}
