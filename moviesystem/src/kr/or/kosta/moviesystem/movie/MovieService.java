package kr.or.kosta.moviesystem.movie;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import kr.or.kosta.moviesystem.screentime.ScreenTime;
import kr.or.kosta.moviesystem.screentime.ScreenTimeDAO;
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
			method="Main";
			//method="viewMovieList";
		}
		System.out.println(method);
		if("viewMovieList".equals(method)){
			// 영화 리스트 출력 메서드 호출
			viewMovieList(request, response);
		}else if("viewMovie".equals(method)){
			// 영화 내용 출력 메서드 호출
			viewMovie(request, response);
		}else if("searchMovieList".equals(method)){
			// 검색 영화 출력 메서드 호출
			searchMovieList(request, response);
		}else if("removeMovie".equals(method)){
			// 영화 데이터 삭제 메서드 호출
			removeMovie(request, response);
		}else if("editMovieForm".equals(method)){
			editMovieForm(request, response);
		}else if("editMovie".equals(method)){
			editMovie(request, response);
		}else if("addMovieForm".equals(method)){
			addMovieForm(request, response);
		}else if("addMovie".equals(method)){
			addMovie(request, response);
		}else if("rankingMovieList".equals(method)){
			rankingMovieList(request, response);
		}else if("MovieTimeListForm".equals(method)){
			MovieTimeListForm(request, response);
		}else if("MovieTimeList".equals(method)){
			MovieTimeList(request, response);
		}else if("Main".equals(method)){
			Main(request, response);
		}else if("adminMovieList".equals(method)){
			adminMovieList(request, response);
		}else if("adminMovieListSch".equals(method)){
			adminMovieListSch(request, response);
		}else if("adminRankingList".equals(method)){
			adminRankingList(request, response);
		}else if("adminMovie".equals(method)){
			adminMovie(request, response);
		}else if("MovieImgUpload".equals(method)){
			MovieImgUpload(request, response);
		}
	}
	private void MovieImgUpload(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String tempRealPath = getServletContext().getRealPath("/temp");
		System.out.println("tempRealPath : "+tempRealPath);
		
		// 임시폴더 temp의 정보를 알아내는 객체 생성
		File tempDirectory = new File(tempRealPath);
		// temp 폴더가 존재 않하는가?
		if(!tempDirectory.exists()){
			// 폴더 생성
			tempDirectory.mkdir();
		}
		// 파일을 저장할 폴더의 절대경로 리턴
		String uploadRealPath = getServletContext().getRealPath("/movieimg");
		System.out.println("uploadRealPath : "+ uploadRealPath);
		
		//파일 저장 폴더의 정보를 알아냐는 객체 생성
		File uploadDirectory = new File(uploadRealPath);
		// 파일 저장 폴더가 존재하지 않는다면
		if(!uploadDirectory.exists()){
			// 폴더 생성
			uploadDirectory.mkdir();
		}
		
		// 임시폴더에 저장할 수 있는 파일 1개 
		// 최대 사이즈 설정(단위 byte)
		int fileMaxSize = 1024*1000*1000;//1G
		// HttpServletRequest request의 파일의 내용을 꺼내서
		// 임시폴더에 저장
		// new DiskFileItemFactory(임시파일하나 최대사이즈, 임시파일 폴더)
		DiskFileItemFactory factory = new DiskFileItemFactory(fileMaxSize, tempDirectory);
		// 임시 파일로 저장된 정보 리턴 객체
		ServletFileUpload upload = new ServletFileUpload(factory);
		//임시 파일의 정보를 저장할 List선언
		List<FileItem> fileList = null;
		//임시 파일들의 정보를 리턴
		try{
			fileList = upload.parseRequest(request);
		}catch(FileUploadException e){
			e.printStackTrace();
		}
		
		String realSaveFileName = null;
		//임시파일을 복사항 폴더의 절대경로
		for(int i=0; i<fileList.size(); i++){
			// 임싶파일 하나의 정보 리턴
			FileItem file = fileList.get(i);
			// 파일의 원래 파일의 이름을 리턴
			String originalFileName = file.getName();
			System.out.printf("업로드 파일명 : %s\n", originalFileName);
			if(originalFileName!=null){
				// 이동할 파일의 경로, 파일명 정보 저장 객체 생성
				File uploadFile = new File(uploadDirectory+"/"+originalFileName);
				
				// 같은 이름의 파일이 존재하면 파일명에 번호를 붙여서 리턴
				uploadFile = FileRenamePolicy.rename(uploadFile);
				// 파일 이동
				try {
					file.write(uploadFile);
					// 진짜로 저장한 파일 이름 리턴
					realSaveFileName = uploadFile.getName();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println(realSaveFileName);
		out.flush();
		out.close();
		
	}
	private void adminMovie(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException{
		String mnum = request.getParameter("mnum");
		String gubun = "total";
		String method = request.getParameter("method");
		
		if(request.getParameter("gubun")!=null){
			gubun = request.getParameter("gubun");
		}
		
		request.setAttribute("gubun", gubun);
		request.setAttribute("method", method);
		
		Movie movie = MovieDAO.selectMovie(mnum);
		//System.out.println(movie);
		request.setAttribute("Movie", movie);
		
		RequestDispatcher rd = request.getRequestDispatcher("/movie/adminMovie.jsp");
		rd.forward(request, response);
		
	}

	private void adminRankingList(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException{
		List<Movie>movieList = MovieDAO.rankingMovieList();
		String method = request.getParameter("method");		
		String pageLinkTag=null;
		
		request.setAttribute("MovieList",movieList);
		
		request.setAttribute("method", method);
		request.setAttribute("page_Link_Tag", pageLinkTag);
		
		RequestDispatcher rd = request.getRequestDispatcher("/movie/adminMovieList.jsp");
		rd.forward(request, response);
		
	}

	private void adminMovieListSch(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException{
		int page = 1;
		int length = 5;
		int movieCnt = 0;
		String method = request.getParameter("method");
		String schCode = request.getParameter("schCode");
		String schString = request.getParameter("schString");
		List<Movie>movieList = null;
		String pageLink = null;
		String pageLinkTag=null;
		
		if(request.getParameter("page")!=null){
			page = Integer.parseInt(request.getParameter("page"));
		}
		movieList = MovieDAO.selectMovieListSearch(page, length, schCode, schString);
		movieCnt = MovieDAO.selectMovieListSearchCnt(schCode, schString);
		
		
		pageLink = "MovieService?method=adminMovieListSch&schCode="+schCode+"&schString="+schString;
		pageLinkTag = PageUtil.generate(page, movieCnt, length, pageLink);
		
		request.setAttribute("schCode",schCode);
		request.setAttribute("method", method);
		request.setAttribute("schString",schString);
		request.setAttribute("MovieList", movieList);
		request.setAttribute("page_Link_Tag", pageLinkTag);
		
		RequestDispatcher rd = request.getRequestDispatcher("/movie/adminMovieList.jsp");
		rd.forward(request, response);
		
	}

	private void adminMovieList(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException{
		int page = 1;
		int length = 5;
		String gubun = "total";
		String method = "adminMovieList";
		
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
		String pageLink = "MovieService?method=adminMovieList&gubun="+gubun;
		
		List<Movie>movieList = MovieDAO.selectMovieList(page, length, gubun);
		request.setAttribute("MovieList",movieList);

		int MovieCnt = MovieDAO.selectMovieCount(gubun);
		
		//System.out.println(pageLink);
		String pageLinkTag = PageUtil.generate(page, MovieCnt, length, pageLink);
		request.setAttribute("page_Link_Tag", pageLinkTag);
		
		RequestDispatcher rd = request.getRequestDispatcher("/movie/adminMovieList.jsp");
		rd.forward(request, response);
		
	}

	private void Main(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		List<Movie>screenMovieList = MovieDAO.selectMovieList(1, 3, "screen");
		List<Movie>scheduleMovieList = MovieDAO.selectMovieList(1, 3, "schedule");
		List<Movie>rankingMovieList = MovieDAO.rankingMovieList();
		
		request.setAttribute("screenMovieList", screenMovieList);
		request.setAttribute("scheduleMovieList", scheduleMovieList);
		request.setAttribute("rankingMovieList", rankingMovieList);
		
		RequestDispatcher rd = request.getRequestDispatcher("/main.jsp");
		rd.forward(request,  response);
	}

	private void MovieTimeList(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException{
		String mnum = request.getParameter("mnum");
		
		List<ScreenTime> screenTimeList = ScreenTimeDAO.selectScreen(mnum);

		JSONArray jsonArray = JSONArray.fromObject(screenTimeList);

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println(jsonArray.toString());
		out.flush();
		out.close();
	}

	private void MovieTimeListForm(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException{
		
		int Moviecnt = MovieDAO.selectMovieCount("");
		List<Movie> movieList = MovieDAO.selectMovieList(1, Moviecnt, "");
		
		request.setAttribute("MovieList", movieList);
		
		RequestDispatcher rd = request.getRequestDispatcher("/movie/test1.jsp");
		rd.forward(request, response);
		
	}

	/**
	 * 영화 순위
	 * 
	 * @param request
	 * @param response
	 */
	public void rankingMovieList(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		List<Movie>movieList = MovieDAO.rankingMovieList();
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
		String mname = request.getParameter("movie_name");
		String genre = request.getParameter("movie_genre");
		String poster = request.getParameter("poster_name");
		String content = request.getParameter("movie_content");
		try {
			DateFormat formatter ; 
	        Date Sdate ;
	        Date Edate ;
	        formatter = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss");	
	        Sdate = (Date)formatter.parse(request.getParameter("movie_sdate")+"T00:00:00");
	        Edate = (Date)formatter.parse(request.getParameter("movie_edate")+"T00:00:00");
	        
	        Movie movie = new Movie();
			movie.setMname(mname);
			movie.setGenre(genre);
			movie.setPoster(poster);
			movie.setContent(content);
			movie.setLaunchDate(Sdate);
			movie.setEndDate(Edate);
			
			MovieDAO.addMovie(movie);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		RequestDispatcher rd = request.getRequestDispatcher("/MovieService?method=adminMovieList");
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
		String method = request.getParameter("method");
		request.setAttribute("method", method)
;		RequestDispatcher rd = request.getRequestDispatcher("/movie/addMovie.jsp");
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
		String mname = request.getParameter("movie_name");
		String genre = request.getParameter("movie_genre");
		String poster = request.getParameter("poster_name");
		String content = request.getParameter("movie_content");
		String gubun = request.getParameter("gubun");
		
		try {
			DateFormat formatter ; 
	        Date Sdate ;
	        Date Edate ;
	        formatter = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss");	
	        Sdate = (Date)formatter.parse(request.getParameter("movie_sdate")+"T00:00:00");
	        Edate = (Date)formatter.parse(request.getParameter("movie_edate")+"T00:00:00");
	        
	        Movie movie = new Movie();
	        movie.setMnum(mnum);
			movie.setMname(mname);
			movie.setLaunchDate(Sdate);
			movie.setGenre(genre);
			movie.setPoster(poster);
			movie.setEndDate(Edate);
			movie.setContent(content);
			
			MovieDAO.editMovie(movie);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("gubun", gubun);
		request.setAttribute("mnum", mnum);
		RequestDispatcher rd = request.getRequestDispatcher("/MovieService?method=adminMovie");
		rd.forward(request,  response);
		
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
		String method = request.getParameter("method");
		Movie movie = MovieDAO.selectMovie(mnum);
		
		request.setAttribute("Movie", movie);
		request.setAttribute("gubun", gubun);
		request.setAttribute("mnum", mnum);
		request.setAttribute("method", method);
		
		RequestDispatcher rd = request.getRequestDispatcher("/movie/addMovie.jsp");
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
		MovieDAO.removeMovie(mnum);
		
		request.setAttribute("gubun", gubun);
		
		RequestDispatcher rd = request.getRequestDispatcher("/MovieService?method=adminMovieList");
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
		String method = request.getParameter("method");
		String schCode = request.getParameter("schCode");
		String schString = request.getParameter("schString");
		List<Movie>movieList = null;
		String pageLink = null;
		String pageLinkTag=null;
		
		if(request.getParameter("page")!=null){
			page = Integer.parseInt(request.getParameter("page"));
		}
		movieList = MovieDAO.selectMovieListSearch(page, length, schCode, schString);
		movieCnt = MovieDAO.selectMovieListSearchCnt(schCode, schString);
		
		
		pageLink = "MovieService?method=searchMovieList&schCode="+schCode+"&schString="+schString;
		pageLinkTag = PageUtil.generate(page, movieCnt, length, pageLink);
		
		request.setAttribute("schCode",schCode);
		request.setAttribute("method", method);
		request.setAttribute("schString",schString);
		request.setAttribute("MovieList", movieList);
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
		String method = request.getParameter("method");
		
		if(request.getParameter("gubun")!=null){
			gubun = request.getParameter("gubun");
		}
		
		request.setAttribute("gubun", gubun);
		request.setAttribute("method", method);
		
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
		
		List<Movie>movieList = MovieDAO.selectMovieList(page, length, gubun);
		request.setAttribute("MovieList",movieList);

		int MovieCnt = MovieDAO.selectMovieCount(gubun);
		
		//System.out.println(pageLink);
		String pageLinkTag = PageUtil.generate(page, MovieCnt, length, pageLink);
		request.setAttribute("page_Link_Tag", pageLinkTag);
		
		RequestDispatcher rd = request.getRequestDispatcher("/movie/viewMovieList.jsp");
		rd.forward(request, response);
	}
}
