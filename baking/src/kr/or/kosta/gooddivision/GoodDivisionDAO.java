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
import org.mybatis.spring.support.SqlSessionDaoSupport;

import kr.or.kosta.member.Member;
import kr.or.kosta.util.ConnectionUtil;

public class GoodDivisionDAO extends SqlSessionDaoSupport implements IGoodDivisionDAO{
	
	
	/**
	 * 상품리스트 조회
	 */
	@Override
	public  List<Good_division> selectGooddivisionList() {
		SqlSession session=null;
		List<Good_division> good_divisionList = null;
		
		session = getSqlSession();
		good_divisionList=session.selectList("Good_division.selectGoodDivision");

		return good_divisionList;
	}

}
