package kr.or.kosta.moviesystem.movie;

import java.io.IOException;

import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.kosta.moviesystem.util.PageUtil;

public class MovieService extends HttpServlet{

	public MovieService() {
        super();
        // TODO Auto-generated constructor stub
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String method = request.getParameter("method");
		if(method==null){
			method="viewMovieList";
		}
		System.out.println(method);
		if("viewMovieList".equals(method)){
			viewMovieList(request, response);
		}else if("viewMovie".equals(method)){
			viewMovie(request, response);
		}else if("searchMovieList".equals(method)){
			searchMovieList(request, response);
		}else if("removeMovie".equals(method)){
			removeMovie(request, response);
		}else if("editMovieForm".equals(method)){
			editMovieForm(request, response);
		}else if("editMovie".equals(method)){
			editMovieForm(request, response);
		}else if("addMovieForm".equals(method)){
			addMovieForm(request, response);
		}else if("addMovie".equals(method)){
			addMovie(request, response);
		}else if("rankingMovieList".equals(method)){
			rankingMovieList(request, response);
		}
	}
	
	/**
	 * 영화 순위
	 * 
	 * @param request
	 * @param response
	 */
	public void rankingMovieList(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		ArrayList<Movie>movieList = MovieDAO.rankingMovieList();
		request.setAttribute("MovieList",movieList);
		
		RequestDispatcher rd = request.getRequestDispatcher("/movie/viewMovieRank.jsp");
		rd.forward(request, response);		
	}
	/**
	 * 영화 추가
	 * 
	 * @param request
	 * @param response
	 */
	public void addMovie(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException{
		String mname = request.getParameter("mname");
		String genre = request.getParameter("genre");
		String poster = request.getParameter("poster");
		String content = request.getParameter("content");
		Date ldate = new Date(request.getParameter("ldate"));
		Date edate = new Date(request.getParameter("edate"));
		
		Movie movie = new Movie();
		movie.setMname(mname);
		movie.setGenre(genre);
		movie.setPoster(poster);
		movie.setContent(content);
		movie.setLaunchDate(ldate);
		movie.setEndDate(edate);
		
		MovieDAO.insertMovie(movie);
		
		RequestDispatcher rd = request.getRequestDispatcher("/moviesystem/MovieService?method=viewMovieList");
		rd.forward(request,  response);
	}

	/**
	 * 영화를 추가할 수 있는 폼으로 감
	 * 
	 * @param request
	 * @param response
	 */
	public void addMovieForm(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException{
		RequestDispatcher rd = request.getRequestDispatcher("/movie/addMovie.jsp");
		rd.forward(request, response);
	}

	/**
	 * 영화를 수정
	 * 
	 * @param request
	 * @param response
	 */
	public void editMovie(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException{
		String mnum = request.getParameter("mnum");
		String mname = request.getParameter("mname");
		String genre = request.getParameter("genre");
		String poster = request.getParameter("poster");
		String content = request.getParameter("content");
		Date ldate = new Date(request.getParameter("ldate"));
		Date edate = new Date(request.getParameter("edate"));
		String gubun = request.getParameter("gubun");
		
		
		
		Movie movie = new Movie();
		movie.setMnum(mnum);
		movie.setMname(mname);
		movie.setLaunchDate(ldate);
		movie.setGenre(genre);
		movie.setPoster(poster);
		movie.setEndDate(edate);
		movie.setContent(content);
		
		MovieDAO.updateMovie(movie);
		
		request.setAttribute("mnum", mnum);
		request.setAttribute("gubun", gubun);
		
		RequestDispatcher rd = request.getRequestDispatcher("/movie/viewMovie.jsp");
		rd.forward(request, response);
		
	}

	/**
	 * 영화를 수정할 수 있는 폼으로 이동
	 * 
	 * @param request
	 * @param response
	 */
	public void editMovieForm(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException{
		String mnum = request.getParameter("mnum");
		String gubun = request.getParameter("gubun");
		
		request.setAttribute("gubun", gubun);
		
		Movie movie = MovieDAO.selectMovie(mnum);
		
		request.setAttribute("Movie", movie);
		
		RequestDispatcher rd = request.getRequestDispatcher("/movie/editMovie.jsp");
		rd.forward(request, response);
	}

	/**
	 * 영화 삭제
	 * 
	 * @param request
	 * @param response
	 */
	public void removeMovie(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		String mnum = request.getParameter("mnum");
		String gubun = request.getParameter("gubun");
		MovieDAO.deleteMovie(mnum);
		
		request.setAttribute("gubun", gubun);
		
		RequestDispatcher rd = request.getRequestDispatcher("/MovieService?method=viewMovieList");
		rd.forward(request, response);
	}

	/**
	 * 검색한 영화의 리스트를 보여주는 기능
	 * 
	 * @param request
	 * @param response
	 */
	public void searchMovieList(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException{
		/* default generated stub */;
		int page = 1;
		int length = 5;
		int movieCnt = 0;
		if(request.getParameter("page")!=null){
			page = Integer.parseInt(request.getParameter("page"));
		}
		
		String schCode = request.getParameter("schCode");	
		request.setAttribute("schCode",schCode);
		
		String schString = request.getParameter("schString");
		request.setAttribute("schString",schString);
		
		ArrayList<Movie>movieList = null;
		if("mname".equals(schCode)){
			movieList = MovieDAO.selectMovieListbyMname(page, length, schString);
			movieCnt = MovieDAO.selectMovieListbyMnameCount(schString);
		}else if("genre".equals(schCode)){
			movieList = MovieDAO.selectMovieListbyGenre(page, length, schString);
			movieCnt = MovieDAO.selectMovieListbyGenreCount(schString);
		}else if("content".equals(schCode)){
			movieList = MovieDAO.selectMovieListByContent(page, length, schString);
			movieCnt = MovieDAO.selectMovieListByContentCount(schString);
		}
		request.setAttribute("MovieList", movieList);
		
		String pageLink = "MovieService?method=searchMovieList&schCode="+schCode+"&schString="+schString;
		String pageLinkTag = PageUtil.generate(page, movieCnt, length, pageLink);
		request.setAttribute("page_Link_Tag", pageLinkTag);
		
		RequestDispatcher rd = request.getRequestDispatcher("/movie/viewMovieList.jsp");
		rd.forward(request, response);
	}

	/**
	 * 영화목록에서 선택한 영활를 보여주는 기능
	 * 
	 * @param request
	 * @param response
	 */
	public void viewMovie(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		String mnum = request.getParameter("mnum");
		String gubun = "total";
		
		if(request.getParameter("gubun")!=null){
			gubun = request.getParameter("gubun");
		}
		
		request.setAttribute("gubun", gubun);
		
		Movie movie = MovieDAO.selectMovie(mnum);
		//System.out.println(movie);
		request.setAttribute("Movie", movie);
		
		RequestDispatcher rd = request.getRequestDispatcher("/movie/viewMovie.jsp");
		rd.forward(request, response);
	}

	/**
	 * 전체 영화리스트
	 * 
	 * @param request
	 * @param response
	 */
	public void viewMovieList(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		int page = 1;
		int length = 5;
		String gubun = "total";
		String method = "viewMovieList";
		
		if(request.getParameter("page")!=null){
			page = Integer.parseInt(request.getParameter("page"));
		}
		if(request.getParameter("gubun")!=null){
			gubun = request.getParameter("gubun");
		}
		if(request.getParameter("method")!=null){
			method = request.getParameter("method");
		}
		request.setAttribute("gubun",gubun);
		request.setAttribute("method", method);
		String pageLink = "MovieService?method=viewMovieList&gubun="+gubun;
		
		ArrayList<Movie>movieList = MovieDAO.selectMovieList(page, length, gubun);
		request.setAttribute("MovieList",movieList);

		int MovieCnt = MovieDAO.selectMovieCount(gubun);
		
		//System.out.println(pageLink);
		String pageLinkTag = PageUtil.generate(page, MovieCnt, length, pageLink);
		request.setAttribute("page_Link_Tag", pageLinkTag);
		
		RequestDispatcher rd = request.getRequestDispatcher("/movie/viewMovieList.jsp");
		rd.forward(request, response);
	}
}
