package kr.or.kosta.good;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.or.kosta.gooddivision.Good_division;
import kr.or.kosta.util.ConnectionUtil;

public class GoodDAO {

	/**
	 * ��ǰ�߰� 
	 */
	public void insertGood(Good good) {
		Connection con=null;
		PreparedStatement psmt=null;
		con=ConnectionUtil.getConnection();
		String sql="insert into good values(good_seq.nextval,?,?,?,?,?,?,?)";
		try {
			psmt=con.prepareStatement(sql);
			psmt.setInt(1, good.getGood_division().getDivision());
			psmt.setInt(2, good.getGoodPrice());
			psmt.setInt(3, good.getQty());
			psmt.setString(4, good.getName());
			psmt.setString(5, good.getExplantion());
			psmt.setString(6, good.getImg());
			psmt.setString(7, good.getOption());
			psmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * ��ǰ����Ʈ ����
	 */
	public ArrayList<Good> selectGoodList(int length, int page) {
		Connection con=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		String sql="select good_num,g.division,good_price,qty,name,explantion,img,g_option,g_name"+
					 " from good g, good_division gd"+
					 " where g.division=gd.division";
		ArrayList<Good> goodList = new ArrayList<Good>();
		try {
			con=ConnectionUtil.getConnection();
			
			  //rs.absolute()�� �����ϵ��� ����
			psmt=con.prepareStatement(sql,
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			rs=psmt.executeQuery();
			
			if(page>1){
				rs.absolute((page-1)*length);
			}
			
			//������ ���ڵ� ����
			int getRecordCount=0;
			while(rs.next()&&getRecordCount<length){
				getRecordCount++;
				int goodNum=rs.getInt(1);
				int division =rs.getInt(2);
				int goodPrice=rs.getInt(3);
				int qty=rs.getInt(4);
				String name=rs.getString(5);
				String explantion=rs.getString(6);
				String img=rs.getString(7);
				String option=rs.getString(8);
				String gName=rs.getString(9);
				
				Good_division good_division=new Good_division();
				good_division.setDivision(division);
				good_division.setgName(gName);
				
				Good good= new Good();
				good.setGoodNum(goodNum);
				good.setGood_division(good_division);
				good.setGoodPrice(goodPrice);
				good.setQty(qty);
				good.setName(name);
				good.setExplantion(explantion);
				good.setImg(img);
				good.setOption(option);
				
				goodList.add(good);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return goodList;
	}

	/**
	 * ��ǰ�󼼺���
	 */
	public Good selectGood(int goodnum) {
		Connection con=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		Good good= new Good();
		String sql="select g.division,good_price,qty,name,explantion,img,g_option,g_name"+
					 " from good g, good_division gd"+
					 " where g.division=gd.division and good_num=?";
		try {
			con=ConnectionUtil.getConnection();
			psmt=con.prepareStatement(sql);
			psmt.setInt(1, goodnum);
			rs=psmt.executeQuery();
			if(rs.next()){
				int division =rs.getInt(1);
				int goodPrice=rs.getInt(2);
				int qty=rs.getInt(3);
				String name=rs.getString(4);
				String explantion=rs.getString(5);
				String img=rs.getString(6);
				String option=rs.getString(7);
				String gName=rs.getString(8);
				
				Good_division good_division=new Good_division();
				good_division.setDivision(division);
				good_division.setgName(gName);
				
				good.setGoodNum(goodnum);
				good.setGood_division(good_division);
				good.setGoodPrice(goodPrice);
				good.setQty(qty);
				good.setName(name);
				good.setExplantion(explantion);
				good.setImg(img);
				good.setOption(option);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return good;
	}

	/**
	 * ��ǰ���÷����Ǻ���
	 */
	public ArrayList selectRelationRecipe(int recipenum) {
		/* default generated stub */;
		return null;
	}

	/**
	 * ��ǰ����
	 */
	public void deleteGood(int goodnum) {
		Connection con =null;
		PreparedStatement psmt=null;
		con=ConnectionUtil.getConnection();
		String sql="delete good where good_num=?";
		try {
			psmt=con.prepareStatement(sql);
			psmt.setInt(1, goodnum);
			psmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * ��ǰ����
	 */
	public void updateGood(Good good) {
		Connection con=null;
		PreparedStatement psmt=null;
		String sql="update good"+
					" set division=?,good_price=?,qty=?,name=?,explantion=?,img=?,g_option=?"+
					" where good_num=?";
		con=ConnectionUtil.getConnection();
		try {
			psmt=con.prepareStatement(sql);
			psmt.setInt(1, good.getGood_division().getDivision());
			psmt.setInt(2, good.getGoodPrice());
			psmt.setInt(3, good.getQty());
			psmt.setString(4, good.getName());
			psmt.setString(5, good.getExplantion());
			psmt.setString(6, good.getImg());
			psmt.setString(7, good.getOption());
			psmt.setInt(8, good.getGoodNum());
			psmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
