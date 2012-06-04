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
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.util.ServletContextAware;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.util.ServletContextAware;

import net.sf.json.JSONArray;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.util.ServletContextAware;

import com.opensymphony.xwork2.ModelDriven;

import kr.or.kosta.moviesystem.aop.IService;
import kr.or.kosta.moviesystem.member.Member;
import kr.or.kosta.moviesystem.screentime.ScreenTime;
import kr.or.kosta.moviesystem.screentime.ScreenTimeDAO;
import kr.or.kosta.moviesystem.util.PageUtil;

public class MovieService implements ModelDriven,ServletContextAware,ServletRequestAware,
ServletResponseAware,SessionAware,IService{
	private static final long serialVersionUID = 1L;
	private ServletContext servletContext;
	private HttpServletRequest request;
	private HttpServletResponse response;
	private Map session;
	private IMovieDAO movieDAO;
	private Movie movie = new Movie();
	private Movie MOVIE;
	private List<Movie> MOVIE_LIST;
	private List<Movie> SCREENMOVIE_LIST;
	private List<Movie> SCHEDULEMOVIE_LIST;
	private List<Movie> RANKINGMOVIE_LIST;
	private int page;
	private String gubun;
	private String method;
	private String PAGE_LINK_TAG;
	private String mnum;
	private String schCode;
	private String schString;
	private String movie_sdate;
	private String movie_edate;
	
	
	
	/* getter/setter 시작 */
	@Override
	public Map getSession() {
		// TODO Auto-generated method stub
		return session;
	}
	@Override
	public void setSession(Map<String, Object> session) {
		 this.session=session;		
		
	}

	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
	
	public HttpServletRequest getRequest() {
		return request;
	}

	public ServletContext getServletContext() {
		return servletContext;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}

	public Movie getMovie() {
		return movie;
	}
	

	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	
	public List<Movie> getMOVIE_LIST() {
		return MOVIE_LIST;
	}

	public void setMOVIE_LIST(List<Movie> mOVIE_LIST) {
		MOVIE_LIST = mOVIE_LIST;
	}

	public List<Movie> getSCREENMOVIE_LIST() {
		return SCREENMOVIE_LIST;
	}

	public void setSCREENMOVIE_LIST(List<Movie> sCREENMOVIE_LIST) {
		SCREENMOVIE_LIST = sCREENMOVIE_LIST;
	}
	
	public List<Movie> getSCHEDULEMOVIE_LIST() {
		return SCHEDULEMOVIE_LIST;
	}
	
	public void setSCHEDULEMOVIE_LIST(List<Movie> sCHEDULEMOVIE_LIST) {
		SCHEDULEMOVIE_LIST = sCHEDULEMOVIE_LIST;
	}

	public List<Movie> getRANKINGMOVIE_LIST() {
		return RANKINGMOVIE_LIST;
	}

	public void setRANKINGMOVIE_LIST(List<Movie> rANKINGMOVIE_LIST) {
		RANKINGMOVIE_LIST = rANKINGMOVIE_LIST;
	}
	
	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public String getGubun() {
		return gubun;
	}

	public void setGubun(String gubun) {
		this.gubun = gubun;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getPAGE_LINK_TAG() {
		return PAGE_LINK_TAG;
	}

	public void setPAGE_LINK_TAG(String pAGE_LINK_TAG) {
		PAGE_LINK_TAG = pAGE_LINK_TAG;
	}
	

	public String getMnum() {
		return mnum;
	}

	public void setMnum(String mnum) {
		this.mnum = mnum;
	}

	public Movie getMOVIE() {
		return MOVIE;
	}

	public void setMOVIE(Movie mOVIE) {
		MOVIE = mOVIE;
	}
	
	public String getSchCode() {
		return schCode;
	}

	public void setSchCode(String schCode) {
		this.schCode = schCode;
	}

	public String getSchString() {
		return schString;
	}

	public void setSchString(String schString) {
		this.schString = schString;
	}
	
	public String getMovie_sdate() {
		return movie_sdate;
	}

	public void setMovie_sdate(String movie_sdate) {
		this.movie_sdate = movie_sdate;
	}

	public String getMovie_edate() {
		return movie_edate;
	}

	public void setMovie_edate(String movie_edate) {
		this.movie_edate = movie_edate;
	}
	
	@Override
	public void setServletContext(ServletContext context) {
		this.servletContext=context;			
	}
	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return movie;
	}
	
	public MovieService(IMovieDAO movieDAO) {
		super();
		System.out.println("movieDAO확인");
		this.movieDAO = movieDAO;
	}

	public MovieService() {
        super();
        // TODO Auto-generated constructor stub
	}
	
	public String adminMovieListSch() throws Exception{
		int length = 5;
		int movieCnt = 0;
		String pageLink = null;
		if(page==0){
			page = 1;
		}
		if(method=="" || method == null){
			method = "adminMovieList";
		}
		
		MOVIE_LIST = movieDAO.selectMovieListSearch(page, length, schCode, schString);
		movieCnt = movieDAO.selectMovieListSearchCnt(schCode, schString);
		
		
		pageLink = "adminMovieListSch.action?schCode="+schCode+"&schString="+schString;
		PAGE_LINK_TAG = PageUtil.generate(page, movieCnt, length, pageLink);
		
		return "success";
	}
	
	public String searchMovieList() throws Exception{
		/* default generated stub */;
		int length = 5;
		if(page==0){
			page = 1;
		}
		int movieCnt = 0;
		
		String pageLink = null;
		
		MOVIE_LIST = movieDAO.selectMovieListSearch(page, length, schCode, schString);
		movieCnt = movieDAO.selectMovieListSearchCnt(schCode, schString);
		
		
		pageLink = "searchMovieList.action?schCode="+schCode+"&schString="+schString;
		PAGE_LINK_TAG = PageUtil.generate(page, movieCnt, length, pageLink);
		
		return "success";
	}
	
	public String editMovieForm() throws Exception{
		if(gubun==null || gubun==""){
			gubun = "total";
		}
		
		movie = movieDAO.selectMovie(mnum);
		
		return "success";
	}
	
	public String addMovieForm() throws Exception{
		return "success";
	}
	
	public String adminMovie() throws Exception{
		if(gubun==null || gubun==""){
			gubun = "total";
		}
		
		movie = movieDAO.selectMovie(mnum);
		return "success";
	}
	
	public String adminRankingList() throws Exception{
		MOVIE_LIST = movieDAO.rankingMovieList();
		if(method==null || method==""){
			method = "adminRankingList";
		}	
		String pageLinkTag=null;
		return "success";
	}
	
	public String adminMovieList() throws Exception{
		int length = 5;
		//HttpSession session=request.getSession();
		//Member member=(Member)session.getAttribute("LOGIN_MEMBER");
		Member member=(Member)session.get("LOGIN_MEMBER");
		//session.put("LOGIN_MEMBER", member);
		//System.out.println("MEMBER:"+member);
		
		if(page==0){
			page = 1;
		}
		if(gubun=="" || gubun==null){
			gubun = "total";
		}
		
		if(method==null || method==""){
			method = "adminMovieList";
		}
		//System.out.println("Session : "+(Member)session.get("LOGIN_MEMBER"));
		String pageLink = "adminMovieList.action?gubun="+gubun;
		
		MOVIE_LIST =movieDAO.selectMovieList(page, length, gubun);
		
		int MovieCnt = movieDAO.selectMovieCount(gubun);
		
		//System.out.println(pageLink);
		PAGE_LINK_TAG = PageUtil.generate(page, MovieCnt, length, pageLink);
		
		return "success";
	}
	
	public String viewMovie() throws Exception {
		if(gubun==null || gubun==""){
			gubun = "total";
		}
		System.out.println(mnum);
		MOVIE = movieDAO.selectMovie(mnum);
		return "success";
	}
	
	public String rankingMovieList() throws Exception {
		MOVIE_LIST = movieDAO.rankingMovieList();
		return "success";		
	}
	
	public String viewMovieList() throws Exception {
		int length = 5;
		String pageLink = "viewMovieList.action?gubun="+gubun;
		if(page==0){
			page = 1;
		}
		if(gubun=="" || gubun==null){
			gubun = "total";
		}
		if(method=="" || method==null){
			method = "viewMovieList";
		}
		
		int MovieCnt = movieDAO.selectMovieCount(gubun);
		
		MOVIE_LIST = movieDAO.selectMovieList(page, length, gubun);
				
		//System.out.println(pageLink);
		PAGE_LINK_TAG = PageUtil.generate(page, MovieCnt, length, pageLink);
		
		return "success";
	}
	
	public String main() throws Exception{
		SCREENMOVIE_LIST = movieDAO.selectMovieList(1, 3, "screen");
		SCHEDULEMOVIE_LIST = movieDAO.selectMovieList(1, 3, "schedule");
		RANKINGMOVIE_LIST = movieDAO.rankingMovieList();
		return "success";
	}

	private void MovieTimeList() throws Exception{
		/*
		SCREENMOVIE_LIST = ScreenTimeDAO.selectScreen(mnum);

		JSONArray jsonArray = JSONArray.fromObject(SCREENMOVIE_LIST);

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println(jsonArray.toString());
		out.flush();
		out.close();
		*/
	}

	private void MovieTimeListForm(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException{
		
		int Moviecnt = movieDAO.selectMovieCount("");
		List<Movie> movieList = movieDAO.selectMovieList(1, Moviecnt, "");
		
		request.setAttribute("MovieList", movieList);
		
		RequestDispatcher rd = request.getRequestDispatcher("/movie/test1.jsp");
		rd.forward(request, response);
		
	}

	/**
	 * 영화 추가
	 * 
	 * @param request
	 * @param response
	 */
	public String addMovie() throws Exception{
		try {
			
			DateFormat formatter ; 
	        Date Sdate ;
	        Date Edate ;
	        formatter = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss");	
	        Sdate = (Date)formatter.parse(movie_sdate+"T00:00:00");
	        Edate = (Date)formatter.parse(movie_edate+"T00:00:00");
	        
	        Movie movie = new Movie();
			movie.setLaunchDate(Sdate);
			movie.setEndDate(Edate);
			
			movieDAO.addMovie(movie);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "success";
	}

	/**
	 * 영화를 수정
	 * 
	 * @param request
	 * @param response
	 */
	public String editMovie() throws Exception{		
		try {
			DateFormat formatter ; 
	        Date Sdate ;
	        Date Edate ;
	        formatter = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss");	
	        Sdate = (Date)formatter.parse(movie_sdate+"T00:00:00");
	        Edate = (Date)formatter.parse(movie_edate+"T00:00:00");
	        
			movie.setLaunchDate(Sdate);
			movie.setEndDate(Edate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//movie.setPoster("");
		System.out.println("movie : "+movie);
		movieDAO.editMovie(movie);
		return "success";		
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
		movieDAO.removeMovie(mnum);
		
		request.setAttribute("gubun", gubun);
		
		RequestDispatcher rd = request.getRequestDispatcher("/MovieService?method=adminMovieList");
		rd.forward(request, response);
	}	
}
