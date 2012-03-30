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
			sql="SELECT m.m_name,s.time" +
					
					"  FROM  MOVIE m,SCREENING_TIME s " +
					"  WHERE  s.m_num=m.m_num " +
					"                      AND  m.m_num=?";
			
			
				psmt=con.prepareStatement(sql);
				psmt.setString(1,mnum);
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
