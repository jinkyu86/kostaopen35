package kr.or.kosta.auction.good;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.or.kosta.auction.util.ConnectionUtil;

public class GoodDAO {

	/**
	 * @param good
	 */
	public static void insertGood(Good good) {
		Connection con=null;
		PreparedStatement psmt=null;
		con=ConnectionUtil.getConnection();
		try {
		psmt=con.prepareStatement(
													"INSERT INTO good "+
													"(g_num, gname, detail, img) "+
													"VALUES (GOOD_SEQ.nextval, ?, ?, ?)");
		psmt.setString(1, good.getgName());
		psmt.setString(2, good.getDetail());
		psmt.setString(3, good.getImg());
		psmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param good
	 */
	public static void updateGood(Good good) {
		Connection con=null;
		PreparedStatement psmt=null;
		
		con=ConnectionUtil.getConnection();
		try {
			psmt=con.prepareStatement(
					"UPDATE good "+
					"SET gname=?," +
						   "detail=?," +
						   "img=?" +
					"WHERE g_num=? ");
			
			psmt.setString(1, good.getgName());
			psmt.setString(2, good.getDetail());
			psmt.setString(3, good.getImg());
			psmt.setString(4, good.getgNum());
			psmt.executeQuery();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param gNum
	 */
	public static void deleteGood(String gNum) {
		Connection con=null;
		PreparedStatement psmt=null;
		con=ConnectionUtil.getConnection();
		
		try {
			psmt=con.prepareStatement(
					"DELETE FROM good "+
					"WHERE g_num=? ");
			
			psmt.setString(1, gNum);
			psmt.executeQuery();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param gNum
	 */
	public static Good selectGood(String gNum) {
		Connection con=null;
		PreparedStatement psmt=null;
		String sql=null;
		ResultSet rs=null;
		Good good=null;
		con=ConnectionUtil.getConnection();
		try {
		sql="SELECT g_num, gname, detail, img "+
			  "FROM good "+
			  "WHERE g_num=?";
		
		psmt=con.prepareStatement(sql);
		psmt.setString(1, gNum);
		rs=psmt.executeQuery();
		
				while(rs.next()){
					gNum=rs.getString(1);
					String gName=rs.getString(2);
					String detail=rs.getString(3);
					String img=rs.getString(4);
		
					good=new Good();
					
					good.setgNum(gNum);
					good.setgName(gName);
					good.setDetail(detail);
					good.setImg(img);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		return good;
	}

	public static ArrayList<Good> selectGoodList() {
		Connection con=null;
		PreparedStatement psmt=null;
		String sql=null;
		ResultSet rs=null;
		Good good=null;
		ArrayList<Good>goodList=new ArrayList<Good>();
		con=ConnectionUtil.getConnection();
		try {
		sql="SELECT g_num, gname, detail, img "+
			  "FROM good ";
		psmt=con.prepareStatement(sql);
		rs=psmt.executeQuery();
		
		while(rs.next()){
			String gNum=rs.getString(1);
			String gName=rs.getString(2);
			String detail=rs.getString(3);
			String img=rs.getString(4);
			
			good=new Good();
			
			good.setgNum(gNum);
			good.setgName(gName);
			good.setDetail(detail);
			good.setImg(img);
			
			goodList.add(good);
		}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return goodList;
	}

	/**
	 * @param length
	 * @param page
	 */
	public static ArrayList<Good> selectGoodList(int length, int page) {
		/* default generated stub */;
		return null;
	}
}
