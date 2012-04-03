package kr.or.kosta.moviesystem.good;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.or.kosta.moviesystem.util.ConnectionUtil;

public class GoodDAO {
	
	/**
	 * 전체 상품의 리스트를 알 수 있는 메서드
	 * 
	 * @param length
	 * @param page
	 */
	public static ArrayList<Good> selectGoodList() {
		/* default generated stub */
		Connection con=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		String sql=null;
		
		ArrayList<Good>goodList=new ArrayList<Good>();
		
		try {
		con=ConnectionUtil.getConnection();
		sql="SELECT g_num,g_name,detail,g_price,photo FROM good";
		
		psmt=con.prepareStatement(sql);
		
		rs=psmt.executeQuery();

		
		while(rs.next()){
			String gnum=rs.getString(1);
			String gname=rs.getString(2);
			String detail=rs.getString(3);
			Long gprice=rs.getLong(4);
			String photo=rs.getString(5);
			
			Good good=new Good();
			good.setGnum(gnum);
			good.setGname(gname);
			good.setDetail(detail);
			good.setGprice(gprice);
			good.setPhoto(photo);
			
			goodList.add(good);
			
		}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return goodList;
	}
	/**
	 * 상품 번호로 상품을 찾을 수 있는 기능
	 * 
	 * @param num
	 */
	public static Good selectGood(String gnum1) {
		/* default generated stub */;
		Connection con=null;
		PreparedStatement psmt=null;
		String sql=null;
		ResultSet rs = null;
		Good good=null;
		
		try {
		con=ConnectionUtil.getConnection();
		sql="SELECT g_num,g_name,detail,g_price,photo FROM good WHERE g_num=?";
		
		psmt=con.prepareStatement(sql);
		psmt.setString(1,gnum1);
		psmt.executeUpdate();
		rs=psmt.executeQuery();

		while(rs.next()){
			String gnum=rs.getString(1);
			String gname=rs.getString(2);
			String detail=rs.getString(3);
			Long gprice=rs.getLong(4);
			String photo=rs.getString(5);
			
			good=new Good();
			good.setGnum(gnum);
			good.setGname(gname);
			good.setDetail(detail);
			good.setGprice(gprice);
			good.setPhoto(photo);
			
		}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return good;
	}
	
	/**
	 * 상품의 이름으로 상품을 찾을 수 있는 메서드
	 * 
	 * @param length
	 * @param page
	 * @param name
	 */

	public static ArrayList selectGoodListByName(int length, int page, String gname1) {
		/* default generated stub */
		Connection con=null;
		PreparedStatement psmt=null;
		String sql=null;
		ResultSet rs = null;
		Good good=null;
		ArrayList<Good> goodList=new ArrayList<Good>();
		
		try {
		con=ConnectionUtil.getConnection();
		sql="SELECT g_num,g_name,detail,g_price,photo FROM good WHERE g_name like?";
		
		psmt=con.prepareStatement(sql);
		psmt.setString(1,"%"+gname1+"%");
		//psmt.executeUpdate();
		rs=psmt.executeQuery();

		while(rs.next()){
			String gnum=rs.getString(1);
			String gname=rs.getString(2);
			String detail=rs.getString(3);
			Long gprice=rs.getLong(4);
			String photo=rs.getString(5);
			
			good=new Good();
			good.setGnum(gnum);
			good.setGname(gname);
			good.setDetail(detail);
			good.setGprice(gprice);
			good.setPhoto(photo);
			
			goodList.add(good);
			
		}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return goodList;

	}
	
	/**
	 * 전체 상품의 수를 알 수 있는 메서드
	 */
	public static int selectGoodCount() {
		/* default generated stub */
		Connection con = null;
		PreparedStatement psmt=null;
		String sql = null;
		ResultSet rs = null;
		int goodCount=0;
		
		 try {
			con = ConnectionUtil.getConnection();
			sql="SELECT count(g_num) FROM good";
			
			psmt=con.prepareStatement(sql);
			rs=psmt.executeQuery();
			if(rs.next()){
				goodCount=rs.getInt(1);
			}
		 } catch (SQLException e) {
			 e.printStackTrace();
		 }
		 return goodCount;
	}
	/**
	 * 이름으로 찾은 상품의 수를 알 수 있는 메서드
	 */
	public static int selectGoodListByNameCount(String gname) {
		/* default generated stub */;
		Connection con = null;
		PreparedStatement psmt=null;
		String sql = null;
		ResultSet rs = null;
		int goodCount=0;
		
		 try {
			con = ConnectionUtil.getConnection();
			sql="SELECT count(g_num) FROM good WHERE g_name like?";
			
			psmt=con.prepareStatement(sql);
			psmt.setString(1, "%"+gname+"%");
			rs=psmt.executeQuery();
			if(rs.next()){
				goodCount=rs.getInt(1);
			}
		 } catch (SQLException e) {
			 e.printStackTrace();
		 }
		 return goodCount;
	}

	/**
	 * 상품을 입력
	 * 
	 * @param good
	 */
	public static void insertGood(Good good) {
		/* default generated stub */
		Connection con=null;
		PreparedStatement psmt=null;
		String sql = null;
		con = ConnectionUtil.getConnection();
		
		sql="INSERT INTO good (g_num,g_name,detail,g_price,photo) VALUES(SQ_GOOD.NEXTVAL,?,?,?,?)";
		
		try {
			psmt = con.prepareStatement(sql);
			
			psmt.setString(1, good.getGname());
			psmt.setString(2, good.getDetail());
			psmt.setLong(3, good.getGprice());
			psmt.setString(4, good.getPhoto());
			
			psmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}







}
