package kr.or.kosta.moviesystem.movie;

public class MovieDAO {

	/**
	 * 영화 등록
	 * 
	 * @param movie
	 */
	public void insertMovie(Movie movie) {
		/* default generated stub */;
		return null;
	}

	/**
	 * 영화 삭제
	 * 
	 * @param mnum
	 */
	public void deleteMovie(Number mnum) {
		/* default generated stub */;
		return null;
	}

	/**
	 * 전체 영화 수를 알 수 있는 메소드
	 */
	public int selectMovieCount() {
		/* default generated stub */;
		return null;
	}

	/**
	 * 영화번호로 영화 찾기
	 * 
	 * @param mnum
	 */
	public Movie selectMovie(Number mnum) {
		/* default generated stub */;
		return null;
	}

	/**
	 * 전체 영화 리스트
	 * 
	 * @param page
	 * @param length
	 */
	public ArrayList selectMovieList(int page, int length) {
		/* default generated stub */;
		return null;
	}

	/**
	 * 영화이름으로 영화 리스트를 알 수 있는 메서드
	 * 
	 * @param page
	 * @param length
	 * @param mname
	 */
	public ArrayList selectMovieListbyMname(int page, int length, String mname) {
		/* default generated stub */;
		return null;
	}

	/**
	 * 영화 이름으로 찾은 리스트의 수를 알 수 있는 메서드
	 * 
	 * @param mName
	 */
	public int selectMovieListbyMnameCount(String mName) {
		/* default generated stub */;
		return null;
	}

	/**
	 * 영화의 장르로 영화를 찾을 수 있는 메서드
	 * 
	 * @param page
	 * @param length
	 * @param genre
	 */
	public ArrayList selectMovieListbyGenre(int page, int length, String genre) {
		/* default generated stub */;
		return null;
	}

	/**
	 * 영화 장르로 찾은 영화의 수를 알 수 있는 메서드
	 * 
	 * @param genre
	 */
	public int selectMovieListbyGenreCount(String genre) {
		/* default generated stub */;
		return null;
	}

	/**
	 * 영화의 내용으로 영화를 찾을 수 있는 메서드
	 * 
	 * @param page
	 * @param length
	 * @param content
	 */
	public ArrayList selectMovieListByContent(int page, int length,
			String content) {
		/* default generated stub */;
		return null;
	}

	/**
	 * 영화의 내용으로 찾은 영화의 수를 알 수 있는 메서드
	 * 
	 * @param count
	 */
	public int selectMovieListByContentCount(String count) {
		/* default generated stub */;
		return null;
	}

	/**
	 * 영화를 업데이트 할 수 있는 메서드
	 * 
	 * @param movie
	 */
	public void updateMovie(Movie movie) {
		/* default generated stub */;
		return null;
	}
}
