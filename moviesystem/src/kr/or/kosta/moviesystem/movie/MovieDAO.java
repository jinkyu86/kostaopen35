package kr.or.kosta.moviesystem.movie;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.mybatis.spring.support.SqlSessionDaoSupport;


public class MovieDAO extends SqlSessionDaoSupport implements IMovieDAO {
	
	@Override
	public List selectMovieList(){
		SqlSession session = null;
		List<Movie>movieList=null;
		session= getSqlSession();
		movieList=session.selectList("MovieService.selectMovieList");
		
		return movieList;
	}
	@Override
	public List<Movie> selectMovieList(int page, int length, String gubun){
		SqlSession session = null;
		List<Movie> movieList = null;
		
		session = getSqlSession();
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
		return movieList;
	}
	@Override
	public int selectMovieCount(String gubun){
		SqlSession session = null;
		Integer mcount = 0;
		session = getSqlSession();
		if("screen".equals(gubun)){
			mcount = session.selectOne("MovieService.selectMovieListScreenCnt");
		}else if("schedule".equals(gubun)){
			mcount = session.selectOne("MovieService.selectMovieListScheduleCnt");
		}else if("reservation".equals(gubun)){
			mcount = session.selectOne("MovieService.selectMovieListReservationCnt");
		}else{	
			mcount = session.selectOne("MovieService.selectMovieListTotalCnt");
		}
		
		return mcount;
	}	
	@Override
	public List<Movie> rankingMovieList(){
		SqlSession session = null;
		List<Movie> movieList = null;
		session = getSqlSession();
		RowBounds rowBounds = new RowBounds(0,3);
		movieList = session.selectList("MovieService.selectMovieRanking", null, rowBounds);
		
		return movieList;
	}
	@Override
	public Movie selectMovie(String mnum){
		SqlSession session = null;
		Movie movie = null;
		session = getSqlSession();
		movie = session.selectOne("MovieService.selectMovie",mnum);
		
		return movie;
	}
	@Override
	public List<Movie> selectMovieListSearch(int page, int length, String schCode, String schString){
		SqlSession session = null;
		List<Movie> movieList = null;
		String exeQuery = null;
		session = getSqlSession();
		RowBounds rowBounds = new RowBounds((page-1)*length, length);
		if("mname".equals(schCode)){
			exeQuery = "MovieService.selectMovieListByMname";
		}else if("genre".equals(schCode)){
			exeQuery = "MovieService.selectMovieListByGenre";
		}else if("content".equals(schCode)){
			exeQuery = "MovieService.selectMovieListByContent";
		}
		movieList = session.selectList(exeQuery,"%"+schString+"%", rowBounds);
		
		return movieList;
	}
	@Override
	public int selectMovieListSearchCnt(String schCode, String schString){
		SqlSession session = null;
		Integer mcnt = 0;
		String schQuery = null;
		session = getSqlSession();
		if("mname".equals(schCode)){
			schQuery = "MovieService.selectMovieListByMnameCount";
		}else if("genre".equals(schCode)){
			schQuery = "MovieService.selectMovieListByGenreCount";
		}else if("content".equals(schCode)){
			schQuery = "MovieService.selectMovieListByContentCount";
		}
		mcnt = session.selectOne(schQuery,"%"+schString+"%");
	
		return mcnt;
	}
	@Override
	public void addMovie(Movie movie){
		SqlSession session = null;
		session = getSqlSession();
		session.insert("MovieService.addMovie",movie);
	}
	@Override
	public void editMovie(Movie movie){
		SqlSession session = null;
		session = getSqlSession();
		session.update("MovieService.editMovie",movie);
	}
	@Override
	public void removeMovie(String mnum){
		SqlSession session = null;
		session = getSqlSession();
		session.delete("MovieService.removeMovie",mnum);
	}
	@Override
	public Movie selectMovieNum(String Mname){
		SqlSession session = null;
		Movie movie = null;
		session = getSqlSession();
		movie = session.selectOne("MovieService.selectMovieNum",Mname);
		
		return movie;
	}
}
