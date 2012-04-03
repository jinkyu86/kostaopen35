package kr.or.kosta.moviesystem.reservation;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;

import kr.or.kosta.moviesystem.member.Member;
import kr.or.kosta.moviesystem.movie.Movie;
import kr.or.kosta.moviesystem.movie.MovieDAO;
import kr.or.kosta.moviesystem.screentime.ScreenTime;
import kr.or.kosta.moviesystem.screentime.ScreenTimeDAO;
import kr.or.kosta.moviesystem.util.PageUtil;



/**
 * Servlet implementation class StudentService
 */
public class ReservationService extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReservationService() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");//우리는 utf-8로 사용한다.
				
		String method=request.getParameter("method");
		if(method==null){
			method="test";
		}
		System.out.println(method);
		if("test".equals(method)){
			test(request,response);
		}else if("viewReservationListById".equals(method)){
			viewReservationListById(request,response);
		}else if("addReservation".equals(method)){
			addReservation(request,response);
		}else if("addReservationForm".equals(method)){
			addReservationForm(request,response);
		}else if("MovieTimeList".equals(method)){
			MovieTimeList(request, response);
		}else if("viewReservationByResNum".equals(method)){
			viewReservationByResNum(request,response);
		}else if("viewReservationByResNumForm".equals(method)){
			viewReservationByResNumForm(request,response);
		}else if("viewCancelByResNum".equals(method)){
			viewCancelByResNum(request,response);
		}else if("addReservationByTimeForm".equals(method)){
			addReservationByTimeForm(request,response);
		}

		
		
		
		//		else if("viewScreenTimeListBymnum".equals(method)){
