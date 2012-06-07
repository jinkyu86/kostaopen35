package kr.or.kosta.betting.loc;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.mybatis.spring.support.SqlSessionDaoSupport;

public class LocDAO extends SqlSessionDaoSupport 
				implements ILoc{
	
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
	 * 연고지 모든 정보 리스트 조회 메서드
	 */
	@Override
	public List<Loc> selectLocList() {
		/* default generated stub */;
		SqlSession session = null;
		List<Loc> locList= null;
		session = getSqlSession();
		locList = 
				session.selectList("Loc.selectLocList");
		return locList;
//		Connection con = null;
//		PreparedStatement ps = null;
//		ResultSet rs = null;
//		ArrayList<Loc> locList = new ArrayList<Loc>();
//		Loc loc = null;
//		String sql = null;
//		
//		sql = "SELECT loc_num, loc" +
//				 " FROM loc";
//		con = ConnectionUtil.getConnection();
//		try {
//			ps = con.prepareStatement(sql);
//			rs = ps.executeQuery();
//			while(rs.next()){
//				String locNum = rs.getString(1);
//				String locName = rs.getString(2);
//				
//				loc = new Loc();
//				loc.setNum(locNum);
//				loc.setLoc(locName);
//				
//				locList.add(loc);
//				
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return locList;
	}

	/**
	 * 연고지 번호로 선택된 연고지 정보 하나만 볼 수 있는 메서드
	 * 
	 * @param num
	 */
	@Override
	public Loc selectLoc(String locNum) {
		/* default generated stub */;
		SqlSession session = null;
		Loc loc= null;
		session = getSqlSession();
		loc = session.selectOne("selectLoc",locNum);
		return loc;
//		Connection con = null;
//		PreparedStatement ps = null;
//		ResultSet rs = null;
//		Loc loc = null;
//		String sql = null;
//		
//		sql = "SELECT loc" +
//				 " FROM loc" +
//				 " WHERE loc_num=?";
//		con = ConnectionUtil.getConnection();
//		try {
//			ps = con.prepareStatement(sql);
//			ps.setString(1,num);
//			rs = ps.executeQuery();
//			if(rs.next()){
//				String locName = rs.getString(1);
//							
//				loc = new Loc();
//				loc.setNum(num);
//				loc.setLoc(locName);
//									
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return loc;
		
		
		
	}
}
