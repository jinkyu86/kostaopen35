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
}
