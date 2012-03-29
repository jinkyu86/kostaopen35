package kr.or.kosta.auction.good;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class GoodService
 */
public class GoodService extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GoodService() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String method=request.getParameter("method");
		if(method==null){
			method="viewGoodList";
		}
		if("viewGoodList".equals(method)){
			viewGoodList(request, response);
		}else if("viewGood".equals(method)){
			viewGood(request, response);
		}else if("removeGood".equals(method)){
			removeGood(request, response);
		}else if("editGoodForm".equals(method)){
			editGoodForm(request, response);
		}else if("editGood".equals(method)){
			editGood(request, response);
		}else if("addGoodForm".equals(method)){
			addGoodForm(request, response);
		}else if("addGood".equals(method)){
			addGood(request, response);
		}
	}


	private void addGood(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException{
		String name=request.getParameter("gName");
		String detail=request.getParameter("detail");
		String img=request.getParameter("img");
		
		Good good=new Good();
		
		good.setgName(name);
		good.setDetail(detail);
		good.setImg(img);
		
		GoodDAO.insertGood(good);
		
		RequestDispatcher rd=request.getRequestDispatcher("/GoodService?method=viewGoodList.jsp");
		rd.forward(request, response);

	}


	private void addGoodForm(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException{
		RequestDispatcher rd=request.getRequestDispatcher("/good/addGood.jsp");
		rd.forward(request, response);

	}


	private void editGood(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException{
		String num=request.getParameter("gNum");
		String name=request.getParameter("gName");
		String detail=request.getParameter("detail");
		String img=request.getParameter("img");
		
		Good good=new Good();
		
		good.setgNum(num);
		good.setgName(name);
		good.setDetail(detail);
		good.setImg(img);
		
		GoodDAO.updateGood(good);
		
		RequestDispatcher rd=request.getRequestDispatcher("/GoodService?method=viewGood"+"&gNum"+num);
		rd.forward(request, response);

	}


	private void editGoodForm(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException{
		String num=request.getParameter("gNum");
		
		Good good=GoodDAO.selectGood(num);
		
		request.setAttribute("GOOD", good);
		
		RequestDispatcher rd=request.getRequestDispatcher("/good/editGood.jsp");
		rd.forward(request, response);

	}


	private void viewGood(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException{
		String num=request.getParameter("gNum");
		
		Good good=GoodDAO.selectGood(num);
		
		request.setAttribute("GOOD", good);
		
		RequestDispatcher rd=request.getRequestDispatcher("/good/viewGood.jsp");
		rd.forward(request, response);
	}


	private void viewGoodList(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException{
		ArrayList<Good>goodList=GoodDAO.selectGoodList();
		
		request.setAttribute("GOOD_LIST", goodList);
		
		RequestDispatcher rd=request.getRequestDispatcher("/good/viewGoodList.jsp");
		rd.forward(request, response);
	}


	private void removeGood(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException{
		String num=request.getParameter("gNum");
		
		GoodDAO.deleteGood(num);
		
		RequestDispatcher rd=request.getRequestDispatcher("/GoodService?method=viewGoodList");
		rd.forward(request, response);

	}
}
