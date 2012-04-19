package kr.or.kosta.moviesystem.good;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


public class GoodDAO {
	
	private static String resource="sqlmap-config.xml";
	private static Reader sqlReader;
	static{
		try {
			sqlReader=Resources.getResourceAsReader(resource);
		} catch (IOException e) {
			e.printStackTrace();
			}
		}
	private static SqlSessionFactory sqlMapper =new SqlSessionFactoryBuilder().build(sqlReader);

	public static String insertGood(Good good) {
		
		SqlSession session=null;
		try{
			session=sqlMapper.openSession(true);
			session.insert("Good.insertGood",good);
		}finally{
			session.close();
		}
		return good.getGnum();
	}
	
	public static void editGood(Good good) {
		SqlSession session=null;
		try{
		session = sqlMapper.openSession(true);
		session.update("Good.editGood",good);
		}finally{
			session.close();
		}
	}
	public static void deleteGood(String gnum) {
		SqlSession session=null;
		try{
		session = sqlMapper.openSession(true);
		session.delete("Good.deleteGood",gnum);
		}finally{
			session.close();
		}
	}
	public static Good selectGood(String gnum) {
		SqlSession session=null;
		Good good=null;
		try{
		session = sqlMapper.openSession(true);
		good=session.selectOne("Good.selectGood",gnum);
		
		}finally{
			session.close();
		}
		return good;
	}
	
	public static List<Good> selectGoodList(int length,int page) {
		SqlSession session=null;
		List<Good> goodList=null;
		try{
		session = sqlMapper.openSession(true);
		RowBounds rowBounds=new RowBounds((page-1)*length,length);
		goodList=session.selectList("Good.selectGoodList",null,rowBounds);
		
		}finally{
			session.close();
		}
		return goodList;
	}

	public static int selectGoodListCount() {
		SqlSession session=null;
		Integer count=null;
		try{
		session = sqlMapper.openSession(true);
		count=session.selectOne("Good.selectGoodListCount");
		
		}finally{
			session.close();
		}
		return count;
	}
	
	public static List<Good> selectGoodListByName(int length, int page, String gname) {
		SqlSession session=null;
		List<Good> goodList=null;
		try{
		session = sqlMapper.openSession(true);
		RowBounds rowBounds=new RowBounds((page-1)*length,length);
		goodList=session.selectList("Good.selectGoodListByName","%"+gname+"%",rowBounds);
		
		}finally{
			session.close();
		}
		return goodList;
	}
	
	public static int selectGoodListByNameCount(String gname) {
		SqlSession session=null;
		Integer count=null;
		try{
		session = sqlMapper.openSession(true);
		count=session.selectOne("Good.selectGoodListByNameCount","%"+gname+"%");
		
		}finally{
			session.close();
		}
		return count;
	}
}
