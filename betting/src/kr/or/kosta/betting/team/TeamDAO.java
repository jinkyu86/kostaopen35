package kr.or.kosta.betting.team;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.or.kosta.betting.loc.Loc;
import kr.or.kosta.betting.util.ConnectionUtil;

public class TeamDAO {

	/**
	 * ���� ��� ���� ����Ʈ�� �����ϴ� �޼���
	 */
	public ArrayList<Team> selectTeamList() {
		/* default generated stub */;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = null;
		ArrayList<Team> teamList = new ArrayList<Team>();
		Team team = null;
		
		sql = "SELECT team_name,photo,team_num" +
				  "FROM team";
		con = ConnectionUtil.getConnection();
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				String name = rs.getString(1);
				String photo = rs.getString(2);
				String num = rs.getString(3);
								
				team = new Team();
				team.setName(name);
				team.setPhoto(photo);
				team.setNum(locNum);
				
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * ���õ� ����ȣ�� �� ������ ��ȸ�ϴ� �޼���
	 * 
	 * @param num
	 */
	public Team selectTeam(String num) {
		/* default generated stub */;
		return null;
	}
}
