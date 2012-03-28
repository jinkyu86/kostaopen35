package kr.or.kosta.auction.auction;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.kosta.auction.good.Good;

public class AuctionService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @param request
	 * @param response
	 */
	public AuctionService() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String method = request.getParameter("method");
		if(method==null){
			method ="viewAuctionList";
		}
		if("viewAuctionList".equals(method)){
			viewAuctionList(request,response);
		}else if("addAuction".equals(method)){
			addAuction(request,response);
		}
		
	}

	private void addAuction(HttpServletRequest request,
			HttpServletResponse response) throws ServletException,IOException {
		String gNum = request.getParameter("gnum");
		String sPrice = request.getParameter("sprice");
		String imPrice = request.getParameter("imprice");
		String sTime = request.getParameter("stime");
		String eTime = request.getParameter("etime");
		boolean sold = Boolean.parseBoolean(request.getParameter("sold"));
		String cuPrice = request.getParameter("cuPrice");
	
		Good good = new Good();
		good.setgNum(gNum);
		
		Auction auction = new Auction();
		auction.setsPrice(sPrice);
		auction.setImPrice(imPrice);
		auction.setsTime(sTime);
		auction.seteTime(eTime);
		auction.setSold(sold);
		auction.setCuPrice(cuPrice);
		auction.setGood(good);
		
		AuctionDAO.insertAuction(auction);
		
		
		RequestDispatcher rd = request.getRequestDispatcher("/AuctionService?method=viewAuctionList");
		rd.forward(request, response);
	}
	
	private void addAuctionForm(HttpServletRequest request,
			HttpServletResponse response) {
		/* default generated stub */;

	}

	/**
	 * @param request
	 * @param response
	 */
	private void editAuction(HttpServletRequest request,
			HttpServletResponse response) {
		/* default generated stub */;

	}

	/**
	 * @param request
	 * @param response
	 */
	private void editAuctionForm(HttpServletRequest request,
			HttpServletResponse response) {
		/* default generated stub */;

	}

	/**
	 * @param request
	 * @param response
	 */
	private void viewAuction(HttpServletRequest request,
			HttpServletResponse response) {
		/* default generated stub */;

	}

	/**
	 * @param request
	 * @param response
	 */
	private void viewAuctionList(HttpServletRequest request,
			HttpServletResponse response) throws ServletException,IOException{
		//1.AuctionDAO에서 전체 경매조회 메서드 호출
		ArrayList<Auction> auctionList=AuctionDAO.selectAuctionList();
		//2.request에 1의 전체 경매 정보 저장
		request.setAttribute("AUCTION_LIST", auctionList);
		//3. /auction/viewAuctionList.jsp로 페이지이동
		RequestDispatcher rd=request.getRequestDispatcher("/auction/viewAuctionList.jsp");
		//4.JSP로 페이지 이동
		rd.forward(request, response);
	}


	/**
	 * @param request
	 * @param response
	 */
	private void removeAuction(HttpServletRequest request,
			HttpServletResponse response) {
		/* default generated stub */;

	}
}
