package kr.or.kosta.moviesystem.screentime;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.util.ServletContextAware;

import kr.or.kosta.moviesystem.aop.IService;
import kr.or.kosta.moviesystem.member.Member;
import kr.or.kosta.moviesystem.movie.IMovieDAO;
import kr.or.kosta.moviesystem.movie.Movie;

import com.opensymphony.xwork2.ModelDriven;

/**
 * Servlet implementation class ScreenTimeService
 */
public class ScreenTimeService implements ModelDriven,ServletContextAware,ServletRequestAware,
ServletResponseAware,SessionAware,IService{
	private static final long serialVersionUID = 1L;
	private List<ScreenTime> SCREENTIME_LIST ;
	private String mnum;
	private String mname;
	private Map session; 
	private Member member=new Member();
	private IScreenTimeDAO screentimeDAO;
	private ScreenTime screentime = new ScreenTime();
	
	private ServletContext servletContext;
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	
	
	
	@Override
	public Map getSession() {
		return session;
	}
	
	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return screentime;
	}
	
	@Override
	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		this.session=session;	
	}

	@Override
	public void setServletResponse(HttpServletResponse response) {
		// TODO Auto-generated method stub
		this.response = response;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.request = request;
	}
	
	public HttpServletRequest getRequest() {
		return request;
	}
	public ServletContext getServletContext() {
		return servletContext;
	}
	
	@Override
	public void setServletContext(ServletContext context) {
		// TODO Auto-generated method stub
		this.servletContext=context;	
	}
  
	
	
    public Member getMember() {
		return member;
	}



	public void setMember(Member member) {
		this.member = member;
	}


	public String getMname() {
		return mname;
	}



	public void setMname(String mname) {
		this.mname = mname;
	}



	public List<ScreenTime> getSCREENTIME_LIST() {
		return SCREENTIME_LIST;
	}



	public void setSCREENTIME_LIST(List<ScreenTime> sCREENTIME_LIST) {
		SCREENTIME_LIST = sCREENTIME_LIST;
	}



	public String getMnum() {
		return mnum;
	}

	public void setMnum(String mnum) {
		this.mnum = mnum;
	}

	
	public ScreenTimeService() {
        super();
        // TODO Auto-generated constructor stub
    }
	public ScreenTimeService(IScreenTimeDAO screentimeDAO) {
		super();
		//System.out.println("movieDAO확인");
		this.screentimeDAO = screentimeDAO;
	}
	
    public String viewScreenTimeListBymnum() throws Exception {
    	System.out.println("viewScreenTimeListBymnum실행 ");
    	System.out.println("영화를 선택해서 해당 영화의 시간을 보여주기 위한 곳");
		System.out.println("mnum==== "+mnum+"==");
		
//		Member member=new Member();
		member.setUserid("1");
		session.put("LOGIN_MEMBER",member);
		SCREENTIME_LIST=screentimeDAO.selectScreen(mnum);
		ScreenTime SCREEN_LIST_MNAME ;
		SCREEN_LIST_MNAME=SCREENTIME_LIST.get(0);
		mname=SCREEN_LIST_MNAME.getMovie().getMname();
		System.out.println("SCREENTIME_LIST= "+SCREENTIME_LIST);
		System.out.println("viewScreenTimeListBymnum종료 ");
		return "success";

	}

	
}