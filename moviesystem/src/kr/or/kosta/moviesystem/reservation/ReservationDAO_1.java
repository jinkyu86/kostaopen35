package kr.or.kosta.moviesystem.reservation;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class ReservationDAO_1 {
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
	
	public static List<Reservation> selectReservationTime(String userid, String mnum) {
		SqlSession session = null;
		List<Reservation>reservationList=null;
		try{
			session= sqlMapper.openSession(true);
			HashMap<String,String> parameter=new HashMap<String,String>();
			parameter.put("userid",userid);
			parameter.put("mnum",mnum);
			reservationList=session.selectOne("Reservation.selectReservationTime",parameter);
			
		}finally{
			session.close();
		}
		return reservationList;
	}

}
