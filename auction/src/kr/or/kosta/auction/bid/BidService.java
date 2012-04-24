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
		//������� Ȯ��
		Member member=memberDAO.selectMember(userid);
		
		//ID�� ���� ������ ���ΰ���
		int count=bidDAO.selectMoneybackByIdCount(userid);
		int plusEmoney=count*500;
		
		//�ش� ID�� emoney
		String emoney=member.getEmoney();
		Long longEmoney=Long.parseLong(emoney);
		
		//emoney �ջ�
		longEmoney+=plusEmoney;
		emoney=Long.toString(longEmoney);
		
		//����
		member.setEmoney(emoney);
		memberDAO.updateMember(member);
		
		//�ش� ����� moneyback ������ ǥ��
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
		
		//��ñ��Ű� ����
		String imPrice=auction.getImPrice();
		Long longImPrice=Long.parseLong(imPrice);
		
		//ȸ�� emoney���
		String downEmoney=member.getEmoney();
		Long longEmoney=Long.parseLong(downEmoney);
		//ȸ���� emoney�� ������� ������ �����޽��� ���
		if((longEmoney-longImPrice)<0){
			ERROR="emoney�� ������� �ʽ��ϴ�";
			return "success";
		}
		
		//ȸ�� emoney����
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
		
		//�ش� ��� �������� ������ ȯ�ҹ����ɷ� ó��
		bidDAO.updateMoneybackByIdInAuction(userid, anum);
		
		ERROR="�����ϼ̽��ϴ�";
		
		return "success";
	}

	public String addBid() throws Exception {
		Member member=(Member)session.get("MEMBER");
		if(member==null) return "login";
		
		auction=auctionDAO.selectAuction(anum);
		
		//�ֱ� ������ �Է�
		String userid=member.getUserid();
		auction.setUserid(userid);
		
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
