package kr.or.kosta.moviesystem.reservation;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

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
		request.setCharacterEncoding("utf-8");//�츮�� utf-8�� ����Ѵ�.
				
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
		}else if("viewSeatListByScrnum".equals(method)){
			viewSeatListByScrnum(request,response);
		}else if("SelectSeat".equals(method)){
			SelectSeat(request,response);
		}else if("InsertReservation".equals(method)){
			InsertReservation(request,response);
		}else if("viewReservationTimeForm".equals(method)){
			viewReservationTimeForm(request,response);
		}else if("viewReservationSeat".equals(method)){
			viewReservationSeat(request,response);
		}
		
		
		//		else if("viewScreenTimeListBymnum".equals(method)){
//			viewScreenTimeListBymnum(request,response);
//		}

	}//end method doPost








private void viewReservationSeat(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String time=request.getParameter("time");
		ScreenTime screenTime = new ScreenTime();
		screenTime=ScreenTimeDAO.selectScreenTimeScrNum(time);
		String scrnum=screenTime.getScrnum();
		System.out.println("scrnum= "+scrnum);
		//Reservation reservation=new Reservation();
		
		HttpSession session=request.getSession();
		Member member=(Member)session.getAttribute("LOGIN_MEMBER");
		String userid=member.getUserid();
		//id�� scrnum�� ��ȸ�ؼ� �¼��� �˾Ƴ���.		
		List<Reservation> reservationList=ReservationDAO.selectSeatNumByScrnumAndUserid(scrnum,userid);
		
		request.setAttribute("reservationList",reservationList);
		System.out.println("reservationList = "+reservationList);

		RequestDispatcher rd=request.getRequestDispatcher(
				"/reservation/viewSeatList.jsp");
				//4.JSP�� ������ �̵�
				rd.forward(request, response);
		
		
		
	}

