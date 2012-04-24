package kr.or.kosta.moviesystem.movie;

import java.util.List;

public interface IMovieDAO {

	List selectMovieList();

	List<Movie> selectMovieList(int page, int length, String gubun);

	int selectMovieCount(String gubun);

	List<Movie> rankingMovieList();

	Movie selectMovie(String mnum);

	List<Movie> selectMovieListSearch(int page, int length, String schCode,
			String schString);

	int selectMovieListSearchCnt(String schCode, String schString);

	void addMovie(Movie movie);

	void editMovie(Movie movie);

	void removeMovie(String mnum);

	Movie selectMovieNum(String Mname);

}
