package kr.or.kosta.moviesystem.reservation;

import java.sql.Date;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;




import kr.or.kosta.moviesystem.member.Member;
import kr.or.kosta.moviesystem.movie.Movie;
import kr.or.kosta.moviesystem.screentime.ScreenTime;
import kr.or.kosta.moviesystem.util.ConnectionUtil;



public class ReservationDAO {

	/**
	 * 영화를 선택해 예약목록에 등록하는 기능
	 
	 */
	public static void insertReservation(Reservation reservation) {
		Connection con=null;
		PreparedStatement psmt=null;
		
		try{
			con=ConnectionUtil.getConnection();
			psmt=con.prepareStatement(
					"INSERT INTO RESERVATION" +
					"(RES_NUM, M_NUM,USERID, RES_DATE, SCR_NUM, RES_QTY, TOTAL_PRICE, PAY_STATE,SEAT_NUM)"+
					"VALUES(res_seq.nextval,?,?,sysdate,?,?,?,?,?)");
			psmt.setString(1,reservation.getMovie().getMnum());
			psmt.setString(2,reservation.getMember().getUserid());
		    psmt.setString(3,reservation.getScreenTime().getScrnum());
			psmt.setLong(4,reservation.getResQty());
			psmt.setLong(5,reservation.getTotalPrice());
			psmt.setLong(6, 0);
			psmt.setLong(7,reservation.getSeatnum());
			psmt.executeUpdate();
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	
	
	
	public static ArrayList<Reservation> selectReservationList(int length,int page,String memberid){//반환값을 ArrayList로 한다.
		Connection con =null;
		PreparedStatement psmt=null;
		String sql=null;//쿼리문 저장할 곳
		ResultSet rs=null;//커리문의 주소를 받아온다.(rs.next()는 쿼리문이있으면 true 없으면 flase
		Reservation reservation=null;
		ArrayList<Reservation>reservationList=new ArrayList<Reservation>();
		try{
			con=ConnectionUtil.getConnection();
			sql="SELECT   m.m_name,s.time,r.seatnum,r.res_date" +
					
					"  FROM  RESERVATION r ,MEMBER mem"+
					"                   MOVIE m,SCREENING_TIME s " +
					"  WHERE  m.userid=r.userid AND  r.scr_num=s.scr_num" +
					"                      AND r.m_num=m.m_num " +
					"                      AND  m.userid=?" +
					"    ORDER BY res_date  DESC";
			//rs.absolute()가  가능하도록 설정
			psmt=con.prepareStatement(sql,
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			psmt.setString(1,"%"+memberid+"%");
			rs=psmt.executeQuery();//쿼리 결과를 rs에 저장
			if(page>1){
				rs.absolute((page-1)*length);
			}
			//가져온 레코드 개수
			int getRecordCount=0;
			while(rs.next()){
				String m_name=rs.getString(1);
				String time=rs.getString(2);
				long seatnum=rs.getShort(3);					
				Date resDate=rs.getDate(4);
								
				reservation=new Reservation();
				
				Movie movie=new Movie();
				ScreenTime screentime=new ScreenTime();
				
				
				movie.setMname(m_name);
				reservation.setMovie(movie);
				screentime.setTime(time);
				reservation.setScreenTime(screentime);
				reservation.setSeatnum(seatnum);
				reservation.setResDate(resDate);
				
			
				reservationList.add(reservation);
			}//end while
		}catch(SQLException e){
			e.printStackTrace();
		}
		return reservationList;
	}
	/**
	 * 회원아이디로 예매내역을 찾을 수 있는 메서드

	 */
	public static ArrayList<Reservation> selectReservationList(String memberid) {
		Connection con=null;
		PreparedStatement psmt=null;
		String sql=null;
		ResultSet rs=null;
		Reservation reservation=null;
		ArrayList<Reservation>reservationList=new ArrayList<Reservation>();
		try {
			con=ConnectionUtil.getConnection();
			sql="SELECT   m.m_name,s.time,r.seat_num,r.res_date" +
					
					"  FROM  RESERVATION r ,MEMBER mem,"+
					"                   MOVIE m,SCREENING_TIME s " +
					"  WHERE  mem.userid=r.userid AND  r.scr_num=s.scr_num" +
					"                      AND r.m_num=m.m_num " +
					"                      AND  r.userid=?" +
					"    ORDER BY r.res_date  DESC";
			
			
				psmt=con.prepareStatement(sql);
				psmt.setString(1,memberid);
				rs=psmt.executeQuery();
				while(rs.next()){
					String m_name=rs.getString(1);
					String time=rs.getString(2);
					long seatnum=rs.getShort(3);					
					Date resDate=rs.getDate(4);
									
					reservation=new Reservation();
					
					Movie movie=new Movie();
					ScreenTime screentime=new ScreenTime();
					
					
					movie.setMname(m_name);
					reservation.setMovie(movie);
					screentime.setTime(time);
					reservation.setScreenTime(screentime);
					reservation.setSeatnum(seatnum);
					reservation.setResDate(resDate);
					
				
					reservationList.add(reservation);
				}//end while
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reservationList;
	}

	/**
	 * 회원아이디로 찾은 예매목록의 수를 찾을 수 있는 기능
	 * 
	 */
	public int selectReservationCount(String userid) {
		Connection con =null;
		PreparedStatement psmt=null;
		String sql=null;//쿼리문 저장할 곳
		ResultSet rs=null;//커리문의 주소를 받아온다.(rs.next()는 쿼리문이있으면 true 없으면 flase
		int reservationCount=0;
		try{
			con=ConnectionUtil.getConnection();
			sql="SELECT count(userid)"+
			       " From reservation"+
				   " WHERE userid=?";
			//rs.absolute()가  가능하도록 설정
			psmt=con.prepareStatement(sql);
			psmt.setString(1,userid);
			rs=psmt.executeQuery();//쿼리 결과를 rs에 저장
			
			
			if(rs.next()){
				reservationCount=rs.getInt(1);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return reservationCount;
		
	}

	/**
	 * 영화번호와 상영시간으로 예약한 수를 확인할 수 있는 기능
	 * 
	 * @param scrnum
	 * @param mnum
	 */
	public int selectReservationSeatCount(Number scrnum, Number mnum) {
		/* default generated stub */;
		return 0;
	}

	/**
	 * 예약번호와 회원번호로 예약된 정보를 찾을 수 있는 기능
	 * 
	 * @param userid
	 * @param resnum
	 */
	public Reservation selectReservation(String userid, int resnum) {
		/* default generated stub */;
		return null;
	}

	/**
	 * 
	 * 
	 * 예매목록 취소 기능
	 * 
	 * @param userid
	 * @param resnum
	 */
	public static void removeReservation(Reservation reservation) {
		 Connection con=null;
		  PreparedStatement psmt=null;
		  
		  con=ConnectionUtil.getConnection();
		  
		  try {
			psmt=con.prepareStatement
					  ("UPDATE RESERVATION SET pay_state=? WHERE res_num=?");
			
			   psmt.setLong(1,reservation.getPayState());
			   psmt.setString(2, reservation.getResnum());
			   
			   psmt.executeUpdate();
			   
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	
	}
		

	/**
	 * 예매목록 업데이트(수정) 기능

	 */
	public static void updateReservation(Reservation reservation) {
		/* default generated stub */;
		 Connection con=null;
		  PreparedStatement psmt=null;
		  
		  con=ConnectionUtil.getConnection();
		  
		  try {
			psmt=con.prepareStatement
					  ("UPDATE RESERVATION SET m_num=?,scr_num=? WHERE res_num=?");
			
			   psmt.setString(1,reservation.getMovie().getMnum());
			   psmt.setString(2,reservation.getScreenTime().getScrnum());
			   psmt.setString(3, reservation.getResnum());
			   
			   psmt.executeUpdate();
			   
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	
	}
}
