package kr.or.kosta.auction.bid;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.kosta.auction.auction.Auction;
import kr.or.kosta.auction.auction.AuctionDAO;
import kr.or.kosta.auction.member.Member;

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
		}else if("addBid".equals(method)){
			addBid(request,response);
		}else if("removeBidById".equals(method)){
			removeBidById(request,response);
		}
	}

	private void addBid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		Member member=(Member)session.getAttribute("LOGIN_MEMBER");
		if(member==null){
			RequestDispatcher rd=request.getRequestDispatcher("/MemberService?method=loginForm");
			//addBuy 메서드가 끝나고 나서 이동
			rd.forward(request, response);
			//메서드 종료
			return;
		}
		String aNum=(String)request.getParameter("aNum");
		
		Auction auction=AuctionDAO.selectAuction(aNum);
		
		Bid bid=new Bid();
		bid.setAuction(auction);
		bid.setMember(member);
		String upPrice=auction.getCuPrice();
		int intBidPrice=Integer.parseInt(upPrice)+10;
		upPrice=Integer.toString(intBidPrice);
		bid.setBidPrice(upPrice);	
		
		BidDAO.insertBid(bid);
		
		auction.setCuPrice(upPrice);
		AuctionDAO.updateAuction(auction);
		RequestDispatcher rd=request.getRequestDispatcher("/AuctionService?method=viewAuction&a_num="+aNum);
		rd.forward(request, response);
	}
	
	private void viewBidList(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		ArrayList bidList=BidDAO.selectBidList();
		request.setAttribute("BID_LIST", bidList);
		
		RequestDispatcher rd=request.getRequestDispatcher("/bid/viewBidList.jsp");
		rd.forward(request, response);
		
	}
	
	private void removeBidById(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		Member member=(Member)session.getAttribute("LOGIN_MEMBER");
		
		String userid=member.getUserid();
		BidDAO.deleteBidById(userid);
	}
}
