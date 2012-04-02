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
			//addBuy �޼��尡 ������ ���� �̵�
			rd.forward(request, response);
			//�޼��� ����
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
		
		//��ñ��Ű� ����
		String imPrice=auction.getImPrice();
		Long longImPrice=Long.parseLong(imPrice);
		
		//ȸ�� emoney���
		String downEmoney=member.getEmoney();
		Long longEmoney=Long.parseLong(downEmoney);
		//ȸ���� emoney�� ������� ������ �����޽��� ���
		if((longEmoney-longImPrice)<0){
			request.setAttribute("ERROR","emoney�� ������� �ʽ��ϴ�");
			RequestDispatcher rd=request.getRequestDispatcher("/AuctionService?method=viewAuction&aNum="+aNum);
			rd.forward(request, response);
			return;
		}
		
		//ȸ�� emoney����
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
			//addBuy �޼��尡 ������ ���� �̵�
			rd.forward(request, response);
			//�޼��� ����
			return;
		}
		String aNum=(String)request.getParameter("aNum");
		
		Auction auction=AuctionDAO.selectAuction(aNum);
		
		Bid bid=new Bid();
		
		//�������� 10�� ����
		String upPrice=auction.getCuPrice();
		int intBidPrice=Integer.parseInt(upPrice)+10;
		upPrice=Integer.toString(intBidPrice);
		bid.setBidPrice(upPrice);	
		auction.setCuPrice(upPrice);
		
		//���� -1
		String downCoin=member.getCoin();
		int intCoin=Integer.parseInt(downCoin)-1;
		downCoin=Integer.toString(intCoin);
		member.setCoin(downCoin);
		
		bid.setAuction(auction);
		bid.setMember(member);
		
		//���� ��� ���, ȸ�� ���μ� ����, ��� ���簡 ����
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
