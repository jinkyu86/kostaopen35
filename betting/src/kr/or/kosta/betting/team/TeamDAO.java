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
	 * 팀의 모든 정보 리스트를 열람하는 메서드
	 */
	public static ArrayList<Team> selectTeamList() {
		/* default generated stub */;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = null;
		ArrayList<Team> teamList = new ArrayList<Team>();
		Team team = null;
		
		sql = "SELECT team_name,photo,team_num" +
				  " FROM team";
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
				team.setNum(num);
				
				teamList.add(team);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return teamList;
	}

	/**
	 * 선택된 팀번호의 팀 정보만 조회하는 메서드
	 * 
	 * @param num
	 */
	public static Team selectTeam(String num) {
		/* default generated stub */;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Team team = null;
		String sql = null;
		
		sql = "SELECT team_name,photo" +
				 " FROM team" +
				 " WHERE team_num=?";
		con = ConnectionUtil.getConnection();
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1,num);
			rs = ps.executeQuery();
			if(rs.next()){
				String teamName = rs.getString(1);
				String 	photo = rs.getString(2);		
				
				team = new Team();
				team.setNum(num);
				team.setName(teamName);
				team.setPhoto(photo);
													
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return team;
				
	}
}
