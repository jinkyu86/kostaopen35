package kr.or.kosta.moviesystem.movie;

public class MovieDAO {

	/**
	 * ��ȭ ���
	 * 
	 * @param movie
	 */
	public void insertMovie(Movie movie) {
		/* default generated stub */;
		return null;
	}

	/**
	 * ��ȭ ����
	 * 
	 * @param mnum
	 */
	public void deleteMovie(Number mnum) {
		/* default generated stub */;
		return null;
	}

	/**
	 * ��ü ��ȭ ���� �� �� �ִ� �޼ҵ�
	 */
	public int selectMovieCount() {
		/* default generated stub */;
		return null;
	}

	/**
	 * ��ȭ��ȣ�� ��ȭ ã��
	 * 
	 * @param mnum
	 */
	public Movie selectMovie(Number mnum) {
		/* default generated stub */;
		return null;
	}

	/**
	 * ��ü ��ȭ ����Ʈ
	 * 
	 * @param page
	 * @param length
	 */
	public ArrayList selectMovieList(int page, int length) {
		/* default generated stub */;
		return null;
	}

	/**
	 * ��ȭ�̸����� ��ȭ ����Ʈ�� �� �� �ִ� �޼���
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
	 * ��ȭ �̸����� ã�� ����Ʈ�� ���� �� �� �ִ� �޼���
	 * 
	 * @param mName
	 */
	public int selectMovieListbyMnameCount(String mName) {
		/* default generated stub */;
		return null;
	}

	/**
	 * ��ȭ�� �帣�� ��ȭ�� ã�� �� �ִ� �޼���
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
	 * ��ȭ �帣�� ã�� ��ȭ�� ���� �� �� �ִ� �޼���
	 * 
	 * @param genre
	 */
	public int selectMovieListbyGenreCount(String genre) {
		/* default generated stub */;
		return null;
	}

	/**
	 * ��ȭ�� �������� ��ȭ�� ã�� �� �ִ� �޼���
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
	 * ��ȭ�� �������� ã�� ��ȭ�� ���� �� �� �ִ� �޼���
	 * 
	 * @param count
	 */
	public int selectMovieListByContentCount(String count) {
		/* default generated stub */;
		return null;
	}

	/**
	 * ��ȭ�� ������Ʈ �� �� �ִ� �޼���
	 * 
	 * @param movie
	 */
	public void updateMovie(Movie movie) {
		/* default generated stub */;
		return null;
	}
}
