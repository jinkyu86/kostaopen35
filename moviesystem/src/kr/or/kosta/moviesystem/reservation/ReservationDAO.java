package kr.or.kosta.moviesystem.reservation;

import java.io.IOException;
import java.io.Reader;
import java.sql.Date;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;




import kr.or.kosta.moviesystem.member.Member;
import kr.or.kosta.moviesystem.movie.Movie;
import kr.or.kosta.moviesystem.screentime.ScreenTime;
import kr.or.kosta.moviesystem.util.ConnectionUtil;


public class ReservationDAO {

	
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
	
	/**
	 * 영화를 선택해 예약목록에 등록하는 기능
	 
	 */
	public static void insertReservation(Reservation reservation) {
		
		SqlSession session= null;
		try{
			session = sqlMapper.openSession(true);
			System.out.println("1 reservation = "+reservation);
			session.insert("Reservation.insertReservation",reservation);	
		}
		finally{
			//Connection을 ConnectionPool에 반납해야지 안끊긴다. 
			//그리고 이건 무조건 반납해야지 멈추지 않으니 finally에 써주어야한다.
			session.close();
		}
		
		
	}
	
	
	

	
	/**
	 * 영화를 선택해 예약목록에 등록하는 기능
	 
	 */
//	public static void insertReservation(Reservation reservation) {
//		Connection con=null;
//		PreparedStatement psmt=null;
//		
//		try{
//			con=ConnectionUtil.getConnection();
//			psmt=con.prepareStatement(
//					"INSERT INTO RESERVATION" +
//					"(RES_NUM, M_NUM,USERID, RES_DATE, SCR_NUM, RES_QTY, TOTAL_PRICE, PAY_STATE,SEAT_NUM)"+
//					"VALUES(res_seq.nextval,?,?,sysdate,?,?,?,?,?)");
//			psmt.setString(1,reservation.getMovie().getMnum());
//			psmt.setString(2,reservation.getMember().getUserid());
//		    psmt.setString(3,reservation.getScreenTime().getScrnum());
//			psmt.setLong(4,reservation.getResQty());
//			psmt.setLong(5,reservation.getTotalPrice());
//			psmt.setString(6, "결제대기");
//			psmt.setLong(7,reservation.getSeatnum());
//			psmt.executeUpdate();
//			
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//	}

	/**
	 * group by 영화이름
	 * where = userid=?
	 * 출력=영화이름
	 
	 */
	
	public static List<Reservation> selectReservationList(int length,int page,String memberid){//반환값을 ArrayList로 한다.
		SqlSession session=null;
		List<Reservation> reservationList=null;
		try{
			session = sqlMapper.openSession(true);
			RowBounds rowBounds=new RowBounds((page-1)*length,length);
			reservationList=
					session.selectList("Reservation.selectReservationListByUserId",memberid,rowBounds);
			
		}
		
		finally{
			//Connection을 ConnectionPool에 반납해야지 안끊긴다. 
			//그리고 이건 무조건 반납해야지 멈추지 않으니 finally에 써주어야한다.
			session.close();
		}
		return reservationList;
	}
	
	/**
	 * userid와 mnom으로 group by time 으로 된 정보의 time sum(total_price) count(res_qty)

	 */
	
	public static List<Reservation> selectReservationTime(String userid, String mnum) {
		SqlSession session = null;
		List<Reservation>reservationList=null;
		try{
			session= sqlMapper.openSession(true);
			HashMap<String,String> parameter=new HashMap<String,String>();
			parameter.put("userid",userid);
			parameter.put("mnum",mnum);
			reservationList=session.selectList("Reservation.selectReservationTime",parameter);
			
		}finally{
			session.close();
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
		SqlSession session=null;
		Integer count=null;
		try{
			session = sqlMapper.openSession(true);
			count=
				session.selectOne("Reservation.selectReservationListByUserIdCount",userid);

		}
		
		finally{
			//Connection을 ConnectionPool에 반납해야지 안끊긴다. 
			//그리고 이건 무조건 반납해야지 멈추지 않으니 finally에 써주어야한다.
			session.close();
		}
		return count;
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
					  ("UPDATE RESERVATION SET pay_state=?,seat_num=0,total_price=0,res_qty=0 WHERE res_num=?");
			   
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
	public static List<Reservation> selectSeatNumByScrnumAndUserid(String scrnum,String userid) {
		SqlSession session = null;
		List<Reservation>reservationList=null;
		try{
			session= sqlMapper.openSession(true);
			HashMap<String,String> parameter=new HashMap<String,String>();
			parameter.put("scrnum",scrnum);
			parameter.put("userid",userid);
			reservationList=session.selectList("Reservation.selectSeatNumByScrnumAndUserid",parameter);
			
		}finally{
			session.close();
		}
		return reservationList;
	}
	
	/**
	 * SCR_NUM으로 예약한 좌석 번호를 찾기
	 * 		SqlSession session=null;
		List<Student> studentList=null;
		try{
			session = sqlMapper.openSession(true);
			studentList=
				session.selectList("Student.selectStudentList");
		

		}
		
		finally{
			//Connection을 ConnectionPool에 반납해야지 안끊긴다. 
			//그리고 이건 무조건 반납해야지 멈추지 않으니 finally에 써주어야한다.
			session.close();
		}
		return studentList;
	 */
	public static List selectSeatNumByScrnum(String scrnum) {
		System.out.println("selectSeatNumByScrnum:scrnum="+scrnum);
		SqlSession session=null;
		List<Reservation> reservationList=null;
		try{
			session = sqlMapper.openSession(true);
			reservationList=
				session.selectList("Reservation.selectSeatNumByScrnum",scrnum);
		

		}
		
		finally{
			//Connection을 ConnectionPool에 반납해야지 안끊긴다. 
			//그리고 이건 무조건 반납해야지 멈추지 않으니 finally에 써주어야한다.
			session.close();
		}
		return reservationList;
	}
	/**
	 *Total seatList
	 * 
	 */
	public static List selectTotalList(String scrnum) {
		List<Reservation>SelectSeatList=null;
		System.out.println("scrnum="+scrnum);
		SelectSeatList=ReservationDAO.selectSeatNumByScrnum(scrnum);
		
		ArrayList<Integer>TotalSeatList=new ArrayList<Integer>();
		System.out.println("SelectSeatList="+SelectSeatList);
		int num;
		
		for(int i=0;i<40;i++){
			TotalSeatList.add(0);
		}
		
		
		
		for(int i=0;i<SelectSeatList.size();i++){
			
			num=(int) SelectSeatList.get(i).getSeatnum();
			if(num!=0){
				TotalSeatList.set(num-1, 1);
			}
		
		}
		
		
		return TotalSeatList;
	}




	
	
}
