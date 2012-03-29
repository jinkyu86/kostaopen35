package kr.or.kosta.auction.bid;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.or.kosta.auction.auction.Auction;
import kr.or.kosta.auction.good.Good;
import kr.or.kosta.auction.member.Member;
import kr.or.kosta.auction.util.ConnectionUtil;

public class BidDAO {
	public static void insertBid(Bid bid) {
		Connection con=null;
		PreparedStatement psmt=null;
		con=ConnectionUtil.getConnection();
		String sql="INSERT INTO BID " +
				"(bidnum,a_num,userid,bid_time,bid_price) "+
				"VALUES (BID_SEQ.NEXTVAL,?,?,?,?)";
		
		try {
			psmt=con.prepareStatement(sql);
			psmt.setString(1,bid.getAuction().getaNum());
			psmt.setString(2,bid.getMember().getUserid());
			psmt.setString(3,bid.getBidPrice());
			psmt.setString(4,bid.getBidTime());
			psmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void updateBid(Bid bid) {
		Connection con=null;
		PreparedStatement psmt=null;
		con=ConnectionUtil.getConnection();
		String sql="UPDATE BID " +
				"SET userid=?," +
				"a_num=?," +
				"bid_time=?," +
				"bid_price=? " +
				"WHERE bidnum=?";
		
		try {
			psmt=con.prepareStatement(sql);
			psmt.setString(1,bid.getMember().getUserid());
			psmt.setString(2,bid.getAuction().getaNum());
			psmt.setString(3, bid.getBidTime());
			psmt.setString(4,bid.getBidPrice());
			psmt.setString(5,bid.getBidNum());
			psmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void deleteBid(String bidNum) {
		Connection con=null;
		PreparedStatement psmt=null;
		con=ConnectionUtil.getConnection();
		
		try {
			psmt=con.prepareStatement(
					"DELETE FROM BID " +
					"WHERE bidnum=?");
			psmt.setString(1,bidNum);
			psmt.executeUpdate();		
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}

	public static Bid selectBid(String bidNum) {
		Connection con=null;
		PreparedStatement psmt=null;
		Bid bid=null;
		
		String sql="SELECT b.a_num,b.userid,b.bid_time,b.bid_price," +
								  "a.g_num,a.s_price,a.im_price,a.s_time,a.e_time,a.sold,a.cu_price," +
								  "m.pw,m.name,m.email,m.coin,m.emoney," +
								  "g.gname,g.detail,g.img " +
					  "FROM BID b, AUCTION a, MEMBER m, GOOD g " +
					  "WHERE b.a_num=a.a_num AND b.userid=m.userid AND a.g_num=g.g_num AND b.bidnum=?";
		con=ConnectionUtil.getConnection();
		try {
			psmt=con.prepareStatement(sql);
			psmt.setString(1,bidNum);
			ResultSet rs=psmt.executeQuery();
			if(rs.next()){
				String aNum=rs.getString(1);
				String userid=rs.getString(2);
				String bidTime=rs.getString(3);
				String bidPrice=rs.getString(4);
				String gNum=rs.getString(5);
				String sPrice=rs.getString(6);
				String imPrice=rs.getString(7);
				String sTime=rs.getString(8);
				String eTime=rs.getString(9);
				String sold=rs.getString(10);
				String cuPrice=rs.getString(11);
				String pw=rs.getString(12);
				String name=rs.getString(13);
				String email=rs.getString(14);
				String coin=rs.getString(15);
				String emoney=rs.getString(16);
				String gName=rs.getString(17);
				String detail=rs.getString(18);
				String img=rs.getString(19);
				
				Member member=new Member();
				member.setUserid(userid);
				member.setName(name);
				member.setPw(pw);
				member.setEmail(email);
				member.setCoin(coin);
				member.setEmoney(emoney);
				
				Good good=new Good();
				good.setgNum(gNum);
				good.setgName(gName);
				good.setDetail(detail);
				good.setImg(img);
					
				Auction auction=new Auction();
				auction.setaNum(aNum);
				auction.setGood(good);
				auction.setsPrice(sPrice);
				auction.setImPrice(imPrice);
				auction.setsTime(sTime);
				auction.seteTime(eTime);
				boolean bSold=false;
				if("1".equals(sold)) bSold=true;
				auction.setSold(bSold);
				auction.setCuPrice(cuPrice);				
				
				bid=new Bid();
				bid.setBidNum(bidNum);
				bid.setMember(member);
				bid.setAuction(auction);
				bid.setBidTime(bidTime);
				bid.setBidPrice(bidPrice);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bid;
	}

	public static ArrayList<Bid> selectBidList() {
		Connection con=null;
		PreparedStatement psmt=null;
		ArrayList<Bid> bidList=null;
		
		String sql="SELECT b.bidnum,b.a_num,b.userid,b.bid_time,b.bid_price," +
								  "a.g_num,a.s_price,a.im_price,a.s_time,a.e_time,a.sold,a.cu_price," +
								  "m.pw,m.name,m.email,m.coin,m.emoney," +
								  "g.gname,g.detail,g.img " +
					  "FROM BID b, AUCTION a, MEMBER m, GOOD g " +
					  "WHERE b.a_num=a.a_num AND b.userid=m.userid AND a.g_num=g.g_num";
		con=ConnectionUtil.getConnection();
		try {
			psmt=con.prepareStatement(sql);
			ResultSet rs=psmt.executeQuery();
			bidList=new ArrayList<Bid>();
			while(rs.next()){
				String bidNum=rs.getString(1);
				String aNum=rs.getString(2);
				String userid=rs.getString(3);
				String bidTime=rs.getString(4);
				String bidPrice=rs.getString(5);
				String gNum=rs.getString(6);
				String sPrice=rs.getString(7);
				String imPrice=rs.getString(8);
				String sTime=rs.getString(9);
				String eTime=rs.getString(10);
				String sold=rs.getString(11);
				String cuPrice=rs.getString(12);
				String pw=rs.getString(13);
				String name=rs.getString(14);
				String email=rs.getString(15);
				String coin=rs.getString(16);
				String emoney=rs.getString(17);
				String gName=rs.getString(18);
				String detail=rs.getString(19);
				String img=rs.getString(20);
				
				Member member=new Member();
				member.setUserid(userid);
				member.setName(name);
				member.setPw(pw);
				member.setEmail(email);
				member.setCoin(coin);
				member.setEmoney(emoney);
				
				Good good=new Good();
				good.setgNum(gNum);
				good.setgName(gName);
				good.setDetail(detail);
				good.setImg(img);
					
				Auction auction=new Auction();
				auction.setaNum(aNum);
				auction.setGood(good);
				auction.setsPrice(sPrice);
				auction.setImPrice(imPrice);
				auction.setsTime(sTime);
				auction.seteTime(eTime);
				boolean bSold=false;
				if("1".equals(sold)) bSold=true;
				auction.setSold(bSold);
				auction.setCuPrice(cuPrice);				
				
				Bid bid=new Bid();
				bid.setBidNum(bidNum);
				bid.setMember(member);
				bid.setAuction(auction);
				bid.setBidTime(bidTime);
				bid.setBidPrice(bidPrice);
				
				bidList.add(bid);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bidList;
	}

	public static ArrayList<Bid> selectBidList(int length, int page) {
		Connection con=null;
		PreparedStatement psmt=null;
		ArrayList<Bid> bidList=null;
		
		String sql="SELECT b.bidnum,b.a_num,b.userid,b.bid_time,b.bid_price," +
								  "a.g_num,a.s_price,a.im_price,a.s_time,a.e_time,a.sold,a.cu_price," +
								  "m.pw,m.name,m.email,m.coin,m.emoney," +
								  "g.gname,g.detail,g.img " +
					  "FROM BID b, AUCTION a, MEMBER m, GOOD g " +
					  "WHERE b.a_num=a.a_num AND b.userid=m.userid AND a.g_num=g.g_num";
		con=ConnectionUtil.getConnection();
		try {
			bidList=new ArrayList<Bid>();
			
			//rs.absolute()가 가능하도록 설정
			psmt=con.prepareStatement(sql,
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			ResultSet rs=psmt.executeQuery();
			if(page>1) rs.absolute((page-1)*length);
			//가져온 레코드 개수
			int getRecordCount=0;
			
			while(rs.next()&&getRecordCount<length){
				getRecordCount++;
				String bidNum=rs.getString(1);
				String aNum=rs.getString(2);
				String userid=rs.getString(3);
				String bidTime=rs.getString(4);
				String bidPrice=rs.getString(5);
				String gNum=rs.getString(6);
				String sPrice=rs.getString(7);
				String imPrice=rs.getString(8);
				String sTime=rs.getString(9);
				String eTime=rs.getString(10);
				String sold=rs.getString(11);
				String cuPrice=rs.getString(12);
				String pw=rs.getString(13);
				String name=rs.getString(14);
				String email=rs.getString(15);
				String coin=rs.getString(16);
				String emoney=rs.getString(17);
				String gName=rs.getString(18);
				String detail=rs.getString(19);
				String img=rs.getString(20);
				
				Member member=new Member();
				member.setUserid(userid);
				member.setName(name);
				member.setPw(pw);
				member.setEmail(email);
				member.setCoin(coin);
				member.setEmoney(emoney);
				
				Good good=new Good();
				good.setgNum(gNum);
				good.setgName(gName);
				good.setDetail(detail);
				good.setImg(img);
					
				Auction auction=new Auction();
				auction.setaNum(aNum);
				auction.setGood(good);
				auction.setsPrice(sPrice);
				auction.setImPrice(imPrice);
				auction.setsTime(sTime);
				auction.seteTime(eTime);
				boolean bSold=false;
				if("1".equals(sold)) bSold=true;
				auction.setSold(bSold);
				auction.setCuPrice(cuPrice);				
				
				Bid bid=new Bid();
				bid.setBidNum(bidNum);
				bid.setMember(member);
				bid.setAuction(auction);
				bid.setBidTime(bidTime);
				bid.setBidPrice(bidPrice);
				
				bidList.add(bid);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bidList;
	}

	public static ArrayList<Bid> selectBidListByID(int length, int page, String userid) {
		Connection con=null;
		PreparedStatement psmt=null;
		ArrayList<Bid> bidList=null;
		
		String sql="SELECT b.bidnum,b.a_num,b.userid,b.bid_time,b.bid_price," +
								  "a.g_num,a.s_price,a.im_price,a.s_time,a.e_time,a.sold,a.cu_price," +
								  "m.pw,m.name,m.email,m.coin,m.emoney," +
								  "g.gname,g.detail,g.img " +
					  "FROM BID b, AUCTION a, MEMBER m, GOOD g " +
					  "WHERE b.a_num=a.a_num AND b.userid=m.userid AND a.g_num=g.g_num AND b.userid=?";
		con=ConnectionUtil.getConnection();
		try {
			
			bidList=new ArrayList<Bid>();
			
			//rs.absolute()가 가능하도록 설정
			psmt=con.prepareStatement(sql,
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			psmt.setString(1, userid);
			ResultSet rs=psmt.executeQuery();
			if(page>1) rs.absolute((page-1)*length);
			//가져온 레코드 개수
			int getRecordCount=0;
			
			while(rs.next()&&getRecordCount<length){
				getRecordCount++;
				String bidNum=rs.getString(1);
				String aNum=rs.getString(2);
				userid=rs.getString(3);
				String bidTime=rs.getString(4);
				String bidPrice=rs.getString(5);
				String gNum=rs.getString(6);
				String sPrice=rs.getString(7);
				String imPrice=rs.getString(8);
				String sTime=rs.getString(9);
				String eTime=rs.getString(10);
				String sold=rs.getString(11);
				String cuPrice=rs.getString(12);
				String pw=rs.getString(13);
				String name=rs.getString(14);
				String email=rs.getString(15);
				String coin=rs.getString(16);
				String emoney=rs.getString(17);
				String gName=rs.getString(18);
				String detail=rs.getString(19);
				String img=rs.getString(20);
				
				Member member=new Member();
				member.setUserid(userid);
				member.setName(name);
				member.setPw(pw);
				member.setEmail(email);
				member.setCoin(coin);
				member.setEmoney(emoney);
				
				Good good=new Good();
				good.setgNum(gNum);
				good.setgName(gName);
				good.setDetail(detail);
				good.setImg(img);
					
				Auction auction=new Auction();
				auction.setaNum(aNum);
				auction.setGood(good);
				auction.setsPrice(sPrice);
				auction.setImPrice(imPrice);
				auction.setsTime(sTime);
				auction.seteTime(eTime);
				boolean bSold=false;
				if("1".equals(sold)) bSold=true;
				auction.setSold(bSold);
				auction.setCuPrice(cuPrice);				
				
				Bid bid=new Bid();
				bid.setBidNum(bidNum);
				bid.setMember(member);
				bid.setAuction(auction);
				bid.setBidTime(bidTime);
				bid.setBidPrice(bidPrice);
				
				bidList.add(bid);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bidList;
	}

	public static ArrayList<Bid> selectBidListByAuctionNum(String aNum, int size) {
		Connection con=null;
		PreparedStatement psmt=null;
		ArrayList<Bid> bidList=null;
		
		String sql="SELECT b.bidnum,b.a_num,b.userid,b.bid_time,b.bid_price," +
								  "a.g_num,a.s_price,a.im_price,a.s_time,a.e_time,a.sold,a.cu_price," +
								  "m.pw,m.name,m.email,m.coin,m.emoney," +
								  "g.gname,g.detail,g.img " +
					  "FROM BID b, AUCTION a, MEMBER m, GOOD g " +
					  "WHERE b.a_num=a.a_num AND b.userid=m.userid AND a.g_num=g.g_num AND a.a_num=?";
		con=ConnectionUtil.getConnection();
		try {
			
			bidList=new ArrayList<Bid>();
			
			//rs.absolute()가 가능하도록 설정
			psmt=con.prepareStatement(sql);
			psmt.setString(1, aNum);
			ResultSet rs=psmt.executeQuery();
			//가져온 레코드 개수
			int getRecordCount=0;
			
			while(rs.next()&&getRecordCount<size){
				getRecordCount++;
				String bidNum=rs.getString(1);
				aNum=rs.getString(2);
				String userid=rs.getString(3);
				String bidTime=rs.getString(4);
				String bidPrice=rs.getString(5);
				String gNum=rs.getString(6);
				String sPrice=rs.getString(7);
				String imPrice=rs.getString(8);
				String sTime=rs.getString(9);
				String eTime=rs.getString(10);
				String sold=rs.getString(11);
				String cuPrice=rs.getString(12);
				String pw=rs.getString(13);
				String name=rs.getString(14);
				String email=rs.getString(15);
				String coin=rs.getString(16);
				String emoney=rs.getString(17);
				String gName=rs.getString(18);
				String detail=rs.getString(19);
				String img=rs.getString(20);
				
				Member member=new Member();
				member.setUserid(userid);
				member.setName(name);
				member.setPw(pw);
				member.setEmail(email);
				member.setCoin(coin);
				member.setEmoney(emoney);
				
				Good good=new Good();
				good.setgNum(gNum);
				good.setgName(gName);
				good.setDetail(detail);
				good.setImg(img);
					
				Auction auction=new Auction();
				auction.setaNum(aNum);
				auction.setGood(good);
				auction.setsPrice(sPrice);
				auction.setImPrice(imPrice);
				auction.setsTime(sTime);
				auction.seteTime(eTime);
				boolean bSold=false;
				if("1".equals(sold)) bSold=true;
				auction.setSold(bSold);
				auction.setCuPrice(cuPrice);				
				
				Bid bid=new Bid();
				bid.setBidNum(bidNum);
				bid.setMember(member);
				bid.setAuction(auction);
				bid.setBidTime(bidTime);
				bid.setBidPrice(bidPrice);
				
				bidList.add(bid);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bidList;
	}
}
