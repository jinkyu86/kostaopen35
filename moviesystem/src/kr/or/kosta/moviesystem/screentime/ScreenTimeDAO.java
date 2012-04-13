package kr.or.kosta.moviesystem.screentime;

import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kr.or.kosta.moviesystem.movie.Movie;
import kr.or.kosta.moviesystem.reservation.Reservation;
import kr.or.kosta.moviesystem.util.ConnectionUtil;

public class ScreenTimeDAO {
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
	 * 	public static Student selectStudent(String studno){
		SqlSession session=null;
		Student student=null;
		try{
			session = sqlMapper.openSession(true);
			 student=
				session.selectOne("selectStudent",studno);
			System.out.println("studno"+studno);

		}
		
		finally{
			//Connection을 ConnectionPool에 반납해야지 안끊긴다. 
			//그리고 이건 무조건 반납해야지 멈추지 않으니 finally에 써주어야한다.
			session.close();
		}
		return student;
		
	}
	 * @param mnum
	 */
	public static ScreenTime selectScreenTimeBySrcNum(String scrnum) {
		System.out.println("scrnum="+scrnum);
		SqlSession session=null;
		ScreenTime screenTime=null;
		
		try{
			session = sqlMapper.openSession(true);
			screenTime=session.selectOne("ScreenTime.selectScreenTime",scrnum);
			System.out.println("scrnum="+scrnum);
		}
		
		finally{
			//Connection을 ConnectionPool에 반납해야지 안끊긴다. 
			//그리고 이건 무조건 반납해야지 멈추지 않으니 finally에 써주어야한다.
			session.close();
		}
		return screenTime;
	}
	
	
	
	
	
	/**
	 * 영화이름으로 상영시간을 찾을 수 있는 기능
	 * 	public static List<Student> selectStudentList(){
		SqlSession session=null;
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
	}
	 * @param mnum
	 */
	public static List<ScreenTime> selectScreen(String mnum) {
		SqlSession session=null;
		List<ScreenTime> screenTimeList=null;
		try{
			session = sqlMapper.openSession(true);
			screenTimeList=
				session.selectList("ScreenTime.selectScreenList",mnum);
		

		}
		
		finally{
			//Connection을 ConnectionPool에 반납해야지 안끊긴다. 
			//그리고 이건 무조건 반납해야지 멈추지 않으니 finally에 써주어야한다.
			session.close();
		}
		return screenTimeList;
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
