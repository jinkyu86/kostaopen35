package kr.or.kosta.moviesystem.reservation;


import java.io.IOException;
import java.io.PrintWriter;
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

import com.opensymphony.xwork2.ModelDriven;

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
public class ReservationService implements ModelDriven, 
ServletContextAware, ServletRequestAware, ServletResponseAware, SessionAware {
	private static final long serialVersionUID = 1L;
	private  ServletContext servletContext;
	private HttpServletRequest request;
	private HttpServletResponse response;
	private Map session; 
	private Member member=new Member();
	private Reservation reservation=new Reservation();
	private String seatString;
//	private String seat;
	private String time;
	private String scrnum;
	private String mnum;
	private String mname;
	private long resQty;
	private long totalPrice;
	private Movie movie =new Movie();
	private Movie MOVIE;
	private Reservation RESERVATION=new Reservation();
	private MovieDAO movieDAO;
	private int page;
	private String PAGE_LINK_TAG;
	private String userid;
	private String resnum;
	private IReservationDAO reservationDAO;
//	int reservationCount;
	ScreenTime screenTime = new ScreenTime();
	ScreenTime SCREENTIME;
	List<Integer>TotalSeatList=new ArrayList<Integer>();
	ArrayList<Integer>SeatNumList=new ArrayList<Integer>();
	List<Reservation>RESERVATION_LIST;
	List<Movie>MOVIE_LIST;
	List<ScreenTime>SCREENTIME_LIST;
	private int maxPage;
	
	
	
//	public String getSeat() {
//		return seat;
//	}
//
//
//	public void setSeat(String seat) {
//		this.seat = seat;
//	}
	
	
	public List<Movie> getMOVIE_LIST() {
		return MOVIE_LIST;
	}


	public int getMaxPage() {
		return maxPage;
	}


	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}


	public List<ScreenTime> getSCREENTIME_LIST() {
		return SCREENTIME_LIST;
	}


	public void setSCREENTIME_LIST(List<ScreenTime> sCREENTIME_LIST) {
		SCREENTIME_LIST = sCREENTIME_LIST;
	}


	public void setMOVIE_LIST(List<Movie> mOVIE_LIST) {
		MOVIE_LIST = mOVIE_LIST;
	}


	@Override
	public void setSession(Map<String, Object> session) {
		this.session=session;
		
	}


//	public int getReservationCount() {
//		return reservationCount;
//	}
//
//
//	public void setReservationCount(int reservationCount) {
//		this.reservationCount = reservationCount;
//	}


	public String getResnum() {
		return resnum;
	}


	public void setResnum(String resnum) {
		this.resnum = resnum;
	}


	public List<Reservation> getRESERVATION_LIST() {
		return RESERVATION_LIST;
	}


	public void setRESERVATION_LIST(List<Reservation> rESERVATION_LIST) {
		RESERVATION_LIST = rESERVATION_LIST;
	}


	public String getUserid() {
		return userid;
	}


	public void setUserid(String userid) {
		this.userid = userid;
	}


	public String getPAGE_LINK_TAG() {
		return PAGE_LINK_TAG;
	}


	public void setPAGE_LINK_TAG(String pAGE_LINK_TAG) {
		PAGE_LINK_TAG = pAGE_LINK_TAG;
	}


	public int getPage() {
		return page;
	}


	public void setPage(int page) {
		this.page = page;
	}


	public String getSeatString() {
		return seatString;
	}


	public Reservation getRESERVATION() {
		return RESERVATION;
	}


	public void setRESERVATION(Reservation rESERVATION) {
		RESERVATION = rESERVATION;
	}


	public void setSeatString(String seatString) {
		this.seatString = seatString;
	}


	public MovieDAO getMovieDAO() {
		return movieDAO;
	}


	public void setMovieDAO(MovieDAO movieDAO) {
		this.movieDAO = movieDAO;
	}



	
    public long getTotalPrice() {
		return totalPrice;
	}


	public void setTotalPrice(long totalPrice) {
		this.totalPrice = totalPrice;
	}


	public Movie getMOVIE() {
		return MOVIE;
	}


	public void setMOVIE(Movie mOVIE) {
		MOVIE = mOVIE;
	}


	public ScreenTime getSCREENTIME() {
		return SCREENTIME;
	}


	public void setSCREENTIME(ScreenTime sCREENTIME) {
		SCREENTIME = sCREENTIME;
	}


	public List<Integer> getTotalSeatList() {
		return TotalSeatList;
	}


	public void setTotalSeatList(List<Integer> totalSeatList) {
		TotalSeatList = totalSeatList;
	}


	public ArrayList<Integer> getSeatNumList() {
		return SeatNumList;
	}


	public void setSeatNumList(ArrayList<Integer> seatNumList) {
		SeatNumList = seatNumList;
	}


	public Movie getMovie() {
		return movie;
	}


	public void setMovie(Movie movie) {
		this.movie = movie;
	}


	public ScreenTime getScreenTime() {
		return screenTime;
	}


	public void setScreenTime(ScreenTime screenTime) {
		this.screenTime = screenTime;
	}


	public long getResQty() {
		return resQty;
	}


	public void setResQty(long resQty) {
		this.resQty = resQty;
		this.totalPrice=this.resQty*8000;
	}


	/**
     * @see HttpServlet#HttpServlet()
     */
    public ReservationService() {
        super();
        // TODO Auto-generated constructor stub
    }


	//SessionAware�޼���-���ǿ� ����� �Ӽ����� �Ѱ���/�߰��� �Ӽ��� ������ �ʿ� �߰�
	//����/������ �Ӽ��� ������ ���� ����

	public ReservationService(IReservationDAO reservationDAO) {
		super();
		this.reservationDAO = reservationDAO;
	}
	
