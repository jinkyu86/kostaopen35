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
	public static void insertReservation(Member member,Reservation reservation,ArrayList<Integer> SeatNumList) {
		Connection con=null;
		PreparedStatement psmt=null;
		
		
		for(int i=0;i<SeatNumList.size();i++){
			try{
				con=ConnectionUtil.getConnection();
				psmt=con.prepareStatement(
						"INSERT INTO RESERVATION" +
						"(RES_NUM, M_NUM,USERID, RES_DATE, SCR_NUM, RES_QTY, TOTAL_PRICE, PAY_STATE,SEAT_NUM)"+
						"VALUES(res_seq.nextval,?,?,sysdate,?,?,?,?,?)");
				psmt.setString(1,reservation.getMovie().getMnum());
				psmt.setString(2,member.getUserid());
			    psmt.setString(3,reservation.getScreenTime().getScrnum());
				psmt.setLong(4,reservation.getResQty());
				psmt.setLong(5,reservation.getTotalPrice());
				psmt.setString(6, "결제완료");
				psmt.setLong(7,SeatNumList.get(i));
				psmt.executeUpdate();
				
			}catch(Exception e){
				e.printStackTrace();
			}
		}

		
		
		
	}
	
	
	
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
			psmt.setString(6, "결제대기");
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
			sql="SELECT   m.m_name,s.time,r.seat_num,r.res_date,r.res_qty,r.pay_state,r.res_num" +
					
					"  FROM  RESERVATION r ,MEMBER mem,"+
					"                   MOVIE m,SCREENING_TIME s " +
					"  WHERE  mem.userid=r.userid AND  r.scr_num=s.scr_num" +
					"                      AND r.m_num=m.m_num " +
					"                      AND  r.userid=?" +
					"    ORDER BY r.res_date  DESC";
			//rs.absolute()가  가능하도록 설정
			psmt=con.prepareStatement(sql,
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			psmt.setString(1,memberid);
			rs=psmt.executeQuery();//쿼리 결과를 rs에 저장
			System.out.println("page="+page+"length"+length);
			if(page>1){
				rs.absolute((page-1)*length);
			}
			//가져온 레코드 개수
			int getRecordCount=0;
			while(rs.next()&&getRecordCount<length){
				getRecordCount++;
				String m_name=rs.getString(1);
				String time=rs.getString(2);
				long seatnum=rs.getShort(3);					
				Date resDate=rs.getDate(4);
				long resQty=rs.getLong(5);
				String payState=rs.getString(6);
				String resnum=rs.getString(7);
				
				
				reservation=new Reservation();
				
				Movie movie=new Movie();
				ScreenTime screentime=new ScreenTime();
				
				
				movie.setMname(m_name);
				reservation.setMovie(movie);
				screentime.setTime(time);
				reservation.setScreenTime(screentime);
				reservation.setSeatnum(seatnum);
				reservation.setResDate(resDate);
				reservation.setResQty(resQty);
				reservation.setPayState(payState);
				reservation.setResnum(resnum);
				
			
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
			sql="SELECT   m.m_name,s.time,r.seat_num,r.res_date,r.res_qty" +
					
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
					long resQty=rs.getLong(5);
					
					
					reservation=new Reservation();
					
					Movie movie=new Movie();
					ScreenTime screentime=new ScreenTime();
					
					
					movie.setMname(m_name);
					reservation.setMovie(movie);
					screentime.setTime(time);
					reservation.setScreenTime(screentime);
					reservation.setSeatnum(seatnum);
					reservation.setResDate(resDate);
					reservation.setResQty(resQty);
					
				
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
	public static int selectReservationCount(String userid) {
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
			
			System.out.println("userid= "+userid);
			if(rs.next()){
				reservationCount=rs.getInt(1);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return reservationCount;
		
	}

	/**
	 * 예매번호로 예약한 첫번째 좌석번호를 확인 할 수 있는 기능
	 * 
	 * 
	 */
	public static long selectReservationSeatNum(long Res_num) {
		Connection con =null;
		PreparedStatement psmt=null;
		String sql=null;//쿼리문 저장할 곳
		ResultSet rs=null;//커리문의 주소를 받아온다.(rs.next()는 쿼리문이있으면 true 없으면 flase
		long seatnum=0;
		try{
			con=ConnectionUtil.getConnection();
			sql="SELECT seat_num"+
			       " From reservation"+
				   " WHERE res_num=?";
			//rs.absolute()가  가능하도록 설정
			psmt=con.prepareStatement(sql);
			psmt.setLong(1,Res_num);
			rs=psmt.executeQuery();//쿼리 결과를 rs에 저장
			if(rs.next()){
			String seat_num=rs.getString(1);
			seatnum=Integer.parseInt(seat_num);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return seatnum;
	}
	
	
	/**
	 * 예매번호로 예약한 수를 확인할 수 있는 기능
	 * 
	 * 
	 */
	public static long selectReservationQty(long res_num) {
		Connection con =null;
		PreparedStatement psmt=null;
		String sql=null;//쿼리문 저장할 곳
		ResultSet rs=null;//커리문의 주소를 받아온다.(rs.next()는 쿼리문이있으면 true 없으면 flase
		long Qty=0;
		try{
			con=ConnectionUtil.getConnection();
			sql="SELECT res_qty"+
			       " From reservation"+
				   " WHERE res_num=?";
			//rs.absolute()가  가능하도록 설정
			psmt=con.prepareStatement(sql);
			psmt.setLong(1,res_num);
			rs=psmt.executeQuery();//쿼리 결과를 rs에 저장
			if(rs.next()){
			String qty=rs.getString(1);
			Qty=Integer.parseInt(qty);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return Qty;
	}
	
	
	/**
	 * SCR_NUM 넘버가 같은 사람중 RES_NUM이 가장 큰사람의 RES_NUM
	 * 
	 * 
	 */
	public static String selectReservationResNum(String scr_num) {
		Connection con =null;
		PreparedStatement psmt=null;
		String sql=null;//쿼리문 저장할 곳
		ResultSet rs=null;//커리문의 주소를 받아온다.(rs.next()는 쿼리문이있으면 true 없으면 flase
		String resnum=null;
		try{
			con=ConnectionUtil.getConnection();
			sql="SELECT max(res_num)"+
			       " From reservation"+
				   " WHERE scr_num=?";
			//rs.absolute()가  가능하도록 설정
			psmt=con.prepareStatement(sql);
			psmt.setString(1,scr_num);
			rs=psmt.executeQuery();//쿼리 결과를 rs에 저장
			if(rs.next()){
			 resnum=rs.getString(1);
			 System.out.println("scr_num= "+scr_num);
			 
			 System.out.println("resnum= "+resnum);
			 
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return resnum;
	}
	
	
	/**
	 * 예약번호와 회원번호로 예약된 정보를 찾을 수 있는 기능
	 * 
	 * @param userid
	 * @param resnum
	 */
	public static Reservation selectReservation(String resnum) {
		Connection con =null;
		PreparedStatement psmt=null;
		String sql=null;//쿼리문 저장할 곳
		ResultSet rs=null;//커리문의 주소를 받아온다.(rs.next()는 쿼리문이있으면 true 없으면 flase
		Reservation reservation=new Reservation();
		try{
			con=ConnectionUtil.getConnection();
			sql="SELECT   m.m_name,s.time,r.seat_num,r.res_qty,r.total_price" +
					
					"  FROM  RESERVATION r ,"+
					"                   MOVIE m,SCREENING_TIME s " +
					"  WHERE  r.scr_num=s.scr_num" +
					"                      AND r.m_num=m.m_num " +
					"                      AND  r.res_num=?" +
					"    ORDER BY r.res_date  DESC";
			//rs.absolute()가  가능하도록 설정
			psmt=con.prepareStatement(sql);
			psmt.setString(1,resnum);
			rs=psmt.executeQuery();//쿼리 결과를 rs에 저장
			if(rs.next()){
			String mname=rs.getString(1);
			String time=rs.getString(2);
			long seatnum=rs.getLong(3);
			long resqty=rs.getLong(4);
			long totalPrice=rs.getLong(5);
			
			
			
			Movie movie=new Movie();
			ScreenTime screenTime=new ScreenTime();
			
			
			movie.setMname(mname);
			reservation.setMovie(movie);
			screenTime.setTime(time);
			reservation.setScreenTime(screenTime);
			reservation.setSeatnum(seatnum);
			reservation.setResQty(resqty);
			reservation.setTotalPrice(totalPrice);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return reservation;
	}

	/**
	 * 
	 * 
	 * 예매목록 취소 기능
	 * 
	 * @param userid
	 * @param resnum
	 */
	public static void removeReservation(String resnum) {
		 Connection con=null;
		  PreparedStatement psmt=null;
		  
		  con=ConnectionUtil.getConnection();
		  
		  try {
			psmt=con.prepareStatement
					  ("UPDATE RESERVATION SET pay_state=? WHERE res_num=?");
			
			   psmt.setString(1,"결제완료");
			   psmt.setString(2, resnum);
			   
			   psmt.executeUpdate();
			   
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	
	}
		
	public static void cancelReservation(String resnum) {
		 Connection con=null;
		  PreparedStatement psmt=null;
		  
		  con=ConnectionUtil.getConnection();
		  
		  try {
			psmt=con.prepareStatement
					  ("UPDATE RESERVATION SET pay_state=? WHERE res_num=?");
			
			   psmt.setString(1,"결제취소");
			   psmt.setString(2, resnum);
			   
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
	
	
	
	
	/**
	 * SCR_NUM으로 예약한 좌석 번호를 찾기
	 * 
	 */
	public static ArrayList selectSeatNumByScrnum(String scrnum) {
		Connection con=null;
		PreparedStatement psmt=null;
		String sql=null;
		ResultSet rs=null;
		ArrayList<Integer>SeatList=new ArrayList<Integer>();
		try {
			con=ConnectionUtil.getConnection();
			sql="	SELECT seat_num " +
					"  FROM  reservation " +
					"  WHERE  scr_num=? " ;
		
			
				psmt=con.prepareStatement(sql);
				psmt.setString(1,scrnum);
				rs=psmt.executeQuery();
				while(rs.next()){
					int seatnum=rs.getInt(1);
								
		
					SeatList.add(seatnum);
					System.out.println("seatnum = "+seatnum);
				}//end while
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return SeatList;
	}
	/**
	 *Total seatList
	 * 
	 */
	public static ArrayList selectTotalList(String scrnum) {
		ArrayList<Integer>SelectSeatList=new ArrayList<Integer>();
		SelectSeatList=ReservationDAO.selectSeatNumByScrnum(scrnum);
		ArrayList<Integer>TotalSeatList=new ArrayList<Integer>();
		int num;
		for(int i=0;i<40;i++){
			TotalSeatList.add(0);
		}
		
		for(int i=0;i<SelectSeatList.size();i++){
			num=SelectSeatList.get(i);
			TotalSeatList.set(num-1, 1);
		}
		
		
		return TotalSeatList;
	}
	
	
}
