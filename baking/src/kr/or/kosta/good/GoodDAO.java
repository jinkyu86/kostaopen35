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
	 * 상품추가 
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
	 * 상품리스트 보기
	 */
	public ArrayList selectGoodList(int length, int page) {
		Connection con=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		String sql="select good_num,g.division,good_price,qty,name,explantion,img,g_option,g_name"+
					 " from good g, good_division gd"+
					 " where g.division=gd.division";
		ArrayList goodList = new ArrayList();
		try {
			con=ConnectionUtil.getConnection();
			
			  //rs.absolute()가 가능하도록 설정
			psmt=con.prepareStatement(sql,
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			rs=psmt.executeQuery();
			
			if(page>1){
				rs.absolute((page-1)*length);
			}
			
			//가져온 레코드 개수
			int getRecordCount=0;
			while(rs.next()&&getRecordCount>length){
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
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 상품상세보기
	 */
	public Good selectGood(int goodnum) {
		/* default generated stub */;
		return null;
	}

	/**
	 * 상품관련레시피보기
	 */
	public ArrayList selectRelationRecipe(int recipenum) {
		/* default generated stub */;
		return null;
	}

	/**
	 * 상품삭제
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
	 * 상품수정
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
