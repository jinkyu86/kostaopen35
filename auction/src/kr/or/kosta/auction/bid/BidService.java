package kr.or.kosta.auction.bid;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.kosta.auction.auction.Auction;
import kr.or.kosta.auction.auction.AuctionDAO;
import kr.or.kosta.auction.member.Member;
import kr.or.kosta.auction.member.MemberDAO;

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
		}else if("buy".equals(method)){
			buy(request,response);
		}
	}

	private void buy(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		Member member=(Member)session.getAttribute("LOGIN_MEMBER");
		if(member==null){
			RequestDispatcher rd=request.getRequestDispatcher("/MemberService?method=loginForm");
			//addBuy 메서드가 끝나고 나서 이동
			rd.forward(request, response);
			//메서드 종료
			return;
		}
		Date date=new Date();
		int year=date.getYear()+1900;
		int month=date.getMonth()+1;
		int day=date.getDate();
		
		int hour=date.getHours();
		int minute=date.getMinutes();
		int second=date.getSeconds();
		
		String sysdate=year+"-"+month+"-"+day+" "+hour+":"+minute+":"+second;
		String aNum=(String)request.getParameter("aNum");
		
		Auction auction=AuctionDAO.selectAuction(aNum);
		
		//즉시구매가 추출
		String imPrice=auction.getImPrice();
		Long longImPrice=Long.parseLong(imPrice);
		
		//회원 emoney계산
		String downEmoney=member.getEmoney();
		Long longEmoney=Long.parseLong(downEmoney);
		//회원의 emoney가 충분하지 않으면 에러메시지 출력
		if((longEmoney-longImPrice)<0){
			request.setAttribute("ERROR","emoney가 충분하지 않습니다");
			RequestDispatcher rd=request.getRequestDispatcher("/AuctionService?method=viewAuction&aNum="+aNum);
			rd.forward(request, response);
			return;
		}
		
		//회원 emoney차감
		longEmoney-=longImPrice;
		downEmoney=Long.toString(longEmoney);
				
		Bid bid=new Bid();
		
		member.setEmoney(downEmoney);
		auction.setSold(1);
		auction.seteTime(sysdate);
		auction.setCuPrice(imPrice);
		
		bid.setAuction(auction);
		bid.setMember(member);
		bid.setBidPrice(imPrice);
		
		MemberDAO.updateMember(member);
		AuctionDAO.updateAuction(auction);
		BidDAO.updateBid(bid);
		
		RequestDispatcher rd=request.getRequestDispatcher("/AuctionService?method=viewAuctionList");
		rd.forward(request, response);
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
		
		//입찰가격 10원 증가
		String upPrice=auction.getCuPrice();
		int intBidPrice=Integer.parseInt(upPrice)+10;
		upPrice=Integer.toString(intBidPrice);
		bid.setBidPrice(upPrice);	
		auction.setCuPrice(upPrice);
		
		//코인 -1
		String downCoin=member.getCoin();
		int intCoin=Integer.parseInt(downCoin)-1;
		downCoin=Integer.toString(intCoin);
		member.setCoin(downCoin);
		
		bid.setAuction(auction);
		bid.setMember(member);
		
		//입찰 목록 등록, 회원 코인수 차감, 경매 현재가 증가
		BidDAO.insertBid(bid);
		MemberDAO.updateMember(member);		
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
