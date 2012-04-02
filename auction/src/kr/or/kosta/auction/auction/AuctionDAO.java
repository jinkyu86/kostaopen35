package kr.or.kosta.auction.auction;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.or.kosta.auction.good.Good;
import kr.or.kosta.auction.util.ConnectionUtil;

public class AuctionDAO {

	/**
	 * @param auction
	 */
	public static void insertAuction(Auction auction) {
		Connection con = null;
		PreparedStatement psmt = null;
		con = ConnectionUtil.getConnection();
		try {
			psmt = con
					.prepareStatement("INSERT INTO AUCTION "
							+ "(g_num," +
							"s_price," +
							"im_price," +
							"a_num," +
							"s_time," +
							"e_time," +
							"sold," +
							"cu_price) "
							+ "VALUES(?,?,?,auc_seq.nextval,?,?,'0',?)");
			psmt.setString(1, auction.getGood().getgNum());
			psmt.setString(2, auction.getsPrice());
			psmt.setString(3, auction.getImPrice());
			psmt.setString(4, auction.getsTime());
			psmt.setString(5, auction.geteTime());
			psmt.setString(6, auction.getCuPrice());
					
			psmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param auction
	 */
	public static void updateAuction(Auction auction) {
		Connection con = null;
		PreparedStatement psmt = null;
		con = ConnectionUtil.getConnection();

		try {
			psmt = con.prepareStatement("UPDATE auction " 
					+ "SET g_num = ?," 
					+ "s_price=?," 
					+ "im_price=?," 
					+ "sold=?, "
					+ "cu_price=?," 
					+ "s_time=to_date(?,'yyyy-mm-dd hh24:mi:ss')," 
					+ "e_time=to_date(?,'yyyy-mm-dd hh24:mi:ss')  " 
					+ "WHERE a_num=?");

			psmt.setString(1, auction.getGood().getgNum());
			psmt.setString(2, auction.getsPrice());
			psmt.setString(3, auction.getImPrice());
			psmt.setBoolean(4, auction.isSold());
			psmt.setString(5, auction.getCuPrice());
			psmt.setString(6, auction.getsTime());
			psmt.setString(7, auction.geteTime());
			psmt.setString(8, auction.getaNum());
			psmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @param aNum
	 */
	public static void deleteAuction(String aNum) {
		Connection con = null;
		PreparedStatement psmt = null;
		con = ConnectionUtil.getConnection();
		try {
			psmt = con.prepareStatement(" DELETE FROM AUCTION"
					+ " WHERE a_num = ? ");
			psmt.setString(1, aNum);
			psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param aNum
	 */
	public static Auction selectAuction(String aNum) {
		Connection con = null;
		PreparedStatement psmt = null;
		Auction auction = null;

		con = ConnectionUtil.getConnection();
		try {
			psmt = con
					.prepareStatement("SELECT a.g_num,a.s_price,a.im_price,to_char(a.s_time,'yyyy-mm-dd hh24:mi:ss'),to_char(a.e_time,'yyyy-mm-dd hh24:mi:ss'),a.sold,a.cu_price,"
							+ "g.gname,g.detail,g.img"
							+ " FROM auction a,good g "
							+ " WHERE a.g_num = g.g_num AND a.a_num=?");
			psmt.setString(1, aNum);
			ResultSet rs = psmt.executeQuery();
			if (rs.next()) {
				String gNum = rs.getString(1);
				String sPrice = rs.getString(2);
				String imPrice = rs.getString(3);
				String sTime = rs.getString(4);
				String eTime = rs.getString(5);
				String sold = rs.getString(6);
				String cuPrice = rs.getString(7);
				String gName = rs.getString(8);
				String detail = rs.getString(9);
				String img = rs.getString(10);

				boolean bSold = false;
				if ("1".equals(sold))
					bSold = true;

				Good good = new Good();

				good.setDetail(detail);
				good.setgName(gName);
				good.setgNum(gNum);
				good.setImg(img);
				auction = new Auction();
				
				auction.setaNum(aNum);
				auction.setSold(bSold);
				auction.seteTime(eTime);
				auction.setsTime(sTime);
				auction.setCuPrice(cuPrice);
				auction.setImPrice(imPrice);
				auction.setsPrice(sPrice);
				auction.setGood(good);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return auction;
	}

	public static ArrayList<Auction> selectAuctionList() {
		Connection con = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		String sql = null;
		ArrayList<Auction> auctionList = new ArrayList<Auction>();

		try {
			con = ConnectionUtil.getConnection();
			sql = "SELECT a.a_num,a.s_price,a.im_price,a.s_time,a.e_time,a.sold,a.cu_price,"
					+ "g.g_num,g.gname,g.detail,g.img"
					+ " FROM auction a,good g "
					+ " WHERE a.g_num = g.g_num " +
					" AND a.e_time>=sysdate AND a.sold='0'" +
					" ORDER BY a.e_time , a.a_num";
			psmt = con.prepareStatement(sql);

			rs = psmt.executeQuery();
			while (rs.next()) {
				String aNum = rs.getString(1); 
				String sPrice = rs.getString(2);
				String imPrice = rs.getString(3);
				String sTime = rs.getString(4);
				String eTime = rs.getString(5);
				String sold = rs.getString(6);
				String cuPrice = rs.getString(7);
				String gNum = rs.getString(8);
				String gname = rs.getString(9);
				String detail = rs.getString(10);
				String img = rs.getString(11);
				

				Good good = new Good();
				good.setDetail(detail);
				good.setgName(gname);
				good.setgNum(gNum);
				good.setImg(img);

				Auction auction = new Auction();

				boolean bsold = false;
				if ("1".equals(sold))
					bsold = true;
				
				auction.setaNum(aNum);
				auction.setCuPrice(cuPrice);
				auction.setSold(bsold);
				auction.seteTime(eTime);
				auction.setsTime(sTime);
				auction.setImPrice(imPrice);
				auction.setsPrice(sPrice);
				auction.setGood(good);

				auctionList.add(auction);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return auctionList;
	}

	public static ArrayList<Auction> selectSoldList() {
		Connection con = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		String sql = null;
		ArrayList<Auction> auctionList = new ArrayList<Auction>();

		try {
			con = ConnectionUtil.getConnection();
			sql = "SELECT a.a_num,a.s_price,a.im_price,a.s_time,a.e_time,a.sold,a.cu_price,"
					+ "g.g_num,g.gname,g.detail,g.img"
					+ " FROM auction a,good g "
					+ " WHERE a.g_num = g.g_num" +
					" AND a.sold='1'" +
					" ORDER BY a.e_time desc, a.a_num";
			psmt = con.prepareStatement(sql);

			rs = psmt.executeQuery();
			while (rs.next()) {
				String aNum = rs.getString(1); 
				String sPrice = rs.getString(2);
				String imPrice = rs.getString(3);
				String sTime = rs.getString(4);
				String eTime = rs.getString(5);
				String sold = rs.getString(6);
				String cuPrice = rs.getString(7);
				String gNum = rs.getString(8);
				String gname = rs.getString(9);
				String detail = rs.getString(10);
				String img = rs.getString(11);
				

				Good good = new Good();
				good.setDetail(detail);
				good.setgName(gname);
				good.setgNum(gNum);
				good.setImg(img);

				Auction auction = new Auction();

				boolean bsold = false;
				if ("1".equals(sold))
					bsold = true;
				
				auction.setaNum(aNum);
				auction.setCuPrice(cuPrice);
				auction.setSold(bsold);
				auction.seteTime(eTime);
				auction.setsTime(sTime);
				auction.setImPrice(imPrice);
				auction.setsPrice(sPrice);
				auction.setGood(good);

				auctionList.add(auction);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return auctionList;
	}

	/**
	 * @param length
	 * @param page
	 */
	public static ArrayList<Auction> selectAuctionList(int length, int page) {
		Connection con = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		String sql = null;
		ArrayList<Auction> auctionList = new ArrayList<Auction>();

		try {
			con = ConnectionUtil.getConnection();
			sql = "SELECT a.a_num,a.s_price,a.im_price,a.s_time,a.e_time,a.sold,a.cu_price,"
					+ "g.g_num,g.gname,g.detail,g.img"
					+ " FROM auction a,good g "
					+ " WHERE a.g_num = g.g_num " +
					" AND a.e_time>=sysdate AND a.sold='0'" +
					" ORDER BY a.e_time , a.a_num";
			psmt = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			rs = psmt.executeQuery();
			if (page > 1) {
				rs.absolute((page - 1) * length);
			}
			int getRecordCount = 0;
			while (rs.next() && getRecordCount < length) {
				getRecordCount++;
				String aNum = rs.getString(1); 
				String sPrice = rs.getString(2);
				String imPrice = rs.getString(3);
				String sTime = rs.getString(4);
				String eTime = rs.getString(5);
				String sold = rs.getString(6);
				String cuPrice = rs.getString(7);
				String gNum = rs.getString(8);
				String gname = rs.getString(9);
				String detail = rs.getString(10);
				String img = rs.getString(11);
				

				Good good = new Good();
				good.setDetail(detail);
				good.setgName(gname);
				good.setgNum(gNum);
				good.setImg(img);

				Auction auction = new Auction();

				boolean bsold = false;
				if ("1".equals(sold))
					bsold = true;
				
				auction.setaNum(aNum);
				auction.setCuPrice(cuPrice);
				auction.setSold(bsold);
				auction.seteTime(eTime);
				auction.setsTime(sTime);
				auction.setImPrice(imPrice);
				auction.setsPrice(sPrice);
				auction.setGood(good);

				auctionList.add(auction);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return auctionList;
	}

	/**
	 * psmt=con.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE,
	 * ResultSet.CONCUR_READ_ONLY); rs=psmt.executeQuery(); if(page>1){
	 * rs.absolute((page-1)*length); } // 가져온 레코드 개수 int getRecordCount =0;
	 * while(rs.next()&&getRecordCount<length){ getRecordCount++;
	 */
	public static ArrayList<Auction> selectSoldList(int length, int page) {
		Connection con = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		String sql = null;
		ArrayList<Auction> auctionList = new ArrayList<Auction>();

		try {
			con = ConnectionUtil.getConnection();
			sql = "SELECT a.a_num,a.s_price,a.im_price,a.s_time,a.e_time,a.sold,a.cu_price,"
					+ "g.g_num,g.gname,g.detail,g.img"
					+ " FROM auction a,good g "
					+ " WHERE a.g_num = g.g_num AND sold = '1' " +
					"order by a.e_time desc , a.a_num";
			psmt = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			rs = psmt.executeQuery();
			if (page > 1) {
				rs.absolute((page - 1) * length);
			}
			int getRecordCount = 0;
			while (rs.next() && getRecordCount < length) {
				getRecordCount++;
				String aNum = rs.getString(1); 
				String sPrice = rs.getString(2);
				String imPrice = rs.getString(3);
				String sTime = rs.getString(4);
				String eTime = rs.getString(5);
				String sold = rs.getString(6);
				String cuPrice = rs.getString(7);
				String gNum = rs.getString(8);
				String gname = rs.getString(9);
				String detail = rs.getString(10);
				String img = rs.getString(11);
				

				Good good = new Good();
				good.setDetail(detail);
				good.setgName(gname);
				good.setgNum(gNum);
				good.setImg(img);

				Auction auction = new Auction();

				boolean bsold = false;
				if ("1".equals(sold))
					bsold = true;
				
				auction.setaNum(aNum);
				auction.setCuPrice(cuPrice);
				auction.setSold(bsold);
				auction.seteTime(eTime);
				auction.setsTime(sTime);
				auction.setImPrice(imPrice);
				auction.setsPrice(sPrice);
				auction.setGood(good);

				auctionList.add(auction);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return auctionList;
	}
}
