package kr.or.kosta.moviesystem.screentime;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ScreenTimeService
 */
public class ScreenTimeService extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ScreenTimeService() {
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
		System.out.println(method);
		if("viewScreenTimeListBymnum".equals(method)){
			viewScreenTimeListBymnum(request,response);
		}
	}
	
	private void viewScreenTimeListBymnum(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String mnum = request.getParameter("mnum");
		System.out.println("mnum= "+mnum);
		List<ScreenTime>screenTimeList=ScreenTimeDAO.selectScreen(mnum);
		request.setAttribute("SCREENTIME_LIST",screenTimeList);
		System.out.println("screenTimeList = "+screenTimeList);
		
		RequestDispatcher rd=request.getRequestDispatcher(
		"/reservation/viewScreenTimeListBymnum.jsp");
		//4.JSP로 페이지 이동
		rd.forward(request, response);
		
		
	}

}
