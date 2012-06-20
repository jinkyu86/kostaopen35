package kr.or.kosta.moviesystem.screentime;

import java.io.IOException;
import java.io.Reader;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.mybatis.spring.support.SqlSessionDaoSupport;

public class ScreenTimeDAO  extends SqlSessionDaoSupport implements IScreenTimeDAO{	
	/**
	 * 상영시간 등록 기능
	 * 
	 * @param time
	 */
	@Override
	public void insertScreenTime(Date time) {
		// TODO Auto-generated method stub
		
	}
	/**
	 * 상영시간으로 scr_num을 알수 있는 기능
	 * 
	 * @param time
	 */
	@Override
	public ScreenTime selectScreenTimeScrNum(String time) {
		SqlSession session = null;
		ScreenTime screentime=null;
		
		String timesubstring=time.substring(0,19);
		System.out.println("timesubstring= "+timesubstring);
		
		session= getSqlSession();
		
		screentime=session.selectOne("ScreenTime.selectScreenTimeScrNum", timesubstring);
		
		return screentime;
	}
//	public static ScreenTime selectScreenTimeScrNum(String time) {
//		Connection con=null;
//		PreparedStatement psmt=null;
//		String sql=null;
//		ResultSet rs=null;
//		ScreenTime screentime=new ScreenTime();
//		ArrayList<ScreenTime>screentimeList=new ArrayList<ScreenTime>();
//		System.out.println("time= "+time);
//		String timesubstring=time.substring(0,19);
//		System.out.println("timesubstring= "+timesubstring);
//		
//		
//		try {
//			con=ConnectionUtil.getConnection();
//			sql="SELECT scr_num" +
//					"  FROM SCREENING_TIME" +
//					"  WHERE  time=to_date(?,'yyyy-mm-dd hh24:mi:ss')" ;
//
//				psmt=con.prepareStatement(sql);
//				psmt.setString(1,timesubstring);
//				rs=psmt.executeQuery();
//				if(rs.next()){
//					
//					String scrnum=rs.getString(1);
//					System.out.println("scrnum = "+scrnum);
//					screentime.setScrnum(scrnum);
//					
//				
//					System.out.println("screentime = "+screentime);
//				}//end while
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return screentime;
//	}
	
	
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
	@Override
	public ScreenTime selectScreenTimeBySrcNum(String scrnum) {
		SqlSession session=null;
		ScreenTime screenTime=null;
		session= getSqlSession();
		screenTime=session.selectOne("ScreenTime.selectScreenTime",scrnum);
		System.out.println("scrnum="+scrnum);
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
	@Override
	public List<ScreenTime> selectScreen(String mnum) {
		SqlSession session=null;
		List<ScreenTime> screenTimeList=null;
		session= getSqlSession();
		screenTimeList= session.selectList("ScreenTime.selectScreenList",mnum);
		
		return screenTimeList;
	}

}
