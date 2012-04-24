package kr.or.kosta.betting.betting;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class BettingDAO implements IBetting{
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

	@Override
	public List<Betting> selectBettingList(int page, int length) {
	 
		/**
		 * 베팅 데이터의 모든 데이터 조회 하는 메서드
		 * 
		 * @param page
		 * @param length
		 */
		SqlSession session = null;
		List<Betting> bettingList= null;
		try{
		session = sqlMapper.openSession(true);
		RowBounds rowBounds = new RowBounds((page-1)*length,length);
		bettingList = 
				session.selectList("selectBettingList",null,rowBounds);
		
		}
		finally{
			session.close();
		}
		return bettingList;
//		Connection con = null;
//		PreparedStatement psmt = null;
//		String sql = null;
//		ResultSet rs = null;
//		ArrayList<Betting> bettingList = new ArrayList<Betting>();
//		try {
//			con = ConnectionUtil.getConnection();
//			sql = "SELECT m.match_num,m.match_result_score"+
//					",m.home_team_num,h.team_name,h.photo"+
//					",m.away_team_num,a.team_name,a.photo"+
//					",m.win_team_num,w.team_name,w.photo"+
//					",m.loc_num,l.loc"+
//					",b.bet_num, b.bet_rating, b.sele_rating, b.tot_mineral"+
//			        ",b.distinguish_team,m.match_time"+
//					" FROM betting b,match m,team h,team a,team w,loc l"+
//					 " WHERE m.home_team_num=h.team_num"+
//					 " AND m.away_team_num=a.team_num"+
//					 " AND m.win_team_num=w.team_num(+)"+
//					 " AND m.loc_num=l.loc_num"+
//					 " AND m.match_num=b.match_num" +
//					 " ORDER BY m.match_num DESC, b.bet_num";
//			
//			psmt = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE,
//					ResultSet.CONCUR_READ_ONLY);
//			rs = psmt.executeQuery();
//			
//			if (page > 1) {
//				rs.absolute((page - 1) * length);
//			}
//			int getRecordCount = 0;
//			while(rs.next()&&getRecordCount<length){
//			    getRecordCount++;
//				
//			    String matchNum=rs.getString(1);
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
//				String locNum=rs.getString(12);
//				String loc1 = rs.getString(13);
//			    String batNum = rs.getString(14);
//				double batRating = rs.getDouble(15);
//				long seleRating = rs.getLong(16);
//				long totMineral = rs.getLong(17);
//				String distinguishTeam = rs.getString(18);
//				String matchTime = rs.getString(19);
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
//				betting.setMatch(match);
//				match.setLoc(loc);
//				
//				bettingList.add(betting);
//
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return bettingList;
	}

	@Override
	public Betting selectBettingByHome(String matchNum) {
		
		/**
		 * 매치번호로 홈경기만 조회하는 메서드
		 * 
		 * @param Date
		 */
		SqlSession session = null;
		Betting betting= null;
		try{
		session = sqlMapper.openSession(true);
		betting = session.selectOne("selectBettingByHome",matchNum);
		
		}
		finally{
			session.close();
		}
		return betting;
//		Connection con = null;
//		PreparedStatement psmt = null;
//		String sql = null;
//		ResultSet rs = null;
//		Betting betting = null;
//		try {
//			
//			con = ConnectionUtil.getConnection();
//			sql = "SELECT m.match_num,m.match_result_score"+
//					",m.home_team_num,h.team_name,h.photo"+
//					",m.away_team_num,a.team_name,a.photo"+
//					",m.win_team_num,w.team_name,w.photo"+
//					",m.loc_num,l.loc"+
//					",b.bet_num, b.bet_rating, b.sele_rating, b.tot_mineral"+
//			        ",b.distinguish_team" +
//			        ",TO_CHAR(match_time,'yyyy/mm/dd hh24:mi:ss')"+
//					" FROM betting b,match m,team h,team a,team w,loc l"+
//					 " WHERE m.home_team_num=h.team_num"+
//					 " AND m.away_team_num=a.team_num"+
//					 " AND m.win_team_num=w.team_num(+)"+
//					 " AND m.loc_num=l.loc_num"+
//					 " AND m.match_num=b.match_num"+
//					 " AND m.match_num= ?" +
//					 " AND b.distinguish_team=? ";
//			
//			psmt = con.prepareStatement(sql);
//			
//			psmt.setString(1, num);
//			psmt.setString(2, "1");
//			rs = psmt.executeQuery();
//			
//			if(rs.next()){
//			   	
//				String matchNum=rs.getString(1);
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
//				String locNum=rs.getString(12);
//				String loc1 = rs.getString(13);
//			    String batNum = rs.getString(14);
//				double batRating = rs.getDouble(15);
//				long seleRating = rs.getLong(16);
//				long totMineral = rs.getLong(17);
//				String distinguishTeam = rs.getString(18);
//				String matchTime = rs.getString(19);
//				
//				betting = new Betting();
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
//				match.setWinTeam(winTeam);
//				betting.setMatch(match);
//				match.setLoc(loc);
//	
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return betting;
	}
	@Override
	public Betting selectBettingByAway(String matchNum) {
		
		/**
		 * 매치넘버를 통해 어웨이경기 데이터만 조회하는 메서드
		 * 
		 * @param Date
		 */
		SqlSession session = null;
		Betting betting= null;
		try{
		session = sqlMapper.openSession(true);
		betting = session.selectOne("selectBettingByAway",matchNum);
		
		}
		finally{
			session.close();
		}
		return betting;
//		Connection con = null;
//		PreparedStatement psmt = null;
//		String sql = null;
//		ResultSet rs = null;
//		Betting betting =null;
//		try {
//			
//			con = ConnectionUtil.getConnection();
//			sql = "SELECT m.match_num,m.match_result_score"+
//					",m.home_team_num,h.team_name,h.photo"+
//					",m.away_team_num,a.team_name,a.photo"+
//					",m.win_team_num,w.team_name,w.photo"+
//					",m.loc_num,l.loc"+
//					",b.bet_num, b.bet_rating, b.sele_rating, b.tot_mineral"+
//			        ",b.distinguish_team" +
//			        ",TO_CHAR(match_time,'yyyy/mm/dd hh24:mi:ss')"+
//					" FROM betting b,match m,team h,team a,team w,loc l"+
//					 " WHERE m.home_team_num=h.team_num"+
//					 " AND m.away_team_num=a.team_num"+
//					 " AND m.win_team_num=w.team_num(+)"+
//					 " AND m.loc_num=l.loc_num"+
//					 " AND m.match_num=b.match_num"+
//					 " AND m.match_num= ?" +
//					 " AND b.distinguish_team=?";
//			
//			psmt = con.prepareStatement(sql);
//			
//			psmt.setString(1, num);
//			psmt.setString(2, "2");
//			rs = psmt.executeQuery();
//			
//			if(rs.next()){
//			   	
//				String matchNum=rs.getString(1);
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
//				String locNum=rs.getString(12);
//				String loc1 = rs.getString(13);
//			    String batNum = rs.getString(14);
//				double batRating = rs.getDouble(15);
//				long seleRating = rs.getLong(16);
//				long totMineral = rs.getLong(17);
//				String distinguishTeam = rs.getString(18);
//				String matchTime = rs.getString(19);
//				
//				betting = new Betting();
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
//				match.setAwayTeam(awayTeam);
//				match.setWinTeam(winTeam);
//				betting.setMatch(match);
//				match.setLoc(loc);
//				
//				
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return betting;
	}
	@Override
	public void updateBetting(Betting betting){

		/**
		 * 베팅번호로 선택된 데이터의 업데이트
		 * 
		 * @param num
		 * @param batRating
		 * @param seleRating
		 * @param totMineral
		 */
		SqlSession session = null; 
		try{
		session = sqlMapper.openSession(true);
		session.update("Betting.updateBetting",betting);
		}
		finally{
			session.close();
		}
//		Connection con = null;
//		PreparedStatement psmt = null;
//		con = ConnectionUtil.getConnection();
//		try {
//			psmt = con.prepareStatement(
//					"UPDATE betting SET bet_rating=?,sele_rating=?"+
//			         ",tot_mineral=? "+
//			        "WHERE bet_num=?");
//
//			psmt.setDouble(1, betting.getBatRating());
//			psmt.setLong(2, betting.getSeleRating());
//			psmt.setLong(3, betting.getTotMineral());
//			psmt.setString(4, betting.getNum());
//			psmt.executeUpdate();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}

		
	}

	/**
	 * 선택된 번호의 베팅률 조회
	 * 
	 * @param num
	 */
	@Override
	public double selectBettingRating(String bettingNum) {
		/* default generated stub */;
		SqlSession session = null;
		double bettingRating= 0;
		try{
		session = sqlMapper.openSession(true);
		bettingRating= session.selectOne("selectBettingRating",bettingNum);
		
		}
		finally{
			session.close();
		}
		return bettingRating;
//		Connection con = null;
//		PreparedStatement ps = null;
//		String sql = null;
//		ResultSet rs =null;
//		sql="SELECT bet_rating"+
//				" FROM betting"+
//				" WHERE bet_num=?";
//		double batRating = 0;
//		con=ConnectionUtil.getConnection();
//		try {
//			ps=con.prepareStatement(sql);
//			ps.setString(1, num);
//			rs=ps.executeQuery();
//			
//			if(rs.next()){
//				batRating=rs.getDouble(1);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return batRating;
//		
	}

	/**
	 * 선택된 번호의 베팅팀의 선택률
	 * 
	 * @param num
	 */
	@Override
	public long selectBettingSeleRating(String bettingNum) {
		/* default generated stub */
		SqlSession session = null;
		long seleRating= 0;
		try{
		session = sqlMapper.openSession(true);
		seleRating= session.selectOne("selectBettingSeleRating",bettingNum);
		
		}
		finally{
			session.close();
		}
		return seleRating;
//		Connection con = null;
//		PreparedStatement ps = null;
//		String sql = null;
//		ResultSet rs =null;
//		sql="SELECT sele_rating"+
//				" FROM betting"+
//				" WHERE bet_num=?";
//		long seleRating = 0;
//		con=ConnectionUtil.getConnection();
//		try {
//			ps=con.prepareStatement(sql);
//			ps.setString(1, num);
//			rs=ps.executeQuery();
//			
//			if(rs.next()){
//				seleRating=rs.getLong(1);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return seleRating;
//		
	}

	/**
	 * 선택된 베팅 번호의 팀의 누적된 베팅 금액을 조회
	 * 
	 * @param num
	 */
	@Override
	public long selectBettingTotMineral(String bettingNum) {
		/* default generated stub */;
		SqlSession session = null;
		long totMineral= 0;
		try{
		session = sqlMapper.openSession(true);
		totMineral= session.selectOne("selectBettingTotMineral",bettingNum);
		
		}
		finally{
			session.close();
		}
		return totMineral;
//		Connection con = null;
//		PreparedStatement ps = null;
//		String sql = null;
//		ResultSet rs =null;
//		sql="SELECT tot_mineral"+
//				" FROM betting"+
//				" WHERE bet_num=?";
//		long totMineral=0;
//		con=ConnectionUtil.getConnection();
//		try {
//			ps=con.prepareStatement(sql);
//			ps.setString(1, num);
//			rs=ps.executeQuery();
//			
//			if(rs.next()){
//				totMineral=rs.getLong(1);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return totMineral;
//		
	}
	//베팅 테이블중 홈팀 컬럼 삽입 메서드
	@Override
	public void insertHomeBetting(String matchNum){
		/* default generated stub */;
		SqlSession session = null;
		try{
		session = sqlMapper.openSession(true);
		session.insert("Betting.insertHomeBetting",matchNum);
		}
		finally{
				session.close();
		}
//		Connection con = null;
//		PreparedStatement ps = null;
//		String sql = null;
//				
//		try {
//		con=ConnectionUtil.getConnection();
//		sql="INSERT INTO betting (bet_num, bet_rating, sele_rating," +
//				" tot_mineral, distinguish_team, match_num) "+
//				 " VALUES(s_home.nextval,1,0,0,1,?)";
//				 			
//			ps=con.prepareStatement(sql);
//			
//			ps.setString(1, num);
//						
//			ps.executeUpdate();
//									
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	}
	
	//베팅 테이블중 어웨이팀 컬럼 삽입 메서드
	@Override
	public void insertAwayBetting(String matchNum){
		/* default generated stub */;
		SqlSession session = null;
		try{
		session = sqlMapper.openSession(true);
		session.insert("Betting.insertAwayBetting",matchNum);
		}
		finally{
				session.close();
		}
//		Connection con = null;
//		PreparedStatement ps = null;
//		String sql = null;
//		
//		try {
//		con=ConnectionUtil.getConnection();
//		sql="INSERT INTO betting (bet_num, bet_rating, sele_rating," +
//				" tot_mineral, distinguish_team, match_num) "+
//				 " VALUES(s_away.nextval,1,0,0,2,?)";
//							
//			ps=con.prepareStatement(sql);
//			
//			ps.setString(1, num);
//				
//			ps.executeUpdate();
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	}
	//베팅리스트 카운터를 위한 메서드
	@Override
	public int selectBettingCount(){
		SqlSession session = null;
		int count=0;
		try{
		session = sqlMapper.openSession(true);
		count = session.selectOne("selectBettingCount");
		
		}
		finally{
			session.close();
		}
		return count;
		
//		Connection con = null;
//		PreparedStatement psmt = null;
//		String sql = null;
//		ResultSet rs =null;
//		int bettingCount=0;
//				
//		try {
//		con=ConnectionUtil.getConnection();
//		sql = "SELECT COUNT(b.bet_num)"+
//				" FROM betting b,match m,team h,team a,team w,loc l"+
//				 " WHERE m.home_team_num=h.team_num"+
//				 " AND m.away_team_num=a.team_num"+
//				 " AND m.win_team_num=w.team_num(+)"+
//				 " AND m.loc_num=l.loc_num"+
//				 " AND m.match_num=b.match_num";
//			
//			psmt=con.prepareStatement(sql);
//			rs=psmt.executeQuery();
//			if(rs.next()){
//				bettingCount=rs.getInt(1);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return bettingCount;
	}
	
}


