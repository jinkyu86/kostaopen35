package kr.or.kosta.auction.bid;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ModelDriven;

import kr.or.kosta.auction.auction.Auction;
import kr.or.kosta.auction.auction.AuctionDAO;
import kr.or.kosta.auction.auction.IAuctionDAO;
import kr.or.kosta.auction.member.IMemberDAO;
import kr.or.kosta.auction.member.Member;
import kr.or.kosta.auction.member.MemberDAO;

public class BidService implements ModelDriven,SessionAware{
	private IBidDAO bidDAO;
	private IAuctionDAO auctionDAO;
	private IMemberDAO memberDAO;
	private static final long serialVersionUID = 1L;
	
	private Map session;
	private String ERROR;
	
	private String anum;
	private String userid;
	
	private List<Bid> BID_LIST;
	private Bid bid=new Bid();
	private Auction auction=new Auction();
	private Member member=new Member();
	
   	public String getERROR() {
		return ERROR;
	}
	public void setERROR(String eRROR) {
		ERROR = eRROR;
	}
	public String getAnum() {
		return anum;
	}
	public void setAnum(String anum) {
		this.anum = anum;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public Bid getBid() {
		return bid;
	}
	public void setBid(Bid bid) {
		this.bid = bid;
	}
	public Auction getAuction() {
		return auction;
	}
	public void setAuction(Auction auction) {
		this.auction = auction;
	}
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	public List<Bid> getBID_LIST() {
		return BID_LIST;
	}
	public void setBID_LIST(List<Bid> bID_LIST) {
		BID_LIST = bID_LIST;
	}
	
	public BidService() {
        super();
    }
	
	@Override
	public Object getModel() {
		return bid;
	}

	public String moneyBack() throws Exception {
		//멤버정보 확인
		Member member=memberDAO.selectMember(userid);
		
		//ID에 따른 유찰된 코인개수
		int count=bidDAO.selectMoneybackByIdCount(userid);
		int plusEmoney=count*500;
		
		//해당 ID의 emoney
		String emoney=member.getEmoney();
		Long longEmoney=Long.parseLong(emoney);
		
		//emoney 합산
		longEmoney+=plusEmoney;
		emoney=Long.toString(longEmoney);
		
		//저장
		member.setEmoney(emoney);
		memberDAO.updateMember(member);
		
		//해당 멤버의 moneyback 받음을 표시
		bidDAO.updateMoneybackById(userid);
		
		return "success";
	}

	public String buy() throws Exception {
		Member member=(Member)session.get("MEMBER");
		if(member==null)	return "login";
		
		Date date=new Date();
		int year=date.getYear()+1900;
		int month=date.getMonth()+1;
		int day=date.getDate();
		
		int hour=date.getHours();
		int minute=date.getMinutes();
		int second=date.getSeconds();
		
		String sysdate=year+"-"+month+"-"+day+" "+hour+":"+minute+":"+second;
				
		auction=auctionDAO.selectAuction(anum);
		
		//즉시구매가 추출
		String imPrice=auction.getImPrice();
		Long longImPrice=Long.parseLong(imPrice);
		
		//회원 emoney계산
		String downEmoney=member.getEmoney();
		Long longEmoney=Long.parseLong(downEmoney);
		//회원의 emoney가 충분하지 않으면 에러메시지 출력
		if((longEmoney-longImPrice)<0){
			ERROR="emoney가 충분하지 않습니다";
			return "success";
		}
		
		//회원 emoney차감
		longEmoney-=longImPrice;
		downEmoney=Long.toString(longEmoney);
		
		bid=new Bid();
		
		member.setEmoney(downEmoney);
		auction.setSold(1);
		auction.seteTime(sysdate);
		auction.setCuPrice(imPrice);
		
		bid.setAuction(auction);
		bid.setMember(member);
		bid.setBidPrice(imPrice);
		
		memberDAO.updateMember(member);
		auctionDAO.updateAuction(auction);
		bidDAO.insertBid(bid);
		
		String userid=bid.getMember().getUserid();
		
		//해당 경매 낙찰자의 코인을 환불받은걸로 처리
		bidDAO.updateMoneybackByIdInAuction(userid, anum);
		
		ERROR="구매하셨습니다";
		
		return "success";
	}

	public String addBid() throws Exception {
		Member member=(Member)session.get("MEMBER");
		if(member==null) return "login";
		
		auction=auctionDAO.selectAuction(anum);
		
		//최근 입찰자 입력
		String userid=member.getUserid();
		auction.setUserid(userid);
		
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
		bidDAO.insertBid(bid);
		memberDAO.updateMember(member);		
		auctionDAO.updateAuction(auction);
		
		return "success";
	}
	
	public String viewBidList() throws Exception {
		BID_LIST=bidDAO.selectBidList();
		return "success";		
	}
	@Override
	public void setSession(Map<String, Object> session) {
		this.session=session;		
	}
	

}
