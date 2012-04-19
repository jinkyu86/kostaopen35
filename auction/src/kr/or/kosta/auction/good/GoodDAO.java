package kr.or.kosta.auction.good;

import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kr.or.kosta.auction.util.ConnectionUtil;

public class GoodDAO {
	
	private static String resource="sqlmap-config.xml";
	private static Reader sqlReader;
	static{
			try {
				sqlReader=Resources.getResourceAsReader(resource);
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
	private static SqlSessionFactory sqlMapper =
			new SqlSessionFactoryBuilder().build(sqlReader);

	/**
	 * @param good
	 */
	public static String insertGood(Good good) {
		SqlSession session=null;
		try{
			session=sqlMapper.openSession(true);
			session.insert("Good.insertGood", good);
		}
		finally{
			session.close();
		}
		
		return good.getgNum();
//		Connection con=null;
//		PreparedStatement psmt=null;
//		con=ConnectionUtil.getConnection();
//		try {
//		psmt=con.prepareStatement(
//				"INSERT INTO good "+
//				"(g_num, gname, detail, img) "+
//				"VALUES (GOOD_SEQ.nextval, ?, ?, ?)");
//		psmt.setString(1, good.getgName());
//		psmt.setString(2, good.getDetail());
//		psmt.setString(3, good.getImg());
//		psmt.executeQuery();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
	}

	/**
	 * @param good
	 */
	public static void updateGood(Good good) {
		SqlSession session=null;
		try{
			session=sqlMapper.openSession(true);
			session.update("Good.updateGood", good);
		}
		finally{
			session.close();
		}
		
//		Connection con=null;
//		PreparedStatement psmt=null;
//		
//		con=ConnectionUtil.getConnection();
//		try {
//			psmt=con.prepareStatement(
//					"UPDATE good "+
//					"SET gname=?," +
//						   "detail=?," +
//						   "img=?" +
//					"WHERE g_num=? ");
//			
//			psmt.setString(1, good.getgName());
//			psmt.setString(2, good.getDetail());
//			psmt.setString(3, good.getImg());
//			psmt.setString(4, good.getgNum());
//			psmt.executeQuery();
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
	}

	/**
	 * @param gNum
	 */
	public static void deleteGood(String gNum) {
		SqlSession session=null;
		try{
			session=sqlMapper.openSession(true);
			session.delete("Good.deleteGood", gNum);
		}
		finally{
			session.close();
		}
//		Connection con=null;
//		PreparedStatement psmt=null;
//		con=ConnectionUtil.getConnection();
//		
//		try {
//			psmt=con.prepareStatement(
//					"DELETE FROM good "+
//					"WHERE g_num=? ");
//			
//			psmt.setString(1, gNum);
//			psmt.executeQuery();
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
	}

	/**
	 * @param gNum
	 */
	public static Good selectGood(String gNum) {
		SqlSession session=null;
		Good good=null;
		try{
			session=sqlMapper.openSession(true);
			good=session.selectOne("Good.selectGood", gNum);
		}
		finally{
			session.close();
		}
		return good;
//		Connection con=null;
//		PreparedStatement psmt=null;
//		String sql=null;
//		ResultSet rs=null;
//		Good good=null;
//		con=ConnectionUtil.getConnection();
//		try {
//		sql="SELECT g_num, gname, detail, img "+
//			  "FROM good "+
//			  "WHERE g_num=?";
//		
//		psmt=con.prepareStatement(sql);
//		psmt.setString(1, gNum);
//		rs=psmt.executeQuery();
//		
//				while(rs.next()){
//					gNum=rs.getString(1);
//					String gName=rs.getString(2);
//					String detail=rs.getString(3);
//					String img=rs.getString(4);
//		
//					good=new Good();
//					
//					good.setgNum(gNum);
//					good.setgName(gName);
//					good.setDetail(detail);
//					good.setImg(img);
//				}
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			
//		return good;
	}

	public static List<Good> selectGoodList() {
		SqlSession session=null;
		List<Good> goodList=null;
		try{
			session=sqlMapper.openSession(true);
			goodList=session.selectList("Good.selectGoodList");
		}
		finally{
			session.close();
		}
		return goodList;
//		Connection con=null;
//		PreparedStatement psmt=null;
//		String sql=null;
//		ResultSet rs=null;
//		Good good=null;
//		ArrayList<Good>goodList=new ArrayList<Good>();
//		con=ConnectionUtil.getConnection();
//		try {
//		sql="SELECT g_num, gname, detail, img "+
//			  "FROM good ";
//		psmt=con.prepareStatement(sql);
//		rs=psmt.executeQuery();
//		
//		while(rs.next()){
//			String gNum=rs.getString(1);
//			String gName=rs.getString(2);
//			String detail=rs.getString(3);
//			String img=rs.getString(4);
//			
//			good=new Good();
//			
//			good.setgNum(gNum);
//			good.setgName(gName);
//			good.setDetail(detail);
//			good.setImg(img);
//			
//			goodList.add(good);
//		}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return goodList;
	}

	/**
	 * @param length
	 * @param page
	 */
	public static List<Good> selectGoodList(int length, int page) {
		SqlSession session=null;
		List<Good> goodList=null;
		RowBounds rowBounds=null;
		try{
				session=sqlMapper.openSession(true);
				rowBounds=new RowBounds((page-1)*length,length);
				goodList=session.selectList("Good.selectGoodList", null, rowBounds);
		}
		finally
		{
			session.close();
		}
		return goodList;
//		Connection con=null;
//		PreparedStatement psmt=null;
//		String sql=null;
//		ResultSet rs=null;
//		Good good=null;
//		ArrayList<Good>goodList=new ArrayList<Good>();
//		con=ConnectionUtil.getConnection();
//		try {
//			sql="SELECT g_num, gname, detail, img "+
//			      "FROM good";
//			psmt=con.prepareStatement(sql,
//				ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
//				rs=psmt.executeQuery();
//				if(page>1){
//					rs.absolute((page-1)*length);
//				}
//				int getRecordCount=0;
//				while(rs.next()&&getRecordCount<length){
//					getRecordCount++;
//					String gNum=rs.getString(1);
//					String gName=rs.getString(2);
//					String detail=rs.getString(3);
//					String img=rs.getString(4);
//					
//					good=new Good();
//					
//					good.setgNum(gNum);
//					good.setgName(gName);
//					good.setDetail(detail);
//					good.setImg(img);
//					
//					goodList.add(good);
//				}
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		return goodList;
	}
}
