package kr.or.kosta.moviesystem.movie;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


public class MovieDAO implements IMovieDAO {
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
	public List selectMovieList(){
		SqlSession session = null;
		List<Movie>movieList=null;
		try{
			session= sqlMapper.openSession(true);
			movieList=session.selectList("MovieService.selectMovieList");
			
		}finally{
			session.close();
		}
		return movieList;
	}
	@Override
	public List<Movie> selectMovieList(int page, int length, String gubun){
		SqlSession session = null;
		List<Movie> movieList = null;
		
		try{
			session = sqlMapper.openSession(true);
			RowBounds rowBounds = new RowBounds((page-1)*length, length);
			if("screen".equals(gubun)){
				movieList = session.selectList("MovieService.selectMovieListScreen", null, rowBounds);
			}else if("schedule".equals(gubun)){
				movieList = session.selectList("MovieService.selectMovieListSchedule", null, rowBounds);
			}else if("reservation".equals(gubun)){
				movieList = session.selectList("MovieService.selectMovieListReservation", null, rowBounds);
			}else{
				movieList = session.selectList("MovieService.selectMovieListTotal", null, rowBounds);
			}
		}finally{
			session.close();
		}
		return movieList;
	}
	@Override
	public int selectMovieCount(String gubun){
		SqlSession session = null;
		Integer mcount = 0;
		try{
			session = sqlMapper.openSession(true);
			if("screen".equals(gubun)){
				mcount = session.selectOne("MovieService.selectMovieListScreenCnt");
			}else if("schedule".equals(gubun)){
				mcount = session.selectOne("MovieService.selectMovieListScheduleCnt");
			}else if("reservation".equals(gubun)){
				mcount = session.selectOne("MovieService.selectMovieListReservationCnt");
			}else{	
				mcount = session.selectOne("MovieService.selectMovieListTotalCnt");
			}
		}finally{
			session.close();
		}
		return mcount;
	}	
	@Override
	public List<Movie> rankingMovieList(){
		SqlSession session = null;
		List<Movie> movieList = null;
		try{
			session = sqlMapper.openSession(true);
			RowBounds rowBounds = new RowBounds(0,3);
			movieList = session.selectList("MovieService.selectMovieRanking", null, rowBounds);
		}finally{
			session.close();
		}
		return movieList;
	}
	@Override
	public Movie selectMovie(String mnum){
		SqlSession session = null;
		Movie movie = null;
		try{
			session = sqlMapper.openSession(true);
			movie = session.selectOne("MovieService.selectMovie",mnum);
		}finally{
			session.close();
		}
		return movie;
	}
	@Override
	public List<Movie> selectMovieListSearch(int page, int length, String schCode, String schString){
		SqlSession session = null;
		List<Movie> movieList = null;
		String exeQuery = null;
		try{
			session = sqlMapper.openSession(true);
			RowBounds rowBounds = new RowBounds((page-1)*length, length);
			if("mname".equals(schCode)){
				exeQuery = "MovieService.selectMovieListByMname";
			}else if("genre".equals(schCode)){
				exeQuery = "MovieService.selectMovieListByGenre";
			}else if("content".equals(schCode)){
				exeQuery = "MovieService.selectMovieListByContent";
			}
			movieList = session.selectList(exeQuery,"%"+schString+"%", rowBounds);
		}finally{
			session.close();
		}
		return movieList;
	}
	@Override
	public int selectMovieListSearchCnt(String schCode, String schString){
		SqlSession session = null;
		Integer mcnt = 0;
		String schQuery = null;
		try{
			session = sqlMapper.openSession(true);
			if("mname".equals(schCode)){
				schQuery = "MovieService.selectMovieListByMnameCount";
			}else if("genre".equals(schCode)){
				schQuery = "MovieService.selectMovieListByGenreCount";
			}else if("content".equals(schCode)){
				schQuery = "MovieService.selectMovieListByContentCount";
			}
			mcnt = session.selectOne(schQuery,"%"+schString+"%");
		}finally{
			session.close();
		}
		return mcnt;
	}
	@Override
	public void addMovie(Movie movie){
		SqlSession session = null;
		try{
			session = sqlMapper.openSession(true);
			session.insert("MovieService.addMovie",movie);
		}finally{
			session.close();
		}
	}
	@Override
	public void editMovie(Movie movie){
		SqlSession session = null;
		try{
			session = sqlMapper.openSession(true);
			session.update("MovieService.editMovie",movie);
		}finally{
			session.close();
		}
	}
	@Override
	public void removeMovie(String mnum){
		SqlSession session = null;
		try{
			session = sqlMapper.openSession(true);
			session.delete("MovieService.removeMovie",mnum);
		}finally{
			session.close();
		}
	}
	@Override
	public Movie selectMovieNum(String Mname){
		SqlSession session = null;
		Movie movie = null;
		try{
			session = sqlMapper.openSession(true);
			movie = session.selectOne("MovieService.selectMovieNum",Mname);
		}finally{
			session.close();
		}
		return movie;
	}
}
