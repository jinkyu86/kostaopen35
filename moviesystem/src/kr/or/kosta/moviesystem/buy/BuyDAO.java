package kr.or.kosta.moviesystem.buy;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import kr.or.kosta.moviesystem.good.Good;
import kr.or.kosta.moviesystem.member.Member;
import kr.or.kosta.moviesystem.util.ConnectionUtil;

public class BuyDAO {
	
	/**
	 * 구매할 상품을 선택해서 Buy목록에 담는 메서드
	 * 
	 * @param buy
	 */
	public static void insertBuy(Buy buy) {
		/* default generated stub */;
		Connection con=null;
		PreparedStatement psmt=null;
		Good good=null;
		Member member=null;
		
		con=ConnectionUtil.getConnection();
		
		try {
		String sql="INSERT INTO buy (buy_num,g_num,qty,userid,buy_date,pay_state,total_price) VALUES(SQ_BUY.NEXTVAL,?,?,?,SYSDATE,0,?)";
		good=new Good();
		member=new Member();
		
		psmt=con.prepareStatement(sql);
		psmt.setString(1, buy.getGood().getGnum());
		psmt.setLong(2, buy.getQty());
		psmt.setString(3, buy.getMember().getUserid());
		psmt.setLong(4, buy.getGood().getGprice()*buy.getQty());
		psmt.executeUpdate();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 전체 구매목록 조회 기능
	 * 
	 * @param userid1
	 * @param length
	 * @param page
	 */
	public static ArrayList<Buy> selectBuyList(String userid1, int length, int page) {
		/* default generated stub */;
		Connection con=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		Member member=null;
		Good good=null;
		Buy buy=null;
		
		ArrayList<Buy>buyList=new ArrayList<Buy>();
		
		con=ConnectionUtil.getConnection();
		
		try {
		String sql="SELECT user_num,m.userid,name,email,phone,zipcode,addr," +
				"g.g_num,g_name,detail,g_price,photo," +
				"buy_num,qty,buy_date,pay_state,total_price " +
				"FROM member m,good g, buy b " +
				"WHERE m.userid=b.userid AND g.g_num=b.g_num AND m.userid=? AND pay_state=0 ORDER BY buy_date DESC ";
		
			psmt=con.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			psmt.setString(1, userid1);
			psmt.executeUpdate();
			rs=psmt.executeQuery();
			
			 if(page>1){
					rs.absolute((page-1)*length);
					}
			 int getRecordCount=0;
			while(rs.next()&&getRecordCount<length){
				getRecordCount++;
				String user_num=rs.getString(1);
				String userid=rs.getString(2);
				String name=rs.getString(3);
				String email=rs.getString(4);
				String phone=rs.getString(5);
				String zipcode=rs.getString(6);
				String addr=rs.getString(7);
				
				String g_num=rs.getString(8);
				String g_name=rs.getString(9);
				String detail=rs.getString(10);
				long g_price=Long.parseLong(rs.getString(11));
				String photo =rs.getString(12);
				
				String buy_num=rs.getString(13);
				long qty=Long.parseLong(rs.getString(14));
				Date buy_date=rs.getDate(15);
				String pay_state=rs.getString(16);
				long total_price=Long.parseLong(rs.getString(17));
				
				member=new Member();
				member.setUserNum(user_num);
				member.setUserid(userid);
				member.setName(name);
				member.setEmail(email);
				member.setPhone(phone);
				member.setZipcode(zipcode);
				member.setAddr(addr);
				
				good=new Good();
				good.setGnum(g_num);
				good.setGname(g_name);
				good.setDetail(detail);
				good.setGprice(g_price);
				good.setPhoto(photo);
				
				buy=new Buy();
				buy.setBuynum(buy_num);
				buy.setQty(qty);
				buy.setBuyDate(buy_date);
				buy.setPayState(pay_state);
				buy.setTotalPrice(total_price);
				
				buy.setMember(member);
				buy.setGood(good);
				
				buyList.add(buy);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return buyList;
	}
	

	public static ArrayList<Buy> selectCancelableBuyList(String userid1, int length, int page) {
		Connection con=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		Member member=null;
		Good good=null;
		Buy buy=null;
		
		ArrayList<Buy>buyList=new ArrayList<Buy>();
		
		con=ConnectionUtil.getConnection();
		
		try {
		String sql="SELECT user_num,m.userid,name,email,phone,zipcode,addr," +
				"g.g_num,g_name,detail,g_price,photo," +
				"buy_num,qty,buy_date,pay_state,total_price " +
				"FROM member m,good g, buy b " +
				"WHERE m.userid=b.userid AND g.g_num=b.g_num AND m.userid=? AND pay_state=0 AND buy_date BETWEEN sysdate-7 AND sysdate ORDER BY buy_date DESC ";
		
			psmt=con.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			psmt.setString(1, userid1);
			psmt.executeUpdate();
			rs=psmt.executeQuery();
			
			 if(page>1){
					rs.absolute((page-1)*length);
					}
			 int getRecordCount=0;
			while(rs.next()&&getRecordCount<length){
				getRecordCount++;
				String user_num=rs.getString(1);
				String userid=rs.getString(2);
				String name=rs.getString(3);
				String email=rs.getString(4);
				String phone=rs.getString(5);
				String zipcode=rs.getString(6);
				String addr=rs.getString(7);
				
				String g_num=rs.getString(8);
				String g_name=rs.getString(9);
				String detail=rs.getString(10);
				long g_price=Long.parseLong(rs.getString(11));
				String photo =rs.getString(12);
				
				String buy_num=rs.getString(13);
				long qty=Long.parseLong(rs.getString(14));
				Date buy_date=rs.getDate(15);
				String pay_state=rs.getString(16);
				long total_price=Long.parseLong(rs.getString(17));
				
				member=new Member();
				member.setUserNum(user_num);
				member.setUserid(userid);
				member.setName(name);
				member.setEmail(email);
				member.setPhone(phone);
				member.setZipcode(zipcode);
				member.setAddr(addr);
				
				good=new Good();
				good.setGnum(g_num);
				good.setGname(g_name);
				good.setDetail(detail);
				good.setGprice(g_price);
				good.setPhoto(photo);
				
				buy=new Buy();
				buy.setBuynum(buy_num);
				buy.setQty(qty);
				buy.setBuyDate(buy_date);
				buy.setPayState(pay_state);
				buy.setTotalPrice(total_price);
				
				buy.setMember(member);
				buy.setGood(good);
				
				buyList.add(buy);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return buyList;
	}

	
	public static ArrayList<Buy> selectCanceledBuyList(String userid1, int length, int page) {
		/* default generated stub */;
		Connection con=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		Member member=null;
		Good good=null;
		Buy buy=null;
		
		ArrayList<Buy>buyList=new ArrayList<Buy>();
	
		try {
		con=ConnectionUtil.getConnection();
		String sql="SELECT user_num,m.userid,name,email,phone,zipcode,addr," +
				"g.g_num,g_name,detail,g_price,photo," +
				"buy_num,qty,buy_date,cancel_date,pay_state,total_price " +
				"FROM member m,good g, buy b " +
				"WHERE m.userid=b.userid AND g.g_num=b.g_num AND m.userid=? AND pay_state=1 ORDER BY cancel_date DESC ";
		
			psmt=con.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			psmt.setString(1, userid1);
			psmt.executeUpdate();
			rs=psmt.executeQuery();
			
			if(page>1){
				rs.absolute((page-1)*length);
			}
			int getRecordCount=0;
			while(rs.next()&&getRecordCount<length){
				getRecordCount++;
				String user_num=rs.getString(1);
				String userid=rs.getString(2);
				String name=rs.getString(3);
				String email=rs.getString(4);
				String phone=rs.getString(5);
				String zipcode=rs.getString(6);
				String addr=rs.getString(7);
				
				String g_num=rs.getString(8);
				String g_name=rs.getString(9);
				String detail=rs.getString(10);
				long g_price=Long.parseLong(rs.getString(11));
				String photo =rs.getString(12);
				
				String buy_num=rs.getString(13);
				long qty=Long.parseLong(rs.getString(14));
				Date buy_date=rs.getDate(15);
				Date cancel_date=rs.getDate(16);
				String pay_state=rs.getString(17);
				long total_price=Long.parseLong(rs.getString(18));
				
				member=new Member();
				member.setUserNum(user_num);
				member.setUserid(userid);
				member.setName(name);
				member.setEmail(email);
				member.setPhone(phone);
				member.setZipcode(zipcode);
				member.setAddr(addr);
				
				good=new Good();
				good.setGnum(g_num);
				good.setGname(g_name);
				good.setDetail(detail);
				good.setGprice(g_price);
				good.setPhoto(photo);
				
				buy=new Buy();
				buy.setBuynum(buy_num);
				buy.setQty(qty);
				buy.setBuyDate(buy_date);
				buy.setcancelbuyDate(cancel_date);
				buy.setPayState(pay_state);
				buy.setTotalPrice(total_price);
				
				buy.setMember(member);
				buy.setGood(good);
				
				buyList.add(buy);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return buyList;
	}

	public static int selectBuyCountByUerid(String userid) {
		/* default generated stub */
		Connection con=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		int buyCount=0;
		
		con=ConnectionUtil.getConnection();
		
		try {
		String sql="SELECT count(g.g_num) FROM member m,good g, buy b " +
				"WHERE m.userid=b.userid AND g.g_num=b.g_num AND m.userid=? AND pay_state=0";
	
		psmt=con.prepareStatement(sql);
		psmt.setString(1, userid);
		rs=psmt.executeQuery();
		
		if(rs.next()){
			buyCount=rs.getInt(1);
		}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return buyCount;
	}
	public static int selectCancelableBuyListCount(String userid1) {
		Connection con=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		int buyCount=0;
	
		con=ConnectionUtil.getConnection();
	
		try {
				String sql="SELECT count(g.g_num) FROM member m,good g, buy b " +
						"WHERE m.userid=b.userid AND g.g_num=b.g_num AND m.userid=? AND pay_state=0 AND buy_date BETWEEN sysdate-7 AND sysdate ORDER BY buy_date DESC ";
	
				psmt=con.prepareStatement(sql);
				psmt.setString(1, userid1);
				rs=psmt.executeQuery();
		
				if(rs.next()){
					buyCount=rs.getInt(1);
				}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return buyCount;
	}
	
	public static int selectCanceledBuyListCount(String userid1) {
		/* default generated stub */;
		Connection con=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		int buyCount=0;
		
		con=ConnectionUtil.getConnection();
		
		try {
		String sql="SELECT count(g.g_num) FROM member m,good g, buy b " +
				"WHERE m.userid=b.userid AND g.g_num=b.g_num AND m.userid=? AND pay_state=1 ORDER BY buy_date DESC ";
		
			psmt=con.prepareStatement(sql);
			psmt.setString(1, userid1);
			rs=psmt.executeQuery();
			
			if(rs.next()){
				buyCount=rs.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return buyCount;
	}
	
//	/**
//	 * 구매목록 삭제 기능
//	 * 
//	 * @param buynum
//	 */
//	public static void deleteBuy(String buynum) {
//		/* default generated stub */
//		Connection con=null;
//		PreparedStatement psmt=null;
//		con=ConnectionUtil.getConnection();
//		
//		try {
//			String sql="DELETE FROM buy WHERE buy_num=?";
//			psmt=con.prepareStatement(sql);
//			
//			psmt.setString(1, buynum);
//			psmt.executeUpdate();
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}	
//	}
//	
//	/**
//	 * 구매목록 수량,가격 수정 기능
//	 * 
//	 * @param buy
//	 */
//	public static void editBuy(Buy buy) {
//		/* default generated stub */;
//		Connection con=null;
//		PreparedStatement psmt=null;
//		con=ConnectionUtil.getConnection();
//		
//		try {
//			String sql="UPDATE buy SET qty=?,total_price=? WHERE buy_num=?";
//			psmt=con.prepareStatement(sql);
//			
//			psmt.setLong(1, buy.getQty());
//			psmt.setLong(2, buy.getTotalPrice());
//			psmt.setString(3, buy.getBuynum());
//			psmt.executeUpdate();
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}	
//	}

	//구매취소하기 (buy table의 pay_state를 1로 set, cancel_date를 취소날짜로 set)
	public static void cancelBuy(String buynum){
		Connection con=null;
		PreparedStatement psmt=null;
		con=ConnectionUtil.getConnection();
		
		try {
			String sql="UPDATE buy SET pay_state=1,cancel_date=SYSDATE WHERE buy_num=?";
			psmt=con.prepareStatement(sql);
			
			psmt.setString(1, buynum);
			psmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		
	}

	
	
}
