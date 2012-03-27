package kr.or.kosta.auction.auction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import kr.or.kosta.auction.bid.Bid;
import kr.or.kosta.auction.good.Good;
import kr.or.kosta.auction.member.Member;
import kr.or.kosta.auction.util.ConnectionUtil;



public class AuctionDAO {

	/**
	 * @param auction
	 */
	public void insertAuction(Auction auction) {
		Connection con=null;
		PreparedStatement psmt=null;
		con= ConnectionUtil.getConnection();
		try {
			psmt=con.prepareStatement(
					"INSERT INTO AUCTION "+
					"(g_num,s_price,im_price,a_num,s_time,e_time,sold,cu_price) "+
					"VALUES(seq_auc.nextval,?,?,seq_auc.nextval,sysdate,sysdate,0,?)");
			psmt.setString(1,auction.getsPrice());
			psmt.setString(2,auction.getImPrice());
			psmt.setString(3,auction.getCuPrice());
			psmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param auction
	 */
	public void updateAuction(Auction auction) {
		/* default generated stub */;
	}

	/**
	 * @param aNum
	 */
	public void deleteAuction(String aNum) {
		/* default generated stub */;
	}

	/**
	 * @param aNum
	 */
	public static Auction selectAuction(String aNum) {
		Connection con=null;
		PreparedStatement psmt=null;
		Auction auction = null;
		
		con=ConnectionUtil.getConnection();
		try {
			psmt=con.prepareStatement(
					"SELECT g.g_num,a.s_price,a.im_price,a.s_time,a.e_time,a.sold,a.cu_price"+
							"b.userid,b.bidnum,b.cu_time,b.cu_price," +
							"g.gname,g.detail"+
					" FROM auction a,bid b,good g " +
					" WHERE a.g_num = g.g_num AND a.a_num=b.a_num AND a.a_num=?");
			psmt.setString(1,aNum);
			ResultSet rs=psmt.executeQuery();
			if(rs.next()){
				String gNum=rs.getString(2);
				String sPrice=rs.getString(3);
				String imPrice=rs.getString(4);
				String sTime=rs.getString(5);
				String eTime=rs.getString(6);
				String cuPrice=rs.getString(7);
				String userid=rs.getString(8);
				String bidnum=rs.getString(9);
				String cuTime=rs.getString(10);
				String cuPrice1=rs.getString(11);
				String gName=rs.getString(12);
				String detail=rs.getString(13);
				
				Good good = new Good();
				
				good.setDetail(detail);
				good.setgName(gName);
				good.setgNum(gNum);
				
				Bid bid = new Bid();
				Member member = new Member();
				
				bid.setCuPrice(cuPrice1);
				bid.setCuTime(cuTime);
				bid.setBidNum(bidnum);
				bid.setMember(member);
				
				auction.setCuPrice(cuPrice);
				auction.seteTime(eTime);
				auction.setsTime(sTime);
				auction.setImPrice(imPrice);
				auction.setsPrice(sPrice);
				
				auction.setGood(good);
			
				
				
				
				
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return auction;
	}

	public ArrayList<Auction> selectAuctionList() {
		/* default generated stub */;
		return null;
	}

	public ArrayList<Auction> selectSoldList() {
		/* default generated stub */;
		return null;
	}

	/**
	 * @param length
	 * @param page
	 */
	public ArrayList<Auction> selectAuctionList(int length, int page) {
		/* default generated stub */;
		return null;
	}

	/**
	 * @param length
	 * @param page
	 */
	public ArrayList<Auction> selectSoldList(int length, int page) {
		/* default generated stub */;
		return null;
	}
}
