package kr.or.kosta.gooddivision;

import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kr.or.kosta.member.Member;
import kr.or.kosta.util.ConnectionUtil;

public class GoodDivisionDAO implements IGoodDivisionDAO{
	
	private static String resource="sqlmap-config.xml";
	private static Reader sqlReader;
	static{
			try {
				sqlReader=Resources.getResourceAsReader(resource);
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
	private static SqlSessionFactory sqlMapper =
			new SqlSessionFactoryBuilder().build(sqlReader);
	
	
	/**
	 * 상품리스트 조회
	 */
	@Override
	public  List<Good_division> selectGooddivisionList() {
		SqlSession session=null;
		List<Good_division> good_divisionList = null;
		try{
		session = sqlMapper.openSession(true);
		good_divisionList=session.selectList("Good_division.selectGoodDivision");
		}finally{
			session.close();
		}
		return good_divisionList;
	}

}
