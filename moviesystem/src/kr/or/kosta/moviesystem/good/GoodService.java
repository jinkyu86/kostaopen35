package kr.or.kosta.moviesystem.good;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GoodService extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
    public GoodService() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String method=request.getParameter("method");
		
		if(method==null){
			method="viewGoodList";
		}
		if("viewGoodList".equals(method)){
			viewGoodList(request,response);
		}
		else if("viewGood".equals(method)){
			viewGood(request,response);
		}else if("addGoodForm".equals(method)){
			addGoodForm(request,response);
		}
	}
	/**
	 * 전체 상품 목록 리스트
	 * 
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public void viewGoodList(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		/* default generated stub */;
		ArrayList<Good>goodList=GoodDAO.selectGoodList(0, 0);
		request.setAttribute("GOOD_LIST", goodList);
		RequestDispatcher rd=request.getRequestDispatcher("/good/viewGoodList.jsp");
		rd.forward(request, response);
	}

	/**
	 * 선택한 상품이 보여지는 기능
	 * 
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public void viewGood(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* default generated stub */;
		String gnum=request.getParameter("gnum");
		Good good=GoodDAO.selectGood(gnum);
		request.setAttribute("GOOD", good);
		RequestDispatcher rd=request.getRequestDispatcher("/good/viewGood.jsp");
		rd.forward(request, response);
	}

	/**
	 * 상품 등록 폼
	 * 
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public void addGoodForm(HttpServletRequest request,	HttpServletResponse response) throws ServletException, IOException {
		/* default generated stub */;
		RequestDispatcher rd=request.getRequestDispatcher("/good/addGood.jsp");
		rd.forward(request, response);
	}

	/**
	 * 상품 등록
	 * 
	 * @param request
	 * @param response
	 */
	public void addGood(HttpServletRequest request, HttpServletResponse response) {
		/* default generated stub */;
		
	}
}
