package kr.or.kosta.betting.loc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.or.kosta.betting.util.ConnectionUtil;

public class LocDAO {

	/**
	 * ������ ��� ���� ����Ʈ ��ȸ �޼���
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
	 * ������ ��ȣ�� ���õ� ������ ���� �ϳ��� �� �� �ִ� �޼���
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
