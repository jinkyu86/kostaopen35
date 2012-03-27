package kr.or.kosta.moviesystem.movie;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import kr.or.kosta.moviesystem.util.ConnectionUtil;

public class MovieDAO {

	/**
	 * ��ȭ ���
	 * 
	 * @param movie
	 */
	public static void insertMovie(Movie movie) {
		Connection con = null;
		PreparedStatement psmt = null;
		String sql = null;
		
		System.out.println(movie);
		try {
			con = ConnectionUtil.getConnection();
			sql = "insert into MOVIE(m_num, m_name, launch_date, genre, poster, end_date, m_price, content)"
					+"values(m_seq.nextval, ?, ?, ?, ?, ?, ?, ?)";
			psmt = con.prepareStatement(sql);
			psmt.setString(1, movie.getMname());
			psmt.setString(2, movie.getLaunchDate());
			psmt.setString(3, movie.getGenre());
			psmt.setString(4, movie.getPoster());
			psmt.setString(5, movie.getEndDate());
			psmt.setLong(6, movie.getMprice());
			psmt.setString(7, movie.getContent());
			
			psmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * ��ȭ ����
	 * 
	 * @param mnum
	 */
	public static void deleteMovie(String mnum) {
		Connection con = null;
		PreparedStatement psmt = null;
		String sql = null;
		
		try{
			con = ConnectionUtil.getConnection();
			sql = "delete from MOVIE where m_num=?";
			psmt = con.prepareStatement(sql);
			psmt.setString(1, mnum);
			psmt.execute();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	/**
	 * ��ü ��ȭ ���� �� �� �ִ� �޼ҵ�
	 */
	public static int selectMovieCount() {
		Connection con = null;
		PreparedStatement psmt = null;
		String sql = null;
		ResultSet rs = null;
		int movieCount = 0;
		try{
			con = ConnectionUtil.getConnection();
			sql = "select count(*) from MOVIE";
			psmt = con.prepareStatement(sql);
			rs = psmt.executeQuery();
			
			if(rs.next()){
				int mCount = rs.getInt(1);
				movieCount = mCount;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return movieCount;
	}

	/**
	 * ��ȭ��ȣ�� ��ȭ ã��
	 * 
	 * @param mnum
	 */
	public static Movie selectMovie(String mnum) {
		Connection con = null;
		PreparedStatement psmt = null;
		String sql = null;
		ResultSet rs = null;
		Movie movie = null;
		
		try{
			con = ConnectionUtil.getConnection();
			sql="select m_num, m_name, launch_date, genre, poster, end_date, m_price, content from MOVIE "
					+"where m_num=?";
			psmt = con.prepareStatement(sql);
			rs = psmt.executeQuery();
			if(rs.next()){
				String mnum2 = rs.getString(1);
				String mname = rs.getString(2);
				String lDate = rs.getString(3);
				String genre = rs.getString(4);
				String poster = rs.getString(5);
				String eDate = rs.getString(6);
				long mprice = rs.getLong(7);
				
				movie = new Movie();
				movie.setMnum(mnum);
				movie.setMname(mname);
				movie.setLaunchDate(lDate);
				movie.setGenre(genre);
				movie.setPoster(poster);
				movie.setEndDate(eDate);
				movie.setMprice(mprice);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return movie;
	}

	/**
	 * ��ü ��ȭ ����Ʈ
	 * 
	 * @param page
	 * @param length
	 */
	public static ArrayList selectMovieList(int page, int length) {
		Connection con = null;
		PreparedStatement psmt = null;
		String sql = null;
		ArrayList<Movie>movieList = new ArrayList<Movie>();
		ResultSet rs = null;
		int num = (page-1)*length;
		int GetRsCount = 0;
		try{
			con = ConnectionUtil.getConnection();
			sql = "select m_num, m_name, launch_date, genre, poster, end_date, m_price, content from MOVIE";
			psmt = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			
			rs = psmt.executeQuery();
			
			if(num>0){
				rs.absolute(num);
			}
			while(rs.next()&&GetRsCount<length){
				GetRsCount++;
				String mnum = rs.getString(1);
				String mname = rs.getString(2);
				String lDate = rs.getString(3);
				String genre = rs.getString(4);
				String poster = rs.getString(5);
				String eDate = rs.getString(6);
				long mprice = rs.getLong(7);
				String content = rs.getString(8);
				
				
				Movie movie = new Movie();
				movie.setMnum(mnum);
				movie.setMname(mname);
				movie.setLaunchDate(lDate);
				movie.setGenre(genre);
				movie.setEndDate(eDate);
				movie.setMprice(mprice);
				movie.setContent(content);
				movie.setPoster(poster);
				
				movieList.add(movie);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return movieList;
	}

	/**
	 * ��ȭ�̸����� ��ȭ ����Ʈ�� �� �� �ִ� �޼���
	 * 
	 * @param page
	 * @param length
	 * @param mname
	 */
	public static ArrayList selectMovieListbyMname(int page, int length, String mname) {
		Connection con = null;
		PreparedStatement psmt = null;
		String sql = null;
		ArrayList<Movie>movieList = new ArrayList<Movie>();
		ResultSet rs = null;
		int getRsCount = 0;
		int num = (page-1)*length;
		
		try{
			con = ConnectionUtil.getConnection();
			sql = "select m_num, m_name, launch_date, genre, poster, end_date, m_price, content "
					+"from MOVIE where m_name like ?";
			psmt = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			psmt.setString(1, "%"+mname+"%");
			
			rs = psmt.executeQuery();
			
			if(num>0){
				rs.absolute(num);
			}
			while(rs.next()&&getRsCount<length){
				getRsCount++;
				String mnum = rs.getString(1);
				String mname2 = rs.getString(2);
				String lDate = rs.getString(3);
				String genre = rs.getString(4);
				String poster = rs.getString(5);
				String eDate = rs.getString(6);
				long mprice = rs.getLong(7);
				String content = rs.getString(8);
				
				Movie movie = new Movie();
				movie.setMnum(mnum);
				movie.setMname(mname2);
				movie.setLaunchDate(lDate);
				movie.setGenre(genre);
				movie.setEndDate(eDate);
				movie.setMprice(mprice);
				movie.setContent(content);
				movie.setPoster(poster);
				
				movieList.add(movie);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return movieList;
	}

	/**
	 * ��ȭ �̸����� ã�� ����Ʈ�� ���� �� �� �ִ� �޼���
	 * 
	 * @param mName
	 */
	public static int selectMovieListbyMnameCount(String mName) {
		/* default generated stub */;
		Connection con = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		String sql = null;
		int searchMovieCount = 0;
		
		try{
			con = ConnectionUtil.getConnection();
			sql = "select count(*) from MOVIE where m_name like ?";
			psmt = con.prepareStatement(sql);
			psmt.setString(1, "%"+ mName +"%");
			
			rs = psmt.executeQuery();
			
			if(rs.next()){
				searchMovieCount = rs.getInt(1);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return searchMovieCount;
	}

	/**
	 * ��ȭ�� �帣�� ��ȭ�� ã�� �� �ִ� �޼���
	 * 
	 * @param page
	 * @param length
	 * @param genre
	 */
	public static ArrayList selectMovieListbyGenre(int page, int length, String genre) {
		Connection con = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		int num = (page-1)*length;
		int getRsCount = 0;
		String sql = null;
		ArrayList<Movie>movieList= new ArrayList<Movie>();
		
		try{
			con = ConnectionUtil.getConnection();
			sql = "select m_num, m_name, launch_date, genre, poster, end_date, m_price, content "
					+"from MOVIE where genre like ?";
			psmt = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			psmt.setString(1, "%"+genre+"%");
			
			rs = psmt.executeQuery();
			
			if(num>0){
				rs.absolute(num);
			}
			while(rs.next()&&getRsCount<length){
				getRsCount++;
				String mnum = rs.getString(1);
				String mname2 = rs.getString(2);
				String lDate = rs.getString(3);
				String genre2 = rs.getString(4);
				String poster = rs.getString(5);
				String eDate = rs.getString(6);
				long mprice = rs.getLong(7);
				String content = rs.getString(8);
				
				Movie movie = new Movie();
				movie.setMnum(mnum);
				movie.setMname(mname2);
				movie.setLaunchDate(lDate);
				movie.setGenre(genre2);
				movie.setEndDate(eDate);
				movie.setMprice(mprice);
				movie.setContent(content);
				movie.setPoster(poster);
				
				movieList.add(movie);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return movieList;
	}

	/**
	 * ��ȭ �帣�� ã�� ��ȭ�� ���� �� �� �ִ� �޼���
	 * 
	 * @param genre
	 */
	public static int selectMovieListbyGenreCount(String genre) {
		Connection con = null;
		PreparedStatement psmt = null;
		String sql = null;
		int schMovieCount = 0;
		ResultSet rs = null;
		try{
			con = ConnectionUtil.getConnection();
			sql = "select count(*) from MOVIE where genre like ?";
			psmt = con.prepareStatement(sql);
			psmt.setString(1, "%"+ genre +"%");
			
			rs = psmt.executeQuery();
			
			if(rs.next()){
				schMovieCount = rs.getInt(1);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return schMovieCount;
	}

	/**
	 * ��ȭ�� �������� ��ȭ�� ã�� �� �ִ� �޼���
	 * 
	 * @param page
	 * @param length
	 * @param content
	 */
	public static ArrayList selectMovieListByContent(int page, int length,
			String content) {
		Connection con = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		String sql = null;
		int num = (page-1)*length;
		int getRsCount = 0;
		ArrayList<Movie>movieList = new ArrayList<Movie>();
		
		try{
			con = ConnectionUtil.getConnection();
			sql = "select m_num, m_name, launch_date, genre, poster, end_date, m_price, content "
					+"from MOVIE where content like ?";
			psmt = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			psmt.setString(1, "%"+content+"%");
			rs = psmt.executeQuery();
			
			if(num>0){
				rs.absolute(num);
			}
			
			while(rs.next()&&getRsCount<length){
				getRsCount++;
				String mnum = rs.getString(1);
				String mname2 = rs.getString(2);
				String lDate = rs.getString(3);
				String genre2 = rs.getString(4);
				String poster = rs.getString(5);
				String eDate = rs.getString(6);
				long mprice = rs.getLong(7);
				String content2 = rs.getString(8);
				
				Movie movie = new Movie();
				movie.setMnum(mnum);
				movie.setMname(mname2);
				movie.setLaunchDate(lDate);
				movie.setGenre(genre2);
				movie.setEndDate(eDate);
				movie.setMprice(mprice);
				movie.setContent(content2);
				movie.setPoster(poster);
				
				movieList.add(movie);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return movieList;
	}

	/**
	 * ��ȭ�� �������� ã�� ��ȭ�� ���� �� �� �ִ� �޼���
	 * 
	 * @param count
	 */
	public static int selectMovieListByContentCount(String content) {
		Connection con = null;
		PreparedStatement psmt = null;
		String sql = null;
		ResultSet rs = null;
		int schMovieCount = 0;
		
		try{
			con = ConnectionUtil.getConnection();
			sql = "select count(*) from MOVIE where content like ?";
			psmt = con.prepareStatement(sql);
			psmt.setString(1, "%"+ content +"%");
			
			rs = psmt.executeQuery();
			
			if(rs.next()){
				schMovieCount = rs.getInt(1);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return schMovieCount;
	}

	/**
	 * ��ȭ�� ������Ʈ �� �� �ִ� �޼���
	 * 
	 * @param movie
	 */
	public static void updateMovie(Movie movie) {
		Connection con = null;
		PreparedStatement psmt = null;
		String sql = null;
		
		try{
			con = ConnectionUtil.getConnection();
			sql = "update MOVIE set m_name=?, launch_date=?, genre=?, poster=?, end_date=?"
					+", m_price=?, content=? where m_num=?";
			psmt = con.prepareStatement(sql);
			psmt.setString(1, movie.getMname());
			psmt.setString(2, movie.getLaunchDate());
			psmt.setString(3, movie.getGenre());
			psmt.setString(4, movie.getPoster());
			psmt.setString(5, movie.getEndDate());
			psmt.setLong(6, movie.getMprice());
			psmt.setString(7, movie.getMnum());
			
			psmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