//	public ReservationService(IScreenTimeDAO screenTimeDAO) {
//		super();
//		this.screenTimeDAO = screenTimeDAO;
//	}


	public Member getMember() {
		return member;
	}


	public void setMember(Member member) {
		this.member = member;
	}


	public Reservation getReservation() {
		return reservation;
	}


	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}


	public String getTime() {
		return time;
	}


	public void setTime(String time) {
		this.time = time;
	}


	public String getScrnum() {
		return scrnum;
	}


	public void setScrnum(String scrnum) {
		this.scrnum = scrnum;
	}


	public String getMnum() {
		return mnum;
	}


	public void setMnum(String mnum) {
		this.mnum = mnum;
	}


	public String getMname() {
		return mname;
	}


	public void setMname(String mname) {
		this.mname = mname;
	}


	//ServletResponseAware�޼���-ServletResponse�� �Ѱ���
	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response=response;
	}

	//ServletRequestAware�޼���-HttpServletRequest�� �Ѱ���
	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request=request;		
	}


	@Override
	public Object getModel() {
		return member;
	}

    
    
	
public ServletContext getServletContext() {
		return servletContext;
	}

	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}

	public HttpServletRequest getRequest() {
		return request;
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

	public Map getSession() {
		return session;
	}








public String viewReservationSeat() throws Exception {
		
	    System.out.println("---viewReservationSeat����---");
		SCREENTIME=ScreenTimeDAO.selectScreenTimeScrNum(time);
	
		scrnum=SCREENTIME.getScrnum();
		System.out.println("scrnum= "+scrnum);

		member=(Member)session.get("LOGIN_MEMBER");
		userid=member.getUserid();
		//id�� scrnum�� ��ȸ�ؼ� �¼��� �˾Ƴ���.		
		RESERVATION_LIST=reservationDAO.selectSeatNumByScrnumAndUserid(scrnum,userid);

		System.out.println("reservationList = "+RESERVATION_LIST);
		System.out.println("---viewReservationSeat����---");
		return "success";
		
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





public String InsertReservation2() throws Exception{
	member=(Member)session.get("LOGIN_MEMBER");
	System.out.println(member);
	System.out.println(mnum);
	System.out.println(scrnum);
	System.out.println(resQty);
	return "success";
}

public String InsertReservation() throws Exception {
	System.out.println("---InsertReservation ����---");
//	HttpSession session=request.getSession();
//	Member member=(Member)session.getAttribute("LOGIN_MEMBER");
	member=(Member)session.get("LOGIN_MEMBER");
	
	reservation=(Reservation)session.get("reservation");
	reservation.setMember(member);
	SeatNumList=(ArrayList<Integer>)session.get("SeatNumList");
	System.out.println("SeatNumList"+SeatNumList);
	System.out.println("SeatNumList.size() "+SeatNumList.size());
	for(int i=0;i<SeatNumList.size();i++){
		reservation.setSeatnum(SeatNumList.get(i));
		System.out.println("for���� i��"+i);
		reservationDAO.insertReservation(reservation);
		
	}
	System.out.println("---InsertReservation ����--");
	
	return "success";
	

	
//	System.out.println("member="+member+"reservaiton="+reservaiton);
//	System.out.println("SeatNumList="+SeatNumList.size());
//	
//    System.out.println("SeatNumList"+SeatNumList.get(0));
    
	
	
	}


















	
	public String SelectSeat() throws Exception {
		
		System.out.println("===============SelectSeat()����==================");
		System.out.println("seatString"+seatString);
		member=(Member)session.get("LOGIN_MEMBER");
		SeatNumList=(ArrayList<Integer>) session.get("SeatNumList");
		reservation=(Reservation)session.get("RESERVATION");
		System.out.println("member"+member);
		System.out.println("reservation"+reservation);
		System.out.println("seatString"+seatString);
		System.out.println("SeatNumList======"+SeatNumList);
		long count=(Long) session.get("COUNT");;
		int seat=Integer.parseInt(seatString);
		String scrnum=reservation.getScreenTime().getScrnum();
		
		
		System.out.println("seat="+seat+"count="+count+"scrnum="+scrnum);
		
		SeatNumList.add(seat);
		
		System.out.print("SeatNumList�� ���� ���� = "+SeatNumList);
		if(count>1){
			TotalSeatList=reservationDAO.selectTotalList(scrnum);	
			
			for(int i=0;i<SeatNumList.size();i++){
				TotalSeatList.set(SeatNumList.get(i)-1, 1);
			}

			count=count-1;
			System.out.println("�������� ������reservation="+reservation);
			session.put("reservation",reservation);
			session.put("SeatNumList",SeatNumList);
			session.put("COUNT", count);
			System.out.println("=====�ѹ���======");
			
			return "resuccess";
		}else{
			System.out.println("-����-");
			System.out.println("seat="+seat+"count="+count+"scrnum="+scrnum);
			System.out.println("reservation"+reservation);
			session.put("reservation",reservation);
			System.out.println("=====����======");
			return "success";
					
		}



}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	public String viewSeatListByScrnum() throws Exception {
		System.out.println("viewSeatListByScrnum����");
		System.out.println("�ش� ���������� ����");
		MOVIE=movieDAO.selectMovie(mnum);
		TotalSeatList=reservationDAO.selectTotalList(scrnum);
		System.out.println("MOVIE= "+MOVIE);
		System.out.println("mnum= "+mnum);
		SCREENTIME=ScreenTimeDAO.selectScreenTimeBySrcNum(scrnum);
		
		System.out.println("=====viewSeatListByScrnum======");
		RESERVATION.setMovie(MOVIE);
		RESERVATION.setScreenTime(SCREENTIME);
		RESERVATION.setResQty(resQty);
		RESERVATION.setTotalPrice(resQty*8000);

		
		
		session.put("RESERVATION",RESERVATION);
		session.put("COUNT", resQty);
		session.put("SeatNumList",SeatNumList);
	
		System.out.println("MOVIE======"+MOVIE);
		System.out.println("SCREENTIME==========="+SCREENTIME);
		System.out.println("RESERVATION========"+RESERVATION);
		
//		List<Integer>TotalSeatList=new ArrayList<Integer>();
//		ArrayList<Integer>SeatNumList=new ArrayList<Integer>();
		
		System.out.println("scrnum : "+scrnum);
		

		System.out.println("TotalSeatList======"+TotalSeatList);
		System.out.println("viewSeatListByScrnum����");
		return "success";
		
	}
	
//	private void viewSeatListByScrnum(HttpServletRequest request,
//			HttpServletResponse response) throws ServletException, IOException {
//
//		Reservation reservation=new Reservation();
//		Movie movie=new Movie();
//		ScreenTime screenTime = new ScreenTime();
//		String mnum = request.getParameter("mnum");
//		String scrnum= request.getParameter("scrnum");
//		String resQty=request.getParameter("resQty");
//		movie=MovieDAO.selectMovie(mnum);
//		screenTime=ScreenTimeDAO.selectScreenTimeBySrcNum(scrnum);
//		
//		System.out.println("mnum="+mnum+"scrnum="+scrnum+"resQty="+resQty);
//
//
//		
//		screenTime.setScrnum(scrnum);
//		reservation.setMovie(movie);
//		reservation.setScreenTime(screenTime);
//		reservation.setResQty(Integer.parseInt(resQty));
//		reservation.setTotalPrice(Integer.parseInt(resQty)*8000);
//		
//		List<Integer>TotalSeatList=new ArrayList<Integer>();
//		ArrayList<Integer>SeatNumList=new ArrayList<Integer>();
//		
//		
//		HttpSession session=request.getSession();
//		session.setAttribute("RESERVATION",reservation);
//		session.setAttribute("COUNT",resQty);
//		session.setAttribute("SeatNumList", SeatNumList);
//
//		System.out.println("reservation="+reservation);
//		System.out.println("SeatNumList="+SeatNumList);
//		TotalSeatList=ReservationDAO.selectTotalList(scrnum);
//
//		request.setAttribute("TotalSeatList",TotalSeatList);
//
//		RequestDispatcher rd=request.getRequestDispatcher(
//				"/reservation/viewSeatListByScrnum.jsp");
//				//4.JSP�� ������ �̵�
//				rd.forward(request, response);
//		
//	}

	public String viewCancelByResNum() throws IOException, ServletException{
		
		reservationDAO.cancelReservation(resnum);
		
		return "success";

		
	}

	public String viewReservationByResNumForm() throws Exception {
		resnum = request.getParameter("resnum");
	    RESERVATION = reservationDAO.selectReservation(resnum);
//		Reservation reservation= new Reservation();
//		reservation.setResnum(resnum);
		 System.out.println("resnum"+resnum);
		System.out.println("reservation"+RESERVATION);
		
		long finalSeatNum=RESERVATION.getSeatnum()+(RESERVATION.getResQty()-1);
		
		String finalSeat = null;
		
		if(RESERVATION.getResQty()==1){
			finalSeat="";
		}else {
			finalSeat="~"+finalSeatNum;
		}
		
		request.setAttribute("finalSeatNum",finalSeat);
		
		return "success";

	}
	
	public String viewReservationTimeForm() throws Exception {
//		String mname = request.getParameter("mname");
//		HttpSession session=request.getSession();
//		Member member=(Member)session.getAttribute("LOGIN_MEMBER");
		System.out.println("------viewReservationTimeForm����-----");
		member=(Member)session.get("LOGIN_MEMBER");
		
		userid=member.getUserid();
		
	    MOVIE = movieDAO.selectMovieNum(mname);
	    mnum=MOVIE.getMnum();
//		request.setAttribute("mname",mname);
	    //userid�� mnom���� group by time ���� �� ������ time sum(total_price) count(res_qty)
	    RESERVATION_LIST = reservationDAO.selectReservationTime(userid,mnum);
//		request.setAttribute("reservationList",reservationList);
//		RequestDispatcher rd=request.getRequestDispatcher(
//					"/reservation/viewReservationTime.jsp");
//					//4.JSP�� ������ �̵�
//					rd.forward(request, response);
	    System.out.println("------viewReservationTimeForm����-----");
		return "success";
	}

	public String viewReservationByResNum() throws Exception {
		resnum = request.getParameter("resnum");	
		
		reservationDAO.cancelReservation(resnum);
		
		return "success";
		
	}

	public String MovieTimeList() throws Exception{
		
		System.out.println(mnum);
		SCREENTIME_LIST = ScreenTimeDAO.selectScreen(mnum);
		System.out.println(SCREENTIME_LIST);
		JSONArray jsonArray = JSONArray.fromObject(SCREENTIME_LIST);
		System.out.println("jsonArray : "+jsonArray);
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println(jsonArray.toString());
		out.flush();
		out.close();
		
		return "success";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	public String addReservationByTimeForm() throws Exception {
		//System.out.println("addReservationByTimeForm���� ");
		//System.out.println("�α��� ������,��ȭ�ð�,��ȭ�̸�,��ȭ��ȣ,�󿵹�ȣ�� ����");
			//session.put("LOGIN_MEMBER", member);
		member=(Member)session.get("LOGIN_MEMBER");
		SCREENTIME_LIST = ScreenTimeDAO.selectScreen(mnum);
		MOVIE = movieDAO.selectMovie(mnum);
			//System.out.println("member = "+member);
			//System.out.println("time"+time);
			//System.out.println("mname"+mname);
			//System.out.println("mnum"+mnum);
			//System.out.println("scrnum"+scrnum);
			//System.out.println("addReservationByTimeForm���� ");
		return "success";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	public String addReservationForm() throws Exception {
		System.out.println("addReservationForm����");
		member=(Member)session.get("LOGIN_MEMBER");
		userid="";
		
		//userid �� null�̸� Exception�߻��ϴ� �װ� ����
		try{
			userid=member.getUserid();
		}catch(NullPointerException e){
			//userid="";
		}
		
		
		if(userid.equals("")){
			System.out.println("�α��� �������� �̵�");
			return "loginForm";
		}else{
			
			int MovieTotalCnt = movieDAO.selectMovieCount("");
			//1.��ü��ȭ ����Ʈ ��ȸ
			//ArrayList<Movie>movieList=MovieDAO.selectMovieList(1,MovieTotalCnt, "reservation");
			MOVIE_LIST=movieDAO.selectMovieList();
			System.out.println("addReservationForm����");
			return "success";
		}
		

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
			String rnum= reservationDAO.selectReservationResNum(scrnum);
			System.out.println(rnum);
			
			//�� �����ȣ�� ù��° �¼��� �¼����� ���ͼ�
	    if(rnum==null){
	    	reservation.setSeatnum(1);
			reservation.setTotalPrice(resQty*8000);
	    }else{
	    	long resnum=Integer.parseInt(rnum);
	    	long snum= reservationDAO.selectReservationSeatNum(resnum);
			long qty= reservationDAO.selectReservationQty(resnum);
			System.out.println("rnum"+rnum+"snum="+snum+" qty="+qty);
			//���� �����ϴ� ����� �¼��� �������ش�.
			reservation.setSeatnum(snum+qty);
			reservation.setTotalPrice(resQty*8000);
	    }

			
		
		
		
		//DB����
	    reservationDAO.insertReservation(reservation);
		
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
	
	public String viewReservationListById() throws Exception{
		//�⺻ ������1
		System.out.println("====viewReservationListById����===");
		int length = 5;
		if(page==0){
			page=1;
		}
//		���������� ������ �л���
		//String userid=request.getParameter("userid");
		//System.out.println(userid);
		member=(Member)session.get("LOGIN_MEMBER");
		//1.StudentDAO���� �������� �ش��ϴ� �л���ȸ �޼��� ȣ��
		System.out.println("member ���� ���"+member);
		
		RESERVATION_LIST=reservationDAO.selectReservationList(length,page,member.getUserid());
		//2.request�� 1�� page�� �ش��ϴ� �л� ���� ����
		System.out.println("����"+RESERVATION_LIST);
		
		session.put("RESERVATION_LIST",RESERVATION_LIST);
		
		System.out.println("����"+RESERVATION_LIST);
		
		//�������� �ش��ϴ� �л��� ��ȸ
		int reservationCount=reservationDAO.selectReservationCount(member.getUserid());
		System.out.println("reservationCount"+reservationCount);
		//�ٸ��������� �̵��ϴ� ��ũ�ױ� ����
//		PageUtil.generate(����������,��ü�Ǽ�,���������纸����row��,�ּ�)
		
		PAGE_LINK_TAG=PageUtil.generate(page, reservationCount, length,
						  "/moviesystem/viewReservationListById.action");
		
		
		
		String pageLinkTag=PageUtil.generate(page, reservationCount, length, "ReservationService?method=viewReservationListById");
		request.setAttribute("PAGE_LINK_TAG",pageLinkTag);
		maxPage=(reservationCount/length);
		if(reservationCount%length!=0){
			maxPage++;
		}
		System.out.println("---viewReservationListById����---");
		return "success";
		
	}


	
	

}
