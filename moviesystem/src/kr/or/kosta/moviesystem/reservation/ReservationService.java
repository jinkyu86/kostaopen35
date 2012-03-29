package kr.or.kosta.moviesystem.reservation;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import kr.or.kosta.moviesystem.member.Member;
import kr.or.kosta.moviesystem.movie.Movie;
import kr.or.kosta.moviesystem.movie.MovieDAO;
import kr.or.kosta.moviesystem.screentime.ScreenTime;



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
			Test(request,response);
		}else if("viewReservationListById".equals(method)){
			viewReservationListById(request,response);
		}else if("addReservation".equals(method)){
			addReservation(request,response);
		}else if("addReservationForm".equals(method)){
			addReservationForm(request,response);
		}
		
		
		
	}//end method doPost

	private void addReservationForm(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
//				Member member=new Member();
//				member.setUserid("jun123");
				String userid=request.getParameter("userid");
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
		String userid=request.getParameter("userid");
		String mnum=request.getParameter("mname");
		String scrnum=request.getParameter("time");
		String resQty1=request.getParameter("resQty");
		long resQty=Integer.parseInt(resQty1);
		
		
		//Reservation에 정보저장
		System.out.println(userid+""+mnum+""+scrnum+""+resQty);
		Reservation reservation=new Reservation();
		Member member =new Member();
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
		long rnum= ReservationDAO.selectReservationResNum(scrnum);
		//그 예약번호의 첫번째 좌석과 좌석수를 얻어와서
		long snum= ReservationDAO.selectReservationSeatNum(rnum);
		long qty= ReservationDAO.selectReservationQty(rnum);
		System.out.println("rnum"+rnum+"snum="+snum+" qty="+qty);
		//지금 예매하는 사람의 좌석을 지정해준다.
		reservation.setSeatnum(snum+qty);
		reservation.setTotalPrice(resQty*8000);
		//DB저장
		ReservationDAO.insertReservation(reservation);
		//test.jsp로 이동
		RequestDispatcher rd=
				request.getRequestDispatcher(
						"/ReservationService?method=test");
		rd.forward(request, response);
		
		
		
	}

	private void Test(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		RequestDispatcher rd=request.getRequestDispatcher(
				"/reservation/test.jsp");
		Member member=new Member();
		member.setUserid("jun123");
		
		request.setAttribute("member",member);
				//4.JSP로 페이지 이동
				rd.forward(request, response);
		
	}
	
	private void viewReservationListById(HttpServletRequest request,
			HttpServletResponse response) throws IOException,ServletException{
		//기본 페이지1
		//int page=1;
		//페이지 파라메터가 존재
//		if(request.getParameter("page")!=null){
//			//파라메터 리턴
//			page=Integer.parseInt(request.getParameter("page"));
//		}
		//한페이지당 보여줄 학생수
//		int length=5;
		String userid=request.getParameter("userid");
		System.out.println(userid);
		//1.StudentDAO에서 페이지에 해당하는 학생조회 메서들 호출
		ArrayList<Reservation>reservationList=ReservationDAO.selectReservationList(userid);
		//2.request에 1의 page에 해당하는 학생 정보 저장
		request.setAttribute("RESERVATION_LIST",reservationList);
		System.out.println("성공");
		
		//페이지에 해당하는 학생수 조회
		//int studentCount=StudentDAO.selectStudentCount();
		//다른페이지로 이동하는 링크테그 만듬
		//PageUtil.generate(현제페이지,전체건수,한페이지당보여줄row수,주소)
		//String pageLinkTag=PageUtil.generate(page, studentCount, length, "StudentService?method=viewStudentList");
		//request.setAttribute("PAGE_LINK_TAG",pageLinkTag);
		
		//3./student/viewStudentList.jsp로 페이지 이동 객체 생성
		RequestDispatcher rd=request.getRequestDispatcher(
		"/reservation/viewReservationListByid.jsp");
		//4.JSP로 페이지 이동
		rd.forward(request, response);
		
	}

	

}