//	private void SelectSeat(HttpServletRequest request,
//			HttpServletResponse response) throws ServletException, IOException {
//		String count=request.getParameter("count");
//		String seat=request.getParameter("seat");
//		int num1= Integer.parseInt(count);
//		int seatnum=Integer.parseInt(seat);
//		System.out.println("count="+count);
//		System.out.println("seatnum1="+request.getParameter("seatnum1"));
//		
//		
//		if(num1==1){
//			String seatnum1=request.getParameter("seatnum1");
//		//	int seatnum1_1=Integer.parseInt(seatnum1);
//			System.out.println("������ �¼� ��ȣ�� "+seatnum1+","+seatnum);
//			
//		}else {
//			String scrnum="4";
//			int num;
//			ArrayList<Integer>TotalSeatList=new ArrayList<Integer>();
//			ArrayList<Integer>SelectSeatList=new ArrayList<Integer>();
//			SelectSeatList=ReservationDAO.selectSeatNumByScrnum(scrnum);
//			TotalSeatList=ReservationDAO.selectTotalList();
//				for(int i=0;i<SelectSeatList.size();i++){
//					num=SelectSeatList.get(i);
//					TotalSeatList.set(num-1, 1);
//				}
//			
//			TotalSeatList.set(seatnum-1, 2);
//			request.setAttribute("seatnum1", seat);
//			request.setAttribute("TotalSeatList", TotalSeatList);
//			request.setAttribute("count",1);
//			request.setAttribute("seatnum",seatnum);
//			RequestDispatcher rd=request.getRequestDispatcher(
//					"/reservation/viewSeatListByScrnum.jsp");
//					//4.JSP�� ������ �̵�
//					rd.forward(request, response);
//			
//		}
//		
//		
//	}
	
	private void SelectSeat(HttpServletRequest request,
	HttpServletResponse response) throws ServletException, IOException {
		
		String seatString=request.getParameter("seat");
		HttpSession session=request.getSession();
		String countString=(String)session.getAttribute("COUNT");
		int count=Integer.parseInt(countString);
		int seat=Integer.parseInt(seatString);
		Reservation reservation=(Reservation)session.getAttribute("RESERVATION");
		ArrayList<Integer> SeatNumList=(ArrayList<Integer>)session.getAttribute("SeatNumList");
		String scrnum=reservation.getScreenTime().getScrnum();
		
		
		
		System.out.println("seat="+seat+"count="+count+"scrnum="+scrnum);
		
		List<Integer>TotalSeatList=new ArrayList<Integer>();
		SeatNumList.add(seat);
		
		if(count>1){
			TotalSeatList=ReservationDAO.selectTotalList(scrnum);	
			
			for(int i=0;i<SeatNumList.size();i++){
//				TotalSeatList.set(seat-1, 1);
				TotalSeatList.set(SeatNumList.get(i)-1, 1);
			}
			
			
			request.setAttribute("TotalSeatList",TotalSeatList);
			
			session=request.getSession();
			session.setAttribute("COUNT",count-1+"");
			session.setAttribute("SeatNumList", SeatNumList);
//			session.setAttribute("seatnum"+count, seat+"");
			
			
			RequestDispatcher rd=request.getRequestDispatcher(
					"/reservation/viewSeatListByScrnum.jsp");
					//4.JSP�� ������ �̵�
					rd.forward(request, response);
		}else{
			System.out.println("����");
			System.out.println("seat="+seat+"count="+count+"scrnum="+scrnum);
			System.out.println("reservation"+reservation);
			//session.setAttribute("SeatNumList", SeatNumList);
			session.setAttribute("reservation",reservation);
			RequestDispatcher rd=request.getRequestDispatcher(
					"/reservation/pay.jsp");
					//4.JSP�� ������ �̵�
					rd.forward(request, response);
					
		}



}

	private void viewSeatListByScrnum(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		Reservation reservation=new Reservation();
		Movie movie=new Movie();
		ScreenTime screenTime = new ScreenTime();
		String mnum = request.getParameter("mnum");
		String scrnum= request.getParameter("scrnum");
		String resQty=request.getParameter("resQty");
		movie=MovieDAO.selectMovie(mnum);
		screenTime=ScreenTimeDAO.selectScreenTimeBySrcNum(scrnum);
		
		System.out.println("mnum="+mnum+"scrnum="+scrnum+"resQty="+resQty);


		
		screenTime.setScrnum(scrnum);
		reservation.setMovie(movie);
		reservation.setScreenTime(screenTime);
		reservation.setResQty(Integer.parseInt(resQty));
		reservation.setTotalPrice(Integer.parseInt(resQty)*8000);
		
		List<Integer>TotalSeatList=new ArrayList<Integer>();
		ArrayList<Integer>SeatNumList=new ArrayList<Integer>();
		
		
		HttpSession session=request.getSession();
		session.setAttribute("RESERVATION",reservation);
		session.setAttribute("COUNT",resQty);
		session.setAttribute("SeatNumList", SeatNumList);

		System.out.println("reservation="+reservation);
		System.out.println("SeatNumList="+SeatNumList);
		TotalSeatList=ReservationDAO.selectTotalList(scrnum);

		request.setAttribute("TotalSeatList",TotalSeatList);

		RequestDispatcher rd=request.getRequestDispatcher(
				"/reservation/viewSeatListByScrnum.jsp");
				//4.JSP�� ������ �̵�
				rd.forward(request, response);
		
	}

	private void viewCancelByResNum(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException{
		String resnum = request.getParameter("resnum");	
		Reservation reservation= new Reservation();
		ReservationDAO.cancelReservation(resnum);
		RequestDispatcher rd=
				request.getRequestDispatcher(
						"/ReservationService?method=viewReservationListById");
		rd.forward(request, response);

		
	}

	private void viewReservationByResNumForm(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		String resnum = request.getParameter("resnum");
		String select = request.getParameter("select");
	    Reservation reservation= new Reservation();
	   
	    reservation = ReservationDAO.selectReservation(resnum);
//		Reservation reservation= new Reservation();
//		reservation.setResnum(resnum);
		request.setAttribute("select", select);
		request.setAttribute("resnum",resnum);
		 System.out.println("resnum"+resnum);
		System.out.println("reservation"+reservation);
		request.setAttribute("reservation",reservation);
		
		long finalSeatNum=reservation.getSeatnum()+(reservation.getResQty()-1);
		
		String finalSeat = null;
		
//		if(reservation.getResQty()==1){
//			finalSeat="";
//		}else {
//			finalSeat="~"+finalSeatNum;
//		}
		
		request.setAttribute("finalSeatNum",finalSeat);
		if(select.equals("1")){
			RequestDispatcher rd=request.getRequestDispatcher(
					"/reservation/payment.jsp");
					//4.JSP�� ������ �̵�
					rd.forward(request, response);
		}else	if(select.equals("2")){
			RequestDispatcher rd=request.getRequestDispatcher(
					"/reservation/cancel.jsp");
					//4.JSP�� ������ �̵�
					rd.forward(request, response);
		}else{
			RequestDispatcher rd=request.getRequestDispatcher(
					"/reservation/viewReservationByResnum.jsp");
					//4.JSP�� ������ �̵�
					rd.forward(request, response);
		}

	}
	
	private void viewReservationTimeForm(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		String mname = request.getParameter("mname");
		HttpSession session=request.getSession();
		Member member=(Member)session.getAttribute("LOGIN_MEMBER");
		String userid=member.getUserid();
	    Movie movie= new Movie();
	    Reservation reservation= new Reservation();
	    movie = MovieDAO.selectMovieNum(mname);
	    String mnum=movie.getMnum();
//		request.setAttribute("mname",mname);
	    //userid�� mnom���� group by time ���� �� ������ time sum(total_price) count(res_qty)
	    List<Reservation>reservationList = ReservationDAO.selectReservationTime(userid,mnum);
		request.setAttribute("reservationList",reservationList);
		RequestDispatcher rd=request.getRequestDispatcher(
					"/reservation/viewReservationTime.jsp");
					//4.JSP�� ������ �̵�
					rd.forward(request, response);
	}

	private static void viewReservationByResNum(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		String resnum = request.getParameter("resnum");	
		Reservation reservation= new Reservation();
		ReservationDAO.removeReservation(resnum);
		
		RequestDispatcher rd=
				request.getRequestDispatcher(
						"/ReservationService?method=viewReservationListById");
		rd.forward(request, response);
		
//		RequestDispatcher rd=request.getRequestDispatcher(
//				"/reservation/test.jsp");
//				//4.JSP�� ������ �̵�
//				rd.forward(request, response);
		
	}

	private void MovieTimeList(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException{
		String mnum = request.getParameter("mnum");
		System.out.println(mnum);
		
		List<ScreenTime> screenTimeList = ScreenTimeDAO.selectScreen(mnum);
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
			Member member=(Member)session.getAttribute("LOGIN_MEMBER");
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
			//������ �̵�
			rd.forward(request, response);
			
	}
	
	
	private void addReservationForm(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
//				Member member=new Member();
//				member.setUserid("jun123");
//				String userid=request.getParameter("userid");
				HttpSession session=request.getSession();
				Member member=(Member)session.getAttribute("LOGIN_MEMBER");
				String userid="";
				
				//userid �� null�̸� Exception�߻��ϴ� �װ� ����
				try{
					userid=member.getUserid();
				}catch(NullPointerException e){
					//userid="";
				}
				
				
				if(userid.equals("")){
					RequestDispatcher rd=
							request.getRequestDispatcher(
									"/MemberService?method=loginForm");
					rd.forward(request, response);
				}else{
					request.setAttribute("userid",userid);
					int MovieTotalCnt = MovieDAO.selectMovieCount("");
					//1.��ü��ȭ ����Ʈ ��ȸ
					//ArrayList<Movie>movieList=MovieDAO.selectMovieList(1,MovieTotalCnt, "reservation");
					List<Movie>movieList=MovieDAO.selectMovieList();
					//2.request�� ����
					request.setAttribute("MOVIE_LIST",movieList);
					//3.�л��߰� ������ �̵� ��ü ����
					RequestDispatcher rd=request.getRequestDispatcher(
							"/reservation/addReservation.jsp");
					//������ �̵�
					rd.forward(request, response);
				}
				
		
	}
	

private void InsertReservation(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	HttpSession session=request.getSession();
	Member member=(Member)session.getAttribute("LOGIN_MEMBER");
	Reservation reservation=(Reservation)session.getAttribute("RESERVATION");
	reservation.setMember(member);
	List<Integer> SeatNumList=(List<Integer>)session.getAttribute("SeatNumList");
	
	for(int i=0;i<SeatNumList.size();i++){
		reservation.setSeatnum(SeatNumList.get(i));
		ReservationDAO.insertReservation(reservation);
	}
	
	
	
	RequestDispatcher rd=
			request.getRequestDispatcher(
					"/ReservationService?method=viewReservationListById");
	rd.forward(request, response);
	
	
	
	
	
	
	
	
//	System.out.println("member="+member+"reservaiton="+reservaiton);
//	System.out.println("SeatNumList="+SeatNumList.size());
//	
//    System.out.println("SeatNumList"+SeatNumList.get(0));
    
	
	
	}

	private void addReservation(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//�Ķ���� ������ ����
		HttpSession session=request.getSession();
		Member member=(Member)session.getAttribute("LOGIN_MEMBER");
		String userid=member.getUserid();
		String mnum=request.getParameter("mnum");
		String scrnum=request.getParameter("scrnum");
		String resQty1=request.getParameter("resQty");
		long resQty=Integer.parseInt(resQty1);
		
		
		//Reservation�� ��������
		System.out.println("���̵� "+userid+" ��ȭ��ȣ"+mnum+" ��������ȣ"+scrnum+" ����"+resQty);
		Reservation reservation=new Reservation();
		member =new Member();
		Movie movie =new Movie();
		ScreenTime screenTime = new ScreenTime();
		member.setUserid(userid);//id
		reservation.setMember(member);
		movie.setMnum(mnum);//��ȭ��ȣ
		reservation.setMovie(movie);
		screenTime.setScrnum(scrnum);//�󿵹�ȣ
		reservation.setScreenTime(screenTime);
		reservation.setResQty(resQty);//�¼���
		
		
		
			//ReservationDAO reservationDAO=new ReservationDAO();
			//�������� ��ȭ�� ���� �ֱٿ� ������ �����ȣ�� �˾Ƴ���
			String rnum= ReservationDAO.selectReservationResNum(scrnum);
			System.out.println(rnum);
			
			//�� �����ȣ�� ù��° �¼��� �¼����� ���ͼ�
	    if(rnum==null){
	    	reservation.setSeatnum(1);
			reservation.setTotalPrice(resQty*8000);
	    }else{
	    	long resnum=Integer.parseInt(rnum);
	    	long snum= ReservationDAO.selectReservationSeatNum(resnum);
			long qty= ReservationDAO.selectReservationQty(resnum);
			System.out.println("rnum"+rnum+"snum="+snum+" qty="+qty);
			//���� �����ϴ� ����� �¼��� �������ش�.
			reservation.setSeatnum(snum+qty);
			reservation.setTotalPrice(resQty*8000);
	    }

			
		
		
		
		//DB����
		ReservationDAO.insertReservation(reservation);
		
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
		session.setAttribute("LOGIN_MEMBER",member);
		
		
		Movie movie=new Movie();
		movie.setMnum("1");
		request.setAttribute("movie",movie);
		request.setAttribute("count","2");
//		request.setAttribute("member",member);
				//4.JSP�� ������ �̵�
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
//		//4.JSP�� ������ �̵�
//		rd.forward(request, response);
//		
//		
//	}
	
	private void viewReservationListById(HttpServletRequest request,
			HttpServletResponse response) throws IOException,ServletException{
		//�⺻ ������1
		int page=1;
		//������ �Ķ���Ͱ� ����
		if(request.getParameter("page")!=null){
			//�Ķ���� ����
			page=Integer.parseInt(request.getParameter("page"));
		}
//		���������� ������ �л���
		int length=5;
		//String userid=request.getParameter("userid");
		//System.out.println(userid);
		HttpSession session=request.getSession();
		Member member=(Member)session.getAttribute("LOGIN_MEMBER");
		String userid=member.getUserid();
		//1.StudentDAO���� �������� �ش��ϴ� �л���ȸ �޼��� ȣ��
		List<Reservation>reservationList=ReservationDAO.selectReservationList(length,page,userid);
		//2.request�� 1�� page�� �ش��ϴ� �л� ���� ����
		request.setAttribute("RESERVATION_LIST",reservationList);
		System.out.println("����"+reservationList);
		
		//�������� �ش��ϴ� �л��� ��ȸ
		int reservationCount=ReservationDAO.selectReservationCount(userid);
		System.out.println("reservationCount"+reservationCount);
		//�ٸ��������� �̵��ϴ� ��ũ�ױ� ����
//		PageUtil.generate(����������,��ü�Ǽ�,���������纸����row��,�ּ�)
		String pageLinkTag=PageUtil.generate(page, reservationCount, length, "ReservationService?method=viewReservationListById");
		request.setAttribute("PAGE_LINK_TAG",pageLinkTag);
		
		//3./student/viewStudentList.jsp�� ������ �̵� ��ü ����
		RequestDispatcher rd=request.getRequestDispatcher(
		"/reservation/viewReservationListByid.jsp");
		//4.JSP�� ������ �̵�
		rd.forward(request, response);
		
	}

	

}
