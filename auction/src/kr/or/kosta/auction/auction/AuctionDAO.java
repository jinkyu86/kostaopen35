package kr.or.kosta.auction.auction;

import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kr.or.kosta.auction.good.Good;
import kr.or.kosta.auction.util.ConnectionUtil;

public class AuctionDAO {

	private static String resource = "sqlmap-config.xml";
	private static Reader sqlReader;
	static {
		try {
			sqlReader = Resources.getResourceAsReader(resource);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	private static SqlSessionFactory sqlMapper = new SqlSessionFactoryBuilder().build(sqlReader);

	/**
	 * @param good
	 */
	public static void insertAuction(Auction auction) {
		SqlSession session = null;
		try {
			session = sqlMapper.openSession(true);
			session.insert("Auction.insertAuction", auction);
		} finally {
			session.close();
		}
	}
	public static void updateAuction(Auction auction){
		SqlSession session = null;
		try {
			session = sqlMapper.openSession(true);
			session.update("Auction.updateAuction", auction);
		} finally {
			session.close();
		}		
	}
	public static void deleteAuction(String aNum){
		SqlSession session = null;
		try {
			session = sqlMapper.openSession(true);
			session.delete("Auction.deleteAuction", aNum);
		} finally {
			session.close();
		}
	}
	public static Auction selectAuction(String aNum){
		SqlSession session = null;
		Auction auction = null;
		try{
			session = sqlMapper.openSession(true);
			auction = session.selectOne("Auction.selectAuction", aNum);
		} finally {
			session.close();
		}return auction;
	}
	public static List<Auction> selectAuctionList(){
		SqlSession session = null;
		List<Auction> auctionList = null;
		try{
			session = sqlMapper.openSession(true);
			auctionList = session.selectList("Auction.selectAuctionList");
		} finally {
			session.close();
		}
		return auctionList;
	}
	public static Auction selectAuctionSoldById(String userid){
		SqlSession session = null;
		Auction auction = null;
		try{
			session = sqlMapper.openSession(true);
			auction = session.selectOne("selectAuctionSoldById",userid);
		} finally {
			session.close();
		}
		return auction;
	}
	public static List<Auction> selectAuctionSoldList(){
		SqlSession session = null;
		List<Auction> auctionSoldList = null;
		try{
			session = sqlMapper.openSession(true);
			auctionSoldList = session.selectList("selectAuctionSoldList");
		} finally {
			session.close();
		}
		return auctionSoldList;
	}
}
/*
 * @param auction
 * 
 * public static void insertAuction(Auction auction) { Connection con = null;
 * PreparedStatement psmt = null; con = ConnectionUtil.getConnection(); try {
 * psmt = con .prepareStatement("INSERT INTO AUCTION " + "(g_num," + "s_price,"
 * + "im_price," + "a_num," + "s_time," + "e_time," + "sold," + "cu_price) " +
 * "VALUES(?,?,?,auc_seq.nextval,?,?,'0',?)"); psmt.setString(1,
 * auction.getGood().getgNum()); psmt.setString(2, auction.getsPrice());
 * psmt.setString(3, auction.getImPrice()); psmt.setString(4,
 * auction.getsTime()); psmt.setString(5, auction.geteTime()); psmt.setString(6,
 * auction.getCuPrice());
 * 
 * psmt.executeUpdate(); } catch (Exception e) { e.printStackTrace(); } }
 * 
 * 
 * 
 * public static void updateAuction(Auction auction) { Connection con = null;
 * PreparedStatement psmt = null; con = ConnectionUtil.getConnection();
 * 
 * try { psmt = con.prepareStatement("UPDATE auction " + "SET g_num = ?," +
 * "s_price=?," + "im_price=?," + "sold=?, " + "cu_price=?," +
 * "s_time=to_date(?,'yyyy/mm/dd hh24:mi:ss')," +
 * "e_time=to_date(?,'yyyy/mm/dd hh24:mi:ss')," + "userid=? " +
 * "WHERE a_num=?");
 * 
 * psmt.setString(1, auction.getGood().getgNum()); psmt.setString(2,
 * auction.getsPrice()); psmt.setString(3, auction.getImPrice()); psmt.setInt(4,
 * auction.getSold()); psmt.setString(5, auction.getCuPrice());
 * psmt.setString(6, auction.getsTime()); psmt.setString(7, auction.geteTime());
 * psmt.setString(8, auction.getUserid()); psmt.setString(9, auction.getaNum());
 * psmt.executeUpdate(); } catch (Exception e) { // TODO Auto-generated catch
 * block e.printStackTrace(); } }
 * 
 * 
 * public static void deleteAuction(String aNum) { Connection con = null;
 * PreparedStatement psmt = null; con = ConnectionUtil.getConnection(); try {
 * psmt = con.prepareStatement(" DELETE FROM AUCTION" + " WHERE a_num = ? ");
 * psmt.setString(1, aNum); psmt.executeUpdate(); } catch (SQLException e) {
 * e.printStackTrace(); } }
 * 
 * 
 * public static Auction selectAuction(String aNum) { Connection con = null;
 * PreparedStatement psmt = null; Auction auction = null;
 * 
 * con = ConnectionUtil.getConnection(); try { psmt = con .prepareStatement(
 * "SELECT a.g_num,a.s_price,a.im_price,to_char(a.s_time,'yyyy/mm/dd hh24:mi:ss'),to_char(a.e_time,'yyyy/mm/dd hh24:mi:ss'),a.sold,a.cu_price,a.userid,"
 * + "g.gname,g.detail,g.img" + " FROM auction a,good g " +
 * " WHERE a.g_num = g.g_num AND a.a_num=?"); psmt.setString(1, aNum); ResultSet
 * rs = psmt.executeQuery(); if (rs.next()) { String gNum = rs.getString(1);
 * String sPrice = rs.getString(2); String imPrice = rs.getString(3); String
 * sTime = rs.getString(4); String eTime = rs.getString(5); int sold =
 * rs.getInt(6); String cuPrice = rs.getString(7); String userid =
 * rs.getString(8); String gName = rs.getString(9); String detail =
 * rs.getString(10); String img = rs.getString(11);
 * 
 * Good good = new Good();
 * 
 * good.setDetail(detail); good.setgName(gName); good.setgNum(gNum);
 * good.setImg(img); auction = new Auction();
 * 
 * auction.setaNum(aNum); auction.setSold(sold); auction.seteTime(eTime);
 * auction.setsTime(sTime); auction.setCuPrice(cuPrice);
 * auction.setImPrice(imPrice); auction.setsPrice(sPrice);
 * auction.setGood(good); auction.setUserid(userid); } } catch (Exception e) {
 * e.printStackTrace(); } return auction; }
 * 
 * public static ArrayList<Auction> selectAuctionList() { Connection con = null;
 * PreparedStatement psmt = null; ResultSet rs = null; String sql = null;
 * ArrayList<Auction> auctionList = new ArrayList<Auction>();
 * 
 * try { con = ConnectionUtil.getConnection(); sql =
 * "SELECT a.a_num,a.s_price,a.im_price,to_char(a.s_time,'yyyy/mm/dd hh24:mi:ss'),to_char(a.e_time,'yyyy/mm/dd hh24:mi:ss'),a.sold,a.cu_price,a.userid,"
 * + "g.g_num,g.gname,g.detail,g.img" + " FROM auction a,good g " +
 * " WHERE a.g_num = g.g_num " + " AND a.e_time>=sysdate AND a.sold='0'" +
 * " ORDER BY a.e_time, a.a_num"; psmt = con.prepareStatement(sql);
 * 
 * rs = psmt.executeQuery(); while (rs.next()) { String aNum = rs.getString(1);
 * String sPrice = rs.getString(2); String imPrice = rs.getString(3); String
 * sTime = rs.getString(4); String eTime = rs.getString(5); int
 * sold=rs.getInt(6); String cuPrice = rs.getString(7); String userid =
 * rs.getString(8); String gNum = rs.getString(9); String gname =
 * rs.getString(10); String detail = rs.getString(11); String img =
 * rs.getString(12);
 * 
 * 
 * Good good = new Good(); good.setDetail(detail); good.setgName(gname);
 * good.setgNum(gNum); good.setImg(img);
 * 
 * Auction auction = new Auction();
 * 
 * 
 * auction.setaNum(aNum); auction.setCuPrice(cuPrice); auction.setSold(sold);
 * auction.seteTime(eTime); auction.setsTime(sTime);
 * auction.setImPrice(imPrice); auction.setsPrice(sPrice);
 * auction.setGood(good); auction.setUserid(userid);
 * 
 * auctionList.add(auction); } } catch (Exception e) { e.printStackTrace(); }
 * return auctionList; }
 * 
 * public static ArrayList<Auction> selectSoldListById(String userid){
 * Connection con = null; PreparedStatement psmt = null; ResultSet rs = null;
 * String sql = null; ArrayList<Auction> auctionList = new ArrayList<Auction>();
 * 
 * try { con = ConnectionUtil.getConnection(); sql =
 * "SELECT a.a_num,a.s_price,a.im_price,to_char(a.s_time,'yyyy/mm/dd hh24:mi:ss'),to_char(a.e_time,'yyyy/mm/dd hh24:mi:ss'),a.sold,a.cu_price,a.userid,"
 * + "g.g_num,g.gname,g.detail,g.img" + " FROM auction a,good g " +
 * " WHERE a.g_num = g.g_num AND (a.e_time<sysdate OR a.sold='1') AND a.userid=?"
 * + " ORDER BY a.e_time , a.a_num"; psmt = con.prepareStatement(sql);
 * psmt.setString(1, userid);
 * 
 * rs = psmt.executeQuery(); while (rs.next()) { String aNum = rs.getString(1);
 * String sPrice = rs.getString(2); String imPrice = rs.getString(3); String
 * sTime = rs.getString(4); String eTime = rs.getString(5); int
 * sold=rs.getInt(6); String cuPrice = rs.getString(7); userid =
 * rs.getString(8); String gNum = rs.getString(9); String gname =
 * rs.getString(10); String detail = rs.getString(11); String img =
 * rs.getString(12);
 * 
 * Good good = new Good(); good.setDetail(detail); good.setgName(gname);
 * good.setgNum(gNum); good.setImg(img);
 * 
 * Auction auction = new Auction();
 * 
 * auction.setaNum(aNum); auction.setCuPrice(cuPrice); auction.setSold(sold);
 * auction.seteTime(eTime); auction.setsTime(sTime);
 * auction.setImPrice(imPrice); auction.setsPrice(sPrice);
 * auction.setGood(good); auction.setUserid(userid);
 * 
 * auctionList.add(auction); } } catch (Exception e) { e.printStackTrace(); }
 * return auctionList; }
 * 
 * public static ArrayList<Auction> selectSoldList() { Connection con = null;
 * PreparedStatement psmt = null; ResultSet rs = null; String sql = null;
 * ArrayList<Auction> auctionList = new ArrayList<Auction>();
 * 
 * try { con = ConnectionUtil.getConnection(); sql =
 * "SELECT a.a_num,a.s_price,a.im_price,to_char(a.s_time,'yyyy/mm/dd hh24:mi:ss'),to_char(a.e_time,'yyyy/mm/dd hh24:mi:ss'),a.sold,a.cu_price,userid,"
 * + "g.g_num,g.gname,g.detail,g.img" + " FROM auction a,good g " +
 * " WHERE a.g_num = g.g_num" + " AND (a.sold='1' OR a.e_time<sysdate) " +
 * " ORDER BY a.e_time desc, a.a_num"; psmt = con.prepareStatement(sql);
 * 
 * rs = psmt.executeQuery(); while (rs.next()) { String aNum = rs.getString(1);
 * String sPrice = rs.getString(2); String imPrice = rs.getString(3); String
 * sTime = rs.getString(4); String eTime = rs.getString(5); int
 * sold=rs.getInt(6); String cuPrice = rs.getString(7); String userid =
 * rs.getString(8); String gNum = rs.getString(9); String gname =
 * rs.getString(10); String detail = rs.getString(11); String img =
 * rs.getString(12);
 * 
 * 
 * Good good = new Good(); good.setDetail(detail); good.setgName(gname);
 * good.setgNum(gNum); good.setImg(img);
 * 
 * Auction auction = new Auction();
 * 
 * auction.setaNum(aNum); auction.setCuPrice(cuPrice); auction.setSold(sold);
 * auction.seteTime(eTime); auction.setsTime(sTime);
 * auction.setImPrice(imPrice); auction.setsPrice(sPrice);
 * auction.setGood(good); auction.setUserid(userid);
 * 
 * auctionList.add(auction); } } catch (Exception e) { e.printStackTrace(); }
 * return auctionList; }
 * 
 * 
 * public static ArrayList<Auction> selectAuctionList(int length, int page) {
 * Connection con = null; PreparedStatement psmt = null; ResultSet rs = null;
 * String sql = null; ArrayList<Auction> auctionList = new ArrayList<Auction>();
 * 
 * try { con = ConnectionUtil.getConnection(); sql =
 * "SELECT a.a_num,a.s_price,a.im_price,to_char(a.s_time,'yyyy/mm/dd hh24:mi:ss'),to_char(a.e_time,'yyyy/mm/dd hh24:mi:ss'),a.sold,a.cu_price,a.userid,"
 * + "g.g_num,g.gname,g.detail,g.img" + " FROM auction a,good g " +
 * " WHERE a.g_num = g.g_num " + " AND a.e_time>=sysdate AND a.sold='0'" +
 * " ORDER BY a.e_time , a.a_num"; psmt = con.prepareStatement(sql,
 * ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY); rs =
 * psmt.executeQuery(); if (page > 1) { rs.absolute((page - 1) * length); } int
 * getRecordCount = 0; while (rs.next() && getRecordCount < length) {
 * getRecordCount++; String aNum = rs.getString(1); String sPrice =
 * rs.getString(2); String imPrice = rs.getString(3); String sTime =
 * rs.getString(4); String eTime = rs.getString(5); int sold=rs.getInt(6);
 * String cuPrice = rs.getString(7); String userid = rs.getString(8); String
 * gNum = rs.getString(9); String gname = rs.getString(10); String detail =
 * rs.getString(11); String img = rs.getString(12);
 * 
 * 
 * Good good = new Good(); good.setDetail(detail); good.setgName(gname);
 * good.setgNum(gNum); good.setImg(img);
 * 
 * Auction auction = new Auction();
 * 
 * auction.setaNum(aNum); auction.setCuPrice(cuPrice); auction.setSold(sold);
 * auction.seteTime(eTime); auction.setsTime(sTime);
 * auction.setImPrice(imPrice); auction.setsPrice(sPrice);
 * auction.setGood(good); auction.setUserid(userid);
 * 
 * auctionList.add(auction); } } catch (Exception e) { e.printStackTrace(); }
 * return auctionList; }
 * 
 * /** psmt=con.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE,
 * ResultSet.CONCUR_READ_ONLY); rs=psmt.executeQuery(); if(page>1){
 * rs.absolute((page-1)*length); } // 가져온 레코드 개수 int getRecordCount =0;
 * while(rs.next()&&getRecordCount<length){ getRecordCount++;
 * 
 * public static ArrayList<Auction> selectSoldList(int length, int page) {
 * Connection con = null; PreparedStatement psmt = null; ResultSet rs = null;
 * String sql = null; ArrayList<Auction> auctionList = new ArrayList<Auction>();
 * 
 * try { con = ConnectionUtil.getConnection(); sql =
 * "SELECT a.a_num,a.s_price,a.im_price,to_char(a.s_time,'yyyy/mm/dd hh24:mi:ss'),to_char(a.e_time,'yyyy/mm/dd hh24:mi:ss'),a.sold,a.cu_price,a.userid,"
 * + "g.g_num,g.gname,g.detail,g.img" + " FROM auction a,good g " +
 * " WHERE a.g_num = g.g_num AND (a.sold = '1' OR a.e_time<sysdate) " +
 * "order by a.e_time desc , a.a_num"; psmt = con.prepareStatement(sql,
 * ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY); rs =
 * psmt.executeQuery(); if (page > 1) { rs.absolute((page - 1) * length); } int
 * getRecordCount = 0; while (rs.next() && getRecordCount < length) {
 * getRecordCount++; String aNum = rs.getString(1); String sPrice =
 * rs.getString(2); String imPrice = rs.getString(3); String sTime =
 * rs.getString(4); String eTime = rs.getString(5); int sold=rs.getInt(6);
 * String cuPrice = rs.getString(7); String userid=rs.getString(8); String gNum
 * = rs.getString(9); String gname = rs.getString(10); String detail =
 * rs.getString(11); String img = rs.getString(12);
 * 
 * 
 * Good good = new Good(); good.setDetail(detail); good.setgName(gname);
 * good.setgNum(gNum); good.setImg(img);
 * 
 * Auction auction = new Auction();
 * 
 * auction.setaNum(aNum); auction.setCuPrice(cuPrice); auction.setSold(sold);
 * auction.seteTime(eTime); auction.setsTime(sTime);
 * auction.setImPrice(imPrice); auction.setsPrice(sPrice);
 * auction.setGood(good); auction.setUserid(userid);
 * 
 * auctionList.add(auction); } } catch (Exception e) { e.printStackTrace(); }
 * return auctionList; } }
 */
