package kr.or.kosta.moviesystem.screentime;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import kr.or.kosta.moviesystem.movie.Movie;
import kr.or.kosta.moviesystem.reservation.Reservation;
import kr.or.kosta.moviesystem.util.ConnectionUtil;

public class ScreenTimeDAO {

	/**
	 * 상영시간 등록 기능
	 * 
	 * @param time
	 */
	public void insertScreenTime(Date time) {
		/* default generated stub */;
		
	}
	/**
	 * 상영시간으로 scr_num을 알수 있는 기능
	 * 
	 * @param time
	 */
	public static ScreenTime selectScreenTimeScrNum(String time) {
		Connection con=null;
		PreparedStatement psmt=null;
		String sql=null;
		ResultSet rs=null;
		ScreenTime screentime=new ScreenTime();
		ArrayList<ScreenTime>screentimeList=new ArrayList<ScreenTime>();
		System.out.println("time= "+time);
		String timesubstring=time.substring(0,19);
		System.out.println("timesubstring= "+timesubstring);
		
		
		try {
			con=ConnectionUtil.getConnection();
			sql="SELECT scr_num" +
					"  FROM SCREENING_TIME" +
					"  WHERE  time=to_date(?,'yyyy-mm-dd hh24:mi:ss')" ;

				psmt=con.prepareStatement(sql);
				psmt.setString(1,timesubstring);
				rs=psmt.executeQuery();
				if(rs.next()){
					
					String scrnum=rs.getString(1);
					System.out.println("scrnum = "+scrnum);
					screentime.setScrnum(scrnum);
					
				
					System.out.println("screentime = "+screentime);
				}//end while
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return screentime;
	}
	
	
	/**
	 * srcnum으로 상영시간을 찾을 수 있는 기능
	 * 
	 * @param mnum
	 */
	public static ScreenTime selectScreenTimeBySrcNum(String scrnum) {
		Connection con=null;
		PreparedStatement psmt=null;
		String sql=null;
		ResultSet rs=null;
		ScreenTime screentime=null;
		ArrayList<ScreenTime>screentimeList=new ArrayList<ScreenTime>();
		try {
			con=ConnectionUtil.getConnection();
			sql="SELECT m.m_name,s.time,s.scr_num,m.m_num" +
					
					"  FROM  MOVIE m,SCREENING_TIME s " +
					"  WHERE  s.m_num=m.m_num " +
					"                      AND  s.scr_num=?" ;
		
			
				psmt=con.prepareStatement(sql);
				psmt.setString(1,scrnum);
				rs=psmt.executeQuery();
				if(rs.next()){
					String m_name=rs.getString(1);
					String time=rs.getString(2);
					scrnum=rs.getString(3);
					String mnum=rs.getString(4);
								
					Movie movie=new Movie();
					screentime=new ScreenTime();
					
					movie.setMname(m_name);
					movie.setMnum(mnum);
					screentime.setMovie(movie);
					screentime.setTime(time);			
					screentime.setScrnum(scrnum);
					
				
					System.out.println("screentime = "+screentime);
				}//end while
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return screentime;
	}
	
	
	
	
	
	/**
	 * 영화이름으로 상영시간을 찾을 수 있는 기능
	 * 
	 * @param mnum
	 */
	public static ArrayList selectScreen(String mnum) {
		Connection con=null;
		PreparedStatement psmt=null;
		String sql=null;
		ResultSet rs=null;
		ScreenTime screentime=null;
		ArrayList<ScreenTime>screentimeList=new ArrayList<ScreenTime>();
		try {
			con=ConnectionUtil.getConnection();
			sql="SELECT m.m_name,s.time,s.scr_num,m.m_num" +
					
					"  FROM  MOVIE m,SCREENING_TIME s " +
					"  WHERE  s.m_num=m.m_num " +
					"                      AND  m.m_num=? AND s.time>sysdate" ;
		
			
				psmt=con.prepareStatement(sql);
				psmt.setString(1,mnum);
				rs=psmt.executeQuery();
				while(rs.next()){
					String m_name=rs.getString(1);
					String time=rs.getString(2);
					String scrnum=rs.getString(3);
					mnum=rs.getString(4);
								
					Movie movie=new Movie();
					screentime=new ScreenTime();
					
					movie.setMname(m_name);
					movie.setMnum(mnum);
					screentime.setMovie(movie);
					screentime.setTime(time);			
					screentime.setScrnum(scrnum);
					
				
					screentimeList.add(screentime);
					System.out.println("screentime = "+screentime);
				}//end while
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return screentimeList;
	}

	/**
	 * 전체 상영시간 조회 기능
	 * 
	 * @param time
	 */
	public ArrayList selectScreenTimeList() {
		Connection con=null;
		PreparedStatement psmt=null;
		String sql=null;
		ResultSet rs=null;
		ScreenTime screentime=null;
		ArrayList<ScreenTime>screentimeList=new ArrayList<ScreenTime>();
		try {
			con=ConnectionUtil.getConnection();
			sql="SELECT m.m_name,s.time" +
					
					"  FROM  MOVIE m,SCREENING_TIME s " +
					"  WHERE  s.m_num=m.m_num ";
			
			
				psmt=con.prepareStatement(sql);
				rs=psmt.executeQuery();
				while(rs.next()){
					String m_name=rs.getString(1);
					String time=rs.getString(2);
								
					Movie movie=new Movie();
					screentime=new ScreenTime();
					
					movie.setMname(m_name);
					screentime.setMovie(movie);
					screentime.setTime(time);					
				
					screentimeList.add(screentime);
				}//end while
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return screentimeList;
	}
}
