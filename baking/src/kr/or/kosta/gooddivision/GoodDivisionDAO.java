package kr.or.kosta.gooddivision;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.or.kosta.util.ConnectionUtil;

public class GoodDivisionDAO {

	/**
	 * 상품리스트 조회
	 */
	public static ArrayList<Good_division> selectGooddivisionList() {
		Connection con=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		ArrayList<Good_division> gooddivisionList=new ArrayList<Good_division>();
		String sql="select division,g_name from good_division";
		try {
			con=ConnectionUtil.getConnection();
			psmt=con.prepareStatement(sql);
			rs=psmt.executeQuery();
			while(rs.next()){
				int division=rs.getInt(1);
				String gName=rs.getString(2);
				
				Good_division good_division = new Good_division();
				good_division.setDivision(division);
				good_division.setgName(gName);
				
				gooddivisionList.add(good_division);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return gooddivisionList;
	}
	
	/**
	 * 상품코드로 상품이름 검색. 만들었으나 활용하지않음..
	 */
	public static Good_division selectDivisionName(int division){
		Connection con=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		String sql="select division,g_name from good_division where division=?";
		Good_division good_division = new Good_division();
		try {
			con=ConnectionUtil.getConnection();
			psmt=con.prepareStatement(sql);
			psmt.setInt(1, division);
			rs=psmt.executeQuery();
			if(rs.next()){
				division = rs.getInt(1);
				String gName=rs.getString(2);
				
				good_division.setDivision(division);
				good_division.setgName(gName);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return good_division;
	}
}
