package kr.or.kosta.betting.team;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.mybatis.spring.support.SqlSessionDaoSupport;

public class TeamDAO extends SqlSessionDaoSupport
				implements ITeam{
//	private static String resource="sqlmap-config.xml";
//	private static Reader sqlReader;
//	static{
//			try {
//				sqlReader=Resources.getResourceAsReader(resource);
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//	}
//	private static SqlSessionFactory sqlMapper =
//			new SqlSessionFactoryBuilder().build(sqlReader);


	/**
	 * ���� ��� ���� ����Ʈ�� �����ϴ� �޼���
	 */
	@Override
	public List<Team> selectTeamList() {
		SqlSession session = null;
		List<Team> teamList= null;
		session = getSqlSession();;
		teamList = 
				session.selectList("Team.selectTeamList");
		return teamList;
		/* default generated stub */
//		Connection con = null;
//		PreparedStatement ps = null;
//		ResultSet rs = null;
//		String sql = null;
//		ArrayList<Team> teamList = new ArrayList<Team>();
//		Team team = null;
//		
//		sql = "SELECT team_name,photo,team_num" +
//				  " FROM team";
//		con = ConnectionUtil.getConnection();
//		try {
//			ps = con.prepareStatement(sql);
//			rs = ps.executeQuery();
//			while(rs.next()){
//				String name = rs.getString(1);
//				String photo = rs.getString(2);
//				String num = rs.getString(3);
//								
//				team = new Team();
//				team.setName(name);
//				team.setPhoto(photo);
//				team.setNum(num);
//				
//				teamList.add(team);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return teamList;
	}

	/**
	 * ���õ� ����ȣ�� �� ������ ��ȸ�ϴ� �޼���
	 * 
	 * @param num
	 */
	@Override
	public Team selectTeam(String teamNum) {
		/* default generated stub */;
		SqlSession session = null;
		Team team= null;
		session = getSqlSession();
		team = session.selectOne("selectTeam",teamNum);
		return team;
//		Connection con = null;
//		PreparedStatement ps = null;
//		ResultSet rs = null;
//		Team team = null;
//		String sql = null;
//		
//		sql = "SELECT team_name,photo" +
//				 " FROM team" +
//				 " WHERE team_num=?";
//		con = ConnectionUtil.getConnection();
//		try {
//			ps = con.prepareStatement(sql);
//			ps.setString(1,num);
//			rs = ps.executeQuery();
//			if(rs.next()){
//				String teamName = rs.getString(1);
//				String 	photo = rs.getString(2);		
//				
//				team = new Team();
//				team.setNum(num);
//				team.setName(teamName);
//				team.setPhoto(photo);
//													
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return team;
//				
	}
}
