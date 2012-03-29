package kr.or.kosta.auction.bid;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class BidService extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public BidService() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String method=request.getParameter("method");
		if(method==null){
			method="viewBidList";
		}
		if("viewBidList".equals(method)){
			viewBidList(request,response);
		}else if("viewBid".equals(method)){
			viewBid(request,response);
		}else if("addBidForm".equals(method)){
			addBidForm(request,response);
		}else if("addBid".equals(method)){
			addBid(request,response);
		}else if("editBidForm".equals(method)){
			editBidForm(request,response);
		}else if("editBid".equals(method)){
			editBid(request,response);
		}else if("removeBid".equals(method)){
			removeBid(request,response);
		}
	}
	
	private void addBid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rd=request.getRequestDispatcher("/BidService?method=viewBidList");
		rd.forward(request, response);
	}

	private void addBidForm(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd=request.getRequestDispatcher("/bid/addBid.jsp");
		rd.forward(request, response);

	}

	private void editBid(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String bidnum=request.getParameter("bidnum");
		RequestDispatcher rd=request.getRequestDispatcher("/BidService?method=viewBid&bidnum="+bidnum);
		rd.forward(request, response);
	}

	private void editBidForm(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd=request.getRequestDispatcher("/bid/editBid.jsp");
		rd.forward(request, response);
	}

	private void viewBid(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd=request.getRequestDispatcher("/bid/viewBid.jsp");
		rd.forward(request, response);
	}

	private void viewBidList(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		ArrayList bidList=BidDAO.selectBidList();
		request.setAttribute("BID_LIST", bidList);
		
		RequestDispatcher rd=request.getRequestDispatcher("/bid/viewBidList.jsp");
		rd.forward(request, response);
		
	}
	
	private void removeBid(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd=request.getRequestDispatcher("/BidService?method=viewBidList");
		rd.forward(request, response);
	}
}
