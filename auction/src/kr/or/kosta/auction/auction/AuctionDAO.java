package kr.or.kosta.auction.auction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import kr.or.kosta.auction.good.Good;
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
					"SELECT g.g_num,a.s_price,a.im_price,a.s_time,a.e_time,a.sold,a.cu_price,"+
							"g.gname,g.detail"+
					" FROM auction a,good g " +
					" WHERE a.g_num = g.g_num AND a.g_num=?");
			psmt.setString(1,aNum);
			ResultSet rs=psmt.executeQuery();
			if(rs.next()){
				String sPrice=rs.getString(2);
				String imPrice=rs.getString(3);
				String sTime=rs.getString(4);
				String eTime=rs.getString(5);
				String sold=rs.getString(5);
				String cuPrice=rs.getString(6);
				String gName=rs.getString(7);
				String detail=rs.getString(8);
				
				boolean bSold=false;
				if("1".equals(sold)) bSold=true;
				
				Good good = new Good();
				
				good.setDetail(detail);
				good.setgName(gName);
				
				auction.setCuPrice(cuPrice);
				auction.setSold(bSold);
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
