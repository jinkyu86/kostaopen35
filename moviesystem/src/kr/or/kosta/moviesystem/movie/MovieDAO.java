package kr.or.kosta.moviesystem.movie;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MovieDAO {
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
	public List selectMovieList(int page, int length, String gubun){
		SqlSession session = null;
		List<Movie> movieList = null;
		String schwhere = null;
		
		if("screen".equals(gubun)){
			schwhere = " and launch_date<=sysdate";
		}else if("schedule".equals(gubun)){
			schwhere = "and launch_date>sysdate";
		}else if("reservation".equals(gubun)){
			schwhere = "and end_date>sysdate";
		}else{
			schwhere = "";
		}
		try{
			
			session = sqlMapper.openSession(true);
			RowBounds rowBounds = new RowBounds((page-1)*length,length);
			movieList = session.selectList("Movie.selectMovie",schwhere,rowBounds);
		}finally{
			session.close();
		}
		return movieList;
	}
}
