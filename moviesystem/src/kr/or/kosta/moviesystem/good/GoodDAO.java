package kr.or.kosta.moviesystem.good;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.mybatis.spring.support.SqlSessionDaoSupport;


public class GoodDAO extends SqlSessionDaoSupport implements IGoodDAO{

	@Override
	public String insertGood(Good good) {
		
		SqlSession session=null;
			session=getSqlSession();
			session.insert("Good.insertGood",good);
		return good.getGnum();
	}
	@Override
	public void editGood(Good good) {
		SqlSession session=null;
		session = getSqlSession();
		session.update("Good.editGood",good);
	}
	@Override
	public void deleteGood(String gnum) {
		SqlSession session=null;
		session = getSqlSession();
		session.delete("Good.deleteGood",gnum);
	}
	@Override
	public Good selectGood(String gnum) {
		SqlSession session=null;
		Good good=null;
		session = getSqlSession();
		good=session.selectOne("Good.selectGood",gnum);
		return good;
	}
	@Override
	public List<Good> selectGoodList(int length,int page) {
		SqlSession session=null;
		List<Good> goodList=null;
		session = getSqlSession();
		RowBounds rowBounds=new RowBounds((page-1)*length,length);
		goodList=session.selectList("Good.selectGoodList",null,rowBounds);
		return goodList;
	}
	@Override
	public int selectGoodListCount() {
		SqlSession session=null;
		Integer count=null;
		session = getSqlSession();
		count=session.selectOne("Good.selectGoodListCount");
		return count;
	}
	@Override
	public List<Good> selectGoodListByName(int length, int page, String gname) {
		SqlSession session=null;
		List<Good> goodList=null;
		session = getSqlSession();
		RowBounds rowBounds=new RowBounds((page-1)*length,length);
		goodList=session.selectList("Good.selectGoodListByName","%"+gname+"%",rowBounds);
		return goodList;
	}
	@Override
	public int selectGoodListByNameCount(String gname) {
		SqlSession session=null;
		Integer count=null;
		session = getSqlSession();
		count=session.selectOne("Good.selectGoodListByNameCount","%"+gname+"%");
		return count;
	}
}
