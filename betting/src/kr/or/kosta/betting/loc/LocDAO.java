package kr.or.kosta.betting.loc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.or.kosta.betting.util.ConnectionUtil;

public class LocDAO {

	/**
	 * 연고지 모든 정보 리스트 조회 메서드
	 */
	public static ArrayList<Loc> selectLocList() {
		/* default generated stub */;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Loc> locList = new ArrayList<Loc>();
		Loc loc = null;
		String sql = null;
		
		sql = "SELECT loc_num, loc" +
				 " FROM loc";
		con = ConnectionUtil.getConnection();
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				String locNum = rs.getString(1);
				String locName = rs.getString(2);
				
				loc = new Loc();
				loc.setNum(locNum);
				loc.setLoc(locName);
				
				locList.add(loc);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return locList;
	}

	/**
	 * 연고지 번호로 선택된 연고지 정보 하나만 볼 수 있는 메서드
	 * 
	 * @param num
	 */
	public static Loc selectLoc(String num) {
		/* default generated stub */;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Loc loc = null;
		String sql = null;
		
		sql = "SELECT loc" +
				 " FROM loc" +
				 " WHERE loc_num=?";
		con = ConnectionUtil.getConnection();
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1,num);
			rs = ps.executeQuery();
			if(rs.next()){
				String locName = rs.getString(1);
							
				loc = new Loc();
				loc.setNum(num);
				loc.setLoc(locName);
									
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return loc;
		
		
		
	}
}
