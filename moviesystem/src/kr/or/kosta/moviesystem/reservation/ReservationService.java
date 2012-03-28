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
		request.setCharacterEncoding("utf-8");//�츮�� utf-8�� ����Ѵ�.
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
				int MovieTotalCnt = MovieDAO.selectMovieCount("");
				//1.��ü��ȭ ����Ʈ ��ȸ
				ArrayList<Movie>movieList=MovieDAO.selectMovieList(1,MovieTotalCnt, "");
				//2.request�� ����
				request.setAttribute("MOVIE_LIST",movieList);
				//3.�л��߰� ������ �̵� ��ü ����
				RequestDispatcher rd=request.getRequestDispatcher(
						"/reservation/addReservation.jsp");
				//������ �̵�
				rd.forward(request, response);
		
	}

	private void addReservation(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String userid=request.getParameter("userid");
		
	}

	private void Test(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		RequestDispatcher rd=request.getRequestDispatcher(
				"/reservation/test.jsp");
		Member member=new Member();
		member.setUserid("jun123");
		
		request.setAttribute("member",member);
				//4.JSP�� ������ �̵�
				rd.forward(request, response);
		
	}
	
	private void viewReservationListById(HttpServletRequest request,
			HttpServletResponse response) throws IOException,ServletException{
		//�⺻ ������1
		//int page=1;
		//������ �Ķ���Ͱ� ����
//		if(request.getParameter("page")!=null){
//			//�Ķ���� ����
//			page=Integer.parseInt(request.getParameter("page"));
//		}
		//���������� ������ �л���
//		int length=5;
		String userid=request.getParameter("userid");
		System.out.println(userid);
		//1.StudentDAO���� �������� �ش��ϴ� �л���ȸ �޼��� ȣ��
		ArrayList<Reservation>reservationList=ReservationDAO.selectReservationList(userid);
		//2.request�� 1�� page�� �ش��ϴ� �л� ���� ����
		request.setAttribute("RESERVATION_LIST",reservationList);
		System.out.println("����");
		
		//�������� �ش��ϴ� �л��� ��ȸ
		//int studentCount=StudentDAO.selectStudentCount();
		//�ٸ��������� �̵��ϴ� ��ũ�ױ� ����
		//PageUtil.generate(����������,��ü�Ǽ�,���������纸����row��,�ּ�)
		//String pageLinkTag=PageUtil.generate(page, studentCount, length, "StudentService?method=viewStudentList");
		//request.setAttribute("PAGE_LINK_TAG",pageLinkTag);
		
		//3./student/viewStudentList.jsp�� ������ �̵� ��ü ����
		RequestDispatcher rd=request.getRequestDispatcher(
		"/reservation/viewReservationListByid.jsp");
		//4.JSP�� ������ �̵�
		rd.forward(request, response);
		
	}

	

}
