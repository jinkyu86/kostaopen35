package kr.or.kosta.auction.good;

import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import kr.or.kosta.auction.util.ConnectionUtil;

public class GoodDAO extends SqlSessionDaoSupport implements IGoodDAO {

	/**
	 * @param good
	 */

	@Override
	public String insertGood(Good good) {
		SqlSession session = null;

		session = getSqlSession();
		session.insert("Good.insertGood", good);

		return good.getgNum();

	}

	/**
	 * @param good
	 */

	@Override
	public void updateGood(Good good) {
		SqlSession session = null;

		session = getSqlSession();
		session.update("Good.updateGood", good);

	}

	/**
	 * @param gNum
	 */

	@Override
	public void deleteGood(String gNum) {
		SqlSession session = null;

			session = getSqlSession();
			session.delete("Good.deleteGood", gNum);


	}

	/**
	 * @param gNum
	 */

	@Override
	public Good selectGood(String gNum) {
		SqlSession session = null;
		Good good = null;

		session = getSqlSession();
		good = session.selectOne("Good.selectGood", gNum);

		return good;

	}

	@Override
	public List<Good> selectGoodList() {
		SqlSession session = null;
		List<Good> goodList = null;

		session = getSqlSession();
		goodList = session.selectList("Good.selectGoodList");

		return goodList;

	}

	/**
	 * @param length
	 * @param page
	 */

	@Override
	public List<Good> selectGoodList(int length, int page) {
		SqlSession session = null;
		List<Good> goodList = null;
		RowBounds rowBounds = null;

		session = getSqlSession();
		rowBounds = new RowBounds((page - 1) * length, length);
		goodList = session.selectList("Good.selectGoodList", null, rowBounds);

		return goodList;

	}
}