//			viewScreenTimeListBymnum(request,response);
//		}

	}//end method doPost





	private void viewCancelByResNum(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException{
		String resnum = request.getParameter("resnum");	
		Reservation reservation= new Reservation();
		ReservationDAO.cancelReservation(resnum);
		RequestDispatcher rd=request.getRequestDispatcher(
				"/reservation/test.jsp");
				//4.JSP로 페이지 이동
				rd.forward(request, response);
		
		
	}

	private void viewReservationByResNumForm(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		String resnum = request.getParameter("resnum");
		String select = request.getParameter("select");
//		Reservation reservation= new Reservation();
//		reservation.setResnum(resnum);
		request.setAttribute("select", select);
		request.setAttribute("resnum",resnum);
		if(select.equals("1")){
			RequestDispatcher rd=request.getRequestDispatcher(
					"/reservation/payment.jsp");
					//4.JSP로 페이지 이동
					rd.forward(request, response);
		}else{
			RequestDispatcher rd=request.getRequestDispatcher(
					"/reservation/cancel.jsp");
					//4.JSP로 페이지 이동
					rd.forward(request, response);
		}

	}

	private static void viewReservationByResNum(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		String resnum = request.getParameter("resnum");	
		Reservation reservation= new Reservation();
		ReservationDAO.removeReservation(resnum);
		RequestDispatcher rd=request.getRequestDispatcher(
				"/reservation/test.jsp");
				//4.JSP로 페이지 이동
				rd.forward(request, response);
		
	}

	private void MovieTimeList(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException{
		String mnum = request.getParameter("mnum");
		System.out.println(mnum);
		
		ArrayList<ScreenTime> screenTimeList = ScreenTimeDAO.selectScreen(mnum);
		System.out.println(screenTimeList);
		JSONArray jsonArray = JSONArray.fromObject(screenTimeList);
		System.out.println("jsonArray : "+jsonArray);
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println(jsonArray.toString());
		out.flush();
		out.close();
	}
	
	private void addReservationByTimeForm(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
			HttpSession session=request.getSession();
			Member member=(Member)session.getAttribute("member");
			String userid=member.getUserid();
			String time=request.getParameter("time");
			String scrnum=request.getParameter("scrnum");
			String mnum=request.getParameter("mnum");
			String mname=request.getParameter("mname");
			System.out.println("(member) = "+member);
			System.out.println("(mnum) = "+mnum);
			System.out.println("(scrnum) = "+scrnum);
			System.out.println("(mname) = "+mname);
			request.setAttribute("time",time);
			request.setAttribute("mname", mname);
			request.setAttribute("userid",userid);
			request.setAttribute("scrnum",scrnum);
			System.out.println("mnum"+mnum);
			request.setAttribute("mnum",mnum);
			RequestDispatcher rd=request.getRequestDispatcher(
					"/reservation/addReservationByTime.jsp");
			//페이지 이동
			rd.forward(request, response);
			
	}
	
	
	private void addReservationForm(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
//				Member member=new Member();
//				member.setUserid("jun123");
//				String userid=request.getParameter("userid");
				HttpSession session=request.getSession();
				Member member=(Member)session.getAttribute("member");
				String userid=member.getUserid();
				request.setAttribute("userid",userid);
				
				int MovieTotalCnt = MovieDAO.selectMovieCount("");
				//1.전체영화 리스트 조회
				ArrayList<Movie>movieList=MovieDAO.selectMovieList(1,MovieTotalCnt, "");
				//2.request에 저장
				request.setAttribute("MOVIE_LIST",movieList);
				//3.학생추가 페이지 이동 객체 생성
				RequestDispatcher rd=request.getRequestDispatcher(
						"/reservation/addReservation.jsp");
				//페이지 이동
				rd.forward(request, response);
		
	}

	private void addReservation(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//파라미터 정보를 리턴
		HttpSession session=request.getSession();
		Member member=(Member)session.getAttribute("member");
		String userid=member.getUserid();
		String mnum=request.getParameter("mnum");
		String scrnum=request.getParameter("scrnum");
		String resQty1=request.getParameter("resQty");
		long resQty=Integer.parseInt(resQty1);
		
		
		//Reservation에 정보저장
		System.out.println("아이디 "+userid+" 영화번호"+mnum+" 상형관번호"+scrnum+" 수량"+resQty);
		Reservation reservation=new Reservation();
		member =new Member();
		Movie movie =new Movie();
		ScreenTime screenTime = new ScreenTime();
		member.setUserid(userid);//id
		reservation.setMember(member);
		movie.setMnum(mnum);//영화번호
		reservation.setMovie(movie);
		screenTime.setScrnum(scrnum);//상영번호
		reservation.setScreenTime(screenTime);
		reservation.setResQty(resQty);//좌석수
		
		
		
			//ReservationDAO reservationDAO=new ReservationDAO();
			//내가보는 영화중 가장 최근에 예약한 예약번호를 알아낸후
			String rnum= ReservationDAO.selectReservationResNum(scrnum);
			System.out.println(rnum);
			
			//그 예약번호의 첫번째 좌석과 좌석수를 얻어와서
	    if(rnum==null){
	    	reservation.setSeatnum(1);
			reservation.setTotalPrice(resQty*8000);
	    }else{
	    	long resnum=Integer.parseInt(rnum);
	    	long snum= ReservationDAO.selectReservationSeatNum(resnum);
			long qty= ReservationDAO.selectReservationQty(resnum);
			System.out.println("rnum"+rnum+"snum="+snum+" qty="+qty);
			//지금 예매하는 사람의 좌석을 지정해준다.
			reservation.setSeatnum(snum+qty);
			reservation.setTotalPrice(resQty*8000);
	    }

			
		
		
		
		//DB저장
		ReservationDAO.insertReservation(reservation);
		//test.jsp로 이동
		RequestDispatcher rd=
				request.getRequestDispatcher(
						"/ReservationService?method=viewReservationListById");
		rd.forward(request, response);
		
		
		
	}

	private void test(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		RequestDispatcher rd=request.getRequestDispatcher(
				"/reservation/test.jsp");
		
	
		Member member=new Member();
		member.setUserid("jun123");
		
		HttpSession session=request.getSession();
		session.setAttribute("member",member);
		
		Movie movie=new Movie();
		movie.setMnum("1");
		request.setAttribute("movie",movie);
		
//		request.setAttribute("member",member);
				//4.JSP로 페이지 이동
				rd.forward(request, response);
		
	}
	
	
	
//	private void viewScreenTimeListBymnum(HttpServletRequest request,
//			HttpServletResponse response) throws ServletException, IOException {
//		String mnum = request.getParameter("mnum");
//		System.out.println("mnum= "+mnum);
//		ArrayList<ScreenTime>screenTimeList=ScreenTimeDAO.selectScreen(mnum);
//		request.setAttribute("SCREENTIME_LIST",screenTimeList);
//		System.out.println("screenTimeList = "+screenTimeList);
//		
//		RequestDispatcher rd=request.getRequestDispatcher(
//		"/reservation/viewScreenTimeListBymnum.jsp");
//		//4.JSP로 페이지 이동
//		rd.forward(request, response);
//		
//		
//	}
	
	private void viewReservationListById(HttpServletRequest request,
			HttpServletResponse response) throws IOException,ServletException{
		//기본 페이지1
		int page=1;
		//페이지 파라메터가 존재
		if(request.getParameter("page")!=null){
			//파라메터 리턴
			page=Integer.parseInt(request.getParameter("page"));
		}
//		한페이지당 보여줄 학생수
		int length=5;
		//String userid=request.getParameter("userid");
		//System.out.println(userid);
		HttpSession session=request.getSession();
		Member member=(Member)session.getAttribute("member");
		String userid=member.getUserid();
		//1.StudentDAO에서 페이지에 해당하는 학생조회 메서들 호출
		ArrayList<Reservation>reservationList=ReservationDAO.selectReservationList(length,page,userid);
		//2.request에 1의 page에 해당하는 학생 정보 저장
		request.setAttribute("RESERVATION_LIST",reservationList);
		System.out.println("성공");
		
		//페이지에 해당하는 학생수 조회
		int reservationCount=ReservationDAO.selectReservationCount(userid);
		System.out.println("reservationCount"+reservationCount);
		//다른페이지로 이동하는 링크테그 만듬
//		PageUtil.generate(현제페이지,전체건수,한페이지당보여줄row수,주소)
		String pageLinkTag=PageUtil.generate(page, reservationCount, length, "ReservationService?method=viewReservationListById");
		request.setAttribute("PAGE_LINK_TAG",pageLinkTag);
		
		//3./student/viewStudentList.jsp로 페이지 이동 객체 생성
		RequestDispatcher rd=request.getRequestDispatcher(
		"/reservation/viewReservationListByid.jsp");
		//4.JSP로 페이지 이동
		rd.forward(request, response);
		
	}

	

}
